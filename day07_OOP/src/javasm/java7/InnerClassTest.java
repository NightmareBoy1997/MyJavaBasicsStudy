package javasm.java7;

/*
 * 类的成员之五：内部类
 *  1. java中允许将一个类A声明在另一个类B中，则类A就是内部类，类B是外部类
 *
 *  2. 内部类的分类：成员内部类(静态、非静态) vs 局部内部类(方法内、代码块内、构造器内)
 *
 * 	3. 成员内部类：
 * 			一方面：作为外部类的成员：
 * 				>调用外部类的结构
 * 				>可以被static修饰
 * 				>可以被4种不同的权限修饰
 *
 * 			另一方面：作为一个类
 * 				>类内可以定义属性、方法、构造器等
 * 				>可以被final修饰，表示无法被继承。不使用final就可以继承
 * 				>可以被abstract修饰，表示无法被实例化。
 *
 * 	4. 关注如下的问题
 * 		4.1 如何实例化内部类的对象
 * 		4.2 如何在成员内部类区分调用外部类的结构
 * 		4.3 开发中局部内部类的使用
 *
 *  5. 补充： 在局部内部类中，如果调用局部内部类所在的方法中局部变量的话，要求此局部变量声明为final的
 *
 */
public class InnerClassTest {
    public static void main(String[] args) {

        //创建Student实例(非静态的成员内部类)：
//		Person.Student test=new Person.Student();	//错误的
        Person2 p = new Person2();
        Person2.Student test = p.new Student();    //!!!
        test.eat();
        test.getName("德玛");

        //创建Man实例(静态的成员内部类)：
        Person2.Man test1 = new Person2.Man();
        test1.eat();
    }
}

class Person2 {

    String name = "人";
    int age;

    public void show() {
        System.out.println("吃什么饭呢");
    }

    // 成员内部类
    class Student {
        String name = "学生";
        int age;
//        static int i = 22; 非静态内部类不允许出现静态结构

        public void eat() {
            Person2.this.show();    //调用外部的非静态属性
            System.out.println("吃饭");
        }

        public void getName(String name) {
            System.out.println(name);                //形参
            System.out.println(this.name);            //内部类属性
            System.out.println(Person2.this.name);    //外部类属性
        }

    }

    abstract static class Woman {

    }

    static class Man {
        String name;
        int age;

        public void eat() {
            System.out.println("吃软饭");
        }

    }

    {
        // 局部内部类
        class BB {
        }
    }

    public Person2() {
        // 局部内部类
        class CC {
        }
    }

    public void method() {
        // 局部内部类
        class AA {
        }
    }

}


interface A {
    int x = 0;
}

class B {
    int x = 1;
}

class C extends B implements A {
    public void pX() {
//System.out.println(x);
        System.out.println(super.x);    //父类
        System.out.println(A.x);        //接口全局常量
    }

    public static void main(String[] args) {
        new C().pX();
    }
}


class InnerClassTest1 {

    //开发中很少见
    public void method() {
        //局部内部类
        class AA {

        }
    }


    //返回一个实现了Comparable接口的类的对象
    public Comparable getComparable() {


        //创建一个实现了Comparable接口的类：局部内部类

        //方式一：标准的，显式类的匿名对象
//		class MyComparable implements Comparable{
//
//			public int compareTo(Object o){
//				return 0;
//			}
//
//		}
//
//		return new MyComparable();

        //方式二：匿名类的匿名对象
        return new Comparable() {

            @Override
            public int compareTo(Object o) {
                return 0;
            }

        };


    }


}

class InnerClass {
}


/*
  在局部内部类中，如果调用局部内部类所在的方法中局部变量的话，要求此局部变量声明为final的
 */
class test2 {

    public void method() {
        // 局部变量
        int num = 10;

        class AA {

            public void show() {
                // final，不可修改
//                num = 20;
                System.out.println(num);
            }
        }
    }
}