package javasm.exercise;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.ElementType;
import java.util.Properties;

/**
 * @projectName: MyJavaStudy
 * @package: javasm.dome
 * @author: Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-03-02 15:05
 */
public class ClassTest {





    /*
    Class实例的获取
     */
    @Test
    public void test1() throws ClassNotFoundException {
        // 1. 调用运行时类的属性
        Class<Person> personClass1 = Person.class;
        System.out.println(personClass1);

        // 2. 运行时类的对象的getClass()
        Person person1 = new Person();
        Class personClass2 = person1.getClass();
        System.out.println(personClass2);

        // 3. Class的静态方法forName(String classPath)
        Class personClass3 = Class.forName("javasm.exercise.Person");
        System.out.println(personClass3);

        System.out.println(personClass1 == personClass2); // true
        System.out.println(personClass2 == personClass3); // true

        // 4. 使用类的加载器
        ClassLoader classLoader = ClassTest.class.getClassLoader();
        Class personClass4 = classLoader.loadClass("javasm.exercise.Person");
        System.out.println(personClass4);



    }


    /*
    Class实力可以是哪些结构的说明
     */
    @Test
    public void test2(){
        Class c1 = Object.class;
        Class c2 = Comparable.class;
        Class c3 = String[].class;
        Class c4 = int[][].class;
        Class c5 = ElementType.class;
        Class c6 = Override.class;
        Class c7 = int.class;
        Class c8 = void.class;
        Class c9 = Class.class;
        Class c13 = Runnable.class;

        int[] a = new int[10];
        int[] b = new int[100];
        String[] c = new String[100];
        Class c10 = a.getClass();
        Class c11 = b.getClass();
        Class c12 = c.getClass();

        // 只要数组元素类型与维度一样，就是同一个Class
        System.out.println(c10 == c11);
        System.out.println(c10 == c12);


    }



    /*
    了解类的加载器
     */
    @Test
    public void test4(){

        ClassLoader classLoader = ClassTest.class.getClassLoader(); // 系统类加载器
        System.out.println(classLoader);
        ClassLoader parent = classLoader.getParent(); // 拓展类加载器
        System.out.println(parent);
        ClassLoader parent1 = parent.getParent(); // 引导类加载器
        System.out.println(parent1);

        // string是引导类加载器加载的
        ClassLoader classLoader1 = String.class.getClassLoader();
        System.out.println(classLoader1);
    }


    /*
    properties配置文件的读取
     */
    @Test
    public void test5(){

        // 方式一： 使用流
        // 默认路径是当前module下
//        try( FileInputStream fileInputStream = new FileInputStream("src\\javasm\\dome\\jdbc.properties");
//        ) {
//            Properties pros = new Properties();
//            pros.load(fileInputStream);
//
//            String user = pros.getProperty("user");
//            String password = pros.getProperty("password");
//            System.out.println("user： "+ user+ " ， password： "+password);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        // 方式二： 使用类的加载器
        // 默认路径是当前module的src目录下
        try {
            ClassLoader classLoader = ClassTest.class.getClassLoader();
            InputStream inputStream = classLoader.getResourceAsStream("jdbc.properties");

            Properties pros = new Properties();
            pros.load(inputStream);

            String user = pros.getProperty("user");
            String password = pros.getProperty("password");
            System.out.println("user： "+ user+ " ， password： "+password);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}