package comguigu.smexercise;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @projectName: MyJavaStudy
 * @package: comguigu.smexercise
 * @author: Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-02-21 19:07
 */
public class StringExerciseTest {


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

//        trim(input);
//        reverse(input);
//        reverse1(input);

//        getNumber(input);

        sort(input);


    }


    // 1.模拟一个trim方法，去除字符串两端的空格。
    public static void trim(Scanner input) {

        System.out.print("请输入要去除首尾空格的字符串:  ");
        String inputString = input.nextLine();

        // 用于记录从前往后首次索引位置不是空格的位置的索引
        int headIndex = 0;
        // 用于记录从后往前首次索引位置不是空格的位置的索引
        int endIndex = inputString.length() - 1;
        String string = null;
        while (headIndex < endIndex && inputString.charAt(headIndex) == ' ') {
            headIndex++;
        }
        while (headIndex < endIndex && inputString.charAt(endIndex) == ' ') {
            endIndex--;
        }
        if (inputString.charAt(headIndex) == ' ') {
            string = "";
        } else {
            string = inputString.substring(headIndex, endIndex + 1);
        }

        System.out.println("**" + string + "**");
    }


    // 2.将一个字符串进行反转。将字符串中指定部分进行反转。比如将“abcdefg”反转为”abfedcg”
    public static void reverse(Scanner input) {
        System.out.print("请输入要反转的字符串：  ");
        String string = input.nextLine();

        System.out.print("请输入要反转的首个位置： ");
        int headIndex = input.nextInt();

        System.out.print("请输入要反转的末尾位置：  ");
        int endIndex = input.nextInt();

        char[] chars = string.toCharArray();
        char temp;
        for (int i = headIndex - 1, j = endIndex - 1; i < j; i++, j--) {
            temp = chars[i];
            chars[i] = string.charAt(j);
            chars[j] = temp;
        }

        String stringReverse = new String(chars);
        System.out.println(stringReverse);
    }

    // 2.2使用StringBuffer
    public static void reverse1(Scanner input) {
        System.out.print("请输入要反转的字符串：  ");
        String string = input.nextLine();

        System.out.print("请输入要反转的首个位置： ");
        int headIndex = input.nextInt();

        System.out.print("请输入要反转的末尾位置：  ");
        int endIndex = input.nextInt();

        int length = string.length();
        StringBuffer stringBuffer = new StringBuffer(length);
        stringBuffer.append(string, 0, headIndex - 1);

        for (int i = endIndex - 1; i >= headIndex - 1; i--) {
            stringBuffer.append(string.charAt(i));
        }

        stringBuffer.append(string, endIndex - 1, length - 1);

        System.out.println(stringBuffer.toString());
    }


    // 3.获取一个字符串在另一个字符串中出现的次数。
    // 比如：获取“ab”在 “cdabkkcadkabkebfkabkskab”中出现的次数
    public static void getNumber(Scanner input) {
        System.out.print("请输入要查询的字符串：  ");
        String string = input.nextLine();

        System.out.print("请输入要查询的内容： ");
        String indexString = input.next();

        if (string.length() > indexString.length()) {
            int number = 0;
            int index = 0;
            while ((index = string.indexOf(indexString, index)) != -1) {
                number++;
                index += indexString.length(); // 注意迭代条件的影响
            }
            System.out.println(indexString + " 在 " + string + " 中出现的次数是： " + number);

        } else {
            System.out.println(0);
        }

    }


    /**
     * 需求：获取两个字符串中最大相同子串。比如：str1 = "abcdefghijk“;str2 = "rewqabcde" 最大子串abcde
     *
     * @param iniput
     * @author Nightmare970701
     * @version: JDK11
     * @create: 2022-02-26 10:42
     */
    public static void getMaxSub(Scanner iniput) {

        // 动态录取
//        System.out.print("请输入第一个字符串： ");
//        String string1 = input.next();
//        System.out.print("请输入第一个字符串： ");
//        String string2 = input.next();

        String string1 = "wangkangfsjlfkwangkangksjfklswangkangwangkang";
        String string2 = "awangkangz";

        if (string1 == null | string2 == null) {
            throw new RuntimeException("包含空的字符串!");
        }

        if (string1.equals(string2)) {
            System.out.println("最大子串： " + string1);
            return;
        }

        String longString = (string1.length() > string2.length()) ? string1 : string2;
        String shortString = (string1.length() > string2.length()) ? string2 : string1;
        int number = 0;
        boolean flag = false;

        for (int i = 1; i < shortString.length(); i++) {
            // 每次从两端查找
            for (int start = i, end = shortString.length() - 1; start >= 0; start--, end--) {
                string1 = shortString.substring(start, end);
                int index = 0;
                while ((index = longString.indexOf(string1, index)) != -1) {
                    number++;
                    flag = true;
                    System.out.println("最大子串： " + string1 + "，第 " + number + " 个位置： " + index);
                    index += string1.length();
                }
                if (flag) {
                    return;
                }
            }
        }
    }


    // 5.对字符串中字符进行自然顺序排序。"abcwerthelloyuiodef"
    //提示： 1）字符串变成字符数组。
    //      2）对数组排序，选择，冒泡，Arrays.sort(str.toCharArray());
    //      3）将排序后的数组变成字符串。
    public static void sort(Scanner input) {
        System.out.print("请输入要排序的字符串：  ");
        String string = input.nextLine();

        if (string.length() == 0) {
            System.out.println("null");
        } else {
            char[] chars = string.toCharArray();
            Arrays.sort(chars);
            System.out.println(new String(chars));
        }
    }


    @Test
    public void test() {

        String regex = "^1[3-9][0-9]{9}$";
        String string = "13244534424";
        boolean flag = string.matches(regex);

        if (flag) {
            regex = "^(\\d{3})\\d{4}(\\d{4})$"; //[0-9]{3}[0-9]4[0-9]4
            System.out.println(string.replaceAll(regex, "$1****$2"));
        }

    }

}

