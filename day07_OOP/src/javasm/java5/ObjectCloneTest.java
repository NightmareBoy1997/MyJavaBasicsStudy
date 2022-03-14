package javasm.java5;

import java.util.Arrays;

/**
 * @projectName: MyJavaStudy
 * @package: javasm.demo
 * @author: Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-02-22 23:07
 * <p>
 * clone() 克隆方法  ---> 类必须实现Cloneable接口
 * 1. 克隆对象不走构造器，jvm底层规则实现
 * 2. 克隆对象跟原对象不是同一个对象
 * 3. 克隆对象跟原对象数据相同
 * 4. 克隆对象影响一些引用数据类型：排除“ 基本数据类型 + 包装类 + String ”
 * 5. 如果影响数据， 则需要深克隆
 *     //在讲方法的时候: 参数传递----->值传递
 *     //克隆的对象-----> 类必须实现Cloneable接口
 *     //1.2 深克隆---> 解决浅克隆
 *     // 序列化可以解决浅克隆
 *
 *     //何时使用? 不推荐使用  转发一封邮件给别人
 *
 */
public class ObjectCloneTest {

    public static void main(String[] args) {

        var obj = new Object1(22, "tom", new Computer("拯救者", 8999));
        obj.filed[0] = "i5-11400";
        obj.filed[1] = "gtx1060";
        obj.filed[2] = "h410";

        Object1 obj1 = (Object1) obj.clone();

        System.out.println(obj);
        System.out.println(obj1);
        System.out.println(obj == obj1);

        System.out.println("************************");

//        obj.name = "xbei";
//        obj.filed[0] = "i7-12600k";
//        obj.filed[1] = "rtx3060";
//        obj.computer.name="华硕天选2";

        System.out.println(obj == obj1);
        System.out.println(obj);
        System.out.println(obj1); // 导致obj1的computer属性被修改

        // 需要深克隆 遍历式复制
        obj1.filed = obj.filed.clone();
        obj1.computer = new Computer(obj.computer.name,obj.computer.money);

        obj.name = "xbei";
        obj.filed[0] = "i7-12600k";
        obj.filed[1] = "rtx3060";
        obj.computer.name="华硕天选2";
        obj.computer.money = 7999;


        System.out.println(obj);
        System.out.println(obj1);

    }

}


class Object1 implements Cloneable {
    int age;
    String name;
    Computer computer;
    String[] filed = new String[3];


    public Object1() {
        System.out.println("空参构造器");
    }

    public Object1(int age, String name, Computer computer) {
        this.age = age;
        this.name = name;
        this.computer = computer;
        System.out.println("有参构造器");
    }

    @Override
    public Object1 clone() {
        Object1 object = null;

        try {
            object = (Object1) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        return object;
    }

    @Override
    public String toString() {
        return "object1{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", computer=" + computer + ",  filed: " + Arrays.toString(filed) +
                '}';
    }
}


class Computer {
    String name;
    double money;

    public Computer() {
    }

    public Computer(String name, double money) {
        this.name = name;
        this.money = money;
    }

    @Override
    public String toString() {
        return "computer{" +
                "name='" + name + '\'' +
                ", money=" + money +
                '}';
    }
}