package javasm.javasm.util;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/**
 * @author: Lisa
 * @className: LocalDemo
 * @description:
 * @date: 2022/2/28 11:42
 * @version: 0.1
 * @since: jdk11
 */
public class LocalDemo {

    public static void main(String[] args) {
        //获得当前此刻时间
        //System.out.println(LocalDateTime.now().toString());
        //System.out.println(LocalDate.now());
        //System.out.println(LocalTime.now());
        //System.out.println(Instant.now());//8 UTC  英国格林尼治时间

        demo3();


    }

    private static void demo3() {
        //1.获得Calendar 类对象
        Calendar calendar = Calendar.getInstance();//多态  获得系统此刻日历信息
        System.out.println(calendar);
        //获得具体时间单位数据----> get
        //Date date = calendar.getTime(); calendar转换成Date类对象
        System.out.println(calendar.get(Calendar.YEAR));
//        System.out.println(calendar.get(Calendar.MONTH)+1);
//        System.out.println(calendar.get(Calendar.DATE));
//        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));
//        System.out.println(calendar.get(Calendar.HOUR));
//        System.out.println(calendar.get(Calendar.MINUTE));
//        System.out.println(calendar.get(Calendar.SECOND));

        //修改年份值为2021
        //年份-1
        //calendar.set(Calendar.YEAR,calendar.get(Calendar.YEAR)-1);
//        calendar.set(Calendar.MONTH,Calendar.MAY);
       /* calendar.add(Calendar.YEAR,2);
        System.out.println(calendar.get(Calendar.YEAR));
        System.out.println(calendar.get(Calendar.MONTH)+1);*/

        //calendar.setTime(new Date());//将指定的date数据转换成Calander对象

        //打印输出指定年份指定月份的完整的日历信息
        //2022-02
        //获得这个月份最大的天数
        //calendar.set(Calendar.MONTH,Calendar.MARCH);
        int maximum = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        System.out.println(maximum);
        //周日  周一
        //获得这一天是这一周的第几天
        int day = calendar.get(Calendar.DAY_OF_WEEK);
        System.out.println(day);
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

    private static void demo1() {
        Scanner input = new Scanner(System.in);
        UserInfo userInfo = new UserInfo();
        System.out.println("请录入用户name:");
        userInfo.setName(input.nextLine());


        //String转LocalDate
        //字符串转jdk1.8+ time包里面的任意一个类  就使用这个类里面parse方法

        System.out.println("请录入用户生日:");
        String birthday = input.nextLine();
        userInfo.setBirthday(LocalDate.parse(birthday));
        System.out.println(userInfo.getBirthday());

        //转:
        System.out.println("请录入用户入职时间:");
        String hireDate = input.nextLine();
        userInfo.setHireDate(LocalDateTime.parse(hireDate, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));

        //现在:now
        userInfo.setCreateTime(LocalDateTime.now());//获得的是当前此刻时间

        System.out.println(userInfo.toString());
    }
}
