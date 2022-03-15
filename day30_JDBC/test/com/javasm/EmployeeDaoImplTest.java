package com.javasm;

import com.javasm.bean.Employee;
import com.javasm.demo2.bean.KeyValues;
import com.javasm.demo2.dao.impl.EmployeeDaoImpl;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @projectName: MyJavaStudy
 * @package: com.javasm
 * @author: Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-03-14 19:03
 */
public class EmployeeDaoImplTest {

    static EmployeeDaoImpl employeeDaoImpl = new EmployeeDaoImpl();


    public static void main(String[] args) {
//        employeeDaoImpl.getLimit(2);
//        employeeDaoImpl.findByParams();
//        final List<Employee> instanceList = employeeDaoImpl.getInstanceList("SELECT  empno id , ename name , job ,mgr manager,hiredate hireDate ,sal salary , comm commission , deptno departmentId  FROM emp WHERE job =  ? OR empno =  ? ", "文员", 1002);
//        for (Employee employee : instanceList) {
//            System.out.println(employee);
//        }
        List<KeyValues> list = new ArrayList<>();
        list.add(new KeyValues("job","销售"));
        list.add(new KeyValues("ename","甘"));

        final List<Employee> byParams = employeeDaoImpl.findByParams(list,2,2);
        byParams.forEach(System.out::println);

    }

//    @Test
//    public void test(){
//
////        employeeDaoImpl.getPage(4);
//
//    }

    @Test
    public void addTest(){
//        employeeDaoImpl.


    }



}