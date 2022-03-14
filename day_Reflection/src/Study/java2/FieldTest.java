package Study.java2;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 *  获取Person类的所有属性
 *
 * @author Freak-W
 * @create 2021-10-20 16:45
 */
public class FieldTest {

    @Test
    public void test1() throws Exception {

        Class clazz=Class.forName("Study.java1.Person");

        //获取属性结构
        //getFields(): 获取当前运行时类及其父类的声明为 public 权限的属性
        Field[] fields = clazz.getFields();

        for(Field f:fields){
            System.out.println(f);
        }

        //getDeclaredFields() : 获取当前运行时类中声明的的所有属性 （不包含父类的）
        Field[] declaredFields = clazz.getDeclaredFields();

        for(Field f: declaredFields){
            System.out.println(f);
        }


    }



    //权限修饰符 数据类型 变量名
    @Test
    public void test2() throws Exception {
        Class clazz= Class.forName("Study.java1.Person");

        Field[] fields = clazz.getDeclaredFields();

        for(Field f: fields){

            // 1. 权限修饰符
            int modifiers = f.getModifiers();
            System.out.print(Modifier.toString(modifiers)+"\t");

            // 2. 变量的数据类型
            Class type=f.getType();
            System.out.print(type+ "\t");
            
            // 3. 变量名
            String name = f.getName();
            System.out.print(name);

            System.out.println();

        }





    }


}
