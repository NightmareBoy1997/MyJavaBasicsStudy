package comguigu.java2;

import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 创建线程的方式四：使用线程池
 *
 * 好处：
 * 1.提高响应速度（减少了创建新线程的时间）
 * 2.降低资源消耗（重复利用线程池中线程，不需要每次都创建）
 * 3.便于线程管理
 *      corePoolSize：核心池的大小
 *      maximumPoolSize：最大线程数
 *      keepAliveTime：线程没有任务时最多保持多长时间后会终止
 *
 *
 * 面试题：创建多线程有几种方式？四种！
 * @author shkstart
 * @create 2019-02-15 下午 6:30
 */
public class ThreadPool {

    public static void main(String[] args) {

        //1. 提供指定线程数量的线程池
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        //设置线程池的属性
//        System.out.println(executorService.getClass());
        ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) executorService;
//        threadPoolExecutor.setCorePoolSize(15);
//        threadPoolExecutor.setKeepAliveTime();

        //2.执行指定的线程的操作。需要提供实现Runnable接口或Callable接口实现类的对象
        threadPoolExecutor.execute(new NewThread2());  //适合适用于Runnable
        // submit(Callable callable) 适合使用于Callable
        threadPoolExecutor.submit(new NewThread3());

        var call = new NewThread3();
        var futureTask =new FutureTask<Double>(call);
        threadPoolExecutor.submit(futureTask);

        var call1 = new NewThread3();
        var futureTask1 =new  FutureTask<Double>(call1);
        threadPoolExecutor.submit(futureTask1);

        try {
            // 获取 FutureTask泛型 任务的返回值
            double money = futureTask.get();
            System.out.println("总营业额： " + money);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        //3.关闭连接池
        threadPoolExecutor.shutdown();
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