package comguigu.java;

import org.junit.jupiter.api.Test;

import java.io.*;

/**
 * 1. 对象流的使用：ObjectInputStream 和 ObjectOutputStream
 * 2. 作用：用于存储和都区基本数据类型或对象的处理流。他的强大之处就是可以把Java中的对象写入到数据源中，也能把
 * 对象从数据源中还原回来
 *
 *  3. 要想一个java对象可以序列化，需要满足相应的要求。见Person类
 *
 *
 *  补充： ObjectOutputStream和ObjectInputStream不能序列化static和transient修饰的成员
 *
 *
 * @author Freak-W
 * @create 2021-09-13 17:36
 */
public class ObjectInputOutputStreamTest {

    /*
     序列化的过程：将内存中的Java对象保存到磁盘中或通过网络传输出去
     使用ObjectOutputStream实现


     */
    @Test
    public void testObjectOutputStream() {

        ObjectOutputStream oos = null;
        try {
            //1.造流造文件
            oos = new ObjectOutputStream(new FileOutputStream("ObjectOutputStream.txt"));
            //2.写出
            oos.writeObject(new String("北京天安門"));
            oos.flush();//刷新操作

            oos.writeObject(new Person("jack",22,151.22,159,new Account(2688.50)));
            oos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (oos != null) {
                try {
                    //3. 关闭流
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }


    /*
    反序列化的过程：将磁盘文件中的对象还原为内存中的java对象
     使用ObjectInputStream来实现



     */
    @Test
    public void testObjectInputStream() {
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream("ObjectOutputStream.txt"));

            Object obj = ois.readObject();
            String str = (String) obj;
            System.out.println(str);

            Person p1=(Person)ois.readObject();
            System.out.println(p1);


        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }


}
