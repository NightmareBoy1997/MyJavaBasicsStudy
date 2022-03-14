package comguigu.exercise1;

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
public class OtherStreamTest2 {

    public static void main(String[] args) {

//        systemInTest();
//
//        printStreamTest();
//
//        dataInputStreamTest();

        dataOutputStreamTest();



    }




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
    private static void systemInTest(){
            try (InputStreamReader inputStream = new InputStreamReader(System.in);
                 BufferedReader bufferedReader = new BufferedReader(inputStream);
            ) {
                StringBuilder stringBuilder = new StringBuilder(16);

                while (true) {
                    System.out.print("请输入字符： ");
                    String string = bufferedReader.readLine();
                    String upperString = string.toUpperCase();
                    System.out.println(upperString);

                    String regex = "^[e|exit]$";
                    System.out.print("是否继续(e/exit退出)？： ");
                    String isExit = bufferedReader.readLine();
                    if ("e".equalsIgnoreCase(isExit) | "exit".equalsIgnoreCase(isExit)) {
                        break;
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        /*
    2. 打印流： PrintStream 和 PrintWriter

    2.1 提供了一系列重载的print() 和 println()
    2.2 练习：
    */
    public static void printStreamTest() {

        try(  PrintStream printStream = new PrintStream("day_IO\\src\\java1.txt");

        ) {
            System.setOut(printStream);

            String string = "arraylist";
            System.out.println(string);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }




    /*
    3. 数据流
    3.1 DataInputStream 和 DataOutputStream
    3.2 作用：用于读取或写出基本数据类型的变量或字符串

    3.3 练习：将内存中的字符串、基本数据类型的变量写出到文件中
     */
    private static void dataInputStreamTest() {

        try(  FileOutputStream fileOutputStream = new FileOutputStream("day_IO\\src\\java31.txt");
              DataOutputStream dataoutputStream = new DataOutputStream(fileOutputStream);
        ) {

            String string = "java";
            String string1 = "java1";
            boolean boolean1= false;
            char char1 = 'a';
            int number = 12;

            dataoutputStream.writeUTF(string);
            dataoutputStream.writeUTF(string1);
            dataoutputStream.writeChar(char1);
            dataoutputStream.writeBoolean(boolean1);
            dataoutputStream.writeInt(12);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /*
    将文件中存储的基本数据类型和字符串读取到内存中，保存在变量中。
    注意点：读取不同类型的数据的顺序要与当初写入文件时，保存的数据的顺序一致！！

     */
    private static void dataOutputStreamTest() {

        try( FileInputStream fileInputStream = new FileInputStream("day_IO\\src\\java31.txt");
             DataInputStream dataInputStream = new DataInputStream(fileInputStream);
        ) {

            String string = dataInputStream.readUTF();
            String string1 = dataInputStream.readUTF();
            char char1 = dataInputStream.readChar();
            boolean boolean1 = dataInputStream.readBoolean();
            int number = dataInputStream.readInt();

            System.out.println(string);
            System.out.println(string1);
            System.out.println(char1);
            System.out.println(boolean1);
            System.out.println(number);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }



}



