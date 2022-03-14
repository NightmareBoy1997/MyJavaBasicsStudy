package comguigu.exercise;

import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @projectName: MyJavaStudy
 * @package: comguigu.exercise
 * @author: Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-02-21 20:50
 */
public class SimpleDateFormatTest1 {

        /*
        SimpleDateFormat 是对日期的Date的格式化和解析

        1. 两个操作
            1） 格式化  日期 --> String
            2） 解析    String --> 日期
         */


    // 实例化SimpleDateFormat
    @Test
    public void testSimpleDateFormat() {
        // 实例化SimpleDateFormat
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();

        // 格式化 ： 日期 --> String
        Date date1 = new Date();
        System.out.println(date1);

        String dateString =  simpleDateFormat.format(date1);
        System.out.println(dateString);

//        String dateString1 = "2022-2-21 15:03"; // ParseException
        String dateString1 = " 2022/2/21 下午9:07 ";
        String dateString2 = " 2022/2/21 下午9:07 "; // 与上面的输出结果一致

        try {

            Date date2 = simpleDateFormat.parse(dateString1);
            System.out.println(date2);

        } catch (ParseException e) {
            e.printStackTrace();
        }

//        **************************************************
        System.out.println("*********************************");


        // ******** 按照在指定的方式格式化 和 解析 ： 调用带参构造器********
        // 实例化SimpleDateFormat
        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        // 格式化：
        String dateString3 = simpleDateFormat1.format(date1);
        System.out.println(dateString3);

        // 解析：要求字符串必须是符合SimpleDateFormat识别的格式( 构造器形参体现 ) ，
        // 否则，异常
        String dateString4 = "2022-02-21 21:15:22";
        try {
            Date dateString7 = simpleDateFormat1.parse(dateString4);
            System.out.println(dateString7);
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }


    // 练习一： 字符串“2022-07-13”转换为java.sql.Date
    @Test
    public void simpleDateFormat2(){

        String dateString = "2022-07-13";

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        try {
            Date   date = simpleDateFormat.parse(dateString);
            java.sql.Date sqlDate = new java.sql.Date(date.getTime());
            System.out.println(sqlDate.getClass());

        } catch (ParseException e) {
            e.printStackTrace();
        }

    }


        // "三天打鱼两天晒网" 1990-1-1  xxxx-xx-xx在打鱼还是晒网？
        @Test
        public void getFish(){

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            String dateString = "2022-2-21 00:00:00";

            try {
                Date date1 = simpleDateFormat.parse("1990-1-1 00:00:00");
                Date date3 = simpleDateFormat.parse(dateString);

                int number = 1000 * 60 * 60 * 24 ;
                long sum = date3.getTime() - date1.getTime();

                int numDay;
                if(sum % number != 0){
                    numDay =(int)( sum / number ) ;
                }else{
                    numDay =(int)( sum / number )+ 1;
                }

                switch(numDay % 5){
                    case 1 :
                    case 2 :
                    case 3 :
                        System.out.println(dateString + " 这天在打鱼！");
                        break;
                    case 4 :
                    case 0 :
                        System.out.println(dateString + " 这天在晒网！");
                        break;
                }

            } catch (ParseException e) {
                e.printStackTrace();
            }

        }






}