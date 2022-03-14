/**
 * @author Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-02-09 16:10
 *
 *
 *  1 . Character
 *
 *   1.1 Method :  -- boolean isLetter( char ch ) 判断ch是否为英文字母
 *                 -- boolean isDigit(char ch) 判断字符ch是否为0~9之间的数字
 *                 -- boolean isUpperCase(char ch) 判断字符ch是否为大写
 *                 -- boolean isLowerCase(char ch) 判断字符ch是否为小写
 *                 -- boolean isWhitespace(char ch) 判断字符ch是否为空格或换行符
 *
 *  2 . Math
 *
 *   1.1 Method :  -- static int abs(int a) 求a的绝对值，有4种重载，还有float、double、long
 *                 -- static double pow(double a , double b) 求a的b次方幂
 *                 -- static double sqrt(double a) 求a的平方根
 *                 -- static int round(float a) 求四舍五入
 *                 -- static double ceil(double a) 返回不小于a的最小整数
 *                 -- static double floor(double a) 返回不大于a的最大整数
 *                 -- static double sin(double a) 返回a的正弦值
 *                 -- static double cos(double a) 返回a的余弦值
 *
 *                 -- boolean isWhitespace(char ch) 判断字符ch是否为空格或换行符
 *
 *
 */
public class JDKLanguage {

    public static void main(String[] args) {


// 1. Character
//    -- boolean isLetter( char ch ) 判断ch是否为英文字母
        char char1 = '1';
        char char2 = 'a';
        char char3 = '0';
        char char4 = 'A';
        char char5 = ' ';
        char char6 = '\n';
        System.out.println(Character.isLetter(char1));
        System.out.println(Character.isLetter(char2));
        System.out.println("\n*******************Character2");

//    -- boolean isDigit(char ch) 判断字符ch是否为0~9之间的数字
        System.out.println(Character.isDigit(char1));
        System.out.println(Character.isDigit(char2));
        System.out.println(Character.isDigit(char3));
        System.out.println("\n*******************Character3");

//    -- boolean isUpperCase(char ch) 判断字符ch是否为大写
        System.out.println(Character.isUpperCase(char1));
        System.out.println(Character.isUpperCase(char2));
        System.out.println(Character.isUpperCase(char3));
        System.out.println(Character.isUpperCase(char4));
        System.out.println("\n*******************Character4");

//    -- boolean isLowerCase(char ch) 判断字符ch是否为小写
        System.out.println(Character.isLowerCase(char1));
        System.out.println(Character.isLowerCase(char2));
        System.out.println(Character.isLowerCase(char3));
        System.out.println(Character.isLowerCase(char4));
        System.out.println(Character.isLowerCase(char5));
        System.out.println(Character.isLowerCase(char6));
        System.out.println("\n*******************Character5");


//    -- boolean isWhitespace(char ch) 判断字符ch是否为空格或换行符
        System.out.println(Character.isWhitespace(char1));
        System.out.println(Character.isWhitespace(char2));
        System.out.println(Character.isWhitespace(char3));
        System.out.println(Character.isWhitespace(char4));
        System.out.println(Character.isWhitespace(char5));
        System.out.println(Character.isWhitespace(char6));
        System.out.println("\n************Math1*******");


//2 . Math
//  2.1 Method :  -- static int abs(int a) 求a的绝对值，有4种重载，还有float、double、long
        int i1 = 1;
        int i2 = -1;
        float f1 = 2.4f;
        float f2 = -2.4f;
        float f3 = 2.5f;
        float f4 = -2.5f;
        double d1 = 4.4;
        double d2 = -4.4;
        double d3 = 4.9;
        long l1 =  4 ;
        long l2 = - 4;

        System.out.println(Math.abs(i1) == Math.abs(i2));
        System.out.println(Math.abs(f1) == Math.abs(f2));
        System.out.println(Math.abs(d1) == Math.abs(d2));
        System.out.println(Math.abs(l1) == Math.abs(l2));
        System.out.println("\n************Math2*******");

//                -- static double pow(double a , double b) 求a的b次方幂
        System.out.println(Math.pow(d1,d2));
        System.out.println(Math.pow(d1,d3));
        System.out.println("\n************Math3*******");

//                -- static double sqrt(double a) 求a的平方根
        System.out.println(Math.sqrt(d1));
        System.out.println(Math.sqrt(d2)); //NaN
        System.out.println(Math.sqrt(d3));
        System.out.println("\n************Math4*******");

//                -- static int round(float a) 求四舍五入
        System.out.println(Math.round(f1));
        System.out.println(Math.round(f2));
        System.out.println(Math.round(f3));
        System.out.println(Math.round(f4));
        System.out.println("\n************Math5*******");

//                -- static double ceil(double a) 返回不小于a的最小整数
        System.out.println(Math.ceil(d1));
        System.out.println(Math.ceil(d2));
        System.out.println(Math.ceil(d3));
        System.out.println("\n************Math6*******");

//                -- static double floor(double a) 返回不大于a的最大整数
        System.out.println(Math.floor(d1));
        System.out.println(Math.floor(d2));
        System.out.println(Math.floor(d3));
        System.out.println("\n************Math6*******");

//                -- static double sin(double a) 返回a的正弦值


//        System.out.println("\n************Math7*******");

//                -- static double cos(double a) 返回a的余弦值


//

//

    }







}
