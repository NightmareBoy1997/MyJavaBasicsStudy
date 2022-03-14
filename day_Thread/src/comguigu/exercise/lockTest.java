package comguigu.exercise;

import org.junit.jupiter.api.Test;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @projectName: MyJavaStudy
 * @package: comguigu.exercise
 * @author: Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-02-17 20:31
 */
public class lockTest extends Thread {
    static int number = 100;
    static ReentrantLock lock = new ReentrantLock();
    private static double money;

    public void run() {
        while (true) {

            lock.lock();

            try {
                if (number > 0) {

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(this.getName() + "卖票，卖的票号是： " + number);
                    number--;
                    money += 99.99;

                } else {
                    break;
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }

        }
    }


    @Test
    public void test() {

        var thread1 = new lockTest();
        var thread2 = new lockTest();
        var thread3 = new lockTest();

        thread1.setName("线程一");
        thread2.setName("线程二");
        thread3.setName("线程三");
        thread1.start();
        thread2.start();
        thread3.start();

        for (int i = 0; i <= 100; i++) {
            System.out.println(Thread.currentThread().getName() + " 计时： " + i);
        }

    }


}

