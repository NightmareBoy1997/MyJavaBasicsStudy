package Study.smjava.exercise;

import Study.java1.Employee;
import Study.java1.EmployeeData;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @projectName: MyJavaStudy
 * @package: Study.exercise1
 * @author: Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-03-07 11:18
 */
public class StreamTest {

    public static void main(String[] args) {

//    demo1();
//    demo2();
//    demo3();

//    demo4();

    }












    @Test
    public void  demo5() {
        List<Employee> employees = EmployeeData.getEmployees();
        boolean allMatch = employees.stream().allMatch(e -> e.getAge() > 18);
        System.out.println(allMatch);

        boolean anyMatch = employees.stream().anyMatch(e -> e.getSalary() > 8000);
        System.out.println(anyMatch);

        boolean noneMatch = employees.stream().noneMatch(e -> e.getName().startsWith("王") );
        System.out.println(noneMatch);

        Optional<Employee> any = employees.parallelStream().sorted((e1, e2) -> Integer.compare(e1.getAge(), e2.getAge())).findAny();
        System.out.println(any);

        Optional<Employee> first = employees.stream().sorted((e1, e2) -> Integer.compare(e1.getAge(), e2.getAge())).findFirst();
        System.out.println(first);

        System.out.println(employees.stream().count());

        System.out.println(employees.stream().max( (e1,e2) -> Integer.compare(e1.getAge(),e2.getAge())));
        System.out.println(employees.stream().max( (e1,e2) -> Double.compare(e1.getSalary(),e2.getSalary())));

    }

    @Test
    public void test2(){
        List<Employee> employees = EmployeeData.getEmployees();

        Double reduce = employees.stream().map(e -> e.getSalary()).reduce(0.0, Double::sum);
        System.out.println(reduce);

        Optional<Double> reduce2 = employees.stream().map(Employee::getSalary).reduce(Double::sum);
        Optional<Double> reduce3 = employees.stream().map(Employee::getSalary).reduce((d1,d2)-> d1+d2);
        System.out.println(reduce2.isPresent());
        System.out.println(reduce3.get());
        System.out.println(reduce2.get());

        List<String> collect = employees.stream().map(Employee::getName).filter(n -> n.length() < 4 ).collect(Collectors.toList());
        System.out.println(collect);

        Set<String> set = employees.stream().map(Employee::getName).filter(n -> n.length() < 4 ).collect(Collectors.toSet());
        System.out.println(set);


    }



    private static void demo4() {
        Stream.iterate(0 , i -> i <100 , i-> i+3 ).forEach(System.out::println);
        Stream.generate(Math::random).limit(10).forEach(System.out::println);
    }



    private static void demo3() {
        Stream<Integer> integerStream = Stream.of(2, 3, 4, 5, 6);
    }




    private static void demo2() {
        List<Employee> employees = EmployeeData.getEmployees();
        Stream<Employee> stream = employees.stream();
        employees.add(new Employee(1001,"马化腾",33,10));
        employees.add(new Employee(1003,"马腾",33,20));
        employees.add(new Employee(1003,"马腾",33,20));
        employees.add(new Employee(1003,"马腾",33,20));
        employees.add(new Employee(1003,"马腾",33,20));
        employees.add(new Employee(1003,"马腾",33,20));
        stream.sorted(Comparator.comparingDouble(Employee::getSalary)).filter(e -> e.getAge()>30).map(Employee::getSalary).forEach(System.out::println);

        employees.stream().skip(3).forEach(System.out::println);
        System.out.println();

        employees.stream().distinct().forEach(System.out::println);
        System.out.println();

        Stream<String> nameStream = employees.stream().map(Employee::getName);
        nameStream.filter( n -> n.length() > 3).forEach(System.out::println);



    }

    private static void demo1() {

        String[] strings = {"张三" ,"王五","阿大","赵二","李四","马六","徐老七","刘老八","百里守约"};
        Stream<String> stream = Arrays.stream(strings);
        stream.filter(s -> s.length() <= 3).sorted().forEach(System.out::println);

    }


}