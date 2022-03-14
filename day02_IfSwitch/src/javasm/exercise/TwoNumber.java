package javasm.exercise;

import java.util.Scanner;

/**
 * @author Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-02-10 15:10
 *
 *   现要求用户输入两个数a、b，如果a能被b整除或a加b大于1000，则输出a，否则输出b
 *
 */
public class TwoNumber {

    public static void main(String[] args) {

         Scanner scanner = new Scanner(System.in);
        System.out.print("请输入第一个数字a: ");
         int a = scanner.nextInt();
        System.out.print("请输入第二个数字： ");
         int b = scanner.nextInt();

         if(a%b == 0 | a+b>1000){
             System.out.println(a);
         }else{
             System.out.println(b);
         }

    }

}
