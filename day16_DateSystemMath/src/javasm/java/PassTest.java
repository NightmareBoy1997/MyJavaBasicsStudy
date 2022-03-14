package javasm.java;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;

/**
 * @projectName: MyJavaStudy
 * @package: javasm.java
 * @author: Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-02-28 22:51
 *
 *  1. 加密： 用户注册/路径/接口路径/参数 不能明文暴露，必须密文传递/秘文存储
 *  2. 解密：
 *
 *  加密方式： Base64  Md5
 *      Base64 : 是可逆的
 *
 *      Md5 : 不可逆的
 *
 *
 */
public class PassTest {

    public static void main(String[] args) {
        base64Test1();
        base64Test2();

        md5Test1();

    }

    // Md5
    private static void md5Test1() {
        String pass = "1234";
        pass += SALT;

        try {
            // 1. 获得信息摘要对象
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");

            // 2. 更新摘要算法 ---> 将要加密的文本数据传输到算法中
            messageDigest.update(pass.getBytes());

            // 3. 执行加密操作
            byte[] bytes = messageDigest.digest();
            System.out.println(Arrays.toString(bytes));
            String byteString = new String(bytes);
//            System.out.println(byteString);
            // 将字节数组里的每个字节数据转换为对应的16进制的字符
            // 一个16进制的字符 4bit  一个字节---> 转换为2个16进制的字符
            BigInteger bigInteger = new BigInteger(1,bytes);
            System.out.println(bigInteger.toString(16));




        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }


    }


    // 4. 推荐手动转换16进制的数据
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


    // 登录
    private static void base64Test2() {
        String pass = "MTIzNHdlaWd1b3FpQCReKiZAJioo";

        // 获得Base64解码器
        Base64.Decoder decoder = Base64.getDecoder();
        byte[] bytes = decoder.decode(pass);
        String string = new String(bytes);
        System.out.println(string);

    }

    // 加盐 , 但 Base64 是完全可逆的
    private static final String SALT = "weiguoqi@$^*&@&*(";

    //
    private static void base64Test1() {
        String pass = "1234";
        pass += SALT;

        // Base64
        // 编码/加密 ---> 编码器
        // 1. 获得编码器
        Base64.Encoder encoder = Base64.getEncoder();
        // 2. 对文本数据加密处理
        String s = encoder.encodeToString(pass.getBytes());
        System.out.println(s);

    }

}