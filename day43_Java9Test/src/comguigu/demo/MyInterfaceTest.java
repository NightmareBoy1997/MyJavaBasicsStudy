package comguigu.demo;

/**
 * @projectName: MyJavaStudy
 * @package: comguigu.demo
 * @author: Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-02-14 17:49
 */
public class MyInterfaceTest implements MyInterface{


    @Override
    public void methodAbstract() {
    }

    // 可以重写接口中的默认方法
    @Override
    public void methodDefault() {
        System.out.println("接口的实现类重写的默认方法。");
    }

    public static void main(String[] args) {


        // 接口的静态方法只能由接口自己调用
        MyInterface.methodStatic();

        // 接口的实现类不能调用接口的静态方法
//        MyInterfaceTest.methodStatic();

        MyInterfaceTest my = new MyInterfaceTest();
        // 可以调用接口的默认方法。 当被实现类重写时，则调用实现类的方法
        my.methodDefault();

        // 接口的私有方法不能在外部调用
//        my.methodPrivate();




    }
}