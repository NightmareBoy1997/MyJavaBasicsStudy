package comguigu.java2;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 创建线程的方式三：实现Callable接口。 --- JDK 5.0新增
 *
 * 如何理解实现Callable接口的方式创建多线程比实现Runnable接口创建多线程方式强大？
 * 1. call()可以有返回值的。
 * 2. call()可以抛出异常，被外面的操作捕获，获取异常的信息
 * 3. Callable是支持泛型的
 *
 */
public class NewThread3Test {
    public static void main(String[] args) {

        // 3.创建Callable接口实现类的对象
        NewThread3 call = new NewThread3();

        // 4.将此Callable接口实现类的对象作为传递到FutureTask构造器中，创建FutureTask的对象
        var futureTask1 = new FutureTask<Double>(call);
        // 特别说明： 不同于Runnable接口，一个FutureTask是call的一个任务分支，
        // 同一个线程Callable可由一个或多个异步任务协同完成。
        var futureTask2 = new FutureTask<Double>(call);
        // 与线程池的线程是同一任务，线程已启动，再启动就无意义
//        var thread1 = new Thread(futureTask);
//        var thread2 = new Thread(futureTask);

        // 5.将FutureTask的对象作为参数传递到Thread类的构造器中，创建Thread对象，并调用start()
        var thread1 = new Thread(futureTask1);
        var thread2 = new Thread(futureTask2);

        thread1.setName(" 窗口一 ");
        thread2.setName(" 窗口2 ");

        thread1.start();
        thread2.start();

        double money = 0;
        try {
            //6.获取Callable中call方法的返回值
            //get()返回值即为FutureTask构造器参数Callable实现类重写的call()的返回值。
            money = futureTask1.get();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println("总营业额： " + money);
    }
}


// 1.创建一个实现Callable的实现类
class NewThread3 implements Callable<Double> {
    private Lock lock = new ReentrantLock();
    int number = 100;
    double money;

    // 2.实现call方法，将此线程需要执行的操作声明在call()中
    public Double call() {

        while (true) {

            try {
                lock.lock();

                if (number > 0) {
                    System.out.println(Thread.currentThread().getName() + " 卖票，卖的票号是： " + number);
                    number--;
                    money += 39.99;

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
        return money;
    }
}

