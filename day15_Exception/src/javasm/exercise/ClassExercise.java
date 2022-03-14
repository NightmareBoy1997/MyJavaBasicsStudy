package javasm.exercise;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @projectName: MyJavaStudy
 * @package: javasm.exercise
 * @author: Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-02-17 17:14
 *
 * 需通过控制台接收用户输入的两个整数，然后做除法。要求用异常处理输入非数字的异常，和 除数为0的异常。
 */
public class ClassExercise {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        scanner(input);
    }


    public static void scanner(Scanner input) {
        System.out.print("请输入第一个 被除数整数: ");
        String input1 = input.next();
        System.out.print("请输入第二个 除数: ");
        String input2 = input.next();

        char[] char1 = input1.toCharArray();
        char[] char2 = input2.toCharArray();

        if (input1.charAt(0) == '-') {
            char1[0] = '0';
        }
        if (input2.charAt(0) == '-') {
            char2[0] = '0';
        }

        char[] chars = Arrays.copyOf(char1, char1.length + char2.length);
        for (int i = 0; i < char2.length; i++) {
            chars[char1.length + i] = char2[i];
        }

        char[] numbers = {'1', '2', '3', '4', '5', '6', '7', '8', '9', '0'};
        boolean flag;

        for (int i = 0; i < chars.length; i++) {
            flag = true;
            for (char number : numbers) {

                if (chars[i] == number) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                throw new MyException1(StatueEnum.MY_STATUE_ENUM_MATH);

            }
        }

        int number2 = Integer.parseInt(input2);
        if (number2 == 0) {
            throw new MyException1(StatueEnum.MY_STATUE_ENUM_ZERO);
        }

        int number1 = Integer.parseInt(input1);


        if(number1 % 2 == 0){
            System.out.println(number1 + " 除以 " + number2 + " = " + number1 / number2);
        }else {
            int residue = number1 % number2 ;
            System.out.println(number1 + " 除以 " + number2 + " = " + number1 / number2 + " ,余数: " + residue);
        }
    }
}

