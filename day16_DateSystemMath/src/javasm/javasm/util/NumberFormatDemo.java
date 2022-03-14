package javasm.javasm.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * @author: Lisa
 * @className: NumberFormatDemo
 * @description:
 * @date: 2022/2/28 16:09
 * @version: 0.1
 * @since: jdk11
 */
public class NumberFormatDemo {

    public static void main(String[] args) {
        demo3();


    }

    private static void demo3() {
        //3.对钱数值进行格式化
        double money = 16637743645556364353534535.6787346;
        System.out.println(money);
        NumberFormat numberFormat = new DecimalFormat(",###.###");
        System.out.println(numberFormat.format(money));

        //存储用户余额: 将钱全部转成分
        //转成2部分:
        //在开发中  余额使用什么类型维护?  BigDecimal---->小数运算
        //System.out.println(0.1+0.2);
        //System.out.println(0.3/0.1);

        BigDecimal num1 = new BigDecimal("0.3");
        BigDecimal num2 = new BigDecimal("0.1");
        System.out.println(num1.divide(num2));

        BigDecimal num3 = BigDecimal.valueOf(0.2);
        System.out.println(num3.add(num2));


    }

    private static void demo2() {
        //2. 将数据转换成百分制的数字 小数点之后保留3个数字
        double num = 0.1234567;
        NumberFormat numberFormat = new DecimalFormat(".###%");
        String result = numberFormat.format(num);
        System.out.println(result);
    }

    private static void demo1() {
        //1. 保留小数点后面指定的位数
        double num = 1100.567895;
        //System.out.println(Math.round(num));
        //格式化数字类  NumberFormat
        //NumberFormat numberFormat = new DecimalFormat("0000000.000");
        NumberFormat numberFormat = new DecimalFormat("######.###");
        String result = numberFormat.format(num);
        System.out.println(result);

        //String转Double
        System.out.println(Double.parseDouble(result));
    }
}
