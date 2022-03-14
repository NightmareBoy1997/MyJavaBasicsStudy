package Study.Exercise;

import org.junit.jupiter.api.Test;

/**
 * @author Freak-W
 * @create 2021-11-05 21:57
 */
public class LambdaTest3 {

//    3. ①声明一个带两个泛型的函数式接口，泛型类型为<T,R> : T 为参数，R 为返回值。
//    ②接口中声明对应抽象方法
//    ③在 LambdaTest 类中声明方法，使用接口作为参数，计算两个 long型参数的和。
//    ④再计算两个 long 型参数的
    @Test
    public void test1(){

        long l1=11l;
        long l2=10l;

        addValue(l1,l2,(x,y) -> x*y);

    }

    public void  addValue(Long l1 , Long l2,FunInterface2<Long,Long> fun){

        System.out.println(fun.getValue(l1,l2));

    }




}
