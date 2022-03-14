package comguigu.java;

/**
 *多线程的创建：
 *      方式一：继承于Thread类
 *          1. 创建一个继承于Thread的子类
 *          2. 重写Thread类的run（）方法 --->将此线程执行的操作声明在run()
 *          3. 创建子类的对象
 *          4. 通过子类的对象调用start（）
 *              start()的作用： ①启动当前线程  ②调用当前线程的run()
 *
 *              例1：遍历100以内的所有偶数
 *
 * @author FreakW
 * @create 2021-03-13 22:04
 */

//1.创建一个Thread的子类
    class MyThread extends Thread{

        //2.重写父类的run（）方法
        public void run(){
            for(int i=0;i<100;i++){
                if(i%2==0){
                    System.out.println(Thread.currentThread().getName()+" :"+i);
                }
            }
        }

}


public class NewThread1 {

    public static void main(String[] args) {
        //3.创建子类的对象
        MyThread test=new MyThread();

        //4.调用子类的start（）方法
        test.start();
        //问题一：我们不能通过直接调用run（）的方式启动线程
//        test.run();

        //问题二：再启动一个线程，遍历100以内的偶数。不可以还让已经start（）的线程去执行。非则会报错：IllegalThreadStateException
//        test.start();
        //我们需要重新创建一个线程的对象来启动
        MyThread test1=new MyThread();
        test1.start();

        //如下操作仍然是在main()线程中执行的
        for(int i=0;i<100;i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName()+" :"+i + "*****main()*****");
            }
        }

    }


}

