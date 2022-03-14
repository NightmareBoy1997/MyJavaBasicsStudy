package comguigu.java;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

/**
 * @author Freak-W
 * @create 2021-10-09 14:52
 */
public class FileUtilsTest {

        public static void main(String[] arg){
            File srcFile=new File("day_IOObject\\src\\樱木花道.jpg");
            File destFile=new File("day_IOObject\\src\\樱木花道4.jpg");

            try {
                FileUtils.copyFile(srcFile,destFile);
            } catch (IOException e) {
                e.printStackTrace();
            }


        }



}
