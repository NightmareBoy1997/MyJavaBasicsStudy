package io;

import java.io.File;

/**
 * @author: Lisa
 * @className: FindChildDemo
 * @description:
 * @date: 2022/3/7 10:38
 * @version: 0.1
 * @since: jdk11
 */
public class FindChildDemo {



    public static void main(String[] args) {

        //展示指定父级目录下的所有的子级的资源。
        String parentDirectoryPath = "E:\\study1\\day21";
        //流程:
        //1. 创建目录对象
        //2. 先获得父级路径下面的1级资源
        // 2.1  1级资源 有可能是目录 也有可能是文件
        // 2.2  1级资源是目录的时候  获得2级资源
        //|-.idea
        //| |- modules.xml
        //| |- misc.xml
        //|- out
        //|- src
        //| |- com
        //| | |- javasm
        //| | | |- io
        //| | | | |- FileDemo1.java
        //|- day21.iml


        File directory = new File(parentDirectoryPath);
        listChild2(directory, "|-");

    }

    private static void listChild2(File directory, String s) {
        String[] nameArray = directory.list();
        for (String childName : nameArray) {
            File child = new File(directory, childName);
            System.out.println(s + childName);
            if (child.isDirectory()) {
                listChild2(child, "| " + s);
            }
        }
    }

    //directory: 父级路径
    private static void listChild(File directory, String s) {
        File[] childArray = directory.listFiles();
        for (File child : childArray) {
            String childName = child.getName();
            //判断子级是否是目录
            if (child.isDirectory()) {
                //再去获得子级资源-----> 递归
                System.out.println(s + childName);
                listChild(child, "| " + s);
            } else {
                //是文件
                    System.out.println(s + childName);
            }
        }
    }
}
