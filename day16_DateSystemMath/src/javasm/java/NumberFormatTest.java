package javasm.java;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * @projectName: MyJavaStudy
 * @package: javasm.java
 * @author: Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-02-28 22:07
 */
public class NumberFormatTest {

    public static void main(String[] args) {

        numberFormat();
        NumberFormat1();
        moneyFormat();

    }

    // 对金钱的格式化
    private static void moneyFormat() {
        double money = 6178678562437.85682;

        NumberFormat numberFormat = new DecimalFormat(",###.###");
        String format = numberFormat.format(money);
        System.out.println(format); // 6,178,678,562,437.856

        // 余额是用什么类型维护？ BigDecimal
        // 要想精度不丢失，必须使用string的构造器参数
        BigDecimal bigDecimal = new BigDecimal(String.valueOf(money));
        BigDecimal bigDecimal2 = new BigDecimal("42412.41241");

        // 减
        BigDecimal subtract = bigDecimal.subtract(bigDecimal2);
        System.out.println(subtract);
        // 加
        BigDecimal add = bigDecimal.add(bigDecimal2);
        System.out.println(add);


    }

    // 百分数的转换
    private static void NumberFormat1() {

        // 将数字转换为百分制的数字，小数点之后保留3个数字
        double number  = 0.3242464;

        NumberFormat numberFormat = new DecimalFormat(".###%");
        String format = numberFormat.format(number);
        System.out.println(format);

    }

    // 保留小数位
    private static void numberFormat() {

        // 保留小数点后两位
        double number = 100.4752423;

        // 格式化数字 NumberFormat
//        NumberFormat numberFormat = new DecimalFormat("00000.00"); // 用0不满位数会用0填充
        NumberFormat numberFormat = new DecimalFormat("#######.##");  // 用#则不会
        String format = numberFormat.format(number);
        System.out.println(format);

        double v = Double.parseDouble(format);
        System.out.println(v);
    }


}