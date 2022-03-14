package Study.java2;

import Study.java1.Person;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 *  调用运行时类的指定结构
 *
 *
 * @author Freak-W
 * @create 2021-10-20 19:10
 */
public class ReflectionTest {


    /*

    不需要掌握，不通用

     */
    @Test
    public void test1() throws Exception {

        Class clazz= Person.class;

        // 创建运行时类的对象
        Person p1= (Person)clazz.newInstance();

        // 获取指定的属性 :要求属性声明为public
        //通常不采用此方式
        Field id=clazz.getField("id");

        //设置当前属性的值
        // set()： 参数1： 指明哪个对象的属性  参数2：初始化的值
        id.set(p1,1001);

        // get() 参数1：获取哪个对象的当前属性值
        int pid=(int) id.get(p1);
        System.out.println(pid);
    }


    /*
     如何操作运行时类的指定属性 --- 需要掌握
     */
   @Test
    public void testField() throws Exception {

        Class clazz=Person.class;

        // 创建运行时类的对象
        Person p1= (Person) clazz.newInstance();

        // 1. getDeclaredField(String fieldName): 获取运行时类中指定变量名的属性
        Field name=clazz.getDeclaredField("name");
        // 2. 保证当前属性是可以访问的
        name.setAccessible(true);
        // 3. 设置当前属性的值  set()： 参数1： 指明哪个对象的属性  参数2：初始化的值
        name.set(p1,"tom");

        // get() 参数1：获取哪个对象的当前属性值
        String fieldAge =(String )name.get(p1);
        System.out.println(fieldAge);
    }


    /*
    如何操作运行时类的指定方法 --- 需要掌握
     */
    @Test
    public void testMethod() throws Exception {

        Class clazz=Person.class;

        //创建运行时类的对象
        Person p1= (Person) clazz.newInstance();

        // 1. 获取指定的某个方法
        // getDeclaredMethod() : 参数1： 指明获取的方法名  参数2 ：方法的形参列表
        Method show =clazz.getDeclaredMethod("show",String.class);
        show.setAccessible(true);

        // 2. 调用运行时类指定的方法
        // invoke() : 参数1 ： 方法的调用者  参数2：方法的形参赋值的实参
        String returnNation =(String) show.invoke(p1,"china");
        System.out.println(returnNation);


        System.out.println("**********************************");

        Method showDesc= clazz.getDeclaredMethod("showDesc");
        showDesc.setAccessible(true);
        // 如果方法没有返回值，返回null
        String returnShowDesc =(String) showDesc.invoke(Person.class);
//        String returnShowDesc =(String) showDesc.invoke(null);
        System.out.println(returnShowDesc);
    }


     /*
    如何操作运行时类的指定构造器
     */
    @Test
    public void testConstructor() throws Exception {

        Class clazz=Person.class;

        // private Person(String name)
        // 1. 获取指定的构造器
        // getDeclaredConstructor() ：参数： 指明构造器的形参列表
        Constructor con=clazz.getDeclaredConstructor(String.class);
        // 2. 保证此构造器是可访问的
        con.setAccessible(true);

        // 3. 利用构造器创建运行时类的对象
        Person p1=(Person)con.newInstance("tom");

        System.out.println(p1);


    }




}
