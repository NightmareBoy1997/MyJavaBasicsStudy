package comguigu.java;

import org.junit.jupiter.api.Test;

import java.lang.annotation.Annotation;
import java.util.ArrayList;

/**
 * 注解的使用
 * <p>
 * 1. 理解Annotation
 * ① jdk5.0新增功能
 * ② Annotation 其实就是代码里的特殊标记, 这些标记可以在编译, 类加载, 运行时被读取, 并执行相应的处理。
 * 通过使用 Annotation, 程序员可以在不改变原有逻辑的情况下, 在源文件中嵌入一些补充信息。
 * ③ 在JavaSE中，注解的使用目的比较简单，例如标记过时的功能，忽略警告等。在JavaEE/Android中注解占据了
 * 更重要的角色，例如用来配置应用程序的任何切面，代替JavaEE旧版中所遗留的繁冗代码和XML配置等
 * <p>
 * 2. Annotation的使用
 * 示例一：生成文档相关的注解
 * 示例二：在编译时进行格式检查(JDK内置的三个基本注解)
 *      @Override: 限定重写父类方法, 该注解只能用于方法
 *      @Deprecated: 用于表示所修饰的元素(类, 方法等)已过时。通常是因为
 * 所修饰的结构危险或存在更好的选择
 *      @SuppressWarnings: 抑制编译器警告
 * 示例三：跟踪代码依赖性，实现替代配置文件功能
 * <p>
 * 3. 如何自定义注解：参照@SuppressWarnings定义
 * ① 注解声明为：@interface
 * ② 内部定义成员，通常使用value表示
 * ③ 可以指定成员的默认值，使用default定义
 * ④ 如果自定义注解没有成员，表示是一个标识作用
 * <p>
 * 如果注解有成员，需要指明成员的值(有default默认值可以不指定)
 * ！！：自定义注解必须配上注解信息处理流程(使用反射)才有意义
 * 自定义注解通常都会指明两个元注解：Retention、Target
 * <p>
 * 4. JDK 提供的4种元注解
 * 元注解：对现有注解进行解释说明的注解
 *      Retention  ：指定所修饰的 Annotation 的生命周期：SOURCE\CLASS(默认)\RUNTIME
 * 只有声明为RUNTIME生命周期的注解，才能通过反射获取。
 *      Target     :指定被修饰的Annotation 能用于修饰哪些程序元素
 * ***********************出现的频率较低***************************
 *      Documented :修饰的 Annotation类将被javadoc工具提取成文档。
 * 默认情况下，javadoc是不包含注解的
 *      Inherited    :被修饰的Annotation将具有继承性
 * <p>
 * 5. 通过反射来获取注解信息---
 * <p>
 * 6. jdk 8 中的注解新特性：可重复注解、类型注解
 * 1. 可重复注解： ①：在MyAnnotation 上声明@Repeatable，成员值为MyAnnotations.class
 * ②： MyAnnotation的Target、Retention 、Inherited 等元注解和MyAnnotations相同
 * <p>
 * 2. 类型注解： ElementType.TYPE_PARAMETER 表示该注解能写在类型变量的声明语句中（如：泛型声明）。
 *               ElementType.TYPE_USE 表示该注解能写在使用类型的任何语
 *
 * @author Freak-W
 * @create 2021-04-07 10:08
 */
public class AnnotationTest {

    @SuppressWarnings("unused")
    int i = 10;
    int n = 20;

    @SuppressWarnings({"unused", "rawtypes"})
    ArrayList list = new ArrayList();


    @Test
    public void testGetAnnotation() {
        Class clazz = Man.class;
        Annotation[] annotations = clazz.getAnnotations();
        for (int j = 0; j < annotations.length; j++) {
            System.out.println(annotations[j]);
        }


    }

}

@MyAnnotation("德邦总管")
@MyAnnotation()
        //default已经指定默认值
//@MyAnnotations({@MyAnnotation("德邦总管"), @MyAnnotation("德玛西亚")}) //jdk8之前

class Person {
    private int age;
    private String name;

    public void getName() {
    }
}

interface info {
    public abstract void show();
}


class Man extends Person implements info {

    @Override
    public void getName() {
    }

    @Override
    public void show() {
    }


}