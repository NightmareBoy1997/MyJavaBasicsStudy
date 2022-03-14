package comguigu.java;

import java.util.Arrays;

/**
 * 一、枚举类的使用
 * 1.枚举类的理解：类的对象只有有限个，确定的。我们称此类为枚举类
 * 2.当需要定义一组常量时，强烈建议使用枚举类
 * 3.如果枚举类中只有一个对象时，则可以作为单例模式的实现方式
 * <p>
 * 二、如何定义枚举类
 * 方式一：jdk5.0之前，自定义枚举类
 * <p>
 * 方式二：jdk5.0，可以使用enum关键字定义枚举类
 * <p>
 * 定义的枚举类默认继承java.lang.Enum类
 * <p>
 * 三、enum类中的常用方法
 *  values()方法：返回枚举类型的对象数组。该方法可以很方便地遍历所有的枚举值。
 *  valueOf(String objName)：返回枚举类中对象名是objName的对象。如没有objName的枚举类对象，会有运行时异常：
 * IllegalArgumentException。
 *  toString()：返回当前枚举类对象常量的名称
 * <p>
 * 四、使用enum关键字定义的枚举类实现接口的情况
 * 情况一：实现接口，在enum类中实现抽象方法
 * 情况二：让枚举类的对象分别实现接口的抽象方法
 *
 * @author Freak-W
 * @create 2021-03-25 12:24
 */
public class SeasonTest {
    public static void main(String[] args) {
        System.out.println(Season.AUTUMN.toString());
        System.out.println(Season.SUMMER.getSeasonDesc());

        String str1 = Season.SPRING.getSeasonDesc();
        System.out.println(str1);
        //获取父类
        System.out.println(SevenTen.class.getSuperclass());

        //toString(): 返回枚举类对象的名称
        System.out.println(SevenTen.SHOU);
        //values()： 所有的枚举类对象构成的数组
        SevenTen[] arr1 = SevenTen.values();
        System.out.println(Arrays.toString(arr1));
        //valueOf(String objName):返回枚举类中对象名是objName的对象。
        //如果没有此对象，则报错 IllegalArgumentException
        System.out.println(SevenTen.valueOf("WINTER"));
//        System.out.println(Season1.valueOf("WINTER1")); //IllegalArgumentException

        SevenTen.SHOU.show();

    }


}

//自定义枚举类
class Season {
    // 1.声明Season对象的属性:private final 修饰
    private final String seasonName;
    private final String seasonDesc;

    // 2.私有化构造器,并给属性赋值
    private Season(String seasonName, String seasonDesc) {
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }

    // 3.提供枚举类Season的多个对象 ： public static final的
    public static final Season SPRING = new Season("春天", "春暖花开");
    public static final Season SUMMER = new Season("夏天", "烈日骄阳");
    public static final Season AUTUMN = new Season("秋天", "天高气爽");
    public static final Season WINTER = new Season("冬天", "冰封万里");

    // 4.其他诉求1：获取对象的属性
    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }

    // 4.其他诉求2：提供toString()方法
    public String toString() {
        return "季节： " + seasonName + " ，场景： " + seasonDesc;
    }

}


interface Info {
    void show();

    String get(String string);
}

//使用enum关键字定义枚举类
enum SevenTen implements Info {

    // 1.提供当前枚举类Season的多个对象，多个对象 之间 用","隔开
    //对象分别实现接口
    SHOU("王康", 24, 2.1) {
        public void show() {
            System.out.println("世一红！");
        }

        public String get(String string) {
            return "一串四————世一红！";
        }
    },
    SU999("左右", 25, 1.6) {
        public void show() {
            System.out.println("唯一超巨！");
        }

        public String get(String string) {
            return "17唯一超巨！";
        }

    },

    XBEI("涂占勇", 25, 3.1) {
        public void show() {
            System.out.println("牛马大将军！");
        }

        public String get(String string) {
            return "谁是牛马大将军?";
        }

    };


    // 2.声明对象的属性:private final 修饰
    private String name;
    private int age;
    private double kd;
    int NUMBER = 4;

    // 3.私有化构造器,并给属性赋值
    private SevenTen(String name, int age, double kd) {
        this.name = name;
        this.age = age;
        this.kd = kd;
    }

    // 4.其他诉求1：获取对象的属性
    public String toString() {
        return "17 2022加油！";
    }

    // 4.其他诉求2：提供toString()方法
    public String getName() {
        return name;
    }

}
