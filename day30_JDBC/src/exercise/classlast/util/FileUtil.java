package exercise.classlast.util;

import java.io.*;
import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

/**
 * @projectName: MyJavaStudy
 * @package: exercise.classlast.util
 * @author: Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-03-15 13:54
 */
public class FileUtil {

    static final String PARENT_DIRECTORY = "day30_JDBC//src/upload/img/";

    private FileUtil() {
    }


    /**
     * 文件上传，返回路径
     *
     * @param sourcePath 源文件路径
     * @return 上传后的路径
     */
    public static String upload(String sourcePath) {
        // 判断源文件路径是否为null
        if (Objects.nonNull(sourcePath)) {
            // 以上传时间创建文件夹
            String curDateStr = LocalDate.now().toString();
            File childParentDirectory = new File(PARENT_DIRECTORY + curDateStr);
            if (!childParentDirectory.exists()) {
                childParentDirectory.mkdirs();
            }
            // 获取上传后的文件路径
            String imgLast = sourcePath.substring(sourcePath.lastIndexOf("."));
            String imgStr = UUID.randomUUID().toString().replaceAll("-", "") + imgLast;

            try (BufferedInputStream bufferedInputStream = new BufferedInputStream
                    (new FileInputStream(sourcePath));
                 BufferedOutputStream bufferedOutputStream = new BufferedOutputStream
                         (new FileOutputStream(new File(childParentDirectory, imgStr)))
            ) {
                bufferedInputStream.transferTo(bufferedOutputStream);

                return childParentDirectory + imgStr;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        ;
        return null;
    }


    // 测试
    public static void main(String[] args) {
        System.out.println(upload("day30_JDBC//src//雷无桀.jpg"));
    }


}