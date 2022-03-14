package comguigu.exercise;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @projectName: MyJavaStudy
 * @package: comguigu.exercise
 * @author: Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-02-17 20:31
 */
public class NewThread3 implements Callable<Integer> {
    private static int number = 100;
    private static int money;

    public Integer call(){

        for (;;) {

           if(number >0){

               System.out.println(Thread.currentThread().getName() + "卖票,卖的票号是： " + number);
               number -- ;
               money += 99;
           }else{
               break;
           }
        }
        return money;
    }
}


class CallableTest{

    public static void main(String[] args) {

        NewThread3 numThread = new NewThread3();
        FutureTask<Integer> futureTask1 = new FutureTask<>(numThread);
        FutureTask<Integer> futureTask2 = new FutureTask<>(numThread);
        FutureTask<Integer> futureTask3 = new FutureTask<>(numThread);
        Thread thread1 = new Thread(futureTask1);
        Thread thread2 = new Thread(futureTask2);
        Thread thread3 = new Thread(futureTask3);

        thread1.setName(" 线程1 ");
        thread2.setName(" 线程二 ");
        thread3.setName(" 线程3 ");

        thread1.start();
//        thread2.start();
//        thread3.start();

        int money= 0 ;
        try {
            money = futureTask1.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println(money);

    }



}