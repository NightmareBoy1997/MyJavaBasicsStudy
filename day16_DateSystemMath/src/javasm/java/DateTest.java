package javasm.java;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.temporal.ChronoUnit;

/**
 * @projectName: MyJavaStudy
 * @package: javasm.java
 * @author: Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-02-28 21:11
 */
public class DateTest {

    public static void main(String[] args) {

//        demo2();
        test2();



    }


    private static void demo2() {

        //1.获得LocalDateTime对象
        //LocalDateTime now = LocalDateTime.now();
   /* System.out.println(now);//2022-02-28T15:10:06.920312800
    System.out.println(LocalDateTime.now(Clock.systemDefaultZone()));
    System.out.println(LocalDateTime.now(Clock.systemUTC()));
    //所有的时区都使用ZoneId代表
    System.out.println(LocalDateTime.now(Clock.system(ZoneId.of("America/Chicago"))));
    //通过指定的时区获得时间，不太推荐local一些类  本地时间
    System.out.println(ZonedDateTime.now(ZoneId.of("America/Chicago")));*/

        //2020-10-01 12:30:30
        LocalDateTime time = LocalDateTime.of(2022, Month.JANUARY, 1, 12, 30, 30);
        System.out.println(time);

        //值不可变
        //TemporalAmount都是接口-----> Duration  Period  时间间隔
        // default Temporal plus(TemporalAmount amount) {
        //TemporalUnit: 时间单位  ChronoUnit
        //public static Duration of(long amount, TemporalUnit unit) {
        //time = time.plus(Period.ofYears(10));
        //time = time.plus(10, ChronoUnit.YEARS);
        //time = time.plusYears(1);
        //time = time.minusMonths(2);

        LocalDateTime now = LocalDateTime.now();
        //获得2个日期间隔的天数
        //Temporal: 接口 代表日期时间
        //TemporalUnit: 日期单位
        //public long until(Temporal endExclusive, TemporalUnit unit) {
        long durationDays = Math.abs(now.until(time, ChronoUnit.DAYS));
        System.out.println(durationDays);

        System.out.println(now.getMonthValue());
        System.out.println(now.getMonth());
        System.out.println(now.getDayOfWeek());
        System.out.println(now.getDayOfMonth());
    }

    private static void test2(){
        LocalDateTime localDateTime = LocalDateTime.now();
        LocalDateTime localDateTime1 = LocalDateTime.of(2022,Month.MAY,23,12,30,55);

        long until =Math.abs( localDateTime1.until(localDateTime, ChronoUnit.DAYS));
        System.out.println(until);

    }



}