package javasm.javasm.util;

import java.time.LocalDate;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author: Lisa
 * @className: RandomDemo
 * @description:
 * @date: 2022/2/28 16:34
 * @version: 0.1
 * @since: jdk11
 */
public class RandomDemo {

    public static void main(String[] args) {

        //System.out.println(Math.random());//0.0-1.0

        demo1();
    }

    private static void demo1() {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        int num = random.nextInt(1000, 10000);
    }

    private static void demo() {
        //循环5次 在每次循环里面获得5个随机数字  1000-10000
        //预测到随机数是多少? 可以预测 指定seed
        for (int i = 1; i <= 5; i++) {
            Random random = new Random(1000);
            for (int j = 1; j <= 5; j++) {
                //获得随机数
                int randomNum = (random.nextInt(9000) + 1000);
                System.out.print(randomNum + "\t");
            }
            System.out.println();
        }
    }
}
