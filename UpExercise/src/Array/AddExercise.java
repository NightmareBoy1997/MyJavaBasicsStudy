package Array;

import java.util.Scanner;

/**
 * @author Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-02-09 16:04
 * <p>
 * 附加练习题
 */
public class AddExercise {

    /**
     * 循环附加练习:  3. 打印如图类似的三角形
     * *
     * ***
     * *****
     * ………
     *
     * @param
     * @param
     * @author 自己写的垃圾逻辑, 反复优化才勉强及格
     * @description: 计算每行' '及'*'的方式
     * @since: 1.5 (修改优化，修改为字符数量标记方式)
     */
    public static void printTriangle1() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入想要打印的行数： ");
        int number = scanner.nextInt();
        // 记录最大行的字符数
        int max = 2 * number - 1;
        // 第1行半边的' '的数量
        int space = number - 1;

        scanner.close();

        // 每打印一行'*'数量 + 2, ' '数量 -2
        for (int i = 1, x = space, y = 1; i <= number; i++, x--, y += 2) {

            for (int j = 1; j <= max; j++) {
                // 打印完' '的数量，接着打印'*'
                if (j >= 1 + x && j < 1 + y + x) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }



    /**
     * 循环附加练习:  3. 打印如图类似的三角形
     * *
     * ***
     * *****
     * ………
     *
     * @param
     * @param
     * @author 通过庆哥讲解许久，才想通，改用指针逻辑，只能说这很C ，果然简洁！ 棒！
     * @description: 给定两个数作为指针边界，在两指针内打印'*'，在两指针外打印' ' 。每打印完一行将左右指针外移1位
     * @since: 2.0 (得庆哥指点，修改为指针标记版本)
     */
    public static void printTriangle2() {

        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入要打印的行数： ");
        int number = scanner.nextInt();

        scanner.close();

        // 记录最大行的*数
        int max = 2 * number - 1;

        // x、y作为指针边界，在x，y指针内打印'*'，否则打印' ' 。每打印完一行将x减一、y加一，使得左右指针外移1位
        for (int i = 1, x = max / 2 + 1, y = max / 2 + 1; i <= number; i++, x--, y++) {

            for (int j = 1; j <= max; j++) {

                if (j >= x && j <= y) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }



    /**
     * 循环附加练习:  4. 打印如图类似的菱角形
     * *
     * ***
     * *****
     * *******
     * *****
     * ***
     * *
     *
     * @param
     * @param
     * @author 利用垃圾逻辑反复配凑
     * @description: 计算每行' '及'*'的方式
     * @since: 1.5 (修改优化，修改为字符数量标记方式)
     */
    public static void printRhombus() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入想要打印的行数： ");
        int number = scanner.nextInt();

        scanner.close();

        // 判断最长列的行数
        int max;
        // 记录总行数是奇数还是偶数
        boolean flag;
        if (number % 2 == 0) {
            flag = true;
            max = number / 2;
        } else {
            flag = false;
            max = number / 2 + 1;
        }

        // 记录最大行的字符数
        int maxChar = 2 * max - 1;
        // 第1行半边的' '的数量
        int space = max - 1;

        // y表示*的数量 ， x表示 的数量
        for (int i = 1, x = space, y = 1; i <= number; i++) {

            // 正三角
            if (i <= max) {

                for (int j = 1; j <= maxChar; j++) {
                    // 打印完' '的数量，接着打印'*'
                    if (j >= 1 + x && j < 1 + y + x) {
                        System.out.print("*");
                    } else {
                        System.out.print(" ");
                    }
                }
                System.out.println();

                // 达到最大行时停止增加'*'迭代
                if (i < max) {
                    x--;
                    y += 2;
                }

                // 如果总行数是奇数，在最大行开始减少'*'迭代。 如果是偶数，停止迭代 ， 重复打印最大行
                if (i == max) {
                    if (!flag) {
                        x++;
                        y -= 2;
                    }
                }

            }

            // 倒置三角
            if (i > max) {

                for (int j = 1; j <= maxChar; j++) {
                    // 打印完' '的数量，接着打印'*'
                    if (j >= 1 + x && j < 1 + y + x) {
                        System.out.print("*");
                    } else {
                        System.out.print(" ");
                    }
                }
                System.out.println();
                x++;
                y -= 2;
            }
        }
    }



    /**
     * 循环附加练习:  4. 打印如图类似的菱形
     * *
     * ***
     * *****
     * *******
     * *****
     * ***
     * *
     *
     * @param
     * @param
     * @author 得益于庆哥的指针思维，简单许多！
     * @description:
     * @since: 2.0 (得庆哥指点，修改为指针标记版本)
     */
    public static void printRhombus1() {

        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入要打印的行数： ");
        int number = scanner.nextInt();
        scanner.close();

        // 判断总行数是奇数还是偶数
        boolean flag;
        if (number % 2 == 0) {
            flag = true;
        } else {
            flag = false;
        }

        // 最大行的行数
        int max;
        if (flag) {
            max = number / 2;
        } else {
            max = number / 2 + 1;
        }

        // 记录最大行的字符数
        int maxChar = 2 * max - 1;

        for (int i = 1, x = maxChar / 2 + 1, y = maxChar / 2 + 1; i <= number; i++, x--, y++) {

            // 正三角
            if (i <= max) {

                for (int j = 1; j <= maxChar; j++) {

                    if (j >= x && j <= y) {
                        System.out.print("*");
                    } else {
                        System.out.print(" ");
                    }
                }
                System.out.println();

                if (i == max) {
                    // 如果是偶数行，将指针内移1位平衡迭代条件。 否则将指针内移2位，经迭代条件内移1位将*数量减少2
                    if (flag) {
                        x++;
                        y--;
                    } else {
                        x += 2;
                        y -= 2;
                    }
                }
            }

            // 倒置三角
            if (i > max) {

                for (int j = 1; j <= maxChar; j++) {

                    if (j >= x && j <= y) {
                        System.out.print("*");
                    } else {
                        System.out.print(" ");
                    }
                }
                System.out.println();

                // 手动将左右指针内移2位，经迭代条件将指针内移1位，将*的数量减少2
                x += 2;
                y -= 2;
            }
        }
    }



    /*
     3，计算用户输入的日期离1900年1月1日相距多少天
     */
    public static void sumDay() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入年： ");
        int year = scanner.nextInt();
        System.out.println("请输入月： ");
        int month = scanner.nextInt();
        System.out.println("请输入日： ");
        int day = scanner.nextInt();

        if (year < 1900) {
            throw new RuntimeException("输入有误！时间不能倒流！");
        }

        scanner.close();

        // 计算年天数
        int dayNumber = 0;
        for (int i = 1900; i < year; i++) {

            if (i % 4 == 0 && i % 100 != 0) {
                dayNumber += 366;
            } else {
                dayNumber += 365;
            }
        }

        // 计算月天数
        switch (month - 1) {
            case 11:
                dayNumber += 30;
            case 10:
                dayNumber += 31;
            case 9:
                dayNumber += 30;
            case 8:
                dayNumber += 31;
            case 7:
                dayNumber += 31;
            case 6:
                dayNumber += 30;
            case 5:
                dayNumber += 31;
            case 4:
                dayNumber += 30;
            case 3:
                dayNumber += 31;
            case 2:
                dayNumber += 28;
            case 1:
                dayNumber += 31;
        }
        if (year % 4 == 0 && year % 100 != 0) {
            dayNumber++;
        }

        // 计算日天数
        dayNumber += day;

        System.out.println(year + " 年 " + month + " 月 " + day + " 日 与 1900 年 1 月 1 日相距 " + dayNumber + " 天");

    }



    // 6，请用程序接收一个三位数，然后打印出所有0到这个数之间 带3和3的倍数的数
//    例如 有99 , 96 , 93 , 90 , 87 , 84 , 83 , 81 , 78 , 75 , 73 , 72.......等等
    public static void threeNumber() {

        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入一个三位数： ");
        String next = scanner.next();

        scanner.close();

        if (next.length() != 3) {
            throw new RuntimeException("输入长度有误！");
        }

        int number = Integer.parseInt(next);
        for (int i = 0; i <= number; i++) {

            if (i % 3 != 0 && i % 10 != 3 && i % 100 / 10 != 3 && i / 100 != 3) {
                continue;
            }
            System.out.println(" " + i);
        }
    }



    //
//4，现有4个数字为6、7、9、5，能组成多少个互不相同且无重复数字的三位数？都是多少？
//    例如有 679，675，697，695，657，659.....等等
    public static void number() {

        int[] array1 = {6, 7, 5, 9};
        int[] array2 = {5, 6, 7, 9};
        int[] array3 = {5, 6, 7, 9};

        int number = 0;

        for (int x : array1) {
            for (int y : array2) {
                for (int z : array3) {

                    if (x != y && x != z && y != z) {
                        number++;
                        System.out.print(x * 100 + y * 10 + z + "  ");
                    }

                }
            }
        }

        System.out.println("\n一共有不重复的数字 " + number + " 个");

    }


    public static void main(String[] args) {

//        printTriangle1();
//        printTriangle2();
//
//        printRhombus();
//        printRhombus1();
//
//        sumDay();
//
//        threeNumber();
//
//        number();

    }
}
