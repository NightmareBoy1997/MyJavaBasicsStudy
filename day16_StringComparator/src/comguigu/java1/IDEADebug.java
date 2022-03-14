package comguigu.java1;

import org.junit.jupiter.api.Test;

/**
 * @author shkstart
 * @create 2021-03-23 10:11
 */
public class IDEADebug {

    @Test
    public void IDEADebug() {

        String str = null;
        StringBuffer sb = new StringBuffer();
        sb.append(str);

        System.out.println(sb.length()); // 4
        System.out.println(sb); // "null"
        StringBuffer sb1 = new StringBuffer(str); //抛异常 NullPointerException
        System.out.println(sb1); //
    }


}
