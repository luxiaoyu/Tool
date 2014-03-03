/*
 * Copyright (C) 2013 Baidu Inc. All rights reserved.
 */
package com.baidu.lxy;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * MD5工具类，从Util中抽出
 * 
 * @author qiaopu
 * @since 2013-7-1
 */
public class MD5Util {
    
    /**
     * private constructor.
     */
    private MD5Util() {
        
    }
    
    /**
     * 把二进制byte数组生成 md5 32位 十六进制字符串，单个字节小于0xf，高位补0。
     * 
     * @param bytes
     *            输入
     * @param upperCase
     *            true：大写， false 小写字符串
     * @return 把二进制byte数组生成 md5 32位 十六进制字符串，单个字节小于0xf，高位补0。
     */
    public static String toMd5(byte[] bytes, boolean upperCase) {
        try {
            MessageDigest algorithm = MessageDigest.getInstance("MD5");
            algorithm.reset();
            algorithm.update(bytes);
            return toHexString(algorithm.digest(), "", upperCase);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 把二进制byte数组生成十六进制字符串，单个字节小于0xf，高位补0。
     * 
     * @param bytes
     *            输入
     * @param separator
     *            分割线
     * @param upperCase
     *            true：大写， false 小写字符串
     * @return 把二进制byte数组生成十六进制字符串，单个字节小于0xf，高位补0。
     */
    public static String toHexString(byte[] bytes, String separator,
            boolean upperCase) {
        StringBuilder hexString = new StringBuilder();
        for (byte b : bytes) {
            String str = Integer.toHexString(0xFF & b); // SUPPRESS CHECKSTYLE
            if (upperCase) {
                str = str.toUpperCase();
            }
            if (str.length() == 1) {
                hexString.append("0");
            }
            hexString.append(str).append(separator);
        }
        return hexString.toString();
    }

}
