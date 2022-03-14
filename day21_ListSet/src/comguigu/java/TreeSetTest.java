package comguigu.java;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author Freak-W
 * @create 2021-04-24 22:12
 */
public class TreeSetTest {

    /*
    1. 向TreeSet中添加的数据，要求是相同类的对象

    2. 两种排序方式：自然排序(实现comparable接口)、定制排序(实现comparator)



    3. 自然排序中，比较两个对象是否相同的标准是： compareTo()返回值0，而不是equals();
    4. 自然排序中，比较两个对象是否相同的标准是： compare()返回值0，而不是equals();

     */
    @Test
    public void test1(){
        Set set=new TreeSet();

        //失败：添加类型不一致
//        set.add(123);
//        set.add(4546);
//        set.add(new String ("tom"));
//        set.add("17 up!");
//        set.add(new Person("王康",24,177.8));

        //
        set.add(new Person("w王康",24,177.9));
        set.add(new Person("s苏九",23,175.7));
        set.add(new Person("x小北",22,180.1));
        set.add(new Person("x小鬼",22,167.55));
        set.add(new Person("w王康",26,187.9));

        //举例一
//        set.add(123);
//        set.add(-2);
//        set.add(185);
//        set.add(125);
//        set.add(184);


        Iterator iterator=set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }


    @Test
    public void test2(){
        Comparator com=new Comparator<Person>(){
            //按照年龄从小到大排序
            public int  compare(Person p1,Person p2){

                    int number1=p1.getAge()-p2.getAge();
                    if(number1!=0){
                        return -number1;
                    }else{
                        int number2=p1.getName().compareTo(p2.getName());
                        if(number2!=0){
                            return number2;
                        }else{
                            return (int) (100*(p2.getHeight()-p1.getHeight()));
                        }
                    }

            }
        };

        TreeSet set=new TreeSet(com);
        set.add(new Person("w王康",24,177.9));
        set.add(new Person("s苏九",23,175.7));
        set.add(new Person("x小北",22,180.1));
        set.add(new Person("x小鬼",22,167.55));
        set.add(new Person("w王康",26,187.9));

        Iterator iterator=set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }

}
