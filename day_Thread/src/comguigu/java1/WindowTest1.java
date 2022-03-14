package comguigu.java1;

import org.junit.jupiter.api.Test;

/**
 * 例子：创建三个窗口卖票，总票数为100张.使用实现Runnable接口的方式
 *
 * 1.问题：卖票过程中出现了重票和错票--->出现线程的安全问题
 * 2.问题出现的原因：当某个线程操作过程中，尚未操作完成时，其他线程参与进入，同时操作
 * 3.如何解决：当一个线程a在操作ticket的时候，其他线程不能参与进来。直到线程a操作完成以后，其他线程才可以
 * 继续开始操作ticket。这种情况即使线程a出现阻塞，也不能改变。
 * 4.在Java中，我们通过同步机制，来解决线程的安全问题
 * 方式一：同步代码块
 *
 * synchronized(同步监视器){
 * //需要被同步的代码
 * }
 * 说明：操作共享数据的代码，即为需要被同步的代码--->不能包含代码多了，也不能少了
 * 共享数据：多个线程共同操作的变量，例如本类的ticket
 * 同步监视器，俗称：锁。任何一个类的对象，都可以充当锁
 * 要求：多个线程必须要共用同一把锁 ！！！
 *
 * 补充：在实现Runnable接口创建多线程的方式中，可以考虑使用this充当同步监视器
 * 在继承Thread类创建多线程的方式中，慎用 this充当同步监视器！考虑使用当前类充当同步监视器（类也是对象）
 *
 * 方式二：同步方法
 * 如果操作共享数据的代码完整的声明在一个方法中，我们不妨将此方法声明同步的
 *
 * 5.同步的方式，解决了线程的安全问题。--->好处
 * 操作同步代码时，只能有一个线程参与，其他线程等待。相当于是一个单线程的过程，效率低 --->坏处
 *
 * 6.同步方法的总结：
 * 1. 同步方法仍然设计到同步监视器，只是不需要显式声明
 * 2. 非静态的同步方法，同步监视器是this
 * 静态的同步方法，同步监视器是：当前类本身
 */
class Window1 implements Runnable {
    private int ticket = 100;
//    Object obj=new Object();

    @Override
    public void run() {

        for (; ; ) {
            synchronized (this) { //此时的this：唯一的Window1的对象w  synchronized (w)
                if (ticket > 0) {

                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread().getName() + "卖票，票号是： " + ticket);
                    ticket--;
                } else {
                    break;
                }
            }
        }
    }

    @Test
    public void WindowTest1() {

        Window1 w = new Window1();
        Thread test1 = new Thread(w);
        Thread test2 = new Thread(w);
        Thread test3 = new Thread(w);

        test1.setName("窗口1");
        test2.setName("窗口2");
        test3.setName("窗口3");

        test1.start();
        test2.start();
        test3.start();
    }



    // 使用同步方法解决继承Thread类的线程安全问题
    @Test
    public void WindowTest4() {

        Window4 test1 = new Window4();
        Window4 test2 = new Window4();
        Window4 test3 = new Window4();
        test1.setName("窗口1：");
        test2.setName("窗口2：");
        test3.setName("窗口3：");

        test1.start();
        test2.start();
        test3.start();
    }


    // 使用同步代码块解决继承Thread类的方式的线程安全问题
    @Test
    public void WindowTest2() {

        Window2 test1 = new Window2();
        Window2 test2 = new Window2();
        Window2 test3 = new Window2();
        test1.setName("窗口1：");
        test2.setName("窗口2：");
        test3.setName("窗口3：");

        test1.start();
        test2.start();
        test3.start();
    }


    // 使用同步方法解决实现Runnable接口的线程安全问题
    @Test
    public void WindowTest39() {

        Window3 w = new Window3();
        Thread test1 = new Thread(w);
        Thread test2 = new Thread(w);
        Thread test3 = new Thread(w);

        test1.setName("窗口1");
        test2.setName("窗口2");
        test3.setName("窗口3");

        test1.start();
        test2.start();
        test3.start();
    }

}


/**
 * 使用同步方法解决继承Thread类的线程安全问题
 * <p>
 * <p>
 * 关于同步方法的总结：
 * 1. 同步方法仍然设计到同步监视器，只是不需要显式声明
 * 2. 非静态的同步方法，同步监视器是this
 * 静态的同步方法，同步监视器是：当前类本身
 *
 * @author shkstart
 * @create 2021-03-16 11:33
 */
class Window4 extends Thread {
    private static int ticket = 100;
    static Object obj = new Object();

    @Override
    public void run() {
        while (true) {

            show();

        }
    }

    public static synchronized void show() { //同步监视器：Window4.class

        if (ticket > 0) {

            try {
                sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + " 卖票，票号为： " + ticket);
            ticket--;
        }
    }
}


/**
 * 使用同步代码块解决继承Thread类的方式的线程安全问题
 * <p>
 * 例子：创建三个窗口卖票，总票数为100张.使用继承Thread类的方式
 * <p>
 * 说明：在继承Thread类创建多线程的方式中，慎用this充当同步监视器，考虑使用当前类充当同步监视器（类也是对象）
 */
class Window2 extends Thread {
    private static int ticket = 100;
    static Object obj = new Object();

    @Override
    public void run() {
        while (true) {
//            synchronized (obj) {
            synchronized (String.class) { //Class clazz=Window2.class, Window2.class只会加载一次
                //错误的方式，因为此时有3个Window2的对象
//              synchronized(this){
                if (ticket > 0) {

                    try {
                        sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(getName() + " 卖票，票号为： " + ticket);
                    ticket--;
                } else {
                    break;
                }
            }
        }
    }
}


/**
 * 例子：创建三个窗口卖票，总票数为100张.使用实现Runnable接口的方式
 * <p>
 * 使用同步方法解决实现Runnable接口的线程安全问题
 */
class Window3 implements Runnable {
    private int ticket = 100;
    //    Object obj=new Object();

    @Override
    public void run() {
        for (; ; ) {
            show();
        }
    }

    public synchronized void show() { //默认的同步监视器：this
        if (ticket > 0) {

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + "卖票，票号是： " + ticket);
            ticket--;
        }
    }
}
