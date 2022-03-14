package javasm.exercise;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @projectName: MyJavaStudy
 * @package: javasm.dome
 * @author: Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-03-02 11:28
 */
public class Reflection {

    public static void main(String[] args) {

        try {
            Class personClass = Person.class;
            Constructor constructors = personClass.getDeclaredConstructor(int.class,String.class);
            constructors.setAccessible(true);

            Person person1 =(Person) constructors.newInstance(25,"xbei");
            System.out.println(person1.name);

            Method show = personClass.getDeclaredMethod("show");
            show.setAccessible(true);
            show.invoke(person1);

            Field name = personClass.getField("name");
            System.out.println(name);

            Method getAge = personClass.getDeclaredMethod("getNumber",int.class);
            getAge.setAccessible(true);
            Integer number =(Integer) getAge.invoke(person1,2001);
            System.out.println(number);

            Method toString = personClass.getDeclaredMethod("toString1");
            toString.setAccessible(true);
            String string1 =(String) toString.invoke(person1);
            System.out.println(string1);

            Constructor[] constructors1 = personClass.getDeclaredConstructors();
            System.out.println(Arrays.toString(constructors1));

            Method[] methods = personClass.getDeclaredMethods();
            System.out.println(Arrays.toString(methods));

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }


    }


}



class Person{

    private int age;
    public String name;

    public Person(){
        System.out.println("Person类的空参构造器");
    }
    public Person(int age){
        System.out.println("Person类的一个参数的构造器");
    }
    private Person(int age,String name){
        this.age = age;
        this.name = name;
        System.out.println("Person类的私有的全参构造器");
    }

    private String toString1() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    private void show(){
        System.out.println("我是一个Person");
    }

    private int getNumber(int number){
        return number;
    }


}