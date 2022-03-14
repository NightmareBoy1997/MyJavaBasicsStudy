package comguigu.java;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 *
 * RandomAccessFile的使用
 *  1. RandomAccessFile直接继承于java.lang.Object类，实现了 DataInput 和 DataOutput 接口
 *  2. RandomAccessFile既可以作为一个输出流，也可以作为一个输出流
 *
 *  3. 如果RandomAccessFile作为输出流时，写出到的文件如果不存在，则在执行中自动创建。
 *     如果已经存在，则会对原有文件进行覆盖（默认情况下，从头覆盖）
 *
 *
 *  4. 可以通过相关的操作实现 RandomAccessFile 实现"插入"数据的效果
 *
 * @author Freak-W
 * @create 2021-09-13 21:57
 */
public class RandomAccessFileTest {

    @Test
    public void test1(){


        RandomAccessFile raf1= null;
        RandomAccessFile raf2= null;
        try {
            raf1 = new RandomAccessFile(new File("樱木花道.jpg"),"r");
            raf2 = new RandomAccessFile(new File("樱木花道2.jpg"),"rw");

            byte[] buffer=new byte[1024];
            int len;
            while((len=raf1.read(buffer))!=-1){
                raf2.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            if (raf1 != null || raf2 != null)

                try {
                    raf1.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }

            if(raf2!=null){

                try {
                    raf2.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }




    }

    @Test
    public void test2() throws IOException {
        RandomAccessFile raf1=new RandomAccessFile("hello.txt","rw" );

        raf1.seek(3); //将指针调到角标为3的位置
        raf1.write("xyz".getBytes()); //
        raf1.close();

    }


    /*使用RandomAccessFile实现文档插入的效果

     */
    @Test //ME
    public void test3() throws IOException {
        RandomAccessFile raf1=new RandomAccessFile("hello.txt","rw" );
        byte[] bytes=new byte[1024];
        int len=0;
        int i=1;

        while((len=raf1.read(bytes))!=-1){

            for(;i>0;i--){

                raf1.seek(3);
            }
            raf1.write(bytes,0,len);

//            raf1.flush();
        }

        raf1.seek(3); //将指针调到角标为3的位置
//
        raf1.write("AAA".getBytes()); //

        raf1.close();

    }
    @Test //GUIGU
    public void test4() throws IOException {
        RandomAccessFile raf1=new RandomAccessFile("hello.txt","rw" );
        raf1.seek(3);
        //保存指针3后面的所有数据到StringBuilder中
        byte[] bytes=new byte[1024];
        StringBuilder builders=new StringBuilder((int)"hello.txt".length());

        int len;
        while((len=raf1.read(bytes))!=-1){

            builders.append(new String(bytes,0,len));

//            raf1.flush();
        }

        raf1.seek(3); //将指针调回角标为3的位置,写入AAA
        raf1.write("AAA".getBytes()); //

        //将StringBuilder中的字符写出到文档中
        raf1.write(builders.toString().getBytes());

        raf1.close();

    }


}
