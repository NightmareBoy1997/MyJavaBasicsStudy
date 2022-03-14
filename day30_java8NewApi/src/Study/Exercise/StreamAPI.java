package Study.Exercise;

import Study.java1.Employee;
import Study.java1.EmployeeData;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * @author Freak-W
 * @create 2021-11-05 14:19
 */
public class StreamAPI {

//    1. 给定一个数字列表，如何返回一个由每个数的平方构成的列表呢？
//    例如，给定【1，2，3，4，5】， 应该返回【1，4，9，16，25】。
    @Test
    public void test1(){
        List<Integer> list= Arrays.asList(1,2,3,4,5,6,7);
//        list.stream().map(i -> Math.pow(i,2)).forEach(System.out :: println);
        list.stream().map(i -> i*i).forEach(System.out :: println);



    }




//            2. 怎样用 map 和 reduce 方法数一数流中有多少个 Employee 呢？
    @Test
    public void test2(){

        List<Employee> employees= EmployeeData.getEmployees();
        Optional<Integer> sum = employees.stream().map(e -> 1).reduce(Integer :: sum);
        System.out.println(sum.get());

    }



}
