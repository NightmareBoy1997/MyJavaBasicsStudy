package comguigu.java;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 *  如何自定义泛型结构：泛型类、泛型接口；泛型方法、
 *
 *   1. 关于自定义泛型类、泛型接口：
 *
 *      要求：如果定义了类是带泛型的，在实例化时要指明类的泛型
 *
 * @author shkstart
 * @create 2021-05-11 12:34
 */
public class GenericTest1 {

    @Test
    public void test1(){

        //如果定义了泛型类，实例化没有指明类的泛型，则认为此泛型为Object类
        //要求：如果定义了类是带泛型的，在实例化时要指明类的泛型
        Order order=new Order();
        order.setOrderT(33);
        order.setOrderT("AA");

        Order<String> order1=new Order<>();

        order1.setOrderT("sfsdf");
//        order1.setOrderT(23);
    }



    @Test
    public void test2(){

        SubOrder sub=new SubOrder();
//        sub.setOrderT("");
        //由于子类在继承带泛型的父类时，指明了泛型的类型。则实例化子类对象时，不再需要指明泛型的类型
        sub.setOrderT(23);

        SubOrder1<String> sub2=new SubOrder1<>();
        sub2.setOrderT("tom");
    }


    @Test
    public void test3(){
        ArrayList<String> list1=new ArrayList<>();
        ArrayList<Integer> list2=new ArrayList<>();

        //泛型不同的引用不能相互赋值
//        list1.addAll(list2);

        //测试泛型方法
        Order<String> order=new Order<>();
        order.setOrderT("德玛西亚之力");
        //泛型方法的调用,在调用时指明泛型参数的类型
        //泛型方法可以是静态的。原因：泛型参数是在调用方法时确定的，而非实例化类
        Integer []arr=new Integer[]{2,434,55};
        List<Integer> list= order.copyFromArrayToList(arr);

        System.out.println(list);


    }

}
