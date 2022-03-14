package comguigu.exercise;

import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @projectName: MyJavaStudy
 * @package: comguigu.exercise
 * @author: Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-02-21 22:15
 */
public class CalendarTest {

/*
Calendar 日历类(抽象类)的使用
Calendar 是可变的
一月是 0 ，星期日是 1
 */
    @Test
    public void CalendarTest1(){
        // 1. 实例化
        // 方式一： 创建其子类(GregorianCalendar)的对象
        // 方式二： 调用其静态方法 getInstance
        Calendar calendar1 = Calendar.getInstance();
        System.out.println(calendar1.getClass()); // class java.util.GregorianCalendar

        // 2. 常用方法
        // get()
        int days = calendar1.get(calendar1.DAY_OF_MONTH);
        System.out.println(days);
        System.out.println(calendar1.get(calendar1.DAY_OF_WEEK));

        // set()
        calendar1.set(calendar1.DAY_OF_MONTH,25); // 无返回值
        days = calendar1.get(calendar1.DAY_OF_MONTH);
        System.out.println(days);

        // add()
        calendar1.add(calendar1.DAY_OF_MONTH , -4);
        days = calendar1.get(calendar1.DAY_OF_MONTH);
        System.out.println(days);


        // getTime() : 日历类 --> Date
        Date date1 = calendar1.getTime();
        System.out.println(date1);


        // setTime() : Date --> 日历类
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String str = "2008-08-08 12:00:00";
        try {
            Date date2 = simpleDateFormat.parse(str);
            calendar1.setTime(date2);

            System.out.println(calendar1.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }


    }




}