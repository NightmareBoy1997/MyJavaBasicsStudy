package comguigu.exercise;

import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

/**
 * @projectName: MyJavaStudy
 * @package: comguigu.exercise
 * @author: Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-02-22 10:05
 */
public class InstantTest {

    /*
    Instant的使用
    类似于Date类
     */
    @Test
    public void InstantTest1(){

        // 实例化1 ： now() 获取本初子午线标准时间的对象
        Instant instant1 = Instant.now();
        System.out.println(instant1); // 2022-02-22T02:11:15.397293Z 伦敦本初子午线

        // 实例化2 ：用指定毫秒数(时间戳) ，获取实例 --> 类似Date类
        Instant instant2 = Instant.ofEpochMilli(1645496210788l);
        System.out.println(instant2);

        // atOffset() ： 添加时间偏移量
        OffsetDateTime offsetDateTime = instant1.atOffset(ZoneOffset.ofHours(8));
        System.out.println(offsetDateTime); //2022-02-22T10:11:15.397293+08:00

        // toEpochMilli() : 获取对应的毫秒数 --> Date.getTime()
        long instantMilli = instant1.toEpochMilli();
        System.out.println(instantMilli);


    }








}