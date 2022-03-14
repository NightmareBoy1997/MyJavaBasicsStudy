package comguigu.exercise1;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @projectName: MyJavaStudy
 * @package: comguigu.exercise1
 * @author: Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-02-25 14:48
 */
public class FileReaderWriter {

    public static void main(String[] args) {

        File file1 = new File("day_IO\\src\\lol.txt");
        File file2 = new File("day_IO\\src\\lol2.txt");

        // 数据的写出
        try(FileWriter fileWriter = new FileWriter(file1)) {

            String str = "不拘小节，最终会坏大事；一板一眼，就会滋生弱点！\n";

            fileWriter.write(str);
            fileWriter.write("谎言不会伤人，真相才是快刀！");

            // 截断式写出
            fileWriter.write("谎言不会伤人，真相才是快刀！",0,5);

        } catch (IOException e) {
            e.printStackTrace();
        }


        // 数据的读取
//        try( FileReader fileReader = new FileReader(file2) ) {
//
//            char[] chars = new char[1024];
//
//            int len;
//            while( (len = fileReader.read(chars)) != -1 ){
//                // 方式一：
////                String sb = new String(chars,0,len);
////                System.out.println(sb);
//                // 方式二：
//                for (int i = 0; i < len; i++) {
//                    System.out.print(chars[i]);
//                }
//            }
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

    }


    // 文件的读取和写出
    @Test
    public void test2(){

        // 不能在单元测试中使用
        File file1 = new File("day_IO\\src\\lol.txt");
        File file2 = new File("day_IO\\src\\Avengers.txt");

        // 不能处理图片视频等字节文件
        try(FileWriter fileWriter = new FileWriter(file1);
            FileReader fileReader = new  FileReader(file2) ) {

            char[] chars = new char[5];

            int len;
            while( (len = fileReader.read(chars)) != -1 ){
                fileWriter.write(chars,0,len);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }










}