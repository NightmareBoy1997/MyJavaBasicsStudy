package comguigu.exercise;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAccessor;

/**
 * @projectName: MyJavaStudy
 * @package: comguigu.exercise
 * @author: Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-02-22 10:20
 */
public class DateTimeFormatterTest {

    /*
    DateTimeFormatter：格式化或解析日期时间
    类似于SimpleDateFormatter
     */
    @Test
    public void dateTimeFormatter1(){

        // 实例化1 ：预定义的标准格式
        DateTimeFormatter isoLocalDateTime = DateTimeFormatter.ISO_LOCAL_DATE_TIME;

        LocalDateTime localDateTime = LocalDateTime.now();
        // 格式化：日期 --> 字符串
        String format = isoLocalDateTime.format(localDateTime);
        System.out.println(localDateTime);
        System.out.println(format);

        // 解析： 字符串 --> 日期
        String string = "2022-02-22T10:45:23.6410893";
        TemporalAccessor parseString = isoLocalDateTime.parse(string);
        System.out.println(parseString);


        // 实例化2 ：本地化的格式
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);

        // 格式化：
        String format1 = dateTimeFormatter.format(localDateTime);
        System.out.println(format1);
        // 解析：
        TemporalAccessor parse = dateTimeFormatter.parse("2022/2/22 上午11:04" );
        System.out.println(parse);


        // 重点： 实例化3 ：自定义的格式。如 ofPattern("yyyy-MM-dd hh:mm:ss E")
//        DateTimeFormatter dateTimeFormatter3 = new DateTimeFormatter();

        DateTimeFormatter dateTimeFormatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss E");

        // 格式化：
        String format2 = dateTimeFormatter2.format(localDateTime);
        System.out.println(format2);

        // 解析：
        String string2 = "2008-08-08 15:09:21 周五"; // 注意周几也要匹配
        TemporalAccessor parse1 = dateTimeFormatter2.parse(string2);
        System.out.println(parse1);


    }

}