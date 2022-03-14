package comguigu.java;

import org.junit.jupiter.api.Test;

import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * 解决线程安全问题的方式三：Lock锁 --->JDK5.0新增
 *
 *
 *  1.面试题：synchronized 与 Lock的异同？
 *       相同：都是用来解决线程的安全问题
 *       不同：synchronized机制在执行完相应的同步代码以后，自动释放同步监视器
 *             Lock需要手动的启动同步(Lock()),同时结束同步也需要手动的实现(unlock())
 *
 *  2.优先使用顺序：Lock  同步代码块（已经进入了方法体，分配了相应资源）  同步方法
 （在方法体之外）
 *
 *   面试题：如何解决线程安全问题？有几种方式
 *
 *
 *
 * @author shkstart
 * @create 2021-03-16 14:02
 */
public class LockTest implements Runnable{
    private int ticket=100;
    //实例化ReentrantLock
    private ReentrantLock lock=new ReentrantLock();

    @Override
    public void run() {
        for(;;){
            try{
                //2.调用锁定方法Lock()
                lock.lock();

                if(ticket>0){

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread().getName()+" :售票，票号为： "+ticket);
                    ticket--;
                }else{
                    break;
                }
            }finally{
                //3.调用解锁方法：unlock()
                lock.unlock();
            }
        }
    }


    @Test
    public void LockTest(){
        Window w1=new Window();

        Thread test1=new Thread(w1);
        Thread test2=new Thread(w1);
        Thread test3=new Thread(w1);
        test1.setName("线程2 ");
        test2.setName("线程1 ");
        test3.setName("线程3 ");

        test1.start();
        test2.start();
        test3.start();
    }
}

