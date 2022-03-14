package javasm.java6;

/*
 * 单例设计模式：
 * 	 1. 所谓类的单例模式，就是采取一定的方法保证在整个软件系统中，对某个类只能存在一个对象实例。
 *
 * 	 2. 如何实现？
 *
 * 		饿汉式    vs   懒汉式
 * 	 3. 区分饿汉式和懒汉式
 * 		饿汉式： 坏处：对象加载时间过长
 * 			     好处：饿汉式是线程安全的
 *
 * 		懒汉式： 好处：延迟对象的创建
 * 			       坏处：目前的写法是不安全的--->到多线程内容时，再修改
 *
 *
 *
 *
 *
 */
public class SingletonTest {
    public static void main(String[] args) {

        Bank1 b1 = Bank1.getInstance();
        Bank1 b2 = Bank1.getInstance();

        if (b1 == b2) {
            System.out.println("同一个对象！");

            Bank2 b3 = Bank2.getInstance();
            Bank2 b4 = Bank2.getInstance();
            if (b3 == b4) {
                System.out.println("同一个对象！");
            }

        }

    }
}


//饿汉式
class Bank1 {

    // 1. 私有化构造器
    private Bank1() {
    }

    // 2. 内部创建类的对象
    // 4. 要求此对象也必须是声明为静态，此时对象作为类的一个属性
    private static Bank1 instance = new Bank1();

    // 3. 提供公共的静态方法，返回对象
    public static Bank1 getInstance() {
        return instance;
    }

}

// 方式二：
class Bank11{

	static Bank11 instance ;

    private Bank11() {
    }

    static {
        instance = new Bank11();
    }

    public Bank11 getInstance() {
        return instance;
    }
}

// 方式三：
class Bank13 {

    public final static Bank13 instance = new Bank13();

    private Bank13() {
    }

}


//懒汉式
class Bank2 {

    private Bank2() {
    }

    // 2. 声明类的对象，没有初始化
    private static Bank2 instance;

    public static Bank2 getInstance() {
        if (instance == null) {
            instance = new Bank2();
        }
        return instance;
    }

}