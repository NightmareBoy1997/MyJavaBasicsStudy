package exercise.classlast.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @projectName: MyJavaStudy
 * @package: exercise.classlast.util
 * @author: Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-03-15 13:41
 */
public class MD5Util {

    static MessageDigest md5 ;

    static {
        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }


    /**
     *  密码加密
     * @param password
     * @return
     */
    public static String md5Password(String password){
        // 根据给定的字节数组更新摘要
        md5.update(password.getBytes());
        // 获取摘要
        final byte[] digest = md5.digest();

        // 转成16进制数据
        return new BigInteger(1,digest).toString(16).toUpperCase();
    }

}