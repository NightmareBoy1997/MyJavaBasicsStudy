package Study;

import org.junit.jupiter.api.Test;

import java.util.Random;

/**
 *
 *  通过反射创建对应的运行时类的对象
 *
 * @author Freak-W
 * @create 2021-10-19 16:25
 */
public class NewInstanceTest {

    @Test
    public void test1() throws Exception {

        Class<Person> clazz=Person.class;
        /*
        newInstance(): 调用此方法，创建对应的运行时类的对象。内部调用了运行时类的空参构造器
        要求：
        1. 运行时类必须提供空参构造器
        2. 空参构造器的权限修饰必须大于访问，通常为public

        在javabean中要求提供一个public的空参构造器，原因：
        1. 便于通过反射，创建运行时类的对象
        2. 便于子类继承此运行时类，默认调用super()时，保证父类有此构造器

         */
        Person p1= clazz.newInstance();
        System.out.println(p1);


    }

    //体会反射的动态性
    @Test
    public void test2(){

        for(int i = 0;i < 100;i++){
            int num = new Random().nextInt(3);//0,1,2
            String classPath = "";
            switch(num){
                case 0:
                    classPath = "java.util.Date";
                    break;
                case 1:
                    classPath = "java.lang.Object";
                    break;
                case 2:
                    classPath = "com.atguigu.java.Person";
                    break;
            }

            try {
                Object obj = getInstance(classPath);
                System.out.println(obj);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }



    }

    /*
    创建一个指定类的对象。
    classPath:指定类的全类名
     */
    public Object getInstance(String classPath) throws Exception {
        Class clazz =  Class.forName(classPath);
        return clazz.newInstance();
    }



}
