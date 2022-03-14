package javasm.Interface_xercise;

/**
 * @projectName: MyJavaStudy
 * @package: javasm.Interface_xercise
 * @author: Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-02-21 10:37
 */
public class A {

    int age;
    private  int id = 11;
    static int iid = 110;

    static void test(){
        System.out.println("idd: " +iid);
    }

}


class B extends A{

    public static void main(String[] args) {

        B b = new B();
        b.age = 1;
        b.iid=11;
//        b.id = 111;
        b.test();

        System.out.println(b.age);
        System.out.println(b.iid);

    }

    public void show(){
        System.out.println( "idd: " + iid);
    }

}