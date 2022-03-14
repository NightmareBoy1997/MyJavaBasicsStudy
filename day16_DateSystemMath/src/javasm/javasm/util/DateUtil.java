package javasm.javasm.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

/**
 * @author: Lisa
 * @className: DateUtil
 * @description: 实现字符串与Date之间相互转换
 * @date: 2022/2/28 10:49
 * @version: 0.1
 * @since: jdk11
 */
public class DateUtil {

    private DateUtil() {
    }


    //内存: 局部的时候 会new很多次  占据很多堆内存
    //线程安全  解决内存过多问题 使用全局进行解决 在单线程没有问题的  在并发里面就会并发安全的问题
    //性能 使用synchronized解决了线程安全以及内存占据过多的问题  但是性能就很低
    //ThreadLocal

    private static final String PATTERN = "yyyy-MM-dd HH:mm:ss";

    //SimpleDateFormat作为全局使用 在单线程里面没有任何问题
    //在并发?SimpleDateFormat 是一个线程不安全的一个类
    //String 转  Date
    public static Date strConvertDate(String dateStr) {
        Objects.requireNonNull(dateStr);
        if (dateStr.isBlank()) {
            throw new RuntimeException("字符串数据为空串");
        }
        DateFormat dateFormat = new SimpleDateFormat(PATTERN);
        //转----> 使用日期格式化类转换数据
        try {
            return dateFormat.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();//字符串时间无法满足pattern模式的要求(字符串时间内容>=pattern)
        }
        return null;
    }

    //Date转String
    public static String dateConvertToStr(Date date) {
        if (date == null) {
            return "";
        }
        Objects.requireNonNull(date);
        DateFormat dateFormat = new SimpleDateFormat(PATTERN);
        return dateFormat.format(date);
    }

}
