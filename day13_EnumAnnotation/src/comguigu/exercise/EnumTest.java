package comguigu.exercise;

/**
 * @projectName: MyJavaStudy
 * @package: comguigu.exercise
 * @author: Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-02-19 21:45
 */
public class EnumTest {

    public static void main(String[] args) {
        Enum1[] values = Enum1.values();
        System.out.println(Enum1.SHOU);

        Enum1 enum17 = Enum1.valueOf("SHOU");
        enum17.show();

        for (Enum1 value : values) {
            System.out.println(value.getName());
        }
    }
}


interface info {

    void show();

    String get(String string);

}

enum Enum1  implements info {

    SHOU("王康", 24, 2.1) {
        public void show() {
            System.out.println("世一红！");
        }

        public String get(String string) {
            return "一串四————世一红！";
        }

        ;
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


    private String name;
    private int age;
    private double kd;
    int NUMBER = 4;

    private Enum1(String name, int age, double kd) {
        this.name = name;
        this.age = age;
        this.kd = kd;
    }

    public String toString(){

        return "17 2022加油！";
    }

    public String getName(){
        return name;
    }

    }