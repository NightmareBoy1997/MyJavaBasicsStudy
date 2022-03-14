package javasm.javasm.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;

/**
 * @author: Lisa
 * @className: PassDemo
 * @description:
 * @date: 2022/2/28 16:49
 * @version: 0.1
 * @since: jdk11
 */
public class PassDemo {

    public static void main(String[] args) {


        System.out.println(MD5Util.md5("1234"));
    }

    private static void md5() {
        String pass = "1234";
        try {
            //1.获得信息摘要对象
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            //2.更新摘要算法---->将要加密的文本数据传输到算法中
            pass = pass + SALT;
            messageDigest.update(pass.getBytes());
            //3.执行加密操作
            byte[] bytes = messageDigest.digest();
            //将字节数组里面的每个字节数据转换成对应的16进制的字符
            //一个字节数据可以转成几个16进制内字符数据?
            //一个字节 8bit
            //一个16进制的字符  4bit
            //一个字节----> 转换成2个16进制的字符
            //-128-127
           /* StringBuilder builder = new StringBuilder();
            for (byte aByte : bytes) {
                int num = aByte;
                if (num < 0) {
                    num += 256;
                }
                int low = num / 16;
                int high = num % 16;
                builder.append(array[low]).append(array[high]);
            }
            System.out.println(builder);*/
            //BigInteger
            String s = new BigInteger(1, bytes).toString(16);
            System.out.println(s);

            //81dc9bdb52d04dc20036dbd8313ed055

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }


    }

    //16进制里面字符数据是固定  0-F
    //0-15
    static char[] array = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    //登录: 再加密  与加密之后数据进行比较
    private static void demo2() {
        String pass = "MTIzNHpoYW5nc2FuJSQjQCE=";

        //1.获得Base64解码器
        Base64.Decoder decoder = Base64.getDecoder();
        byte[] bytes = decoder.decode(pass);
        //字节数组转String
        String s = new String(bytes);
        System.out.println(s);
    }

    //Base64是完全可逆的。
    //加盐
    private static final String SALT = "zhangsan%$#@!";

    //模拟注册
    private static void demo1() {
        String pass = "1234";
        pass = pass + SALT;
        //Base64(使用一些字母和数字和特殊符号组成)
        //编码/加密----> 编码器
        //1.获得编码器
        Base64.Encoder encoder = Base64.getEncoder();
        //2.对文本数据进行加密处理
        //将字符串转换成字节数组
        String encodePass = encoder.encodeToString(pass.getBytes());
        System.out.println(encodePass);//MTIzNA==
    }
}
