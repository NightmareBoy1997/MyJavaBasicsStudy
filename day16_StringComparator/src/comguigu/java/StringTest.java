package comguigu.java;

import org.junit.jupiter.api.Test;

/**
 * String 的使用
 *
 * @author shkstart
 * @create 2021-03-18 22:27
 */
public class StringTest {

    /*
    String ：字符串，使用“ ”引起来表示。
    1. String声明为final的，不可继承
    2. String实现了Serializable接口：表示字符串是支持序列化的
             实现了Comparable接口：表示String是可以比较大小的
    3. String 内部定义了final char[] value用于存储字符串数据
    4. String代表不可变的字符序列，不可变性
            表现： 1. 当对字符串重新赋值时，需要重新指定内存区域赋值，不能使用原有的Value进行赋值
                   2. 当对现有的字符串进行连接操作时，也需要重新指定内存区域赋值
                   3. 当调用String的replace()方法修改指定字符或字符串时，也需要重新指定内存区域赋值
    5. 通过字面量的方式(区别于new)给一个字符串赋值，此时的字符串值声明在字符串常量池中。
    6. 字符串常量池是不会存储相同内容( 使用equals()返回true )的字符串的。


     */

    @Test
    public void test1(){
        String s1="abc"; //字面量的定义方式
        String s2="abc";
//        s1="hello";

        System.out.println(s1==s2);
        System.out.println(s1);
        System.out.println(s2);

        System.out.println("************************************************");

        String s3="abc";
        s3+="def";
        System.out.println(s3);
        System.out.println(s2);

        System.out.println("************************************************");

        String s4="abc";
        String s5=s4.replace('a','m');
        System.out.println(s4);
        System.out.println(s5);

    }

    /*
    String的实例化方式：
    方式一：通过字面量定义的方式
    方式二：通过new+构造器的方式

    面试题：String s=new String("abc") ：方式创建对象，在内存中创建了几个对象？
            两个：一个是堆空间中的new结构，另一个是char[]对应的常量池中的数据："abc"
     */

    @Test
    public void test2(){
        //字面量的方式：此时的s1、s2声明在字符串常量池
        String s1="JavaEE";
        String s2="JavaEE";
        //new+构造器的方式：此时的s3、s4保存的地址值，是数据在声明在堆空间中开辟的空间对应的地址值
        String s3=new String("JavaEE");
        String s4=new String("JavaEE");

        System.out.println(s1==s2);//true
        System.out.println(s3==s4);//false
        System.out.println(s1==s3);//false

        System.out.println("**********************************");

        Person p1=new Person("tom",19);
        Person p2=new Person("tom",10);

        System.out.println(p1.name==p2.name); //true

        p1.name="jeck";
        System.out.println(p2.name);


    }

    /*
    结论：
         常量与常量的拼接结果在常量池。且常量池中不会存在相同内容的常量
         只要其中有一个是变量，结果就在堆中
         如果拼接的结果调用intern()方法，返回值就在常量池中
                intern()返回常量池的地址
     */

    @Test
    public void test3(){
        String s1="javaEE";
        String s2="hadoop";

        String s3="javaEEhadoop";
        String s4="javaEE"+"hadoop";
        String s5=s1+"hadoop";
        String s6="javaEE"+s2;
        String s7=s1+s2;

        System.out.println(s3==s4);//true
        System.out.println(s3==s5);//false
        System.out.println(s3==s6);//false
        System.out.println(s5==s6);//false
        System.out.println(s7==s3);//false
        System.out.println(s7==s6);//false
        System.out.println(s7==s5);//false

        String s8=s5.intern(); //返回值得到的s8使用的常量池中已经存在的"javaEEhadoop"

        System.out.println(s8==s3);

        final String s9 = "javaEE" ; // 此时的s9是常量
        System.out.println(s3 == s9+"hadoop");

        char char1 = 'a';
        System.out.println(Character.isLetterOrDigit(char1));
        System.out.println(Character.digit(char1, 10));
        System.out.println(Character.MIN_RADIX);
        System.out.println(Character.MAX_RADIX);

    }


}


class Person {

    int age;
    String name;

    public Person( String name,int age) {
        this.age = age;
        this.name = name;
    }

    public Person() {
    }



}
