package javasm.exercise;

import java.util.Scanner;

/**
 * @author Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-02-10 19:07
 *
 *  循环作业：
 *  要求用户输入一个0到2之间的整数
 *  如果用户输入0输出“你出的是石头”，
 *  如果用户输入1就输出“你出的是剪刀”，
 *  如果用户输入的是2就输出“你出的是布”，
 *  然后再问是否要继续出拳，
 *  如果回答“y”就重复以上过程，
 *  否则结束程序
 *
 */
public class FingerGuessingGame {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        for(int i = 1 ; i > 0 ; i--){

            System.out.print("请输入0~2的整数:_ ");
            int number = scanner.nextInt();
            if(number > 2 | number < 0){
                throw new RuntimeException("输入的数值有误！");
            }

            switch(number){
                case 0 :
                    System.out.println("你出的是石头！");
                    break;
                case 1 :
                    System.out.println("你出的是剪刀！");
                    break;
                case 2 :
                    System.out.println("你出的是布！");
                    break;
            }

            System.out.print("是否要继续出拳？(输入y继续)：_ ");
            String string = scanner.next();
            if(string.charAt(0) == 'y' | string.charAt(0) == 'Y'){
                i--;
            }else{
                System.out.println("欢迎下次再来！");
            }

        }

    }



}
