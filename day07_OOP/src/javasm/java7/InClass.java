package javasm.java7;

/**
 * @projectName: MyJavaStudy
 * @package: comguigu.exercise
 * @author: Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-02-21 16:50
 */
public class InClass {

    public static void main(String[] args) {

        var p1 = new person7();
        var b1 = new person7.birth();
        var d1 = p1.new dog();
        var f1 = p1.new fish();

        b1.eat();
        d1.eat();
        f1.eat();

        f1.show();

    }

}


class person7 {

    String name = "wei";

    // 非静态内部类父类
    class dog {

        String name = "小笨狗";

        public void eat() {
            System.out.println("狗");
        }

    }

    // 非静态内部类子类
    class fish extends dog {
        String name = "小黄鱼" ;

        public void eat() {

            System.out.println("鱼会游泳！");
        }

        public void show() {

            System.out.println("类的name： " + new person7().name);  // 外层类的name
            System.out.println("内部类dog的name： " + super.name);   // 内部父类dog的name
            System.out.println("内部类fish的name： " + this.name);  // 方式一：内部子类birth() 的name (自身类)
            System.out.println("内部类fish的name： " + new person7().new fish().name);  // 方式二：内部子类birth() 的name

        }
    }

    // 静态内部类
    static class birth {

        String name = "小小鸟" ;

        public void eat() {
            System.out.println("鸟吃虫子！");
        }
    }

}

