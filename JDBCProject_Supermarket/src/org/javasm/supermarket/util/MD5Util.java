package org.javasm.supermarket.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @projectName: MyJavaStudy
 * @package: org.javasm.supermarket.util
 * @author: Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-03-18 22:48
 */
public class MD5Util {
    private static MessageDigest messageDigest;

    static {
        try {
            messageDigest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param password 要加密的密码字符串
     * @return 加密后的16进制密码字符串
     */
    public static String getMD5Password(String password){
        final byte[] digest = messageDigest.digest(password.getBytes());

        final String s = new BigInteger(1,digest).toString(16).toUpperCase();
        return s;
    }

}