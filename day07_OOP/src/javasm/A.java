package javasm;

/**
 * @projectName: MyJavaStudy
 * @package: javasm
 * @author: Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-02-19 21:10
 */
public class A {
    int id = 100 ;


    public A(){
        System.out.println(this.getClass() + "我是父类的空参构造器！" + this.id );
    }

    public Object get(){
        return new Object();
    }


}

class B extends A{

    int id = 20 ;

    public B(){

    }

    public static void main(String[] args) {

        var a = new A();
        var b = new B();

    }


    public String get(){
        return new String();
    }

}