package comguigu.java;

import org.junit.jupiter.api.Test;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 * 涉及到String类其他结构之间的转换
 *
 * @author shkstart
 * @create 2021-03-19 11:09
 */
public class StringTest1 {

    /*
    复习：
    String 与基本数据类型、包装类之间的转换。
    String--> 基本数据类型、包装类 :调用包装类的静态方法：parseXXX(str)
    基本数据类型、包装类-->String ：调用String重载的valueOf()方法 / +“”


     */

    @Test
    public void test1() {
        String str1 = "123";
        int num = Integer.parseInt(str1);

        int num1 = 234;
        String str2 = String.valueOf(num1);
        String str3 = num1 + "";

        System.out.println(str1 == str3);

    }


    /*
    String 与char[]之间的转换: 调用string的toCharArray()
    char[]-->String： 调用String的构造器


     */
    @Test
    public void test2() {

        String str1 = "abc123";
        char[] charArray = str1.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            System.out.println(charArray[i]);
        }

        char[] arr = new char[]{'h', 'e', 'l', 'l', 'o'};
        String str2 = new String(arr);
        System.out.println(str2);

    }


    /*
    String 与byte[]之间的转换
    编码 ：String --> byte[]:调用String的getBytes()
    解码 :byte[] --> String： String构造器

    编码：字符串 --> 字节 (看得懂-->看不懂的二进制数据)
    解码：编码的逆过程：字节 --> 字符串 (二进制数据-->看得懂)

     */


    @Test
    public void test3() throws UnsupportedEncodingException {
        String str1 = "abc123中国";
        byte[] bytes = str1.getBytes(); //使用默认的字符集进行转换
        System.out.println(Arrays.toString(bytes));

        byte[] gbks=str1.getBytes("gbk"); //使用GBK字符集进行编码
        System.out.println(Arrays.toString(gbks));

        System.out.println("********************************");

        String str2=new String(bytes);
        System.out.println(str2);

        String str3 = new String(gbks);
        System.out.println(str3); // 乱码， 编码集跟解码集不同

    }

}
