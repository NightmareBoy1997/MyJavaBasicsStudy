package Study;

import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.util.Properties;
import java.util.Random;

/**
 *  了解类的加载器：
 *
 * @author Freak-W
 * @create 2021-10-19 16:25
 */
public class ClassLoaderTest {


    @Test
    public void test1() {
        //对于自定义类，使用系统类加载器
        ClassLoader classLoader=ClassLoaderTest.class.getClassLoader();
        System.out.println(classLoader);
        //调用系统类加载器的getParent() ：获取拓展类加载器
        ClassLoader classLoader1=classLoader.getParent();
        System.out.println(classLoader1);
        //调用系统类加载器的getParent() ：无法获取引导类加载器
        //引导类加载器主要负责加载java核心类库，无法加载自定义类
        System.out.println(classLoader1.getParent());

        System.out.println(String.class.getClassLoader());

    }




    /*
    Properties: 用来读取配置文件

     */
    @Test
    public void test2() throws Exception {

        Properties pros=new Properties();
        //此时的文件路径默认为当前module下
        //读取配置文件的方式一：
//        FileInputStream fis=new FileInputStream("src\\jdbc.properties");
//        pros.load(fis);

        //读取配置文件的方式二：使用ClassLoader
        //配置文件默认识别为当前module的src下
        ClassLoader classLoader=ClassLoaderTest.class.getClassLoader();
        InputStream is = classLoader.getResourceAsStream("jdbc.properties");
        pros.load(is);

        String str1=pros.getProperty("user");
        System.out.println(str1);

        String str2=pros.getProperty("password");
        System.out.println(str2);

    }

    //  体会反射的动态性
    @Test
    public void test3() throws IllegalAccessException, InstantiationException, ClassNotFoundException {

        for(int i=0;i<=100;i++){


            String classPath=null;
            int num=new Random().nextInt(3);

            switch(num){
                case 0:
                    classPath="java.util.Date";
                    break;

                case 1:
                    classPath="java.lang.Object";
                    break;

                case 2:
                    classPath="com.atguigu.java.Person";
                    break;
            }

            Object obj=getInstance(classPath);
            System.out.println(obj);

        }

    }

    /*
    此方法创建一个指定路径类的对象
    classPath：指定类的全类名

     */
    public Object getInstance(String classPath) throws ClassNotFoundException, IllegalAccessException, InstantiationException {

        Class clazz=Class.forName(classPath);
        return clazz.newInstance();


    }




}




class ClassLoadingTest {
    public static void main(String[] args) {
        System.out.println(A.m);
    }

}

class A {
    static {
        m = 300;
    }

    static int m = 100;
}
//第二步：链接结束后m=0
// 第三步：初始化后，m的值由<clinit>()方法执行决定
// 这个A的类构造器<clinit>()方法由类变量的赋值和静态代码块中的语句按照顺序合并产生，类似于
// <clinit>(){
// m = 300;
// m = 100;
//}