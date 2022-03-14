package javasm.java2;

import org.junit.jupiter.api.Test;

/*
 * 关于变量的赋值：
 *
 * 如果变量是基本数据类型，此时赋值的是变量所保存的数据值
 * 如果变量是引用类型数据，此时赋值的是变量所保存的数据的地址值。
 *
 *
 */
public class ValueTransfer {

    @Test
    public void test() {

        System.out.println("*****************基本数据类型*****************");
        int m = 10;
        int n = m;

        System.out.println("m=  " + m + ",n=  " + n);

        n = 20;
        System.out.println("m=  " + m + ",n=  " + n);

        System.out.println("*****************引用数据类型************");

        Order o1 = new Order();
        o1.orderId = 1001;

        Order o2 = o1;    //赋值以后 o1、o2都是同一个内存地址，指向堆空间的同一个对象实体
        System.out.println("o1.orderId=  " + o1.orderId + "  ,o2.orderId=  " + o2.orderId);
        o1.orderId = 101;
        System.out.println("o1.orderId=  " + o1.orderId + "  ,o2.orderId=  " + o2.orderId);
    }


    /*
     * 方法形参的传递机制：值传递
     *
     * 1.形参：方法定义时，声明的（）内的参数。
     *   实参：方法调用时，实际传递给形参的数据（如：p.show(2，“hello”)。此时的2、“hello”）
     *
     * 2.值传递机制：如果参数是基本数据类型，此时实参赋给形参的是-实参真实存储的数据值。
     *				如果参数是引用类型数据，此时实参赋给形参的是-实参存储数据的地址值。
     */
    @Test
    public void ValueTransferTest1() {
        int m = 10;
        int n = 20;
        System.out.println("m=  " + m + ",n=  " + n);
        swap(m, n);
        System.out.println("m=  " + m + ",n=  " + n);    //m=10,n=20 没有换成
        //实参传给形参，方法内的数值做了交换，但由于作用域的关系，方法内的值没有影响到其他的（ main）方法的值
    }


    /*
     * 形参传递机制测试
     */
    @Test
    public void ValueTransferTest2() {
        Data data = new Data();
        data.m = 10;
        data.n = 20;
        System.out.println("m=  " + data.m + ",n=  " + data.n);
        swap(data);
        System.out.println("m=  " + data.m + ",n=  " + data.n);
    }


    public static void swap(Data data1) {
        int temp = data1.m;
        data1.m = data1.n;
        data1.n = temp;
    }

    public static void swap(int m, int n) {
        int temp = m;
        m = n;
        n = temp;
    }

}


class Data {
    int m;
    int n;
}

class Order {
    int orderId;
}
