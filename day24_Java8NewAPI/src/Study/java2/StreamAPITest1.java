package Study.java2;

import Study.java1.Employee;
import Study.java1.EmployeeData;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 *  测试Stream的中间操作
 *
 *
 *
 * @author Freak-W
 * @create 2021-11-03 14:59
 */
public class StreamAPITest1 {


    // 1. 筛选与切片
    @Test
    public void test1(){

        List<Employee> employees = EmployeeData.getEmployees();

//       ①  filter(Predicate p)  接收 Lambda ， 从流中排除某些元素
        Stream<Employee> stream1 = employees.stream();
        stream1.filter(e -> e.getSalary()>7000).forEach(System.out :: println);

        System.out.println("*******************************");

//       ②  limit(long maxSize)  截断流，使其元素不超过给定数量
//        stream1.limit(3).forEach(System.out :: println);  // java.lang.IllegalStateException: stream has already been operated upon or closed
        employees.stream().limit(3).forEach(System.out :: println);

        System.out.println("************************");

//       ③  skip(long n)  跳过元素，返回一个扔掉了前 n 个元素的流。若流中元素不足 n 个，则返回一个空流。
//        与 limit(n) 互补
        employees.stream().skip(2).forEach(System.out :: println );

        System.out.println("***************************");

//       ④  distinct()  筛选，通过流所生成元素的 hashCode() 和 equals() 去除重复元素
        employees.add(new Employee(1001, "马化腾", 34, 6000.38));
        employees.add(new Employee(102, "马化腾", 34, 6000.38));
        employees.add(new Employee(1001, "马化", 34, 6000.38));
        employees.stream().distinct().forEach(System.out :: println);

    }


    // 2. 映射
    @Test
    public void test2(){

//   .①  map(Function f)   接收一个函数作为参数，该函数会被应用到每个元素上，并将其映射成一个新的元素。
        List<String> list= Arrays.asList("aa","bb","cc","dd");
        list.stream().map(str -> str.toUpperCase()).forEach(System.out :: println);


//   .②  mapToDouble(ToDoubleFunction f)   接收一个函数作为参数，该函数会被应用到每个元素上，产生一个新的 DoubleStream。

//   .③  mapToInt(ToIntFunction f)   接收一个函数作为参数，该函数会被应用到每个元素上，产生一个新的 IntStream。

//   .④  mapToLong(ToLongFunction f)   接收一个函数作为参数，该函数会被应用到每个元素上，产生一个新的 LongStream。


        // 练习1 ： 获取员工姓名长度大于3的员工姓名
        List<Employee> employees = EmployeeData.getEmployees();
        employees.stream().map(Employee :: getName).filter(str ->  str.length()>3).forEach(System.out :: println);

        // 练习2 ：
        Stream<Stream<Character>> streamStream = list.stream().map(StreamAPITest1 :: fromStreamToStream);
        streamStream.forEach(e -> e.forEach(System.out :: println));

        System.out.println("************************");

//   ②  flatMap(Function f)   接收一个函数作为参数，将流中的每个值都换成另一个流，然后把所有流连接成一个流
        list.stream().flatMap(StreamAPITest1::fromStreamToStream).forEach(System.out :: println);


    }

    // 将字符串中的多个字符构成的集合转换成对应的stream实例
    public static Stream<Character> fromStreamToStream(String str){

        ArrayList<Character> list = new ArrayList<>();
        for (Character c : str.toCharArray()){
            list.add(c);
        }

        return list.stream();
    }



//3-排序
    @Test
    public void test3(){

//       ①  sorted() 产生一个新流，其中按自然顺序排序
        List<Integer> list1 =Arrays.asList(1,43,64,34,58,67,88,65,32,23,3,4);

        list1.stream().sorted().forEach(System.out :: println);
        // 异常，原因：Employee没有实现Comparable接口
//        List<Employee> employees = EmployeeData.getEmployees();
//        employees.stream().sorted().forEach(System.out :: println);

//       ②  sorted(Comparator com) 产生一个新流，其中按比较器顺序排序
        List<Employee> employees1 = EmployeeData.getEmployees();
        employees1.stream().sorted( (e1,e2) -> {

            int ageValue=Integer.compare(e1.getAge(),e2.getAge());
            if(ageValue!=0){
                return ageValue;
            }else{
                return Double.compare(e1.getSalary(),e2.getSalary());
            }

        } ).forEach(System.out :: println);


    }



    @Test
    public void test6(){

        ArrayList list1=new ArrayList();
        list1.add(1);
        list1.add(2);
        list1.add(3);

        ArrayList list2=new ArrayList();
        list2.add(4);
        list2.add(5);
        list2.add(6);

        list1.add(list2);
        System.out.println(list1.toString());
        list1.addAll(list2);
        System.out.println(list1.toString());


    }





}
