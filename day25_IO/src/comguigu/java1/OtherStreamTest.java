package comguigu.java1;

import org.junit.jupiter.api.Test;

import java.io.*;

/**
 * 其他流的使用
 * 1. 标准的输入、输出流
 * 2. 打印流
 * 3. 数据流
 *
 * @author Freak-W
 * @create 2021-05-26 11:11
 */
public class OtherStreamTest {


    /*
    1. 标准的输入、输出流
    System.in: 标准的输入流，默认从键盘输入
    System.out: 标准的输出流，默认从控制台输出

    1.2
    System类的senIn(InputStream is) / setOut(PrintStream ps) 方式重新指定输入和输出的流

    1.3 练习：
    从键盘输入字符串，要求将读取到的整行字符串转成大写输出。然后继续进行输入操作，直至当输入“e”或者“exit”时，退出程序。

    方法一： Scanner,调用next()返回一个字符串
    方法二： 使用System.in实现。System.in ---> 转换流 ---> BufferedReader的readline()

     */
    public static void main(String[] args) {

        BufferedReader br = null;
        try {
            InputStreamReader isr = new InputStreamReader(System.in);

            br = new BufferedReader(isr);

            while (true) {
                System.out.print("请输入字符串：");
                String data = br.readLine();
                if ("e".equalsIgnoreCase(data) || "exit".equalsIgnoreCase(data)) {
                    System.out.println("程序结束！");
                    break;
                }
                System.out.println(data.toUpperCase());


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
        }


    }


    /*
    2. 打印流： PrintStream 和 PrintWriter

    2.1 提供了一系列重载的print() 和 println()
    2.2 练习：



     */
    @Test
    public void test1() {

        PrintStream ps = null;
        try {
            FileOutputStream fos = new FileOutputStream(new File("D:\\IO\\text.txt"));
            // 创建打印输出流,设置为自动刷新模式(写入换行符或字节 '\n' 时都会刷新输出缓冲区)
            ps = new PrintStream(fos, true);
            if (ps != null) {
                // 把标准输出流(控制台输出)改成文件
                System.setOut(ps);
            }
            for (int i = 0; i <= 255; i++) {
                // 输出ASCII字
                System.out.print((char) i);
                if (i % 50 == 0) {
                    // 每50个数据一行
                    System.out.println(); // 换行
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (ps != null) {
                ps.close();
            }
        }

    }


    /*
    3. 数据流
    3.1 DataInputStream 和 DataOutputStream
    3.2 作用：用于读取或写出基本数据类型的变量或字符串

    3.3 练习：将内存中的字符串、基本数据类型的变量写出到文件中
     */
    @Test
    public void test2() throws IOException {

        DataOutputStream dos=new DataOutputStream(new FileOutputStream("data.txt"));

        dos.writeUTF(new String("德玛西亚之力"));
        dos.writeUTF("盖伦");
        dos.writeUTF("450");
        dos.writeBoolean(true);
        dos.flush();

        dos.close();

    }

    /*
    将文件中存储的基本数据类型和字符串读取到内存中，保存在变量中。

    注意点：读取不同类型的数据的顺序要与当初写入文件时，保存的数据的顺序一致！！

     */
    @Test
    public void test3() throws IOException {

        // 1.
        DataInputStream dis=new DataInputStream(new FileInputStream("data.txt"));

        // 2.
        String name=dis.readUTF();
        String names=dis.readUTF();
        int j=dis.readInt();
        Boolean attack=dis.readBoolean();

        System.out.println("称号："+name);
        System.out.println("名字："+names);
        System.out.println("金币： "+j);
        System.out.println("t0： "+attack);


        dis.close();



    }



}
