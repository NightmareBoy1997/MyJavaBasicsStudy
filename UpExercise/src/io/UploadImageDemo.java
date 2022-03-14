package io;

import java.io.*;
import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

/**
 * @author: Lisa
 * @className: UploadImageDemo
 * @description: 模拟用户上传头像
 * @date: 2022/3/7 15:29
 * @version: 0.1
 * @since: jdk11
 */
public class UploadImageDemo {

    private static final String PARENT_DIRECTORY = "day26_io/src/upload/user/";//根目录

    /**
     * 上传文件
     *
     * @param sourceFilePath 源文件路径
     * @return 上传成功之后 文件所在的服务器路径  upload/user/a.jpg
     */
    public static String upload(String sourceFilePath) throws FileNotFoundException {
        Objects.requireNonNull(sourceFilePath);

        //读取源文件数据: InputStream  read
        //写入目标文件中 OutputStream  write
        InputStream inputStream = new FileInputStream(sourceFilePath);
        //获得目标文件文件名称
        //1. 获得原文件名称  最后\之后的数据  弊端: 不同的用户可能会上传重名的文件
        //String fileName = sourceFilePath.substring(sourceFilePath.lastIndexOf(File.separator) + 1);
        //2. 保证名称唯一性 UUID
        //3.用户量增加 所有文件都在一个目录中  读取文件性能比较低----> 分目录存储图片
        //目录打散
        // 动态创建目录 以当前时间为目录名称  2022-03-07
        String curDate = LocalDate.now().toString();
        //判断目录是否存在 File.exsits()
        File directory = new File(PARENT_DIRECTORY, curDate);
        if (!directory.exists()) {
            System.out.println("1111111111111111111");
            directory.mkdirs();
        }
        //获得原文件后缀
        String extension = sourceFilePath.substring(sourceFilePath.lastIndexOf("."));
        String targetFileName = UUID.randomUUID().toString().replaceAll("-", "") + extension;

        //将基本字节流转换成高效流实现

        OutputStream outputStream = new FileOutputStream(new File(directory, targetFileName));
        try (inputStream; outputStream) {
            //循环读写文件数据
            //1.读一个字节 写一个字节   小文件ok  大文件有问题
            //2.缓冲---->  byte[]
            byte[] bytes = new byte[1024 * 10];
            int len;
            while ((len = inputStream.read(bytes)) != -1) {
                //outputStream.write(len);
                outputStream.write(bytes, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("文件上传成功");
        return PARENT_DIRECTORY + curDate + "/" + targetFileName;
    }


    //4588
    public static void main(String[] args) throws FileNotFoundException {

        long begin = System.currentTimeMillis();
        String path = "E:\\study1\\day21\\4k美女.jpg";
        path = "E:\\study1\\day21\\金克斯4k.jpg";
        System.out.println(upload(path));//回显图片
        long end = System.currentTimeMillis();
        System.out.println(end - begin);
//        System.out.println(UUID.randomUUID().toString().replaceAll("-",""));
    }

}
