package comguigu.java;

import org.junit.jupiter.api.Test;

import java.util.Date;

/**
 *
 *  JDK 8.0之前日期和时间的API测试
 *
 * @author shkstart
 * @create 2021-03-22 12:12
 */
public class DateTimeTest1 {

    // 1.System类中的 currentTimeMillis()
    @Test
    public void test(){
        //返回当前时间与1970年1月1日1时1分1秒之间的毫秒时间差
        //称为时间戳
        long time =System.currentTimeMillis();
        System.out.println(time);
    }


    /*
    java.util.Date类
            |---java.sql.Date类

    1. 两个构造器的使用
        //构造器一：Date()：创建一个对应当前时间的Date对象
        //构造器二：创建指定毫秒数的Date对象

    2. 两个方法的使用
        >toString() : 显示当前年月日时分秒
        >getTime(): 获取当前Date对象对应的毫秒数(时间戳)

    3. java.sql.Date对应着数据库的日期类型的变量
        >如何实例化
        >如何将java.util.Date对象转换为java.sql.Date对象

     */

    @Test
    public void test2(){
        //构造器一：Date()：创建一个对应当前时间的Date对象
        Date date1=new Date();
        System.out.println(date1); // Mon Mar 22 12:25:11 CST 2021

        //getTime()方法
        System.out.println(date1.getTime()); // 1616387235811

        //构造器二：创建指定毫秒数的Date对象
        Date date2=new Date(1423424242134213L);
        System.out.println(date2);

        //创建java.sql.Date对象
        java.sql.Date date3=new java.sql.Date(1616387235811L);
        System.out.println(date3); //1970-10-08

        //如何将java.util.Date对象转换为java.sql.Date对象
        //情况一：强转-->报错
//        Date date4 =new java.sql.Date(2423421L); //多态
//        java.sql.Date date5=(java.sql.Date)date4;

        //情况二
        Date date6=new Date();
        java.sql.Date date7=new java.sql.Date(date6.getTime());

        System.out.println(date7);

    }



}
