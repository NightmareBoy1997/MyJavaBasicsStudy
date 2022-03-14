package comguigu.java1;

import org.junit.jupiter.api.Test;

import java.io.*;

/**
 * 处理流之一：缓冲流的使用
 * <p>
 * 1. 缓冲流
 * BufferedInputStream
 * BufferedOutputStream
 * BufferedReader
 * BufferWriter
 * <p>
 * 2. 作用：提供流的读取、写入的速度
 * 提高读写速度的原因：内部提供了一个缓冲区
 * <p>
 * 3. 处理流，就是“套接”在 已有的流 的基础之上
 *
 * @author Freak-W
 * @create 2021-05-25 15:11
 */
public class BufferedTest {

    /*
    实现非文本文件的复制

     */
    @Test
    public void BufferedStream() {

//        FileInputStream fi=null;
//        FileOutputStream fo=null;
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;

        try {
            // 1. 造文件
            File srcFile = new File("d:\\百分下载\\io\\西游记.mp4");
            File destFile = new File("d:\\百分下载\\io\\西游记1.mp4");

            // 2. 造流
            // 2.1 造节点流
            FileInputStream fi = new FileInputStream(srcFile);
            FileOutputStream fo = new FileOutputStream(destFile);
            // 2.2 造缓冲流
            bis = new BufferedInputStream(fi);
            bos = new BufferedOutputStream(fo);


            // 3. 读取写入
            byte[] bytes = new byte[1024];
            int len;
            while ((len = bis.read(bytes)) != -1) {

                bos.write(bytes, 0, len);

            }

            System.out.println("复制完成!");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 4. 关闭流
            // 要求：先关闭外层的流，再关闭内层的流。
            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }


            //说明：关闭外层流的同时，内层流也会自动关闭。关闭内层流的操作可以省略

//            if(fi!=null){
//                try {
//                    fi.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//
//            if(fo!=null){
//
//                try {
//                    fo.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//
//            }


        }


    }


    //实现文件复制的方法
    public void bufferedStream(String srcStr, String destStr) {

//        FileInputStream fi=null;
//        FileOutputStream fo=null;
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;

        try {
            File srcFile = new File(srcStr);
            File destFile = new File(destStr);

            FileInputStream fi = new FileInputStream(srcFile);
            FileOutputStream fo = new FileOutputStream(destFile);
            bis = new BufferedInputStream(fi);
            bos = new BufferedOutputStream(fo);

            byte[] bytes = new byte[1024];
            int len;
            while ((len = bis.read(bytes)) != -1) {

                bos.write(bytes, 0, len);

//                bos.flush(); //刷新缓冲区

            }


        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            if (bis != null) {

                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            if (bos != null) {

                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }


    @Test
    public void bufferedStreamTest() {

        long strat1 = System.currentTimeMillis();

        bufferedStream("d:\\百分下载\\io\\西游记.mp4", "d:\\百分下载\\io\\西游记1.mp4");

        long end1 = System.currentTimeMillis();


        long strat2 = System.currentTimeMillis();

        FileInputOutputStreamTest IOS = new FileInputOutputStreamTest();
        IOS.copyFile("d:\\百分下载\\io\\西游记.mp4", "d:\\百分下载\\io\\西游记3.mp4");

        long end2 = System.currentTimeMillis();

        System.out.println("花费的时间为：" + (end1 - strat1)); //233
        System.out.println("花费的时间为：" + (end2 - strat2)); //742


    }


    /*
    使用BufferedReader 和 BufferedWriter 实现文本的复制

     */
    @Test
    public void testBufferedReaderWriter() {

        BufferedReader br = null;
        BufferedWriter bw = null;

        try {

            File srcFile = new File("dbcp.txt");
            File destFile = new File("dbcp2.txt");

            FileReader fr = new FileReader(srcFile);
            FileWriter fw = new FileWriter(destFile);

            br = new BufferedReader(fr);
            bw = new BufferedWriter(fw);

            // 读写操作:
            // 方式一：char[] 数组
//            int len;
//            char[] chars = new char[10];
//            while ((len = br.read(chars)) != -1) {
//
//                bw.write(chars, 0, len);
////                bw.flush();
//
//            }

            // 方式二： 使用String
            String data;
            while((data=br.readLine())!=null){

                // 方法一：
//                bw.write(data+"\n"); //data中不包含换行符
                // 方法二：
                bw.write(data);
                bw.newLine();

            }


        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            if (br != null) {

                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

            if (bw != null) {

                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

        }


    }


}
