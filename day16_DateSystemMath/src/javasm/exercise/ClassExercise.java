package javasm.exercise;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAccessor;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @projectName: MyJavaStudy
 * @package: javasm.exercise
 * @author: Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-02-28 11:36
 */
public class ClassExercise {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Date date = new Date();

//        dateString();
//
//        calenderTest(scanner);

//        verificationCode(scanner);
//
//        timeDifference(scanner);
//
        setDateTime(date , 10);

        randomNumber();

    }


    //1. 将长时间格式时间转换为字符串 yyyy-MM-dd HH:mm:ss
    private static void dateString() {

        LocalDateTime localDateTime = LocalDateTime.now();

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println(dateTimeFormatter.format(localDateTime));

    }


    //2. 使用Calendar类的相关属性以及方法！打印出某年某个月的日历信息！（要求年月日由命令行输入）
    private static void calenderTest(Scanner scanner) {

        Calendar calendar = Calendar.getInstance();

        int year = 2022;
        int month = 3;

        calendar.set(year,Calendar.MARCH,1);
        System.out.println("日\t1\t2\t3\t4\t5\t6");

        // .1 获取指定月份的总天数
        int totalDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

        // .2 获得指定月份1号属于这一周的第几天
        int number = calendar.get(Calendar.DAY_OF_WEEK);
        for (int i = 0; i < number; i++) {
            System.out.print("\t");
        }

        for (int i = 1; i <= totalDay; i++) {
            System.out.print(i+ "\t");
            if(i%7 == (7-number)){
                System.out.println();
            }
        }
    }


    // 3. 从命令行输入一个字符串！要求从中随机选择6个字符组成验证码！
    private static void verificationCode(Scanner scanner) {
        System.out.print("请输入字符串： ");
        String string = scanner.next();

        ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();

        StringBuilder stringBuilder = new StringBuilder(16);
        int index;
        for (int i = 0; i < 6; i++) {

            index = threadLocalRandom.nextInt(string.length());
            stringBuilder.append( string.charAt(index) );
        }

        System.out.println(stringBuilder);


        // 一般验证码： 纯数字 数字+字母  UUID类
        // 0-9 a-z
        System.out.println(UUID.randomUUID());
    }


// 4. 计算两个时间相差几个小时
    private static void timeDifference(Scanner scanner) {
        System.out.print("请输入第一个日历时间(yyyy-MM-dd HH:mm:ss)： ");
        String dateString1 = scanner.nextLine();
        System.out.print("请输入第二个日历时间(yyyy-MM-dd HH:mm:ss)： ");
        String dateString2 = scanner.nextLine();

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        TemporalAccessor parse1 = dateTimeFormatter.parse(dateString1);
        TemporalAccessor parse2 = dateTimeFormatter.parse(dateString2);

        LocalDateTime localDateTime1 = LocalDateTime.from(parse1);
        LocalDateTime localDateTime2 = LocalDateTime.from(parse2);

        long timeDifference = Math.abs( localDateTime1.until(localDateTime2, ChronoUnit.HOURS) ) ;
        System.out.println("时间相差： " + timeDifference);

        // 获取年月日的差值
        LocalDate localDate1 = LocalDate.from(parse1);
        LocalDate localDate2 = LocalDate.from(parse2);
        Period period = localDate1.until(localDate2);
        System.out.println(period.getYears());
        System.out.println(period.getMonths());
        System.out.println(period.getDays());


    }


//5. 一个方法，要求传入时间和间隔天数，返回新的日期
    private static void setDateTime(Date date , int day) {

        // 方式一：
        long time = date.getTime();
        long millis = Duration.ofDays(day).toMillis();
        date.setTime(time + millis);
        System.out.println("修改后的时间： " + date);

        // 方式二：
        Calendar calendar = Calendar.getInstance();
        calendar.add(day,Calendar.DAY_OF_WEEK);
        System.out.println("修改后的时间： " + calendar.getTime() );


        // 方式三：
        LocalDateTime localDateTime = LocalDateTime.now();
        LocalDateTime localDateTime1 = localDateTime.plusDays(day);

        System.out.println("修改后的时间： " + localDateTime1);

    }


//6. 要求写一个工具类，可以自定义获取N个随机数字或字母（0~9,a~z,A~Z混合一起）
    private static void randomNumber(){
        StringBuilder code = new StringBuilder();

        ThreadLocalRandom random = ThreadLocalRandom.current();

        // ASCII
        // 0-9  48 - 57
        // a-z  65 - 90
        // A-Z  97 - 122
        for (int i = 0; i < 6; i++) {
            int number = random.nextInt(48,122);
            if( number > 57 && number < 65 || number > 90 && number < 97 ){
                i--;
                continue;
            }
            code.append((char)number);
        }

        System.out.println("验证码： " + code);
    }




}



