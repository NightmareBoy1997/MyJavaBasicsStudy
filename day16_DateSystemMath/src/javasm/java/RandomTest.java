package javasm.java;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @projectName: MyJavaStudy
 * @package: javasm.java
 * @author: Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-02-28 22:33
 *
 *  1.概述： java.util.Random是线程安全的，但是跨线程的同时使用实例可能遇到争用，从而导致性能下降。
 *      在多线程考虑使用ThreadLocalRandom
 *  2.伪随机数，可以通过时间种子预测随机的数字
 *
 */
public class RandomTest {

    public static void main(String[] args) {

//        randomTest1();
        randomTest2();

    }

    // 子类ThreadLocalRandom
    private static void randomTest2() {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        for (int i = 0; i < 5; i++) {
            for (int i1 = 0; i1 < 5; i1++) {
                int number = random.nextInt(10,100);
                System.out.print(number + "\t");
            }
            System.out.println();
        }
    }


    private static void randomTest1() {
        // 循环5次，每次获得5个随机数 10-100
        // 指定时间种子seed ，可以预测随机数
        Random random = new Random(); // 无参，底层使用时间纳秒数来充当时间种子seed ，无法预测随机数
        for (int i = 0; i < 5; i++) {
//            random = new Random(100); // 指定时间种子seed ，可以预测随机数 ， 伪随机数
            for (int i1 = 0; i1 < 5; i1++) {
                int number = random.nextInt(90) + 10;
                System.out.print(number + "\t");
            }
            System.out.println();
        }


    }





}