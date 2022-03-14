package comguigu.demo;

/**
 * @projectName: MyJavaStudy
 * @package: comguigu.demo
 * @author: Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-02-14 17:38
 */
public interface MyInterface {

    // 除私有方法 ，其余方法的权限修饰符都是 public

    void methodAbstract();

    static void methodStatic(){
        System.out.println("接口的静态方法。");
    };

    // jdk9 新特性： 允许在接口中定义私有方法
    private void methodPrivate(){
        System.out.println("接口的私有方法。");
    }

    // 此时的 default 不是权限修饰符
    default void methodDefault(){
        System.out.println("接口的默认方法。");
    }

}
