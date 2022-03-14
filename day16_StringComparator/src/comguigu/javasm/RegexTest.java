package comguigu.javasm;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @projectName: MyJavaStudy
 * @package: comguigu.javasm
 * @author: Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-02-26 16:54
 *
 * 正则表达式(了解)  读懂就可以。百度
 *
 * 1. 理解：  正则表达式通常被用来==检索(匹配/校验)==、==替换==那些符合某个模式(规则)的文本。
 *
 * 2. String的正则方法
 *      String[] split(String regex);
 *      String replaceAll(String regex, String replacement)
 *      String replaceFirst(String regex, String replacement)
 *      boolean matches(String regex)
 *
 * 3. 正则语法:
 *   String regex = "^([]{})([]{})([]{})([]{})([]{})$";
 *      ^: 以***开头
 *      []: 文本字符。 匹配[]里面的内容。[a|b]  [abc]
 *      {}:限定[]里面文本数据出现的次数。  [a]{1,}
 *      (): 组。域。在java语言中\n 代表第n个域。 n是从1开始的。 \n在正则模式里面使用。
 *          替换环境中:  $n 代表的是第n个域里面的内容。
 *      $:以***结尾
 *
 *      \： 转义符号。  \\.   \\
 *      *: 匹配文本数据出现0次或者多次。
 *      +：匹配文本数据出现1次或者多次。
 *      .: 匹配除“\n”之外的任何单个字符
 *      [a-z] 、 [A-Z] 、 [0-9]
 *      [0-9] \d
 *      \w[a-zA-Z0-9_]
 *
 */
public class RegexTest {


    // 1. 对密码/用户名校验
    //  > 用户录入的用户名或者是密码是否能够满足需求
    @Test
    public  void regexDemo1() {

        //用户名规则:
        //首字母必须大写 只能是一个
        //有3-5个小写字母组成
        //_必须有1个下划线
        //有2-5个数字
        String username = "Jimmy_123";
        //校验用户名是否满足规则(模式)。
        String regex = "^([A-Z]{1})([a-z]{3,5})([_]{1})([0-9]{2,5})$";
        regex = "^[A-Z][a-z]{3,5}_\\d{2,5}$";

        //判断一个文本数据是否满足正则模式的需求
        System.out.println(username.matches(regex));
    }




    // 2. 校验并隐藏手机号码
    @Test
    public  void regexDemo2() {
        String phoneStr = "15278681234";
        //1.校验手机号码是否是合法的
        String phoneRegex = "^1[3-9]\\d{9}$";
        if (!phoneStr.matches(phoneRegex)) {
            System.out.println(phoneStr + "不合法");
            return;
        }
        //2.隐藏手机号中间的4位数字为****
        //String replaceAll(String regex, String replacement)
        //替换内容:是动态获得原字符串里面的一部分  这个时候必须使用 ()
        String regex = "^(\\d{3})\\d{4}(\\d{4})$";
        System.out.println(phoneStr.replaceAll(regex, "$1****$2")); //156****1234
    }


    // 3. 字符串去重
    @Test
    public void regexDemo5() {
        String str = "abaa乌克克克克克aacccc乌克克克克克兰兰兰兰";
        //排序---->数组
        //字符串可以转数组
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        str = new String(chars);
        System.out.println(str);//aaaaabccccddd乌乌克克克克克克克克克克兰兰兰兰
        //String replaceAll(String regex, String replacement)
        //前提: 满足字符数据是连贯的
        //使用一个唯一字符替换重复n次字符数据-----> 匹配一个字符出现>=1
        //多次替换: 不允许使用 ^ $
        String regex = "(.)\\1+";
        System.out.println(str.replaceAll(regex, "$1"));//效率高
    }


    // 4. 去掉一个字符串中的所有空格(包括中间的空格)
    @Test
    public void test6(){
        String oldString = "  jij jk lkj ljl joph osj   ";

        System.out.println(oldString.replaceAll(" ", ""));
    }


}