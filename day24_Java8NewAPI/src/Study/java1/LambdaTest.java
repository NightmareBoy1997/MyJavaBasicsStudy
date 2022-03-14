package Study.java1;

import org.junit.jupiter.api.Test;

import java.util.Comparator;

/**
 *
 *  Lambda表达式的使用举例
 *
 *
 *
 * @author Freak-W
 * @create 2021-10-28 12:35
 */
public class LambdaTest {


    @Test
    public void test1(){

        Runnable r1= new Runnable(){
            @Override
            public void run() {
                System.out.println("匿名实现类1");
            }
        };
        r1.run();

        System.out.println("*****************************");

        Runnable r2= ()-> System.out.println("匿名实现类2");
        r2.run();

    }


    @Test
    public void test2(){

        // 标准式写法
        Comparator<Integer> comparable1= new Comparator<Integer>(){

            @Override
            public int compare(Integer o1,Integer o2) {
                return Integer.compare(o1,o2);
            }
        };
        System.out.println(comparable1.compare(22,33));

        System.out.println("***************");

        // Lambda 表达式的写法
        Comparator<Integer> comparable2= (o1,o2) -> Integer.compare(o1,o2);
        System.out.println(comparable2.compare(234,33));

        System.out.println("*************************************");

        // 方法引用的写法
        Comparator<Integer> comparable3= Integer :: compare;
        System.out.println(comparable3.compare(234,33));


    }










}
