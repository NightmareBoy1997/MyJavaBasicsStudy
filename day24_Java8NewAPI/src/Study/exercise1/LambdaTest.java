package Study.exercise1;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.function.Consumer;

/**
 * @projectName: MyJavaStudy
 * @package: Study.exercise1
 * @author: Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-02-22 11:47
 *
 *  Lambda表达式
 *  1. 举例： (o1,o2) -> Integer.compare(o1,o2)
 *  2. 格式：
 *      -> ： lambda操作符 或 箭头操作符
 *      -> 左边 ： lambda形参列表 （其实就是 接口方法的形参列表）
 *      -> 右边 ： lambda体（其实就是 重写方法的方法体）
 *  3. lambda表达式的使用：
 *      语法格式一：无参，无返回值
 *      语法格式二：Lambda 需要一个参数，但是没有返回值。
 *      语法格式三：数据类型可以省略，因为可由编译器推断得出，称为“类型推断
 *      语法格式四：Lambda 若只需要一个参数时，参数的小括号可以省略
 *      语法格式五：Lambda 需要两个或以上的参数，多条执行语句，并且可以有返回值
 *      语法格式六：当 Lambda 体只有一条语句时，return 与大括号若有，都可以省略
 *
 *
 *
 *  4. lambda表达式的本质： 函数式接口的实例
 *
 *  5. lambda表达式的总结：
 *          -> 左边： lambda形参列表的参数类型可以省略（类型推断） ； 如果只有一个参数，()也可以省略
 *          -> 右边： lambda体应该使用一对{} 包裹； 如果lambda体只有一条执行语句（可以是return 语句 ） ，可以省略 {} 和 return
 *
 *  6. 如果接口只声明了一个抽象接口， 就称为函数式接口 ， 可以加上注解 @FunctionalInterface 来检查是否是函数式接口
 *  7. 匿名实现类的表示都可以用lambda表达式来写
 *
 */
public class LambdaTest {


    @Test
    public  void test1(){

        // 匿名实现类写法
        Runnable run1 = new Runnable(){
            @Override
            public void run() {
                System.out.println("匿名实现类");
            }
        };

        run1.run();

        System.out.println("************** lambda **************");

        // lambda 表达式 无参类型
        Runnable run2 = () -> System.out.println(" lambda 基本形式 ");

        run2.run();


        Comparator<Integer> comparator1 = new Comparator(){
            @Override
            public int compare(Object o1, Object o2) {
                return 0;
            }
        };

        // // lambda 表达式 有参类型
        Comparator<Integer> comparator2 = (o1,o2) -> Integer.compare(o1,o2);

        // 方法引用的方式：
        Comparator<Integer> comparator3 = Integer::compare;

    }



    /*
    语法格式一：无参，无返回值
    语法格式二：Lambda 需要一个参数，但是没有返回值。
    语法格式三：数据类型可以省略，因为可由编译器推断得出，称为“类型推断
    语法格式四：Lambda 若只需要一个参数时，参数的小括号可以省略
    语法格式五：Lambda 需要两个或以上的参数，多条执行语句，并且可以有返回值
    语法格式六：当 Lambda 体只有一条语句时，return 与大括号若有，都可以省略
    */
    @Test
    public void lambdaTest(){

        // 1. 无参无返回值
        Runnable run1 = () -> System.out.println("run");
        run1.run();

        // 2. 单参无返回
        Consumer<String> consumer1 = (str) -> System.out.println(str);
        consumer1.accept("一板一眼，就会滋生弱点！");

        // 3. 类型省略
        Consumer<String> consumer2 = str -> System.out.println(str);
        consumer2.accept("不拘小节，最终会坏大事！");

        // 4. 单参数

        // 5. 两个或以上的参数，多条执行语句，并且可以有返回值
        Comparator<Integer> comparator1 = (o1,o2) -> {
            System.out.println("Lambda");
            return o1.compareTo(o2);
        };
        System.out.println(comparator1.compare(13, 42));


        // 6. lambda体只有一条语句
        Comparator<Integer> comparator2 = (o1,o2) -> o1.compareTo(o2);
        System.out.println(comparator2.compare(12, 2));

        Comparator<Integer> comparator3 = Integer::compare;
        System.out.println(comparator3.compare(12, 100));

    }



}