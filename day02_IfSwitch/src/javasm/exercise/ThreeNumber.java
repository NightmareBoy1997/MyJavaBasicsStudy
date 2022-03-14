package javasm.exercise;

import java.util.Scanner;

/**
 * @author Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-02-10 17:31
 * <p>
 * <p>
 * //动态录入3个数，请使用条件结构/三元运算符求3个数的最值
 * <p>
 */
public class ThreeNumber {


    //动态录入3个数，请使用条件结构/三元运算符求3个数的最值
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入第一个数字： ");
        int number1 = scanner.nextInt();
        System.out.print("请输入第二个数字： ");
        int number2 = scanner.nextInt();
        System.out.print("请输入第三个数字： ");
        int number3 = scanner.nextInt();
        int maxNumber;
        int minNumber;

        // 条件表达式写法：
        if(number1 > number2){

            if(number1 > number3){

                maxNumber = number1;
                if(number2 < number3){
                    minNumber = number2;
                }else{
                    minNumber = number3;
                }
            }else{

                maxNumber = number3;
                if(number2 < number1){
                    minNumber = number2;
                }else{
                    minNumber = number1;
                }
            }


        }else{

            if(number2 > number3){

                maxNumber = number2;
                if(number1 < number3){
                    minNumber = number1;
                }else{
                    minNumber = number3;
                }

            }else{

                maxNumber = number3;
                if(number1 < number2){
                    minNumber = number1;
                }else{
                    minNumber = number2;
                }

            }

        }

        System.out.println("最大的数字是 " + maxNumber);
        System.out.println("最小的数字是 " + minNumber);


    }


}
