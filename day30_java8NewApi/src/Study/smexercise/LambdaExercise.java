package Study.smexercise;

import Study.java1.Employee;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @projectName: MyJavaStudy
 * @package: Study.smexercise
 * @author: Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-02-22 17:08
 */
public class LambdaExercise {


    // 调用 Collections.sort()方法，通过定制排序比较两个 Employee(先按年龄比，年龄相同按姓名比),
    // 使用 Lambda 表达式作为参数传递。

    @Test
    public void CollectionLambda(){

        List<Employee> list = Arrays.asList(
            new Employee(1001,"tom",20 ,4999),
            new Employee(1002, "jack", 25, 7000),
            new Employee(1012, "xbei", 31, 9000),
            new Employee(1020, "shou", 28, 12000)
        );

        Collections.sort(list , (e1, e2) -> {  if( e1.getAge() == e2.getAge() ){
            return e1.getName().compareTo(e2.getName());
        }
        return - Integer.compare(e1.getAge(),e2.getAge());
        }  );

        for (Employee employee : list) {
            System.out.println(employee);
        }

    }


    //   2.
    //  ① 声 明 函 数 式 接 口 ， 接 口 中 声 明 抽 象 方 法 ： public String  getValue(String str);
    //  ②声明类 LambdaTest，类中编写方法使用接口作为参数，将一个字符串转换成大写，并作为方法的返回值。
    //  ③再将一个字符串的第 2 个到第 4 个索引位置进行截取子串。
    @Test
    public void stringTest1(){

        String string = "sdlkfjsfkljaskfl";
        System.out.println(string);

        StringUpper  stringUpper = String :: toUpperCase;

        String stringUp = stringUpper.getValue(string);
        System.out.println(stringUp);

        StringUpper stringSub = str -> string.substring(1,4);
        System.out.println(stringSub.getValue(string));

    }


    // 3. ①声明一个带两个泛函数式型的接口，泛型类型为<T,R> : T 为参数，R 为返回值。
    //    ②接口中声明对应抽象方法
    //    ③在 LambdaTest 类中声明方法，使用接口作为参数，计算两个 long型参数的和。
    //    ④再计算两个 long 型参数的乘积*/
    @Test
    public void mathTest(){

        mathInfo<Integer,Long> mathInfo1 = (l1,l2) -> (int)(Long.sum(l1,l2));

        mathInfo<Integer,Long> mathInfo2 = (l1,l2) -> (int)(l1.intValue() * l2.intValue());

        System.out.println(mathInfo1.get(2010l, 2022l));

        System.out.println(mathInfo2.get(2010l,2022l));
    }


}


@FunctionalInterface
interface StringUpper{
    String getValue(String string);
}

@FunctionalInterface
interface mathInfo<R,T>{

    R get(T t1 , T t2);

}