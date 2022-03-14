package comguigu.java1;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


/**
 *
 *  测试 FileInputStream 和 FileOutputStream 的使用
 *
 *
 *  结论：
 *    1. 对于文本文件(.txt、 .java、 .c、 .c++)，使用字符流处理
 *    2. 对于非文本文件(图片、mp3、mp4、avi、doc、ppt……)，使用字节流处理
 *
 * @author Freak-W
 * @create 2021-05-19 18:09
 */
public class FileInputOutputStreamTest {


    //测试字节流 FileInputStream 读写文本。 读取可能会出现乱码。但写出不会影响
    @Test
    public void testFileInputStream(){
        FileInputStream fi=null;

        try {

            // 造文件
            File file =new File("hello.txt");

            //造流
            fi=new FileInputStream(file);

            //读数据
            int len;
            byte[] bytes=new byte[5];
            while((len=fi.read(bytes))!=-1){
                String str=new String(bytes,0,len);
                System.out.print(str);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            try {
                if(fi!=null)
                fi.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }


    }


    /*
    实现图片的读取复制
     */
    @Test
    public void testFileInputOutputStream(){
        FileInputStream fi=null;
        FileOutputStream fo=null;

        try {
            File srcFile=new File("卡特琳娜.jpg");
            File destFile=new File("卡特.jpg");

            fi=new FileInputStream(srcFile);
            fo=new FileOutputStream(destFile);

            byte[] bytes=new byte[10];
            int len;
            while((len=fi.read(bytes))!=-1){

                fo.write(bytes,0,len);
            }
            System.out.println("复制成功！");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            try {
                fo.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                fi.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }


    @Test
    public void testCopy(){

        long start=System.currentTimeMillis();

        copyFile("d:\\百分下载\\io\\西游记.mp4","d:\\百分下载\\io\\第16集.mp4");

        long end = System.currentTimeMillis();

        System.out.println("复制操作花费的时间为："+(end-start)); //复制操作花费的时间为：[10]55731  [1024] 797

    }




/*
指定路径下文件复制的方法
 */

    public void copyFile(String srcPath,String destPath ) {

        FileInputStream fr = null;
        FileOutputStream fo = null;

        try {
            File srcFile=new File(srcPath);
            File destFile=new File(destPath);

            fr = new FileInputStream(srcFile);
            fo = new FileOutputStream(destFile);

            byte[] bytes = new byte[1024];
            int len;    //记录每次读入到arr数组中的字符个数
            while ((len = fr.read(bytes)) != -1) {

                // 写出，每次写出len个字符
                fo.write(bytes,0,len);

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
                if (fo != null)
                    fo.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }









}
