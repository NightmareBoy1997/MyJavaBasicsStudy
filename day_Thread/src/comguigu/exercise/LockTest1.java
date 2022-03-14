package comguigu.exercise;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @projectName: MyJavaStudy
 * @package: comguigu.exercise
 * @author: Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-02-18 9:45
 */
public class LockTest1 {

    public static void main(String[] args) {

        var lockTest1 = new RunnableTest();

        Thread thread1 = new Thread(lockTest1);
        Thread thread2 = new Thread(lockTest1);
        Thread thread3 = new Thread(lockTest1);

        thread1.setName(" 窗口一 ");
        thread2.setName(" 窗口二 ");
        thread3.setName(" 窗口三 ");

        thread1.start();
        thread2.start();
        thread3.start();


    }



    static class RunnableTest implements Runnable {
        private int number = 100;
        ReentrantLock lock = new ReentrantLock();
        private double money;

        public void run() {

            for (; ; ) {
                lock.lock();
                try {
                    if (number > 0) {

                        try {
                            Thread.sleep(120);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println(Thread.currentThread().getName() + "卖票，卖的票号是： " + number);
                        number--;
                        money += 99;
                    }else{

                        break;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }

            System.out.println("今日营业额： " + money);

        }


    }

}