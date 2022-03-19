package comguigu.exercise;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @projectName: MyJavaStudy
 * @package: comguigu.javjva
 * @author: Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-02-18 12:36
 */
public class LockTest5 extends Thread{

        private int ticketNum = 100;
        static Lock lock = new ReentrantLock();

        @Override
        public void run() {
            while (ticketNum>0){
                try {
                    lock.lock();

                    Thread.sleep(200);

                    if(ticketNum>0){
                        System.out.println(Thread.currentThread().getName()+"卖了第"+ticketNum);
                        ticketNum--;

                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }
    }


class Test11{
    public static void main(String[] args) {
        LockTest5 win1 = new LockTest5();
        LockTest5 win2 = new LockTest5();
        LockTest5 win3 = new LockTest5();
        win1.setName("窗口1");
        win2.setName("窗口2");
        win3.setName("窗口3");

        win1.start();
        win2.start();
        win3.start();
    }
}
