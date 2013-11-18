package com.baidu.lxy;

import sun.security.pkcs.PKCS7;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.security.cert.X509Certificate;

/**
 * @author luxiaoyu01@baidu.com
 * @date 2013-7-30
 * @version
 * @todo
 */
public class ApkParser2 {
    public static X509Certificate readSignatureBlock(InputStream in) throws IOException,
            GeneralSecurityException {
        PKCS7 pkcs7 = new PKCS7(in);
        return pkcs7.getCertificates()[0];
    }

    public static void main(String[] args) throws FileNotFoundException, IOException,
            GeneralSecurityException {
        X509Certificate publicKey = readSignatureBlock(new FileInputStream("c:\\BDMOBILE.RSA"));
        System.out.println("issuer:" + publicKey.getIssuerDN());
        System.out.println("subject:" + publicKey.getSubjectDN());
        System.out.println(publicKey.getPublicKey());
    }
}
