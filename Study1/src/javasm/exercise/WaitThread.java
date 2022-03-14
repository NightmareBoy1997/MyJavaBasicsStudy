package javasm.exercise;

/**
 * 线程通信的例子：使用两个线程打印1-100.线程1，线程2，交替打印
 *
 * @author shkstart
 * @create 2021-03-18 0:10
 */

class Wait extends Thread {
    static int number = 100;

    @Override
    public void run() {
        synchronized (Wait.class) {
            for (; ; ) {
                Wait.class.notifyAll();
                if (number >= 0) {
                    System.out.println(getName() + "  " + number);
                    number--;
                } else {
                    break;
                }

                try {
                    Wait.class.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

public class WaitThread {
    public static void main(String[] args) {
        Wait test1 = new Wait();
        Wait test2 = new Wait();
        Wait test3 = new Wait();

        test1.setName("线程1 ");
        test2.setName("线程2 ");
        test3.setName("线程3 ");

        test1.start();
        test2.start();
        test3.start();

    }


}
