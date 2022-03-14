package javasm.javasm.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;

/**
 * @author: Lisa
 * @className: MD5Util
 * @description:
 * @date: 2022/2/28 17:49
 * @version: 0.1
 * @since: jdk11
 */
public class MD5Util {

    private MD5Util() {
    }


    public static String md5(String sourceStr) {

        Objects.requireNonNull(sourceStr);
        StringBuilder builder = new StringBuilder();
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(sourceStr.getBytes());
            byte[] bytes = messageDigest.digest();
            for (byte aByte : bytes) {
                builder.append(byteToHex(aByte));
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return builder.toString().toUpperCase();
    }

    private static final char[] array = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    private static String byteToHex(byte aByte) {
        int num = aByte;
        if (num < 0) {
            num += 256;
        }
        int low = num / 16;
        int high = num % 16;
        return array[low] + "" + array[high];
    }
}
