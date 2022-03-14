package Study.Exercise;

import Study.java1.Employee;
import Study.java1.EmployeeData;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

/**
 * @author Freak-W
 * @create 2021-11-05 20:08
 */
public class LambdaTest1 {


//    1. 调用 Collections.sort()方法，通过定制排序比较两个 Employee(先按年龄比，年龄相同按姓名比),
//    使用 Lambda 表达式作为参数传递。

    @Test
    public void test1(){

        List<Employee> list= EmployeeData.getEmployees();

//        System.out.println(list);

        Collections.sort(list ,(e1, e2) -> {
            if(e1.getAge()-e2.getAge()!=0){
                return e1.getAge()-e2.getAge();
            }else{
                return e1.getName().compareTo(e2.getName());
            }
        });

        for (Employee emp : list){
            System.out.println(emp);
        }

    }

}
