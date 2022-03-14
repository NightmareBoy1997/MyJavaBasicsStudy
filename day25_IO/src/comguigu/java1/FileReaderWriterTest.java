package comguigu.java1;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 一、流的分类：
 * 1. 操作数据单位不同：字节流、字符流
 * 2. 数据的流向： 输入流、输出流
 * 3. 流的角色： 节点流、处理流
 * <p>
 * 二、 流的体系结构
 * 抽象基类                 节点流(文件流)                                 缓冲流(处理流的一种)
 * InputStream              FileInputStream   ( read(byte[] buffer) )     BufferedInputStream    ( read(byte[] buffer) )
 * OutputStream             FileOutputStream  ( read(byte[] buffer) )     BufferedOutputStream   ( read(byte[] buffer) )      flush()
 * Reader                   FileReader  ( read(char[]) )                  BufferedReader         ( read(char[]) / readLine()  )
 * Writer                   FileWriter  ( write(char[] cbuf,0,len) )      BufferedWriter         ( write(char[] cbuf,0,len) )   flush()
 *
 * @author Freak-W
 * @create 2021-05-18 22:51
 */
public class FileReaderWriterTest {

    /*
    将day26的hello.txt文件内容读入程序，并打印

    说明：
      1. read(): 返回读入的一个字符，如果文件达到末尾，返回-1
      2. 异常的处理：为了保证资源一定可以执行关闭，需要使用try-catch-finally处理
      3. 数据的读入必须要求文件存在，否则会报：FileNotFoundException

     */
    @Test
    public void testFileReader() {
        FileReader fr = null;

        try {
            // 1. 实例化File类的对象，指明要操作的文件
            File file1 = new File("hello.txt"); //相较于当前Module下

            // 2. 提供具体的流
            fr = new FileReader(file1);

            // 3. 数据的读入
            // read(): 返回读入的一个字符，如果文件达到末尾，返回-1
            //方式一
//        int data=fr.read();
//        while(data!=-1){
//            System.out.print((char)data);
//            data=fr.read();
//        }

            //方式二：优化操作
            int data;
            while ((data = fr.read()) != -1) {
                System.out.print((char) data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 4. 流的关闭操作
            try {
                if (fr != null) {
                    fr.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    // 对read()操作升级：使用read的重载方法
    @Test
    public void testFileReader1() {
        FileReader fr = null;

        try {
            // 1. File类的实例化
            File file = new File("hello.txt");

            // 2. FileReader流的实例化
            fr = new FileReader(file);

            // 3. 读入的操作
            // read(char[] arr)： 返回每次读入arr数组中的字符的个数，如果达到文件末尾，返回-1
            char[] arr = new char[5];
            int len;
            while ((len = fr.read(arr)) != -1) {

                //方式一：for
                // 错误的
//                for (int i = 0;i<arr.length; i++) {
//                    System.out.print(arr[i]);
//                }

                //正确的
//                for (int i = 0;i<len; i++) {
//                    System.out.print(arr[i]);
//                }

                //方式二： String
                //错误的：对应方式一的错误
//                String str=new String(arr);
//                System.out.print(str);

                //正确的
                String str = new String(arr, 0, len);
                System.out.print(str);


            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            // 4. 资源的关闭
            try {
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }


    /*
    从内存中写出数据到硬盘文件里。

    说明：
        1. 输出操作，对应的File可以不存在，不会报异常。
        2. File对应的硬盘文件如果不存在，会在输出过程中自动创建
            如果存在：
                  如果流使用的构造器是：FileWriter(file,false)/FileWriter(file)    ：会对原有文件进行覆盖
                  如果流使用的构造器是：FileWriter(file,true)      ：不会对原有文件覆盖，而是在原有内容基础上追加写出
     */
    @Test
    public void testFileWriter() {
        FileWriter fw = null;

        try {
            // 1. 提供File类的对象，指明要写出到的文件
            File file = new File("hello1.txt");

            // 2. 流的实例化：提供FileWriter的对象，用于数据的写出
            fw = new FileWriter(file, true);

            // 3. 写出的操作
            fw.write("\nI have a dream! \n\n");
            fw.write("you need to have a dream !");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            // 4. 资源的关闭
            try {
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }


    }

    // 不能在单元测试中使用
    @Test
    public void testFileReaderFileWriter() {
        FileReader fr = null;
        FileWriter fw = null;

        try {
            // 1. 创建File类的对象，指明读入和写出的文件

            File srcFile = new File("hello.txt");
            File destFile = new File("Hello2.txt");

            // 2. 流的实例化：输入流和输出流
            fr = new FileReader(srcFile);
            fw = new FileWriter(destFile, false);

            // 3. 数据的读入和写出
            char[] arr = new char[5];
            int len;    //记录每次读入到arr数组中的字符个数
            while ((len = fr.read(arr)) != -1) {
                // 读入，每次读取len个字符
                String str = new String(arr, 0, len);
                System.out.print(str);

                // 写出，每次写出len个字符
                fw.write(arr, 0, len);

            }

//        for (int i = 0; i <len ; i++) {
//
//        }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {


            // 4. 资源的关闭
            try {
                if (fr != null)
                    fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                if (fw != null)
                    fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }


        }

    }


}
