package comguigu.exercise;

/**
 * @projectName: MyJavaStudy
 * @package: comguigu.exercise
 * @author: Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-02-19 22:37
 */
public class StringBuffer1 {

    public static void main(String[] args) {

        char [] chars = new char[]{'s','b','n','b','g'};
        StringBuffer stringBuffer1 = new StringBuffer("str");
        StringBuffer stringBuffer2 = new StringBuffer(22);

        System.out.println(stringBuffer1);
        System.out.println(stringBuffer2);
        stringBuffer1.insert(2 , chars);
//        stringBuffer2.insert(5,chars);

        System.out.println(stringBuffer1.length());
        System.out.println(stringBuffer2.length());


    }

}