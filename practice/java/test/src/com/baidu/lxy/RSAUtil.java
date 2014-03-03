package com.baidu.lxy;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.RSAPrivateKeySpec;
import java.security.spec.RSAPublicKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.Cipher;


/**
 * RSA 加解密工具类。
 */
public final class RSAUtil {
    
    /** private constructor. */
    private RSAUtil() { }
    
    /** 加密算法。 */
    public static final String ALGORITHM_RSA = "RSA";
    
    /** 用于 返回密钥对（Map）中的key。 */
    public static final String PUBLIC_KEY = "PublicKey";
    /** 用于 返回密钥对（Map）中的key。 */
    public static final String PRIVATE_KEY = "PrivateKey";
    /** 一个Byte所包含的bit数 */
    public static final int BYTE_IN_BITS = 8;
    /** RSA加密明文最大长度跟公钥长度的差值 */
    public static final int PT_MAXLEN_OFFSET = 11;
    
    /**
     * 生成RSA公密钥对。
     * 
     * @param keyLength
     *            生成公钥对的长度 （bis）
     * @return Map， 通过PUBLIC_KEY PRIVATE_KEY获取。
     * @throws NoSuchAlgorithmException
     *             NoSuchAlgorithmException
     */
    public static Map<String, Object> generateKey(int keyLength) throws NoSuchAlgorithmException {
        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance(ALGORITHM_RSA);
        keyPairGen.initialize(keyLength);
        
        KeyPair keyPair = keyPairGen.generateKeyPair();
        
        RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
        RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();
        
        Map<String, Object> keyMap = new HashMap<String, Object>(2);
        
        keyMap.put(PUBLIC_KEY, publicKey);
        keyMap.put(PRIVATE_KEY, privateKey);
        
        return keyMap;
    }
    /** 
     * 取得公钥 
     *   
     * @param keyMap 
     * @return base64编码的公钥字符串
     * @throws UnsupportedEncodingException 
     * @throws UnsupportedEncodingException  Exception
     */ 
    public static String getPublicKey(Map<String, Object> keyMap) throws UnsupportedEncodingException {   
        Key key = (Key) keyMap.get(PUBLIC_KEY);   
        
        return Base64.encode(key.getEncoded(), "utf-8");   
    }   

    /** *//** 
     * 取得私钥 
     *   
     * @param keyMap 
     * @return base64编码的私钥字符串
     * @throws Exception 
     */ 
    public static String getPrivateKey(Map<String, Object> keyMap)   
            throws Exception {   
        Key key = (Key) keyMap.get(PRIVATE_KEY);   

        return Base64.encode(key.getEncoded(), "utf-8");   
    }   
    

    /**
     * 解密<br> 
     * 用私钥解密
     *   
     * @param data 需要解密的数据
     * @param key 私钥（base64编码）
     * @return 解密后的数据
     * @throws Exception Exception
     */ 
    public static byte[] decryptByPrivateKey(byte[] data, String key)   
            throws Exception {   
        // 对密钥解密   
        byte[] keyBytes = Base64.decode(key.getBytes());   

        // 取得私钥   
        PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(keyBytes);   
        KeyFactory keyFactory = KeyFactory.getInstance(ALGORITHM_RSA);   
        Key privateKey = keyFactory.generatePrivate(pkcs8KeySpec);   

        // 对数据解密   
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");   
        cipher.init(Cipher.DECRYPT_MODE, privateKey);   

        return cipher.doFinal(data);   
    }

    /**
     * 解密长串<br>
     * 用私钥解密
     * 
     * @param data
     *            需要解密的数据
     * @param key
     *            私钥（base64编码）
     * @param keyLength
     *            密钥长度（bits）
     * @return 解密后的数据
     * @throws Exception
     *             Exception
     */
    public static byte[] decryptLongByPrivateKey(byte[] data, String key, int keyLength) throws Exception {
        // 对密钥解密
        byte[] keyBytes = Base64.decode(key.getBytes());

        // 取得私钥
        PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(ALGORITHM_RSA);
        Key privateKey = keyFactory.generatePrivate(pkcs8KeySpec);

        // 对数据解密
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(Cipher.DECRYPT_MODE, privateKey);

        // 公钥长度转换成byte
        int keySize = keyLength / BYTE_IN_BITS;

        StringBuilder sb = new StringBuilder();
        int dataLen = data.length;
        int index = 0;
        while (index < dataLen) {
            int left = dataLen - index;
            int readLen = keySize < left ? keySize : left;
            byte[] buffer = new byte[readLen];
            System.arraycopy(data, index, buffer, 0, readLen);
            index += readLen;
            sb.append(new String(cipher.doFinal(buffer)));
        }

        return sb.toString().getBytes();
    }   

    /** 
     * 解密<br> 
     * 用私钥解密 
     *   
     * @param data 需要解密的数据
     * @param key 公钥（base64编码）
     * @return 解密后的数据
     * @throws Exception Exception
     */ 
    public static byte[] decryptByPublicKey(byte[] data, String key)   
            throws Exception {   
        // 对密钥解密   
        byte[] keyBytes = Base64.decode(key.getBytes());

        // 取得公钥   
        X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(keyBytes);   
        KeyFactory keyFactory = KeyFactory.getInstance(ALGORITHM_RSA);   
        Key publicKey = keyFactory.generatePublic(x509KeySpec);   

        // 对数据解密   
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");   
        cipher.init(Cipher.DECRYPT_MODE, publicKey);   

        return cipher.doFinal(data);   
    }   

    /**
     * 加密
     * 用公钥加密 
     *   
     * @param data 需要加密的数据
     * @param key 公钥（base64编码）
     * @return 加密后的数据
     * @throws Exception  Exception
     */ 
    public static byte[] encryptByPublicKey(byte[] data, String key)   
            throws Exception {   
        // 对公钥解密   
        byte[] keyBytes = Base64.decode(key.getBytes());   

        // 取得公钥   
        X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(keyBytes);   
        KeyFactory keyFactory = KeyFactory.getInstance(ALGORITHM_RSA);   
        Key publicKey = keyFactory.generatePublic(x509KeySpec);   

        // 对数据加密   
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");   
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);   

        return cipher.doFinal(data);   
    }

    /**
     * 加密超长串 用公钥加密
     * 
     * @param data
     *            需要加密的数据
     * @param key
     *            公钥（base64编码） *
     * @param keyLength
     *            密钥长度（bits）
     * @return 加密后的数据
     * @throws Exception
     *             Exception
     */
    public static byte[] encryptLongByPublicKey(byte[] data, String key, int keyLength) throws Exception {
        // 对公钥解密
        byte[] keyBytes = Base64.decode(key.getBytes());

        // 取得公钥
        X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(ALGORITHM_RSA);
        Key publicKey = keyFactory.generatePublic(x509KeySpec);

        // 对数据加密
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);

        // 公钥长度
        int keySize = keyLength / BYTE_IN_BITS;
        // 明文长度不能超过公钥长度 - 11
        int ptSize = keySize - PT_MAXLEN_OFFSET;

        int dataLen = data.length;

        // 申请： 分段数量 * keySize的内存
        // (加密的时候用StringBuilder会导致长度不对，原因应该是按公钥长度截断byte数组会导致字符被截断
        byte[] relt = new byte[((dataLen + ptSize - 1) / ptSize) * keySize];
        int index = 0;
        int offset = 0;
        while (index < dataLen) {
            int left = dataLen - index;
            int readLen = ptSize < left ? ptSize : left;
            byte[] buffer = new byte[readLen];
            System.arraycopy(data, index, buffer, 0, readLen);
            index += readLen;
            System.arraycopy(cipher.doFinal(buffer), 0, relt, offset, keySize);
            offset += keySize;
        }

        return relt;
    }

    /** 
     * 加密
     * 用私钥加密 
     *   
     * @param data 要加密的数据
     * @param key 私钥（base64编码）
     * @return 加密后的数据
     * @throws Exception  Exception
     */ 
    public static byte[] encryptByPrivateKey(byte[] data, String key)   
            throws Exception {   
        // 对密钥解密   
        byte[] keyBytes = Base64.decode(key.getBytes());

        // 取得私钥   
        PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(keyBytes);   
        KeyFactory keyFactory = KeyFactory.getInstance(ALGORITHM_RSA);   
        Key privateKey = keyFactory.generatePrivate(pkcs8KeySpec);   

        // 对数据加密   
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");   
        cipher.init(Cipher.ENCRYPT_MODE, privateKey);   

        return cipher.doFinal(data);   
    }
    
    /**
     * 根据 根据 modulus 和 Exponent 生成公钥
     * @param modulus modulus
     * @param publicExponent Exponent
     * @return 公钥
     * @throws Exception Exception
     */
    public static RSAPublicKey generateRSAPublicKey(BigInteger modulus, BigInteger publicExponent) 
        throws Exception {  
        
        KeyFactory keyFac = null;  
        try {  
            keyFac = KeyFactory.getInstance("RSA"); 
        } catch (NoSuchAlgorithmException ex) {  
            throw new Exception(ex.getMessage());  
        }  
        RSAPublicKeySpec priKeySpec = new RSAPublicKeySpec(modulus, publicExponent);  
        try {  
            return (RSAPublicKey) keyFac.generatePublic(priKeySpec);  
        } catch (InvalidKeySpecException ex) {  
            throw new Exception(ex.getMessage());  
        }  
    }  
    
    /**
     * 根据 根据 modulus 和 Exponent 生成私钥
     * @param modulus modulus
     * @param privateExponent Exponent
     * @return 私钥
     * @throws Exception Exception
     */
    public static RSAPrivateKey generateRSAPrivateKey(BigInteger modulus, BigInteger privateExponent)
        throws Exception {  
        
        KeyFactory keyFac = null;  
        try {  
            keyFac = KeyFactory.getInstance("RSA"); 
        } catch (NoSuchAlgorithmException ex) {  
            throw new Exception(ex.getMessage());  
        }  
        RSAPrivateKeySpec priKeySpec = new RSAPrivateKeySpec(modulus, privateExponent);  
        try {  
            return (RSAPrivateKey) keyFac.generatePrivate(priKeySpec);  
        } catch (InvalidKeySpecException ex) {  
            throw new Exception(ex.getMessage());  
        }  
    }      
}