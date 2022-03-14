package comguigu.java;

/**
 * 创建多线程的方法二：
 *  1. 创建一个实现了Runnable接口的类
 *  2. 实现类去实现Runnable中的抽象方法：run()
 *  3. 创建实现类的对象
 *  4. 将此对象作为参数传递给Thread类的构造器，创建Thread类的对象
 *  5. 通过Thread类的对象调用start()
 *
 *
 *
 * @author FreakW
 * @create 2021-03-14 23:18
 */
//1. 创建Runnable的实现类
class MThread implements Runnable{

    //实现Runnable的抽象方法run()
    @Override
    public void run() {
        for (int i = 0; i <100 ; i++) {
            if(i%3==0){
                System.out.println(Thread.currentThread().getName()+"  "+i);
            }
        }
    }
}



public class NewThread2 {
    public static void main(String[] args) {

        //3.创建实现类的对象
        MThread m1 = new MThread();
        //4.将此实现类的对象作为参数创建Thread类的对象
        Thread test = new Thread(m1);
        //5.通过Thread类的对象调用start() ② 调用当前线程的run() --->调用了Runnable类型的target的run()……

        test.start();

        //再启动一个线程，start
        Thread test2=new Thread(m1);
        test2.start();

    }
}
