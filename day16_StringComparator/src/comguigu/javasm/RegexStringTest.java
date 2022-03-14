package comguigu.javasm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @projectName: MyJavaStudy
 * @package: comguigu.javasm
 * @author: Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-02-25 21:16
 *
 * String的正则方法 的使用
 * String[] split(String regex);
 * String replaceAll(String regex, String replacement)
 * String replaceFirst(String regex, String replacement)
 * boolean matches(String regex)
 */
public class RegexStringTest {


    //String join(CharSequence delimiter, CharSequence... elements), 类似于 contains()
    //delimiter: 分隔符  自定义
    @Test
    public void jionTest() {
        // 执行用户注册 将多个数据连接成 1001-张三-22-zhangsan
        // id.concat("-").concat("name").concat("-")....不便利r
        int id = 1001;
        String name = "张三";
        String password = "zhangsan";
        int age = 22;

        // 此时要求连接的数据都是同一类型
        String userString = String.join("--", String.valueOf(id), name, password, String.valueOf(age));
        System.out.println(userString);

    }


    // String[] split(String regex) //根据指定的正则表达式要求分隔字符串
    // String[] split(String regex, int limit)
    private static void demo4() {
        //统计原字符串里面a出现的次数
        String s = "abcabaaa";
        String[] as = s.split("a", -2);
        System.out.println(Arrays.toString(as));
        //假设最多分为: length个 , 有 length-1 个分隔符
        //limit 默认是0 ，limit=0 当数组里面最后的元素为空字符 直接省略
        //limit>0 limit<=length  限定数组里面元素个数
        //尽可能使用length  limit<0
        System.out.println("a出现的次数:" + (as.length - 1));
    }

    private static void demo3() {

        String str = "abcadad";
        //使用a分隔字符串
        String[] array = str.split("a");
        System.out.println(Arrays.toString(array));

        //为什么最后有一个分隔内容的时候，反而分出来的数据  少了一个?  空字符
        //分隔使用的场景是什么?
        //用户注册---->持久化报存----->文件里面
        //id-name-age-pass
        // 将多个数据连接成 1001-张三-22-zhangsan
        String userInfoStr = "1001-张三-30-1234";
        String[] infoArray = userInfoStr.split("-");
        //将字符串的数据转换成UserInfo对象信息
        UserInfo userInfo = new UserInfo();
        userInfo.setId(Integer.parseInt(infoArray[0]));
        userInfo.setName(infoArray[1]);
        userInfo.setPass(infoArray[3]);
        userInfo.setAge(Integer.parseInt(infoArray[2]));

        System.out.println(userInfo);
    }


}

@Data
@AllArgsConstructor
@NoArgsConstructor
class UserInfo {
    private Integer age;
    private String name;
    private String pass;
    private Integer id;
}