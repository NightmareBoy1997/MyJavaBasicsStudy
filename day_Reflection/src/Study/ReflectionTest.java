package Study;

import org.junit.jupiter.api.Test;

import java.lang.annotation.ElementType;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author Freak-W
 * @create 2021-10-19 16:26
 */
public class ReflectionTest {

    //反射之前：
    @Test
    public void test1(){

        Person p1=new Person(14,"ton");

        p1.show("人");
        p1.age=10;
        System.out.println(p1);

        //外部不能调用私有结构
//        p1.showNation();
//        p1.age=2l;

    }

    @Test
    public void test2() throws Exception {


    Class clazz=Person.class;
    Constructor constructor=clazz.getConstructor(int.class,String.class);
    // 1. 通过反射创建Person类的对象
    Person p1=(Person)constructor.newInstance(22,"tom");
        System.out.println(p1.toString());

        // 2. 通过反射调用类的属性和方法
        Field age=clazz.getDeclaredField("age");
        age.set(p1,10);
        System.out.println(p1);

        Method show=clazz.getDeclaredMethod("show",String.class);
        System.out.println(show);
        show.invoke(p1,"人");

        System.out.println("*********************************************");

        // 3. 通过反射调用类的私有结构
        //调用私有构造器
        Constructor constructor1=clazz.getDeclaredConstructor(int.class);
        constructor1.setAccessible(true);
        Person p2=(Person)constructor1.newInstance(18);
        System.out.println(p2);

        //调用私有的属性
        Field name=clazz.getDeclaredField("name");
        name.setAccessible(true);
        name.set(p2,"jack");
        System.out.println(p2);

        //调用私有的方法
        Method showNation=clazz.getDeclaredMethod("showNation",String.class);
        showNation.setAccessible(true);
        String nation=(String)showNation.invoke(p2,"china"); //相当于String str=p2.showNation(“china”)
        System.out.println(nation);

    }

    //疑问1：通过直接new的方式和反射都可以调用公共的结构，开发中用哪个？
    //建议：直接new的方式
    //什么时候使用：反射的方式  反射的特征：动态性
    //疑问2：反射机制与面向对象的封装性是否矛盾？如何看待？
    //不矛盾

    /*
    关于java.lang.Class类的理解：
    1. 类的加载过程：
    程序在经过javac.exe命令以后，会生成一个或多个字节码文件（.class），接着我们使用java.exe命令对某个字节码文件
    进行解释运行。相当于将某个字节码文件加载到内存中，此过程就称为类的加载。
    加载到内存中的类就称为运行时类，此运行时类就作为Class的一个实例。

    2. 换句话说：Class的实例就对应着一个运行时类
    3. 加载到内存中的运行时类，会缓存一段时间。在此时间之内，可以通过不同的方式获取此运行时类


     */

    //获取Class的实例的方式（前三种需要掌握）
    @Test
    public  void test3() throws Exception {
        //方式一：调用运行时类的属性： .class
        Class<Person> clazz1=Person.class;
        System.out.println(clazz1);

        //方式二:调用运行时类的对象
        Person p1=new Person(); //空参构造器
        Class clazz2=p1.getClass();
        System.out.println(clazz2);

        //方式三：调用Class的静态方法：forName(String classPSath)
        Class clazz3=Class.forName("Study.Person");
//        clazz3=Class.forName("java.lang.String");
        System.out.println(clazz3);

        System.out.println(clazz1==clazz2);
        System.out.println(clazz1==clazz3);

        //方式四：使用类的加载器：ClassLoader (了解)
        ClassLoader classLoader=ReflectionTest.class.getClassLoader();
        Class clazz4=classLoader.loadClass("Study.Person");
        System.out.println(clazz4);

        System.out.println(clazz1==clazz4);

    }


    @Test
    public void test5(){

        Class c1 = Object.class;
        Class c2 = Comparable.class;
        Class c3 = String[].class;
        Class c4 = int[][].class;
        Class c5 = ElementType.class;
        Class c6 = Override.class;
        Class c7 = int.class;
        Class c8 = void.class;
        Class c9 = Class.class;


        int[] a = new int[10];
        int[] b = new int[100];
        Class c10 = a.getClass();
        Class c11 = b.getClass();
        // 只要元素类型与维度一样，就是同一个Class
        System.out.println(c10 == c11);

    }



}
