package javasm.exercise;

import org.junit.jupiter.api.Test;

/**
 * @projectName: MyJavaStudy
 * @package: javasm.dome
 * @author: Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-03-02 16:57
 * <p>
 * 通过放射创建对应的运行时类的对象
 */
public class NewInstanceTest {

    public static void main(String[] args) {




    }

    @Test
    public void test1() throws IllegalAccessException, InstantiationException {
        Class<Person> personClass = Person.class;
        /*
        newInstance ： 调用此方法，创建运行时类的对象,内部调用了运行时类的空参构造器

        使用条件： 1. 运行是类必须由空参构造器
                  2. 空参构造器权限要可见。 通常，使用public

         在javabean中，要求提供一个public空参构造器。
         原因： 1. 便于通过反射，创建运行时类的对象
                2. 便于子类继承此运行时类时，默认调用super()时，保证父类有此构造器
         */
        Person person1 = personClass.newInstance();
        System.out.println(person1);




    }
}