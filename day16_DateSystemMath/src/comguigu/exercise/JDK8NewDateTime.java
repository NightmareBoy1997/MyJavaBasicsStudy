package comguigu.exercise;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

/**
 * @projectName: MyJavaStudy
 * @package: comguigu.exercise
 * @author: Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-02-21 22:41
 */
public class JDK8NewDateTime {

    @Test
    public void testDate1() {
        // 偏移量
        Date date1 = new Date(2022,2,21);
        System.out.println(date1);
    }


    /*
    LocalDate、LocalTime、LocalDateTime
        1. LocalDateTime用的多
        2. 类似于Calendar类
     */
    @Test
    public void NewDate(){

        // now(): 获取当前的日期、时间、日期+时间
        LocalDate localDate =LocalDate.now() ;
        LocalTime localTime = LocalTime.now();
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDate);
        System.out.println(localTime);
        System.out.println(localDateTime);

        // of(): 指定日期时间
        LocalDate localDate1 = LocalDate.of(2022, 2, 21);
        LocalTime localTime1 = LocalTime.of(22, 59, 57);
        LocalDateTime localDateTime1 = LocalDateTime.of(2022, 2, 21, 22, 57, 22);

        System.out.println(localDate1);
        System.out.println(localTime1);
        System.out.println(localDateTime1);


        // getXxx(): 获取相关属性
        System.out.println(localDateTime1.getDayOfWeek());
        System.out.println(localDateTime1.getDayOfMonth());
        System.out.println(localDateTime1.getDayOfYear());
        System.out.println(localDateTime1.getMonth());
        System.out.println(localDateTime1.getMonthValue());
        System.out.println(localDateTime1.getMinute());

        // withXxx(): 设置相关属性
        // 返回一个修改过的对象，本身没有改变 。 体现不可变性
        LocalDateTime localDateTime2 = localDateTime1.withDayOfMonth(2);
        System.out.println(localDateTime1);
        System.out.println(localDateTime2);

        // plus() : 添加
        LocalDateTime localDateTime3 = localDateTime1.plusMonths(-1);
        System.out.println(localDateTime3);
        System.out.println(localDateTime1);


    }

}