package comguigu.exercise1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

/**
 * @projectName: MyJavaStudy
 * @package: comguigu.exercise1
 * @author: Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-02-25 16:23
 */
public class FileInOutputStream {


    public static void main(String[] args) {

        File file1 = new File("day_IO\\src\\雷无桀.jpg");
        File file2 = new File("day_IO\\src\\雷无桀副本.jpg");

        // 图片的读取
/*        File file1 = new File("day_IO\\src\\雷无桀.jpg");
        File file2 = new File("day_IO\\src\\雷无桀副本.jpg");

        try( FileInputStream input = new FileInputStream(file1) ) {
            byte[] chars = new byte[1024];
            int len;
            while( (len = input.read(chars)) != -1 ){
                String str = new String(chars,0,len);
                System.out.println(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        // 写出
/*        try( FileOutputStream output = new FileOutputStream(file2) ) {

            byte [] bytes = "weiguoqi".getBytes();
            output.write( bytes );

        }catch (IOException e) {
            e.printStackTrace();

        }*/

        // 图片的读取、写出，实现复制
        try( FileInputStream input = new FileInputStream(file1);
             FileOutputStream output = new  FileOutputStream(file2) ) {

            byte[] bytes = new byte[1024];
            int len;
            while( (len = input.read(bytes)) != -1){
                output.write(bytes,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 字节流也可以处理字符文件
        file1 = new File("E:\\study1\\java\\hello.txt");
        file2 =new File("E:\\study1\\java\\hell.txt");

        try( FileInputStream input = new FileInputStream(file1);
             FileOutputStream output = new  FileOutputStream(file2) ) {

            byte[] bytes = new byte[1024];
            int len;
            while( (len = input.read(bytes)) != -1){
                output.write(bytes,0,len);
                System.out.println(Arrays.toString(bytes));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }













}