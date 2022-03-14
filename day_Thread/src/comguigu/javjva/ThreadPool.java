package comguigu.javjva;

import java.util.concurrent.*;

/**
 * @projectName: MyJavaStudy
 * @package: comguigu.javjva
 * @author: Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-02-18 20:17
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
        var futureTask =new  FutureTask<Double>(call);
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

