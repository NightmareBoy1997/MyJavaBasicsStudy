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
public class NewThread1Test {

    public static void main(String[] args) {

        var thread1 = new NewThread1();
        var thread2 = new NewThread1();
        var thread3 = new NewThread1();

        thread1.setName(" 窗口一 ");
        thread2.setName(" 窗口二 ");
        thread3.setName(" 窗口三 ");

        thread1.start();
        thread2.start();
        thread3.start();

        for (int i = 0; i <100 ; i++) {
            System.out.println(Thread.currentThread().getName() + " 计数： " + i);
        }
    }

}

class NewThread1 extends Thread{
    private static int number = 100;
    static Lock lock = new ReentrantLock();

    public void run(){

        while(true){

            try {
                lock.lock();

                if(number > 0 ){
                    System.out.println(getName()+ " 卖票，卖的票号是： " + number );
                    number--;

                    try {
                        sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }else{
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