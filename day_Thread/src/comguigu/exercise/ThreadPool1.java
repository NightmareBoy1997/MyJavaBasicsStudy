package comguigu.exercise;

import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @projectName: MyJavaStudy
 * @package: comguigu.exercise
 * @author: Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-02-18 10:46
 */
public class ThreadPool1 {

    public static void main(String[] args) {

        ExecutorService pool = Executors.newFixedThreadPool(10);
        ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) pool;

        var call = new NewThread3Test();
        FutureTask<Double> futureTask = new FutureTask<Double>(call);


//
//        thread1.setName(" 窗口1 ");
//        thread2.setName(" 窗口二 ");
//        thread3.setName(" 窗口  3 ");
//
//
////        thread2.start();
////        thread3.start();
//        thread1.start();

        try {

            threadPoolExecutor.submit(futureTask);
            threadPoolExecutor.execute(new NewThread2());
            threadPoolExecutor.execute(new NewThread2());
//            threadPoolExecutor.submit(thread2);
//            threadPoolExecutor.submit(thread3);
            var money = futureTask.get();
            System.out.println(" 总营业额： " + money);

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        threadPoolExecutor.shutdown();

    }

}


class NewThread2 extends Thread {
    static int number = 100;
    static double money;
    static ReentrantLock lock = new ReentrantLock();
    static boolean flag = true ;

    public void run() {

        while (true) {

            lock.lock();

            try {
                if (number > 0) {

                    try {
                        sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(getName() + "卖了一桶爆米花 ，库存剩余： " + number);
                    number--;
                    money += 15.99;
                } else {
                    break;
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }

        }

        synchronized(NewThread2.class){
            if( flag ){
                System.out.println(" 爆米花总营业额： " + money);
                flag = false;
            }
        }

    }

}