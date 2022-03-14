package javasm.exercise;

import java.util.Scanner;

/**
 * @author Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-02-10 14:58
 *
 *  小林子买了一筐鸡蛋，如果坏蛋少于5个，他就吃掉，否则他就去退货
 *
 */
public class Egg {

    public static void main(String[] args) {

            Scanner scanner = new Scanner(System.in);
            System.out.print("请输入坏蛋的数量： ");
            int low = scanner.nextInt();

            if( low< 5 ){
                System.out.println("勉勉强强！");
            }else{
                System.out.println("质量太差！退货！");
            }
    }

}
