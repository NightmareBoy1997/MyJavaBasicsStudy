package javasm.exercise;

import java.util.Scanner;

/**
 * @author Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-02-10 18:38
 *
 *
 *  //超市为了促销，规定：购物不足50元的按原价付款，超过50不足100的按九折付款，超过100元的，超过部分按八折付款。编程序完成超市的自动计费的工作。
 *
 */
public class Shop {

    public static void main(String[] args) {
    //超市为了促销，规定：购物不足50元的按原价付款，超过50不足100的按九折付款，超过100元的，超过部分按八折付款。编程序完成超市的自动计费的工作。
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入消费金额： ");
        double money = scanner.nextDouble();
        double endMoney;

        if(money <= 0){
            System.out.println("输入有误！");
            return;
        }

        if(money <= 50 ){
            endMoney = money;
        }else{
            if( money <= 100){
                endMoney = (money - 50) * 0.9 + 50;
            }else{
                endMoney = 50 + 50 * 0.9 + (money - 100) * 0.8;
            }
        }

        System.out.println("结算金额： " +  endMoney);

    }


}
