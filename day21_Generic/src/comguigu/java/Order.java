package comguigu.java;

import java.util.ArrayList;
import java.util.List;

/**
 *  自定义泛型类
 *
 *
 *
 * @author shkstart
 * @create 2021-05-11 12:19
 */
public class Order<T> {

    String orderName;
    int orderId;

    //类的内部结构就可以使用类的泛型
    T orderT;

    public Order(){

    }
    public Order(int i){
//        T []arr=new T [10];
        //编译通过
        T []arr=(T [])new Object[10];

    }

    public Order(String name,int orderId,T orderT){
        this.orderName=orderName;
        this.orderId=orderId;
        this.orderT = orderT;
    }

    //以下三个方法不是泛型方法
    public T getOrderT(){
        return orderT;
    }
    public void setOrderT(T orderT1){
        this.orderT=orderT1;
    }
    public String toString(){
        return "orderName= "+orderName+",orderId= "+",orderT= "+orderId+orderT;

    }

    //泛型方法：在方法中出现了泛型的结构，泛型的参数与类的泛型参数类型没有任何关系
    //换句话说，泛型方法所属的类是不是泛型类都没有关系
    public <E> List<E> copyFromArrayToList(E [] arr){
        ArrayList<E> list=new ArrayList<>();

        for(E e: arr){
            list.add(e);
        }
        return list;
    }


    //静态方法不能使用类的泛型
//    public static void show(T orderT){
//        System.out.println(orderT);
//    }



}

class SubOrder extends Order<Integer>{  //SubOrder 不再是泛型类

    // 实例化时无法再使用泛型
//    SubOrder<Integer> o = new SubOrder1<Integer>();

}

class SubOrder1<E> extends Order<E>{ //SubOrder 仍是泛型类


}

class SubOrder2<E,T> extends Order<E>{ //SubOrder 仍是泛型类


}