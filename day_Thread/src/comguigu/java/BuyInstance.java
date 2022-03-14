package comguigu.java;

import org.junit.jupiter.api.Test;

/**
 *
 * 例子：创建三个窗口卖票，总票数为100张.使用实现Runnable接口的方式
 *
 *   存在线程安全问题，待解决
 *
 * 比较创建线程的两种方式：
 * 开发中，优先选择：实现Runnable接口的方式
 *   原因：1.实现的方式没有类的单继承性的局限性
 *        2.实现的方式更适合来处理多个线程共享数据的情况
 *
 *联系：Thread也实现了Runnable接口
 *   相同点：两种方式都需要重写run(),将线程要执行的逻辑声明在run()中
 *
 * @author FreakW
 * @create 2021-03-15 0:03
 */
class Window1 implements Runnable{
    private int ticket=1;

    @Override
    public void run() {

        for (;;) {
            if(ticket<=100){
                System.out.println(Thread.currentThread().getName()+"卖票，票号是： "+ticket);
                ticket++;
            }else{
                break;
            }
        }
    }

@Test
    public void WindowTest1() {
            Window1 w=new Window1();
            Thread test1=new Thread(w);
            Thread test2=new Thread(w);
            Thread test3=new Thread(w);

            test1.setName("窗口1");
            test2.setName("窗口2");
            test3.setName("窗口3");
            test1.start();
            test2.start();
            test3.start();
    }
}




/**
 *
 *  例子：创建三个窗口卖票，总票数为100张.使用继承Thread类的方式
 *
 *  存在线程的安全问题
 *
 * @author FreakW
 * @create 2021-03-14 23:04
 */
class Window extends Thread{
    private static int ticket=100;

    @Override
    public void run() {
        while(true){
            if(ticket>0){
                System.out.println(getName()+" 卖票，票号为： "+ticket);
                ticket--;
            }else{
                break;
            }
        }
    }

    @Test
    public void WindowTest() {
        Window test1=new Window();
        Window test2=new Window();
        Window test3=new Window();
        test1.setName("窗口一：");
        test2.setName("窗口二：");
        test3.setName("窗口三：");

        test1.start();
        test2.start();
        test3.start();
    }
}

