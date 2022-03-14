package Study.java2;

import Study.java1.Employee;
import Study.java1.EmployeeData;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

/**
 *
 *
 *
 * @author Freak-W
 * @create 2021-11-03 23:18
 */
public class StreamAPITest2 {

    // 1 - 匹配与查找
    @Test
    public void test1(){
        List<Employee> employees = EmployeeData.getEmployees();

//      ①  allMatch(Predicate p) —— 检查是否匹配所有元素
        // 练习： 是否所有的员工的年龄都大于18岁
        boolean allMatch = employees.stream().allMatch(e -> e.getAge() >18);
        System.out.println(allMatch);

//       ②  anyMatch(Predicate p) —— 检查是否至少匹配一个元素
        // 练习： 是否存在员工工资大于10000
        boolean maxSalary= employees.stream().anyMatch(e -> e.getSalary() >10000);
        System.out.println(maxSalary);

//       ③  noneMatch(Predicate p) —— 检查是否没有匹配所有元素
        // 练习： 检查是否存在员工姓 “雷”
        boolean leiName = employees.stream().noneMatch(e -> e.getName().startsWith("雷"));
        System.out.println(leiName);

//       ④  findFirst() —— 返回第一个元素
        Optional<Employee> firstEmployee = employees.stream().findFirst();
        System.out.println(firstEmployee);

//       ⑤  findAny() —— 返回当前流中的任意元素
//        Optional<Employee> anyEmployee = employees.stream().findAny(); // 串行流
        Optional<Employee> anyEmployee = employees.parallelStream().findAny();
        System.out.println(anyEmployee);

//       ⑥  count() —— 返回流中元素总数
        long count1 = employees.stream().filter(e -> e.getSalary() > 5000).count();
        System.out.println(count1);

//       ⑦  max(Comparator c) —— 返回流中最大值
        // 练习： 获取年龄大于20的员工的最高工资
        Optional<Double> ageMaxSalary = employees.stream().filter(e -> e.getAge() > 20 ).map(e -> e.getSalary()).max(Double :: compare);
        System.out.println(ageMaxSalary);

//       ⑧  min(Comparator c) —— 返回流中最小值
        // 练习： 获取年龄大于20的员工的最低工资
        Optional<Double> ageMinSalary = employees.stream().filter(e -> e.getAge() > 20).map(e -> e.getSalary()).min(Double :: compare);
        System.out.println(ageMinSalary);

//       ⑨  forEach(Consumer c) —— 内部迭代 ( 需要用户去做迭代，称为外部迭代。Stream API 使用内部迭代——它帮你把迭代做了)
        employees.stream().forEach(System.out :: println);

        //使用 Collection 的遍历操作
        employees.forEach(System.out :: println);

    }

    // 2 - 归约 自动累加
    @Test
    public void test2(){

//        reduce(T iden, BinaryOperator b) 可以将流中元素反复结合起来，得到一个值。返回 T
        // 练习： 计算1-10的自然数的和
        List<Integer> list =  Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        Integer sum = list.stream().reduce(0, Integer::sum);
        System.out.println(sum);

//        reduce(BinaryOperator b) 可以将流中元素反复结合起来，得到一个值。返回 Optional<T>
        // 练习： 计算公司所有员工的工资总和
        Optional<Double> sumMoney = EmployeeData.getEmployees().stream().map(Employee :: getSalary).reduce(Double :: sum);
        System.out.println(sumMoney);

    }


    // 3 - 收集
    @Test
    public void test3(){

//         collect(Collector c)将流转换为其他形式。接收一个 Collector接口的实现，
//         用于给Stream中元素做汇总的方法
        // 练习 ：查找工资大于6000的员工

        List<Employee> list = EmployeeData.getEmployees();
        List<Employee> employees1 = list.stream().filter(e -> e.getSalary() > 6000).collect(Collectors.toList());
        employees1.forEach( System.out :: println );

        System.out.println();

        Set<Employee> employees2 = list.stream().filter(e -> e.getSalary() > 6000).collect(Collectors.toSet());
        employees2.forEach( System.out :: println );
    }


}
