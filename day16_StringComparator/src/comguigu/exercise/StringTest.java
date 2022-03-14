package comguigu.exercise;

/**
 *
 *  String 面试题 值传递
 *
 * @author shkstart
 * @create 2021-03-18 23:34
 */
public class StringTest {
    String str = new String("good");
    char[] ch = {'t', 'e', 's', 't'};

    public void change(String str,  char ch[]) {
        str = "test ok";
        ch[0] = 'b';
    }

    public static void main(String[] args) {
        StringTest ex = new StringTest();
        ex.change(ex.str, ex.ch);
        System.out.println(ex.str );//good
        System.out.println(ex.ch);//best
    }
}