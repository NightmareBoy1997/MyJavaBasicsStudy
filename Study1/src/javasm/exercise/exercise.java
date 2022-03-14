package javasm.exercise;

import org.junit.jupiter.api.Test;

import java.util.Scanner;

/**
 * @projectName: MyJavaStudy
 * @package: javasm.exercise
 * @author: Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-02-20 20:47
 */

public class exercise {

        // 2. 编写一个Student类，包含name、age等属性，要求使用System.out.println()
        // 打印Student类的对象引用时，输出的为name的值！
        @Test
        public void Student(){
        System.out.println(new Student("德玛西亚之力", 25));
        }


        // 1. 不利用Integer.parseInt()方法将一个给定的字符串转变为Int型数值,并检测
        // 自己实现的方法和Integer.parseInt()的性能差距。
        public static void main(String[] args) {
            stringToInt();
        }




    class Student {
        private String name;
        private int age;

        public Student(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String toString() {
            return this.name;
        }
    }


    /* 需求： 不利用Integer.parseInt()方法将一个给定的字符串转变为Int型数值,
    并检测自己实现的方法和Integer.parseInt()的性能差距。
    * @author Nightmare970701
    * @description:
    * @version: JDK11
    * @create: 2022-02-20 21:25
    */
    public static void stringToInt() {

        // 动态获取要转换的String
        Scanner input = new Scanner(System.in);
        System.out.print("请输入要转换的数字： ");
        String string = input.next();

        char[] strChar = string.toCharArray();
        // 参照数组
        char[] chars = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

        // 储存转换后的数值
        int sum = 0;
        int length = strChar.length;

        for (int i = 0, m = length - 1; i < strChar.length; i++) {
            // m记录每位数值的10次幂
            for (int j = 0; j < chars.length; j++) {
                if (strChar[i] == chars[j]) {
                    sum += j * Math.pow(10, m);
                    m--;
                    break;
                }
            }
        }
        System.out.println(sum);
    }


}


