package comguigu.java;

/**
 * 测试Thread中的常用方法：
 *  1. start()： 启动当前线程，调用当前线程的run()
 *  2. run()： 通常需要重写Thread类中的此方法，将创建的线程需要执行的操作声明在此方法中
 *  3. currentThread()： 静态方法，返回当前代码的线程。
 *  4. getName():  获取当前线程的名字
 *  5. setName()： 设置当前线程的名字
 *  6. yield()： 释放当前CPU的执行权
 *  7. join(): 在线程a中调用线程b的join()，此时线程a就进入阻塞状态，直到线程b完全执行结束以后，
 * 才结束阻塞状态
 *  8. stop(): 已过时，强制结束当前线程
 *  9. sleep(long millitime): 让当前线程“睡眠”指定millitime毫秒，在指定的millitime毫秒时间内，
 *当前线程是阻塞状态。
 *  10. isAlive(): 判断当前线程是否存活
 *
 *
 * 线程的优先级
 *  1.线程的优先级等级
     MAX_PRIORITY：10
     MIN _PRIORITY：1
     NORM_PRIORITY：5--->默认优先级
 *  2.如何获取和设置当前线程的优先级:
 *      getPriority(): 获取线程优先级
 *      setPriority(int priority): 设置线程优先级
 *
 *  说明：高优先级的线程要抢占低优先级线程CPU的执行权，但是只是从概率上来讲，高优先级的线程要高概率
 *  的情况下被执行。并不意味着只有当高优先级的线程执行完以后，低优先级的线程才执行
 *
 *
 *
 *
 * @author FreakW
 * @create 2021-03-14 21:48
 */
class HelloThread extends Thread{

    //初始化name的构造器
    public HelloThread(String string){
        super(string);
    }

    @Override
    public void run() {
        for (int i = 0; i <100 ; i++) {
            if(i%2==0) {
//                try {
//                    sleep(10);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                System.out.println(Thread.currentThread().getName() + " : " +Thread.currentThread().getPriority()+" "+ i);
            }
            if(i%20==0){
//                yield();

//                try {
//                    sleep(2000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }


            }

        }

    }
}




public class ThreadMethodTest {
    public static void main(String[] args) {
        HelloThread test=new HelloThread("1.线程");
//        test.setName("1号线程");
        //设置分线程的优先级
        test.setPriority(Thread.MAX_PRIORITY);
        test.start();

        new Thread(){
            public void run(){
                for(int i = 0 ; i<1000; i++){

                        System.out.println(i);

                }
            }
        }.start();

        //主线程命名
        Thread.currentThread().setName("主线程");
        for (int i = 0; i <100 ; i++) {
            if(i%2==0) {
                System.out.println(Thread.currentThread().getName() + " : " + i);
            }

            if(i==20){

                try {
                    test.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

        }

        System.out.println(test.isAlive());

}






}
