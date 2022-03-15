package javasm;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @projectName: MyJavaStudy
 * @package: javasm
 * @author: Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-03-15 22:40
 */
public class MD5Util {

    static MessageDigest messageDigest ;

    // 初始化MD5
    static {
        try {
            messageDigest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    public String passwordMD5(String password){
        // 摘要处理
        byte[] digest = messageDigest.digest(password.getBytes());
        // 转换为16进制字符串 , 1参数，保证为正数
       return new BigInteger(1,digest).toString(16).toUpperCase();
    }


    @Test
    public void test(){
        String string  = "weiguoqi";
        System.out.println(passwordMD5(string));
    }

}