package comguigu.exercise;

import java.util.Date;

/**
 * @projectName: MyJavaStudy
 * @package: comguigu.exercise
 * @author: Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-02-21 17:09
 */
public class DateTest {

    public static void main(String[] args) {

        /*
        System 类的获取时间方法
         */
        long currentTimeMillis = System.currentTimeMillis();
        System.out.println(currentTimeMillis); // 1970年1月1号到现在的毫秒数：时间戳

        /*
        Date 类的时间api
         */
        // 构造器一： 当前时间的Date对象
        Date date1 = new Date();
        System.out.println(date1);
        System.out.println(date1.getTime()); // 返回时间戳

        // 构造器二： 构造器二：创建指定毫秒数的Date对象
        Date date2 = new Date(1645435054317l);
        System.out.println(date2);


        /*
        Date类下的 SQL Date api
         SQL.Date 对应着数据库的日期类型的变量
         > 如何实例化
         > sql.Date --> util.Date对象 -- 多态
         > util.Date --> sql.Date --

         */
        java.sql.Date date3 = new java.sql.Date(1645435054317l);
        System.out.println(date3);

        // 情况一：
        java.sql.Date date4 = new java.sql.Date(1645435054317l);
        java.sql.Date date5 = (java.sql.Date)date4;

        // 情况二：
        Date date6 = new Date(1645435054317l);
//        var date7 = (java.sql.Date) date6 ; // 报错
        java.sql.Date date8 = new java.sql.Date(date6.getTime());
        System.out.println(date8);

    }
}