package comguigu.javjva;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @projectName: MyJavaStudy
 * @package: comguigu.javjva
 * @author: Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-02-18 19:30
 */
public class NewThread2Test {
    public static void main(String[] args) {

        var runnable = new NewThread2();

        var thread1 =new  Thread(runnable);
        var thread2 =new Thread(runnable);
        var thread3 = new Thread(runnable);

        thread1.setName(" 窗口一 ");
        thread2.setName(" 窗口二 ");
        thread3.setName(" 窗口三 ");

        thread1.start();
        thread2.start();
        thread3.start();

    }

}

class NewThread2 implements Runnable {
    private int number = 100;
    Lock lock = new ReentrantLock();

    public void run() {


        while (true) {

            try {
                lock.lock();
                if (number > 0) {
                    System.out.println(Thread.currentThread().getName() + " 卖票，卖的票号是： " + number);
                    number--;

                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

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

}