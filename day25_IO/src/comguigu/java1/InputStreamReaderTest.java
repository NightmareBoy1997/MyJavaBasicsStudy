package comguigu.java1;

import org.junit.jupiter.api.Test;

import java.io.*;

/**
 *
 * 处理流之二： 转换流的使用
 *  1. 转换流：属于字符流
 *      InputStreamReader ：将一个字节的输入流转换为字符的输入流
 *      OutputStreamWriter ： 将一个字符的输出流转换为字节的输出流
 *
 *  2. 作用：提供字符流与字节流直接的转换
 *
 *  3. 解码： 字节、字节数组 ---> 字符数组、字符串
 *     编码： 字符数组、字符串 ---> 字节、字节数组
 *
 *  4. 字符集：
 *     常见的编码表
 *     ASCII：美国标准信息交换码。
 *           用一个字节的7位可以表示。
 *    ISO8859-1：拉丁码表。欧洲码表
 *           用一个字节的8位表示。
 *     GB2312：中国的中文编码表。最多两个字节编码所有字符
 *     GBK：中国的中文编码表升级，融合了更多的中文文字符号。最多两个字节编码
 *     Unicode：国际标准码，融合了目前人类使用的所有字符。为每个字符分配唯一的字符码。所有的文字都用两个字节来表示。
 *     UTF-8：变长的编码方式，可用1-4个字节来表示一个字
 *
 *
 *
 *
 * @author Freak-W
 * @create 2021-05-25 17:15
 */
public class InputStreamReaderTest {


    /*
    InputStreamReader实现字节的输入流到字符的输入流的转换

    此时处理异常，简略使用throws

     */
    @Test
    public void test1() throws IOException {

        FileInputStream fis=new FileInputStream("dbcp.txt");
//        InputStreamReader isr=new InputStreamReader(fis);  // 使用系统默认的字符集
        // 参数2指明了字符集，具体使用哪个字符集，取决于文件的保存格式字符集决定
        InputStreamReader isr=new InputStreamReader(fis,"UTF-8");

        char[] chars=new char[20];
        int len;
        while((len=isr.read(chars))!=-1){
            String str=new String(chars,0,len);
            System.out.print(str);
        }


    }


    /*
    综合使用InputStreamReader 和 OutputStreamWriter

     */
    @Test
    public void test2(){

        InputStreamReader isr= null;
        OutputStreamWriter osw= null;

        try {
            FileInputStream fis=new FileInputStream("dbcp.txt");
            FileOutputStream fos=new FileOutputStream("dbcp_gbk.txt");

            isr = new InputStreamReader(fis,"utf-8");
            osw = new OutputStreamWriter(fos,"gbk");

            int len;
            char[] chars=new char[20];
            while((len=isr.read(chars))!=-1){

                osw.write(chars,0,len);

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            if(isr!=null){

                try {
                    isr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

            if(osw!=null){

                try {
                    osw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

        }

    }








}
