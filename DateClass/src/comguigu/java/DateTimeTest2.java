package comguigu.java;

import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * JDK8之前的日期时间的API测试
 *
 * 1.System类的currentTimeMillis()
 * 2.java.util.Date和子类java.sql.Date
 * 3.SimpleDateFormat
 * 4.Calendar
 *
 * @author Freak-W
 * @create 2021-03-23 10:46
 */
public class DateTimeTest2 {
    /*
    SimpleDateFormat的使用：SimpleDateFormat对日期Date类的格式化和解析

    1.两个操作：
        1.1 格式化 ： 日期-->字符串
        1.2 解析 ： 格式化的逆过程，字符串-->日期

    2. SimpleDateFormat的实例化
        new + 构造器

     */


    @Test
    public void testSimpleDateFormat() throws ParseException {
        //实例化SimpleDateFormat
        SimpleDateFormat sdf=new SimpleDateFormat();

        //格式化：日期-->字符串
        Date date=new Date();
        System.out.println(date);

        String format=sdf.format(date);
        System.out.println(format);

        //解析：字符串-->日期
        String str="20-07-02 下午11:56";
        Date date1=sdf.parse(str);
        System.out.println(date1);

        //***************按照指定的方式格式化和解析:调用带参的构造器*************************
        SimpleDateFormat sdf1=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

        //格式化
        String format1=sdf1.format(date);
        System.out.println(format1); // 2021-03-23 11:17:16

        //解析:要求字符串必须是符合SimpleDateFormat识别的格式(通过构造器参数体现)
        Date date2=sdf1.parse(format1);
        System.out.println(date2);


    }

    /*
    练习一：字符串："2020-9-8"转换为java.sql.Date

     */
    @Test
    public void testExer() throws ParseException {
        String str1="2020-9-8";
        SimpleDateFormat sdf1=new SimpleDateFormat("yyyy-MM-dd");
        Date date1=sdf1.parse(str1);

        java.sql.Date sqlDate=new java.sql.Date(date1.getTime());
        System.out.println(sqlDate);

    }

    /*
    练习二：“三天打鱼两天晒网”  1990-1-1 xxxx-xx-xx 打鱼？晒网？

    方式一：（date2-date1）/（1000*60*60*24）+1
    方式二：1990-1-1 -->2019-12-31 +2020-1-1 -->2020-9-8


     */

    @Test
    public void test2(){






    }



    /*
    Calendar日历类(抽象类)的使用


     */
    @Test
    public void testCalendar(){
        //1. 实例化
        //方式一：创建子类（GregorianCalendar）的对象
        //方式二：调用其静态方法getInstance()
        Calendar calendar=Calendar.getInstance();
        System.out.println(calendar.getClass());

        //常用方法：
        //get()
        int day=calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(day);
        System.out.println(calendar.get(Calendar.DAY_OF_YEAR));

        //set()
        //Calendar可变性
        calendar.set(Calendar.DAY_OF_MONTH,2);
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));

        //add()
        calendar.add(Calendar.DAY_OF_MONTH,-3); //减到上月
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));

        //getTime() :日历类-->Date
        Date date=calendar.getTime();
        System.out.println(date);

        //setTime() ：Date-->日历类
        Date date1=new Date();
        calendar.setTime(date1);
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));




    }


}
