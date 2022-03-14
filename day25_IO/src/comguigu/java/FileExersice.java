package comguigu.java;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;

/**
 * 1. 利用File构造器，new 一个文件目录file
 * 1)在其中创建多个文件和目录
 * 2)编写方法，实现删除file中指定文件的操作
 * <p>
 * 2. 判断指定目录下是否有后缀名为.jpg的文件，如果有，就输出该文件名称
 * <p>
 * 3. 遍历指定目录所有文件名称，包括子文件目录中的文件。
 * 拓展1：并计算指定目录占用空间的大小
 * 拓展2：删除指定文件目录及其下的所有
 *
 * @author Freak-W
 * @create 2021-05-18 16:22
 */
public class FileExersice {

    int number = 0;

    @Test
    public void test1() throws IOException {
        File file1 = new File("D:\\百分下载\\io\\fileTest");
        File file2 = new File("d:\\百分下载\\io\\fileTest\\haha.txt");
        File file3 = new File(file2.getParent(), "666.txt");
        File file4=new File("D:\\百分下载\\io\\steam");

//        System.out.println(file1.mkdirs());
//
//        if(!file2.exists()){
//            file2.createNewFile();
//            System.out.println("创建成功！");
//        }else{
//            System.out.println("创建失败！");
//        }


        FileExersice exer1 = new FileExersice();
//        int number=0;
        deleteFile(file1, exer1);
        System.out.println(exer1.number);

    }


    //遍历指定目录所有文件名称，包括子文件目录中的文件。
//   拓展1：并计算指定目录占用空间的大小
//   拓展2：删除指定文件目录及其下的所有
    synchronized void  deleteFile(File file, FileExersice exer1) {

        if (file.isFile()) {
            file.delete();
            exer1.number += file.length();
        } else {
            File[] arr = file.listFiles();
            if (arr.length!=0) {
                for (int i = 0; i < arr.length; i++) {
                    if (arr[i].isFile()) {
                        exer1.number += arr[i].length();
                        arr[i].delete();
                    } else {
                        deleteFile(arr[i], exer1);
                    }
                }
            }

            file.delete();
            System.out.println("删除完成！");
            System.out.println(exer1.number);

        }

    }

}


/**
 * 课后练习2：判断指定目录下是否有后缀名为.jpg的文件，如果有，就输出该文件名称
 * @author shkstart 邮箱：shkstart@126.com
 * @version  创建时间：2019年2月23日  上午1:55:59
 *
 */
class FindJPGFileTest {

    @Test
    public void test1(){
        File srcFile = new File("d:\\code");

        String[] fileNames = srcFile.list();
        for(String fileName : fileNames){
            if(fileName.endsWith(".jpg")){
                System.out.println(fileName);
            }
        }
    }
    @Test
    public void test2(){
        File srcFile = new File("d:\\code");

        File[] listFiles = srcFile.listFiles();
        for(File file : listFiles){
            if(file.getName().endsWith(".jpg")){
                System.out.println(file.getAbsolutePath());
            }
        }
    }
    /*
     * File类提供了两个文件过滤器方法
     * public String[] list(FilenameFilter filter)
     * public File[] listFiles(FileFilter filter)

     */
    @Test
    public void test3(){
        File srcFile = new File("d:\\code");

        File[] subFiles = srcFile.listFiles(new FilenameFilter() {

            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith(".jpg");
            }
        });

        for(File file : subFiles){
            System.out.println(file.getAbsolutePath());
        }
    }

}



/**
 * 3. 遍历指定目录所有文件名称，包括子文件目录中的文件。
 拓展1：并计算指定目录占用空间的大小
 拓展2：删除指定文件目录及其下的所有文件

 * @author shkstart 邮箱：shkstart@126.com
 * @version  创建时间：2019年2月23日  上午1:55:31
 *
 */
class ListFilesTest {

    public static void main(String[] args) {
        // 递归:文件目录
        /** 打印出指定目录所有文件名称，包括子文件目录中的文件 */

        // 1.创建目录对象
        File dir = new File("E:\\teach\\01_javaSE\\_尚硅谷Java编程语言\\3_软件");

        // 2.打印目录的子文件
        printSubFile(dir);
    }

    public static void printSubFile(File dir) {
        // 打印目录的子文件
        File[] subfiles = dir.listFiles();

        for (File f : subfiles) {
            if (f.isDirectory()) {// 文件目录
                printSubFile(f);
            } else {// 文件
                System.out.println(f.getAbsolutePath());
            }

        }
    }

    // 方式二：循环实现
    // 列出file目录的下级内容，仅列出一级的话
    // 使用File类的String[] list()比较简单
    public void listSubFiles(File file) {
        if (file.isDirectory()) {
            String[] all = file.list();
            for (String s : all) {
                System.out.println(s);
            }
        } else {
            System.out.println(file + "是文件！");
        }
    }

    // 列出file目录的下级，如果它的下级还是目录，接着列出下级的下级，依次类推
    // 建议使用File类的File[] listFiles()
    public void listAllSubFiles(File file) {
        if (file.isFile()) {
            System.out.println(file);
        } else {
            File[] all = file.listFiles();
            // 如果all[i]是文件，直接打印
            // 如果all[i]是目录，接着再获取它的下一级
            for (File f : all) {
                listAllSubFiles(f);// 递归调用：自己调用自己就叫递归
            }
        }
    }

    // 拓展1：求指定目录所在空间的大小
    // 求任意一个目录的总大小
    public long getDirectorySize(File file) {
        // file是文件，那么直接返回file.length()
        // file是目录，把它的下一级的所有大小加起来就是它的总大小
        long size = 0;
        if (file.isFile()) {
            size += file.length();
        } else {
            File[] all = file.listFiles();// 获取file的下一级
            // 累加all[i]的大小
            for (File f : all) {
                size += getDirectorySize(f);// f的大小;
            }
        }
        return size;
    }

    // 拓展2：删除指定的目录
    public void deleteDirectory(File file) {
        // 如果file是文件，直接delete
        // 如果file是目录，先把它的下一级干掉，然后删除自己
        if (file.isDirectory()) {
            File[] all = file.listFiles();
            // 循环删除的是file的下一级
            for (File f : all) {// f代表file的每一个下级
                deleteDirectory(f);
            }
        }
        // 删除自己
        file.delete();
    }

}
