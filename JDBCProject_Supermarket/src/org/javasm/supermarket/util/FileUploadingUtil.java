package org.javasm.supermarket.util;

import java.io.*;
import java.time.LocalDate;
import java.util.UUID;

/**
 * @projectName: MyJavaStudy
 * @package: org.javasm.supermarket.util
 * @author: Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-03-18 22:55
 */
public class FileUploadingUtil {
    private FileUploadingUtil(){
    }

    final static String PRENT_DIRECTORY = "JDBCProject_Supermarket/src/upload/image/";

    public static String uploadImage(String sourcePath) {
        if(! new File(sourcePath).exists()){
            return null;
        }

        File curDirectory = new File(PRENT_DIRECTORY + LocalDate.now().toString());
        if (!curDirectory.exists()) {
            curDirectory.mkdirs();
        }
        String imageType = sourcePath.substring(sourcePath.lastIndexOf(".") );
        String imageName = UUID.randomUUID().toString().replaceAll("-", "") + imageType;

        try (BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(sourcePath));
             BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(new File(curDirectory, imageName)));
        ) {
            bufferedInputStream.transferTo(bufferedOutputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return curDirectory + "/" + imageName;
    }


    public static void main(String[] args) {
        final String s = new FileUploadingUtil().uploadImage("C:/Users/JAVASM/Desktop/supermarket/拉克丝.jpg");
        System.out.println(s);
    }

}