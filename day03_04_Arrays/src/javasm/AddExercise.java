package javasm;

import java.util.Arrays;
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
     * 1.商场实行新的抽奖规则：会员号的百位数字等于产生的随机数字即为幸运会员。实现如下功能：
     * 1、从键盘接收4位数会员号
     * 2、生成随机数   提示：int random = (int) (Math.random() * 10);
     * 3、算出会员号中在百位的数字号码   提示：int baiwei = custNo / 100 % 10;
     */
    public static void luckDraw() {

        // 动态获取4位会员号
        Scanner scanner = new Scanner(System.in);
        System.out.print(Thread.currentThread().getName() + "请输入4位数会员号码： ");
        String str = scanner.next();

        // 排除长度不一致
        if (str.length() != 4) {
            throw new RuntimeException(" 输入数字的长度有误! ");
        }

        // 生成本次幸运号码
        int randomNumber = (int) (Math.random() * 10);
        System.out.println("本次的幸运号码是： " + randomNumber);
        // 比较百位数字与幸运码是否一致
        int number = Integer.parseInt(str);
        int custNo = (number / 100) % 10;

        // 输出结果
        if (custNo == randomNumber) {
            System.out.println(Thread.currentThread().getName() + " 恭喜你！你是幸运会员！ ");
        } else {
            System.out.println(Thread.currentThread().getName() + "很遗憾！祝您下次好运！");
        }
        scanner.close();
    }


    /*
    2，计算个税
     */
    public static void money() {
        // 动态获取税前工资
        Scanner scanner = new Scanner(System.in);
        System.out.println(Thread.currentThread().getName() + "请输入工资： ");
        double salary = scanner.nextDouble();

        // 排除负输入
        if (salary < 0) {
            throw new RuntimeException("输入有误！");
        }

        // 记录超出3500的工资部分
        double exceedSalary = salary - 3500;
        // 应交税款
        double taxMoney;
        // 实际收入
        double income;
        // 税率
        double ratio = 0;
        // 速算扣除
        int minusMoney = 0;

        // 工资不足起征数目
        if (exceedSalary <= 0) {
            taxMoney = 0;
        }

        // 工资超出 0 - 1500
        if (exceedSalary > 0 && exceedSalary <= 1500) {
            ratio = 0.03;
            minusMoney = 0;
        }

        // 工资超出 1501 - 4500
        if (exceedSalary > 1500 && exceedSalary <= 4500) {
            ratio = 0.1;
            minusMoney = 105;
        }

        // 工资超出 4501 - 9000
        if (exceedSalary > 4500 && exceedSalary <= 9000) {
            ratio = 0.2;
            minusMoney = 555;
        }

        // 工资超出 9001 - 35000
        if (exceedSalary > 9000 && exceedSalary <= 35000) {
            ratio = 0.25;
            minusMoney = 1005;
        }

        // 工资超出 35001 - 55000
        if (exceedSalary > 35000 && exceedSalary <= 55000) {
            ratio = 0.3;
            minusMoney = 2755;
        }

        // 工资超出 50001 - 80000
        if (exceedSalary > 50000 && exceedSalary <= 80000) {
            ratio = 0.35;
            minusMoney = 5505;
        }

        // 工资超出 80000
        if (exceedSalary > 80000) {
            ratio = 0.45;
            minusMoney = 13505;
        }

        taxMoney = (exceedSalary - 262) * ratio - minusMoney;
        income = salary - taxMoney - 262;
        System.out.println(Thread.currentThread().getName() + "你的工资是： " + salary + " ，应交个人所得税： " + taxMoney + " ，税后工资： " + income);

        scanner.close();
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


    //4，一张纸的厚度大约是0.08mm，对折多少次之后能达到珠穆朗玛峰的高度（8848.13米）
    public static void height() {

        double height = 0.08 / 1000;
        int number = 0;

        for (double i = height; i < 8848.13; i *= 2) {
            number++;
        }
        System.out.println("需要对折 " + number + " 次");

    }


    // 5, 一球从100米高度处自由落下，每次落地后反跳回原高度的一半；再落下再弹回，求它在 第10次落地反弹时，反弹多高？以及共经过多少米？
    public static void ball() {

        double height = 100;
        double sumHeight = 0;

        for (int i = 1; i <= 10; i++) {
            sumHeight += height;
            height /= 2;
        }

        System.out.println("小球经过 10 次反弹时，反弹高度是 " + height + "米 ， 其中共经过 " + sumHeight + "米");

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


    //            数组附加练习
//1，定义一个长度为10的int类型数组，接受10个值后使用冒泡排序算法对数组进行排序
    public static void tenArray() {

        Scanner scanner = new Scanner(System.in);
        int[] array = new int[10];

        // 动态录入数组的 10 个数字
        for (int i = 0; i < array.length; i++) {
            System.out.print("请输入int数组的第 " + (i + 1) + " 个元素: ");
            array[i] = scanner.nextInt();
        }

        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp;
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }

        // 遍历数组
        for (int i : array) {
            System.out.print(i + "   ");
        }

        scanner.close();

    }


    //2，数组的动态扩容，自定义一个int数组用于存放学生成绩，需要做到当学生人数增加时数组可以自动扩容
    public static void autoArray() {

        int[] array = new int[2];
        System.out.println("当前数组容量： " + array.length);

        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入要添加的学生数量： ");
        int number = scanner.nextInt();

        for (int i = 0; i < number; i++) { // 数组赋值


            System.out.print("请输入要添加的学生标号： ");

            if (i < array.length) {
                array[i] = scanner.nextInt();
                System.out.println("添加成功！");
            }

            if (i >= array.length) { // 数组扩容并赋值

                int[] array1 = new int[array.length * 2 + 2];

                System.out.println("\n ****** 数组已满，扩容成功 ******\n当前容量： " + array1.length);

                for (int j = 0; j < array.length; j++) {
                    array1[j] = array[j];
                }
                array = array1;
                array[i] = scanner.nextInt();

                System.out.println("添加成功！");

            }
        }

        // 遍历数组
        for (int i : array) {
            System.out.print(i + " ");
        }

    }


    //3，自定义一个int数组a,现输入一个数据x,要在数组a中删除所有出现的x，删除之后后面的元素依次向前移动
    public static void moveArray() {

        Scanner scanner = new Scanner(System.in);
        int[] array = new int[10];
        // 数组赋值
        for (int i = 0; i < 10; i++) {
            System.out.print("请输入第 " + (i + 1) + " 个数字: ");
            array[i] = scanner.nextInt();
        }

        System.out.println("原数组为：  " + Arrays.toString(array));

        // 数组修改
        System.out.print("请输入要删除的数值： ");
        int delete = scanner.nextInt();
        for (int i = 0; i < array.length; i++) {

            if (array[i] == delete) {

                for (int j = i ; j < array.length - 1; j++) {
                    array[j] = array[j + 1];
                }

                if (array[i] == delete) {
                    i--;
                }

                // 将末尾元素置为默认值
                array[array.length - 1] = 0;
            }
        }

        System.out.print("删除 " + delete + " 后的数组为：  " + Arrays.toString(array));
        scanner.close();
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

//        luckDraw();
//
//        money();
//
//        printTriangle1();
//        printTriangle2();
//
//        printRhombus();
//        printRhombus1();
//
//        sumDay();
//
//        height();
//
//        ball();
//
//        threeNumber();
//
//        tenArray();
//
//        autoArray();
//
//        moveArray();
//
//        number();

    }


}
