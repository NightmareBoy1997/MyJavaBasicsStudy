package com.javasm.java.study;

import org.junit.jupiter.api.Test;

import java.util.Scanner;

public class Test1 implements Runnable{

    public static void main(String[] args) {

        System.out.println("this is NewDay");


        Person p1 = new Person();
        p1.number = 11;

        Scanner scan = new Scanner(System.in);
        int i = scan.nextInt();



        // 三元运算符/三目运算符 : 数据类型 变量 = (表达式boolean)? (表达式1): (表达式2)
        int int1 = ( 5 > 8)?5:8;
        String str = (2 < 7) ? "正确" : "错误s";
        System.out.println(int1);
        System.out.println(str);


    }


    @Override
    public void run() {

    }


    @Test
    public void test1(){

        System.out.println("HelloWorld!");

}




}


class Person{

    /**属性介绍演示*/
    int number;
    boolean aBoolean = false;


}