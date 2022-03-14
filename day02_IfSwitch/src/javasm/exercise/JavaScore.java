package javasm.exercise;

import java.util.Scanner;

/**
 * @author Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-02-10 19:00
 *
 *  学校为了鼓励学生学习，规定如果Java成绩大于90，则奖励一部华为 ，如果成绩是介于 70–90 之间，则奖励一个小米，如果成绩小于等于 70 ，则罚做 100个俯卧撑；
 *
 */
public class JavaScore {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入成绩： ");
        double score = scanner.nextDouble();

        if(score > 90){
            System.out.println("做得好！奖励一部华为手机！继续保持！");
        }else{
            if(score > 70){
                System.out.println("真不错！奖励一部小米手机！继续加油！");
            }else{
                System.out.println("太差劲了！罚做100个俯卧撑！好好反思！");
            }
        }





    }

}
