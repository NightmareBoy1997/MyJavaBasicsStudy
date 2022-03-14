package comguigu.java;

import org.junit.jupiter.api.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAccessor;
import java.util.Date;

/**
 *
 * JDK8中的日期时间API的测试
 *
 * @author Freak-W
 * @create 2021-03-23 14:05
 */
public class JDK8DateTimeTest {

    @Test
    public void testDate(){
        //偏移量
        Date date1=new Date(2020-1900,9-1,1);
        System.out.println(date1);

    }


    /*
    LocalDate、LocalTime、LocalDateTime的使用

    1.LocalDateTime使用频率更高
    2.类似于Calendar

     */

    @Test
    public void test1(){
        //now():获取当前的日期、时间、日期+时间
        LocalDate localDate= LocalDate.now();
        LocalTime localTime = LocalTime.now();
        LocalDateTime localDateTime = LocalDateTime.now();

        System.out.println(localDate);
        System.out.println(localTime);
        System.out.println(localDateTime);

        //of(): 设置指定的年、月、日、时、分、秒。没有偏移量
        LocalDateTime localDateTime1=LocalDateTime.of(2020,3,23,10,57,54);
        System.out.println(localDateTime1);

        //getXxx():获取相关的属性
        System.out.println(localDateTime1.getDayOfMonth());
        System.out.println(localDateTime1.getDayOfWeek());
        System.out.println(localDateTime1.getMonthValue()); //星期几
        System.out.println(localDateTime1.getDayOfYear());
        System.out.println(localDateTime1.getHour());
        System.out.println(localDateTime1.getMinute());
        System.out.println(localDateTime1.getSecond());

        //withXxx():设置相关属性
        //体现了不可变性
        LocalDateTime localDateTime2=localDateTime1.withDayOfMonth(2);
        LocalDateTime localDateTime3=localDateTime1.withHour(1);
        System.out.println(localDateTime2);
        System.out.println(localDateTime1);
        System.out.println(localDateTime3);

        //不可变性
        LocalDateTime localDateTime4=localDateTime.plusYears(-8);
        System.out.println(localDateTime4);

        LocalDateTime localDateTime5=localDateTime.minusYears(8);
        System.out.println(localDateTime5);

    }


    /*
    Instant的使用
    类似于 java.util.Date类
     */
    @Test
    public void InstantTest(){
        //now()获取本初子午线对应的标准时间时间
        Instant instant=Instant.now();
        System.out.println(instant);  //2021-03-24T01:25:24.809Z

        //添加时间的偏移量
        OffsetDateTime offsetDateTime =instant.atOffset(ZoneOffset.ofHours(8));
        System.out.println(offsetDateTime); //2021-03-24T09:25:24.809+08:00

        //获取自1970-1-1-0：0：0(UTC)开始的毫秒数 -->Date类的getTime()
        long milli=instant.toEpochMilli();
        System.out.println(milli);

        //
        Instant instant1=Instant.ofEpochMilli(1616549664919l);
        System.out.println(instant1);
    }


    /*
    DateTimeFormatter：格式化或解析日期、时间
    类似于SimpleDateFormat
     */
    @Test
    public void test2(){
//      方式一：预定义的标准格式：ISO_LOCAL_DATE_TIME;ISO_LOCAL_DATE;ISO_LOCAL_TIME
        DateTimeFormatter formatter=DateTimeFormatter.ISO_LOCAL_DATE_TIME;

        //格式化:日期-->字符串
        LocalDateTime localDateTime=LocalDateTime.now();
        String str1=formatter.format(localDateTime);
        System.out.println(localDateTime);
        System.out.println(str1);

        //解析：字符串 -->日期
        TemporalAccessor parse=formatter.parse("2021-03-24T09:58:23");
        System.out.println(parse);

//      方式二：
        // 本地化相关的格式。如：ofLocalizedDateTime(FormatStyle.LONG)
        //FormatStyle.LONG / FormatStyle.MEDIUM / FormatStyle.SHORT :适用于LocalDateTime

        DateTimeFormatter formatter1=DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
        //格式化
        String str2=formatter1.format(localDateTime);
        System.out.println(str2); //SHORT :21-3-24 上午10:07  LONG:2021年3月24日 上午10时08分15秒  MEDIUM:2021-3-24 10:08:51


        //本地化相关格式化。如：ofLocalizedDate()
        //FormatStyle.LONG / FormatStyle.FULL / FormatStyle.MEDIUM / FormatStyle.SHORT ：适用于localDate
        DateTimeFormatter formatter2=DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM);
        //格式化
        String str3=formatter2.format(LocalDate.now());
        System.out.println(str3); //FULL:2021年3月24日 星期三  MEDIUM: 2021-3-24

//      重点！方式三：自定义的格式。如：ofPattern(“yyyy-MM-dd hh:mm:ss”)
        DateTimeFormatter formatter3=DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
        //格式化
        String str4=formatter3.format(localDateTime);
        System.out.println(str4);
        //解析
        TemporalAccessor parse1=formatter3.parse(str4);
    }

}
