package Study.java1;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 一、构造器引用
 *      类似方法引用，函数式接口的抽象方法的形参列表和构造器的形参列表一致，
 *      抽象方法的返回值类型即为构造器所属的类的类型
 *
 * 二、数组引用
 *      可以把数组看作是特殊的类，写法与构造器一致
 *
 *
 * Created by shkstart
 */
public class ConstructorRefTest {


	//构造器引用
    //Supplier中的T get()
    // Employee的空参构造器： Employee()
    @Test
    public void test1(){

        // 原始写法
//        Supplier<Employee> su1 = new Supplier<Employee>() {
//            @Override
//            public Employee get() {
//                return new Employee();
//            }
//        };

        System.out.println("***************************");

        Supplier<Employee> su1 = () -> new Employee();
        System.out.println(su1.getClass());

        Employee emp1=su1.get(); // 此前只是创建了Supplier接口的匿名对象，调用get() 方法以后才能创建Employee的对象
        emp1.test("abc");

        System.out.println("******************************");

        Supplier<Employee> su2 = Employee :: new ;
        System.out.println(su2.getClass());
        su2.get();

    }

	//Function中的R apply(T t)
    @Test
    public void test2(){

        Function<Integer,Employee> fun1 = id -> new Employee(id);
        Employee emp1=fun1.apply(1002);
        System.out.println(emp1.getId());

        System.out.println("***************************************");

        Function<Integer,Employee> fun2 = Employee :: new ;
        Employee emp2=fun2.apply(1001);
        System.out.println(emp2.getId());

    }

	//BiFunction中的R apply(T t,U u)
    @Test
    public void test3(){

        BiFunction<Integer,String,Employee> bi1 = (id, str1) -> new Employee(id,str1);
        Employee emp1=bi1.apply(1002,"tom");
        emp1.test("啊啊啊");

        System.out.println("************************");

        BiFunction<Integer,String,Employee> bi2 = Employee :: new ;
        Employee emp2= bi2.apply(1001,"jack");
        emp2.test("啊啊啊");

	}

	//数组引用
    //Function中的R apply(T t)
    @Test
    public void test4(){

        Function<Integer , String[]> fun1= length -> new String[length];
        String[] arr1= fun1.apply(5);
        arr1[0]="jay";
        System.out.println(Arrays.toString(arr1));

        System.out.println("*********************");

        Function<Integer, String[]> fun2= String[] :: new ;
        String[] arr2 = fun2.apply(2);
        arr2[0]="jj";
        System.out.println(Arrays.toString(arr2));


    }
}
