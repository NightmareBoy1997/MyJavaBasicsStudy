package javasm;

import java.util.Scanner;

/**
 * @author Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-02-10 11:34
 */
public class ScannerDemo1 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("请输入数字： ");
        int number = scanner.nextInt();
        System.out.println(number);

        System.out.print("\n请输入字符串: ");
        String string = scanner.next();
        System.out.println(string);


        /*
    next() / nextInt() : 这些功能只会读取空格之前的数据 ， 不会换行操作，光标依然在当前行 。遇到空格自动结束录入
    nextLine() 从新的一行读取数据，读取一整行，自动换行 ，如果当前行有数据，则会跳过录入直接换行操作

    scanner.next().var idea的类型推断自动生成

         */

        System.out.print("\n请输入姓名：");
        System.out.println(); // 显示行的换行操作无法重置光标指针
        String name = scanner.nextLine(); //跳过，无法录入
        System.out.println(name);

        System.out.print("请输入时间： "); // 2022-02-10 21:46:45
        String createTime = scanner.next();
        System.out.println(createTime); // 2022-02-10 只会读取空格之前的数据

        System.out.print("请输入时间： ");
        scanner.nextLine();
        String createTimeLine = scanner.nextLine();
        System.out.println(createTimeLine);

    }
}
