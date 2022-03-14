package comguigu.exercise;

import org.junit.jupiter.api.Test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @projectName: MyJavaStudy
 * @package: comguigu.exercise
 * @author: Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-02-18 10:25
 */
public class NewThread3Test implements Callable<Double> {
    private static int number = 100;
    private static double money;
    static ReentrantLock lock = new ReentrantLock();

    public Double call() {
        while (true) {
            lock.lock();

            try {
                if (number > 0) {

                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread().getName() + "卖票，卖的票号是： " + number);
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
        return money;
    }


    @Test
    public void Newthread3(){
        var call = new NewThread3Test();

        var futureTask1 = new FutureTask<Double>(call);
        var futureTask2 = new FutureTask<Double>(call);
        var futureTask3 = new FutureTask<Double>(call);

        var thread1 = new Thread(futureTask1);
        var thread2 = new Thread(futureTask2);
        var thread3 = new Thread(futureTask3);

        thread1.setName(" 窗口1 ");
        thread2.setName(" 窗口2 ");
        thread3.setName(" 窗口3 ");

        thread1.start();
        thread2.start();
        thread3.start();

        try {

            var money = futureTask1.get();
            System.out.println("总营业额： " + money);
//            futureTask2.get();
//            futureTask3.get();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }

}