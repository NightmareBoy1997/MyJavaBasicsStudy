package javasm;

import java.io.*;
import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

/**
 * @projectName: MyJavaStudy
 * @package: javasm
 * @author: Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-03-15 22:08
 * <p>
 * 文件上传客户端的工具类
 */
public class FileUtil {
    // 默认的上级目录
    static File defaultPath = new File("day25_IO/src/upload");

    /**
     *  上传文件，按照上传时间传至指定文件夹，随机生成16进制作为名称
     * @param sourcePath 源文件地址
     * @return 上传后的资源地址
     */
    public static String imgUpLine(String sourcePath) {
        if (Objects.nonNull(sourcePath)) {
            // 按照上传时间创建文件夹
            String curStr = defaultPath + LocalDate.now().toString();
            File curDirectory = new File(curStr);
            if (!curDirectory.exists()) {
                curDirectory.mkdirs();
            }

            String sourceName = UUID.randomUUID().toString().replaceAll("-","");
            sourceName += sourcePath.substring(sourcePath.lastIndexOf("."));

            try (BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(sourcePath));
                 BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(new File(curDirectory, sourceName)));
            ) {
                bufferedInputStream.transferTo(bufferedOutputStream);
                return curDirectory + sourceName;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }


    /** 测试
     * @param args
     */
    public static void main(String[] args) {
        String path = "day25_IO/src/擎天柱.jpg";
        System.out.println(imgUpLine(path));
    }

}