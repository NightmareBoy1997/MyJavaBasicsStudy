package javasm.bike.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @projectName: MyJavaStudy
 * @package: javasm.bike.util
 * @author: Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-02-27 21:35
 */
public class DateUtil {

    private DateUtil(){

    }

    public static double getDuration(String backTime, String borrowTime) {
//        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss");
//        TemporalAccessor borrow = dateTimeFormatter.parse(borrowTime);
//        TemporalAccessor back = dateTimeFormatter.parse(backTime);
//        Date borrowDate = new Date(borrow);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
        try {
            Date borrow = simpleDateFormat.parse(borrowTime);
            Date back = simpleDateFormat.parse(backTime);

            long time = Math.abs(back.getTime() - borrow.getTime());

            if(time % 3600000 == 0  ){
                return time/1000/60/60;
            }else{
                return time/1000/60/60 + 1;
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }


        return 0 ;
    }
}