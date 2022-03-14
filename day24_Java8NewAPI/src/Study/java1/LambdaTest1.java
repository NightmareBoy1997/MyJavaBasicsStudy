package Study.java1;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.function.Consumer;

/**
 * Lambda表达式的使用
 *
 * 1. 举例： （o1,o2） -> Integer.compare(o1,o2);
 * 2. 格式：
 *      -> ：Lambda操作符 或 箭头操作符
 *      ->左边：Lambda的行参列表 （其实就是接口中的抽象方法的形参）
 *      ->右边：Lambda体 （其实就是重写的抽象方法的方法体）
 *
 *
 * 3. Lambda表达式的使用： （分为6种情况介绍）
 *
 *      总结：
 *      -> 左边： Lambda形参列表的参数类型可以省略（类型推断）； 如果Lambda表达式的形参列表只有一个参数，则（）可以省略
 *      -> 右边： Lambda体应该是用一对{} ； 如果Lambda体只有一条执行语句（可能是return语句），就可以省略{}和return
 *
 *
 * 4. Lambda表达式的本质： 作为函数式接口的实例
 *
 * 5。如果一个借口中，只声明了一个抽象方法，则此接口就称为函数式接口+
 *    我们可以在一个接口上使用 @FunctionalInterface 注解，这样做可以检查它是否是一个函数式接口。
 *
 * 6. 所以以前用匿名实现类表示的现在都可以用Lambda表达式来写。
 *
 *
 * @author Freak-W
 * @create 2021-10-28 12:57
 */
public class LambdaTest1 {

    // 语法格式一： 无参，无返回值
    @Test
    public void test1() {
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Lambda");
            }
        };

        //Lambda
        Runnable r2 = () -> System.out.println("Lambda");


    }

    @Test
    public void test2() {
        // 语法格式二： Lambda 需要一个参数，没有返回值
        Consumer<String> con = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
                System.out.println("多行表达式");
            }
        };
        con.accept("谎言不是快刀！");

        // Lambda
        Consumer<String> con2 = (s) -> {  // 语法格式三：数据类型可以省略，因为可由编译器推断得出，称为“类型推断”
            System.out.println(s);
            System.out.println("多行表达式");
        };
        con2.accept("谎言不是快刀！");

    }

    int[] array = {1, 2, 3};

    // 语法格式四：Lambda 若只需要一个参数时，参数的小括号可以省略
    @Test
    public void test3() {
        Consumer<String> con = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
                System.out.println("多行表达式");
            }
        };
        con.accept("谎言不是快刀！");

        // Lambda
        Consumer<String> con2 = s -> {  //只需要一个参数时，参数的小括号可以省略
            System.out.println(s);
            System.out.println("多行表达式");
        };
        con2.accept("谎言不是快刀！");


    }


    // 语法格式五：Lambda 需要两个或以上的参数，多条执行语句，并且可以有返回值1 Lambda 表达式：
    @Test
    public void test4() {

        Comparator<Integer> comparable1 = new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {
                System.out.println(o1);
                System.out.println(o2);
                return Integer.compare(o1, o2);
            }
        };
        System.out.println(comparable1.compare(22, 33));


        // Lambda 表达式的写法
        Comparator<Integer> comparable2 = (o1, o2) -> {
            System.out.println(o1);
            System.out.println(o2);
            return Integer.compare(o1, o2);
        };
        System.out.println(comparable2.compare(234, 33));
    }


    // 语法格式六：当 Lambda 体只有一条语句时，return 与大括号若有，都可以省略
    @Test
    public void test5() {

        Comparator<Integer> comparable1 = new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        };
        System.out.println(comparable1.compare(22, 33));


        System.out.println("*************************************");

        Comparator<Integer> com2 = (o1, o2) -> o1.compareTo(o2);
        System.out.println(com2.compare(22, 33));

        Comparator<Integer> con2 = Integer::compare;

    }


}
