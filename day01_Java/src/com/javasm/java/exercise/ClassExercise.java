package com.javasm.java.exercise;

import org.junit.jupiter.api.Test;

/**
 * @author Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-02-09 22:17
 *
 *
 */
public class ClassExercise {

//1.求一光年是多少千米 , 光在真空中传播速度299792458 m/s
    @Test
    public void lightYearDistance(){

        long speed = 299792458l ;
        long distance = 365 * 24 * 3600 * speed;
        System.out.println(" 光一年传播的距离是： " + distance/1000 + " 千米");

    }

//2.根据天数（46）计算周数和剩余的天数
    @Test
    public void getWeekAndDay(){

        int number = 46;
        int weekNo = number/7;
        int day = number % 7 ;
        System.out.println("第46天是： " + weekNo + " 周零 " + day + "天");

    }

//3.已知圆的半径radius= 1.5，求其面积 (Java中π用Math.PI表示)
    @Test
    public void circleArea(){

        double radius = 1.5 ;
        double area = radius* radius * Math.PI ;
        System.out.println("半径radius=" + radius + "的圆的面积是：" + area);

    }

//4.自己给定5个整数，通过编程求出最大值(使用三元运算符)
    @Test
    public void maxNumber(){

        int number1 = 12;
        int number2 = -22;
        int number3 = 57;
        int number4 = 123;
        int number5 = 0;

        int maxNumber = (number1 > number2)? number1:number2;
        maxNumber = (maxNumber > number3) ? maxNumber : number3;
        maxNumber =(maxNumber > number4)? maxNumber : number4;
        maxNumber = (maxNumber > number5)? maxNumber : number5;

        System.out.println(maxNumber);

    }

//5.韩梅梅看中两把价格相同的扇子，想挑选一个扇面较大的扇子购买，请你帮她挑选。
//    A款折叠扇：展开后角度为134.6°,扇骨长26.5cm
//    B款圆扇：扇柄长12.3cm，扇子总长度36.5cm
//    注：圆形面积 = 3.14 * 半径平方
//            扇形面积 = 3.14 * 半径平方 * (度数/360)
    @Test
    public void area(){

        double radius1 = 26.5 ;
        double angle1 = 134.6 ;
        double area1 = 3.14 * radius1 * radius1 * (134.6 / 360);

        double radius2 = (36.5 - 12.3)/2 ;
        double area2 = radius2 * radius2 * 3.14;

        String maxArea = (area1 > area2 )? "A款" : "B款";

        System.out.println("面积较大的扇子是" + maxArea);
    }

//5.变量a和b的值互换  例如：int a = 10,b=20;  结果：a=20,b=10;
    @Test
    public void revereValue(){

        int a = 10 ;
        int b = 20 ;
        int temp = a ;
        a = b ;
        b = temp;
        System.out.println("a= " + a + " , b= " + b);

    }

//6.定义一个变量，是一个三位数，求各个位数的和. 如：123，结果是1+2+3=6
    @Test
    public void sum(){

        int number = 157 ;
        int i1 = number/100 ;
        int i2 = number % 100 /10 ;
        int i3 = number % 10 ;
        int sum = i1 + i2 + i3 ;

        System.out.println("百位数是： " + i1 + "十位数是： "  + i2 + "个位数是： " + i3 + " , 各位的总和是： " + sum);

    }

}
