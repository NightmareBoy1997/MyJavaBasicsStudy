package javasm.exercise;

import java.io.File;
import java.io.RandomAccessFile;

/**
 * @projectName: MyJavaStudy
 * @package: javasm.exercise
 * @author: Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-02-28 16:45
 */
public class RandomAccessFileTest {

    public static void main(String[] args) {

//        try( RandomAccessFile raf1 = new RandomAccessFile(new File("day_IO\\src\\javasm\\exercise\\樱木花道.jpg") , "rw" );
//             RandomAccessFile raf2 = new RandomAccessFile(new File("day_IO\\src\\javasm\\exercise\\randomAccessFile1.jpg") , "rw" )
//        ) {
//            int len;
//            byte[] bytes = new byte[1024];
//            while( (len = raf1.read(bytes)) != -1){
//                raf2.write(bytes,0,len);
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        test();



    }




    public static void test(){
        try( //RandomAccessFile raf1 = new RandomAccessFile(new File("day_IO\\src\\javasm\\exercise\\dream.txt") , "rw" );
             RandomAccessFile raf2 = new RandomAccessFile(new File("day_IO\\src\\javasm\\exercise\\dream11.txt") , "rw" )
        ) {
//            int len;
//            byte[] bytes = new byte[1024];
//            while( (len = raf1.read(bytes)) != -1){
//                raf2.write(bytes,0,len);
//            }
            String string = "ABCDEFGHIJKLMN";

            raf2.seek(4);
            raf2.write(string.getBytes());
            System.out.println("*******");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}