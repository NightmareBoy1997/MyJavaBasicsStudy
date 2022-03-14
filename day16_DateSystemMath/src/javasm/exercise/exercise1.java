package javasm.exercise;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;


/**
 * @projectName: MyJavaStudy
 * @package: javasm.exercise
 * @author: Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-03-01 11:07
 */
public class exercise1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Date date = new Date();

//        demo1();
//        demo2();
        demo3(scanner);
//        demo4();
//        demo5();
//        demo6();

    }



    // 4. 计算两个时间相差几个小时
    private static void demo4() {

        // 方式一：
//        String date1 = "2022-02-28 12:23:34";
//        String date2 = "2022-03-01 15:53:16";
//
//        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//
//        TemporalAccessor parse1 = dateTimeFormatter.parse(date1);
//        TemporalAccessor parse2 = dateTimeFormatter.parse(date2);
//
//        LocalDateTime localDateTime1 = LocalDateTime.from(parse1);
//        LocalDateTime localDateTime2 = LocalDateTime.from(parse2);
//
//        long days = localDateTime1.until(localDateTime2, ChronoUnit.HOURS);
//        System.out.println(days);

        // 方式二：
        LocalDate localDate1 = LocalDate.of(2022,3,1);
        LocalDate localDate2 = LocalDate.of(2022,3,4);

        // 获取两个时间的间隔
        long days1 = Math.abs(localDate2.until(localDate1, ChronoUnit.DAYS));
        System.out.println(Duration.ofDays(days1).toHours());
    }



    //5. 一个方法，要求传入时间和间隔天数，返回新的日期
    private static void demo5() {
        LocalDateTime localDateTime = LocalDateTime.now();
        LocalDateTime localDateTime1 = localDateTime.plusDays(10);
        System.out.println(localDateTime1);

        // 方式二：
        Date date1 = new Date();
        long millis = Duration.ofDays(10).toMillis();
        Date date2 = new Date(date1.getTime() + millis);
        System.out.println(date2);

        // 方式三：
        Calendar calendar1 = Calendar.getInstance();
        calendar1.add(Calendar.DAY_OF_YEAR,10);
        System.out.println(calendar1.getTime());
    }


    //6. 要求写一个工具类，可以自定义获取N个随机数字或字母（0~9,a~z,A~Z混合一起）
    private static void demo6() {
        // ASCII
        // 0-9 48~57
        // a-z 65-90
        // A-Z 97-122
        ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();
        StringBuilder stringBuilder = new StringBuilder(16);
        for (int i = 0; i < 6; i++) {

            int index = threadLocalRandom.nextInt(48,123);
            if(index>57 && index<65 || index>90 && index<97){
                i--;
                continue;
            }
            stringBuilder.append((char)index);
        }
        System.out.println("验证码: " + stringBuilder);
    }


    //1. 将长时间格式时间转换为字符串 yyyy-MM-dd HH:mm:ss
    private static void demo1() {

        // 方式一：
        Date date = new Date();

        SimpleDateFormat simpleDateFormat =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss a E");
        String string = simpleDateFormat.format(date);
        System.out.println(string);


        // 方式二：
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss a E");
        String dateString = dateTimeFormatter.format(localDateTime);
        System.out.println(dateString);

    }


    //2. 使用Calendar类的相关属性以及方法！打印出某年某个月的日历信息！（要求年月日由命令行输入）
    private static void demo2() {

        int year = 2022;
        int month = Calendar.MARCH;

        Calendar calendar = Calendar.getInstance();
        calendar.set(year,month,1);

        int number = calendar.get(Calendar.DAY_OF_WEEK);
        int days = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        System.out.println("日\t一\t二\t三\t四\t五\t六");

        for (int i = 1; i < number; i++) {
            System.out.print("\t");
        }

        // 方式一：
        for (int i = 1; i <= days; i++) {
            System.out.print( i + "\t" );
            if( i % 7 == (7 - number + 1)){
                System.out.println();
            }
        }
        System.out.println();
        // 方式二：
        for (int i = 1; i <= days; i++) {
            System.out.print(i + "\t");
            calendar.set(Calendar.DATE,i);
            if(calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY){
                System.out.println();
            }

        }

    }

    // 3. 从命令行输入一个字符串！要求从中随机选择6个字符组成验证码！
    private static void demo3(Scanner scanner) {
        System.out.print("请输入要随机的字符串： ");
        String string = scanner.next();

        ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();
        StringBuilder stringBuilder = new StringBuilder(16);
        for (int i = 0; i < 6; i++) {
            int index = threadLocalRandom.nextInt(string.length());
            stringBuilder.append(string.charAt(index));
        }

        System.out.println("随机的字符是： " + stringBuilder);


        // 0-9 a-z 获取随机码的工具类
        System.out.println(UUID.randomUUID().toString().substring(0,6));

        // 纯数字
        System.out.println(String.valueOf(System.currentTimeMillis()).substring(0,6));
    }


}