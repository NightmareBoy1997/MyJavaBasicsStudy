package Study.java2;

import Study.java1.Employee;
import Study.java1.EmployeeData;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 *  1. Stream 关注的是对数据的运算，与CPU打交道
 *     集合关注的是数据的存储，与内存打交道
 *      “集合讲的是数据，Stream讲的是计算！”
 *
 *  2. 注意：
 *      ①Stream 自己不会存储元素。
 *      ②Stream 不会改变源对象。相反，他们会返回一个持有结果的新Stream。
 *      ③Stream 操作是延迟执行的。这意味着他们会等到需要结果的时候才执行。
 *
 *  3.Stream 执行流程
 *      ① Stream的实例化
 *      ② 一系列中间操作 (过滤、映射……)
 *      ③ 终止操作：
 *
 *  4.
 *      ① 一个中间操作链，对数据源的数据进行处理
 *      ② 一旦执行终止操作，就执行中间操作链，并产生结果。之后，不会再被使用
 *
 *
 *
 *
 * @author Freak-W
 * @create 2021-11-03 14:17
 */
public class StreamAPITest {


    //创建 Stream方式一：通过集合
    @Test
    public void test1(){

        List<Employee> employees = EmployeeData.getEmployees();
//       default Stream<E> stream() : 返回一个顺序流
        Stream<Employee> stream1 = employees.stream();

//       default Stream<E> parallelStream() : 返回一个并行流
        Stream<Employee> stream2 =employees.parallelStream();

    }


    //创建 Stream方式二：通过数组
    //     Java8 中的 Arrays 的静态方法 stream() 可以获取数组流：
    @Test
    public void test2(){


//      static <T> Stream<T> stream(T[] array): 返回一个流
       Employee [] arr1 = new Employee[5];
       Stream<Employee> stream1=Arrays.stream(arr1);

//      重载形式，能够处理对应基本类型的数组：
//       public static IntStream stream(int[] array)
//       public static LongStream stream(long[] array)
//       public static DoubleStream stream(double[] array)
       int[] arr2=new int[5] ;
       IntStream stream2=Arrays.stream(arr2);

       long [] arr3=new long[5];
       LongStream stream3=Arrays.stream(arr3);

       double[] arr4=new double[5];
       DoubleStream stream4=Arrays.stream(arr4);

    }


    //创建 Stream方式三：通过Stream的of()
    //      可以调用Stream类静态方法 of(), 通过显示值创建一个流。它可以接收任意数量的参数。
    @Test
    public void test3(){


//       public static<T> Stream<T> of(T... values) : 返回一个流
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5, 6);



    //创建 Stream方式四：创建无限流
    //    可以使用静态方法 Stream.iterate() 和 Stream.generate(),创建无限流。

//     迭代
//    public static<T> Stream<T> iterate(final T seed, final UnaryOperator<T> f)
        // 遍历前10个偶数
        Stream.iterate(0,t -> t+2).limit(10).forEach(System.out :: println);


//     生成
//    public static<T> Stream<T> generate(Supplier<T> s)
        // 生成10个随机数
        Stream.generate(Math :: random).limit(10).forEach(System.out :: println);

    }



}
