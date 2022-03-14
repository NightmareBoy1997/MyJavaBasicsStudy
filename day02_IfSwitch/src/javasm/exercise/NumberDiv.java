package javasm.exercise;

import java.util.Scanner;

/**
 * @author Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-02-10 17:46
 *
 *
 *  输入一个数，判断它是否能被3、5、7整除，注意考虑同时整除的情况
 *
 */
public class NumberDiv {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入数字：");
         int number = scanner.nextInt();

         boolean three = false;
         boolean five = false;
         boolean seven = false;

         if(number %3 == 0 ){
             three = true;
         }
         if(number %5 == 0 ){
             five = true;
         }
         if(number %7 == 0 ){
             seven = true;
         }

         // 判断结果
        if(three && five && seven ){
            System.out.println("这个数能同时被3、5、7整除");
            return;
        }
        if(!(three | five | seven)) {
            System.out.println("这个数不能被3、5、7任何一个整除");
            return;
        }

        if(three){

            if(five){
                System.out.println("这个数能被3、5整除，不能被7整除");
                return;
            }else{
                if(seven){
                    System.out.println("这个数能被3、7整除，不能被5整除");
                    return;
                }else{
                    System.out.println("这个数只能被3整除");
                    return ;
                }
            }

        }

        if(five){

            if(three){
                System.out.println("这个数能被3、5整除，不能被7整除");
            }else{
                if(seven){
                    System.out.println("这个数能被5、7整除，不能被3整除");
                }else{
                    System.out.println("这个数只能被5整除");
                }
            }

        }

        if(seven){

            if(three){
                System.out.println("这个数能被3、7整除，不能被5整除");
            }else{
                if(five){
                    System.out.println("这个数能被5、7整除，不能被3整除");
                }else{
                    System.out.println("这个数只能被7整除");
                }
            }

        }
    }





}
