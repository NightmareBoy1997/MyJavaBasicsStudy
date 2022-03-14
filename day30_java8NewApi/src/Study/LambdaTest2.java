package Study;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 *
 *  java内置的 4大核心函数式接口：
 *
 *   消费型接口： Consumer<T>     void    accept();
 *   供给型接口： Supplier<T>     T       get(T t);
 *   函数型接口： Function<T,R>   R       apply(T t);
 *   断定型接口： Predicate<T>    boolean  test(T t);
 *
 *
 * @author Freak-W
 * @create 2021-11-02 20:04
 */
public class LambdaTest2 {


    @Test
    public void test(){
        happyTime(500, money -> System.out.println("学习太累了，去网吧嗨一嗨！ 花费：" + money) );
    }


    public void happyTime(double money, Consumer<Double> con){
        con.accept(money);
    }



    @Test
    public void test2(){
        List<String> list= Arrays.asList("北京","南京","东京","普京","大长今","西京");



        List<String> filterStr=filterString(list, new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.contains("京");
            }
        });
        System.out.println(filterStr);


        // Lambda
        List<String> filterStr1=filterString(list,s -> s.contains("京"));

        System.out.println(filterStr1);

    }

    // 根据给定的规则， 过滤集合中的字符串。 此规则由 Predicate 的方法决定
    public List<String> filterString(List<String> list, Predicate<String> pre){

        ArrayList<String> filterList=new ArrayList<>();

        for(String s : list){
            if(pre.test(s)){
                filterList.add(s);
            }
        }

        return filterList;
    }




}
