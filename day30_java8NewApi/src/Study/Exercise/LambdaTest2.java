package Study.Exercise;

import org.junit.jupiter.api.Test;

/**
 * @author Freak-W
 * @create 2021-11-05 21:39
 */
public class LambdaTest2 {


//    2. ① 声 明 函 数 式 接 口 ， 接 口 中 声 明 抽 象 方 法 ： public String getValue(String str);
//    ②声明类 LambdaTest，类中编写方法使用接口作为参数，将一个字符串转换成大写，并作为方法的返回值。
//    ③再将一个字符串的第 2 个到第 4 个索引位置进行截取子串。




    public String UpStr( String str ){

        FunInterface fun =(s -> s.toUpperCase());

        String upStr = fun.getValue(str);
        String substr=upStr.substring(2,5);

        return substr;

    }

    @Test
    public void test(){

        String str="abcdefghijklmn";

        System.out.println(UpStr(str));

    }



}