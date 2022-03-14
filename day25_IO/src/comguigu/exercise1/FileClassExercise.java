package comguigu.exercise1;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;

/**
 * @projectName: MyJavaStudy
 * @package: comguigu.exercise1
 * @author: Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-02-24 23:42
 */
public class FileClassExercise {

/*
    练 习
    1. 利用File构造器，new 一个文件目录file
        1)在其中创建多个文件和目录
        2)编写方法，实现删除file中指定文件的操作
    2. 判断指定目录下是否有后缀名为.jpg的文件，如果有，就输出该文件名称
    3. 遍历指定目录所有文件名称，包括子文件目录中的文件。
        拓展1：并计算指定目录占用空间的大小
        拓展2：删除指定文件目录及其下的所有
*/
    @Test
    public void test3(){

        File file1 = new File("E:\\study1\\java\\test.txt");
        File file2 = new File("E:\\study1\\java\\hello.txt");
        File file3 = new File("E:\\study1\\java\\haha.java");
        File file4 = new File("E:\\study1\\java","javaee");
        File file5 = new File("E:\\study1\\java","javase");
        File file6 = new File("E:\\study1\\java1");

        file1.mkdirs();
        file4.mkdirs();
        file5.mkdirs();
        file6.mkdirs();
        try {
            file1.createNewFile();
            file2.createNewFile();
            file3.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }


//        2. 判断指定目录下是否有后缀名为.jpg的文件，如果有，就输出该文件名称
//        3. 遍历指定目录所有文件名称，包括子文件目录中的文件。
//        拓展1：并计算指定目录占用空间的大小
//        拓展2：删除指定文件目录及其下的所有
        File file7 = new File("E:\\study1\\java");
        String[] list = file7.list();
        for (String s : list) {
            if(s.contains("jpg")){
                System.out.println(s);
            }
        }

        File file8 = new  File("E:\\study1");
        System.out.println("**************");
        System.out.println(file6.listFiles().length);

        // 3. 遍历指定目录所有文件名称，包括子文件目录中的文件。
        FileByte  fileByte = new FileByte();
        files(file8, fileByte);
        System.out.println();
        System.out.println(fileByte.length);

        System.out.println("*******************");
//        delete(file8);
        System.out.println(file8.length());


    }


    public void delete(File file){

        if(file.isFile()){
            file.delete();
            return;
        }

        if(file.listFiles().length != 0 ){
            File [] files = file.listFiles();
            for (int i = 0; i < files.length; i++) {
                    delete(files[i]);
            }

        }else{
            file.delete();
        }

    }


    public void files(File file,FileByte fileByte){

        if(file.isFile()){
            fileByte.length += file.length();
            return;
        }
        if(file.listFiles().length != 0 ){
            File [] files = file.listFiles();
            for (int i = 0 ; i< files.length ; i++ ) {
                files(files[i],fileByte);
                System.out.print(files[i].getAbsolutePath() + "\t");
            }
        }

    }



    @Test
    public void test1(){

//    public File(String pathname)以pathname为路径创建File对象，如果pathname是相对路径，则默认的当前路径在系统属性user.dir中存储。
//     绝对路径：是一个固定的路径,从盘符开始
//     相对路径：是相对于某个位置开始
//     public File(String parent,String child)以parent为父路径，child为子路径创建File对象。
//     public File(File parent, String child)根据一个父File对象和子文件路径创建File对象
        File file1 = new File("hello.txt");
        File file11= new File("E:\\study\\io1\\java");

        File file2 = new File("E:\\study\\io2");
        File file3 = new File("E:\\study","IO");

//        File类的获取功能
//     public String getAbsolutePath()：获取绝对路径
//     public String getPath() ：获取路径
//     public String getName() ：获取名称
//     public String getParent()：获取上层文件目录路径。若无，返回null
//     public long length() ：获取文件长度（即：字节数）。不能获取目录的长度。
//     public long lastModified() ：获取最后一次的修改时间，毫秒值
//
//     public String[] list() ：获取指定目录下的所有文件或者文件目录的名称数组
//     public File[] listFiles() ：获取指定目录下的所有文件或者文件目录的File数组

        System.out.println(file1.exists());
        System.out.println(file1.getAbsoluteFile());
        System.out.println(file1.getName());
        System.out.println(file1.getPath());
        System.out.println(file1.getParent());
        System.out.println(file1.length());
        System.out.println(file1.lastModified());

        System.out.println("*******************************");

        System.out.println(file2.exists());
        System.out.println(file2.getAbsoluteFile());
        System.out.println(file2.getName());
        System.out.println(file2.getPath());
        System.out.println(file2.getParent());
        System.out.println(file2.length());
        System.out.println(new Date(file2.lastModified()));

        System.out.println(Arrays.toString( file2.list() ));
        System.out.println(Arrays.toString( file2.listFiles() ));

    }




    @Test
    public void test2(){

        //    File 类的使用：常用方法
        //     File类的创建功能
        //     public boolean createNewFile() ：创建文件。若文件存在，则不创建，返回false
        //     public boolean mkdir() ：创建文件目录。如果此文件目录存在，就不创建了。如果此文件目录的上层目录不存在，也不创建。
        //     public boolean mkdirs() ：创建文件目录。如果上层文件目录不存在，一并创建注意事项：如果你创建文件或者文件目录没有写盘符路径，那么，默认在项目路径下。

        File file1 = new File ("E:\\study\\IO.txt");
        File file2 =new  File ("E:\\study\\io3\\java");
        File file3 = new File("E:\\study\\IO","java");

        try {
            file1.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(file1.exists());
        System.out.println( "file2: " + file2.isDirectory());
        System.out.println( "file3: " + file3.isDirectory());

        System.out.println(file2.mkdir());
        System.out.println(file3.mkdirs());

        //         File类的删除功能
        //     public boolean delete()：删除文件或者文件夹删除注意事项：Java中的删除不走回收站。要删除一个文件目录，请注意该文件目录内不能包含文件或者文件目录
        System.out.println(file2.delete());
        System.out.println(file3.delete());

                //     File类的重命名功能
        //     public boolean renameTo(File dest):把文件重命名为指定的文件路径
        File file4 = new File("E:\\study\\haha.java");
        System.out.println(file1.renameTo(file4));

        //        13.1 File 类的使用：常用方法
        //     File类的判断功能
        //     public boolean isDirectory()：判断是否是文件目录
        //     public boolean isFile() ：判断是否是文件
        //     public boolean exists() ：判断是否存在
        //     public boolean canRead() ：判断是否可读
        //     public boolean canWrite() ：判断是否可写
        //     public boolean isHidden() ：判断是否隐藏
        System.out.println(file1.canRead());
        System.out.println(file1.canWrite());
        System.out.println(new Date(file1.lastModified()));
        System.out.println(file1.isHidden());

    }



}


class FileByte{

    int length;

}