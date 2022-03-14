package comguigu.exercise;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author Freak-W
 * @create 2021-04-07 9:00
 */
public class Test6 {

    @Test
    public void test1(){
//        String str1="德玛西亚";
        char []arr=new char[]{'F','R','E','A','K'};
        StringBuilder arr1=new StringBuilder();
        arr1.append(arr);
        System.out.println(arr1);
        System.out.println("******************************");

    }

    @Test
    public void test2(){
        int []arr=new int[]{1,2,3,4,5};
        char[]arr1=new char[]{'w','e','i'};
        try{
            Arrays.sort(arr1);
            System.out.println(Arrays.toString(arr1));


        }catch(Exception e){
            throw new RuntimeException("出错！");
        }finally{
            System.out.println("处理中请稍候……");

        }

        System.out.println("处理完成！");


    }

    @Test
    public void test3(){

        System.out.println("HelloWorld!");

    }

    @Test
    public void test4(){
        ThreadWei wei=new ThreadWei();
        Thread thread1=new Thread(wei);
        Thread thread2=new Thread(wei);

        thread1.setName("线程一  ");
        thread2.setName("线程二  ");

        thread1.start();
        for (int i = 0; i < 100; i++) {
            if (i % 3 == 0) {
                System.out.println(i + " %");

                try {
                    Thread.sleep(200);
                    thread1.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
        thread2.start();
    }


}

class ThreadWei implements Runnable{

    public void run(){
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName()+"加载中：完成百分之"+i);
        }
    }

}
