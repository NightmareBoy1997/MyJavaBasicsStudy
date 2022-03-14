package comguigu.smexercise;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;

/**
 * @projectName: MyJavaStudy
 * @package: comguigu.smexercise
 * @author: Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-02-25 22:53
 */
public class StringExercise1 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
//        test1();
//        test2(input);
//        test3(input);
//        test4(input);
//        test5();
        test6(input);
//        test7(input);
//        test8(input);
//        test9(input);
        test10();

    }



    //1. 用户从控制台输入一个字符串，要求判断是否为合法的email地址，如果合法，请判断是否为sina的邮箱地址。
    // (PS:记住异常处理) 合法邮箱规则:
    //	有且仅有一个@和.
    //	@在.之前 且@不能是第一位  .不能是最后一位
    //	@与.不能相邻
    //	新浪邮箱应当以@sina.com结尾
    public static void test1(){

        String regex = "^[0-9a-zA-Z]{6,9}@[a-z]{2,4}.com$";
        String email = "a234Ajk@zbcd.com";

        boolean matches = email.matches(regex);
        System.out.println(matches);
    }



    /**
     *   2. 用户从控制台输入一个字符串，请判断是否为回文字
     * @description:
     */
    public static void test2( Scanner input ){

        System.out.print("请输入字符串： ");
        String string = input.next();
        char [] chars = string.toCharArray();


        // 方式一： for循环
//        for (int i = 0 ; i <= chars.length / 2 ; i++ ) {
//            if(chars[i] != chars[chars.length -1 - i] ){
//                System.out.println("这个字符串不是回文");
//                return;
//            }
//        }
//        System.out.println("这个字符串是回文");

//        // 方式二 ： 双指针
//        int startFlag = 0 ;
//        int endFlag = chars.length - 1 ;
//        while ( endFlag > startFlag ) {
//            if(chars[startFlag] != chars[endFlag] ){
//                System.out.println("这个字符串不是回文");
//                return;
//            }
//            startFlag ++;
//            endFlag --;
//        }
//        System.out.println("这个字符串是回文");


        // 方式三 ：内置反转方法
        StringBuilder stringBuilder = new StringBuilder(string);
        stringBuilder.reverse();
        // StringBuilder没有重写equals()
        System.out.println( string.equals(stringBuilder.toString()) );
        System.out.println("********");

    }


    // 3. 编写自定义的字符串一致性匹配方法，只要两个字符串包含同样的字符，不管字符的顺序如何，
    // 都认为两个字符串一致，如：”aabbcc”和”abcabc”被认为是一致的
    public static void test3(Scanner input){

        System.out.print("请输入第一个字符串： ");
        String string1 = input.next();
        System.out.print("请输入第一个字符串： ");
        String string2 = input.next();

//        String string1 = "aabbcc";
//        String string2 = "abcabc";

        char[] chars1 = string1.toCharArray();
        char[] chars2 = string2.toCharArray();

        Arrays.sort(chars1);
        Arrays.sort(chars2);

        if(chars1.length != chars2.length){
            System.out.println("这两个字符串包含的字符不相同");
            return;
        }else{
            for(int i = 0 ; i < chars1.length ;i++ ){
                if(chars1[i] != chars2[i] ){
                    System.out.println("这两个字符串包含的字符不相同");
                    return ;
                }
            }
        }

        System.out.println("这两个字符串包含的字符相同");
    }


    //4. 从控制台实现输入字符串（路径），分别把盘符，文件路径（不包含盘符），文件名，文件类型打出来如：
    // E:\jboss-4.0.4.GA\server\minimal\conf\readme.txt 解析路径，输入 盘符，文件路径，文件名，文件类型。
    // 	盘符：E:
    // 	文件路径：jboss-4.0.4.GA\server\minimal\conf\
    // 	文件名：readme
    // 	文件类型：txt
    public static  void test4( Scanner input ){
//        System.out.print("请输入文件全路径： ");
//        String fileString = input.next();

        String fileString = "E:\\jboss-4.0.4.GA\\server\\minimal\\conf\\readme.txt";

        String[] directoryString = fileString.split("\\\\");

        String dish = directoryString[0];

        String[] string1 = new String[directoryString.length - 2 ];
        for (int i = 0 ; i < string1.length ; i++) {
            string1[i] = directoryString[i+1] ;
        }
        String directory = String.join("\\",string1);

        String fileString1 = directoryString[directoryString.length - 1 ];
        String fileString2 = fileString1.split("\\.")[0] ;

        String type = fileString1.split("\\.")[1];

        System.out.println("文件盘符： " + dish + "\n文件路径： " + directory
                + "\n文件名："+ fileString2 + "\n文件类型： " + type);

    }


    //5. 把数组中的数据按照指定格式拼接成一个字符串。
    // 	 举例：int[] arr = {1,2,3};	输出结果：[1, 2, 3]
    public static void test5(){

        int [] array ={1,2,3,4,5};
        String[] strings = new String[array.length];
        for (int i = 0; i < array.length; i++) {
            strings[i] = Integer.toString( array[i] ) ;
        }

        String stringJoin = String.join("," , strings );

        StringBuilder stringBuilder = new StringBuilder(16);
        stringBuilder.append("[");
        stringBuilder.append( stringJoin );
        stringBuilder.append("]");

        System.out.println(stringBuilder.toString());

    }


    // 6. 去掉一个字符串中的所有空格(包括中间的空格) 使用正则
    public static void test6(Scanner input){
//        System.out.print("请输入要去空格的字符串：");
//        String oldString = input.next();
        String oldString = "  jij jk lkj ljl joph osj   ";

        System.out.println(oldString.replaceAll(" ", ""));

    }


    // 7. 获取一个字符串中指定子串出现的次数。比如说“hanbasdnbafllgnbahjnbakqqqqlnbaxi” 在这个字符串中，有几个nba？
    public static void test7(Scanner input){

        System.out.print("请输入要字符串： ");
        String string = input.next();
        System.out.print("请输入要查询的子串： ");
        String str = input.next();

//        String string = "hanbasdnbafllgnbahjnbakqqqqlnbaxi" ;
//        String str = "nba";

        int number = 0 ;
        for (int i = 0; i < string.length() ; i++) {
            int index;
            if( (index = string.indexOf(str,i)) != -1){
                number++;
                System.out.println("位置： " + index + " 是第 " + number + "个");
                i = index + str.length() - 1;
            }
        }
        System.out.println("\nnba 一共出现了 "+number+"次");
    }


    //8. 练习：让用户在控制台不断录入英文字母（每次录入两个字母即可），直到总长度超过6个停止，然后统计一下一共有几个a
    public static void test8(Scanner input){

        String regex  = "[a-zA - Z]{2}";
        StringBuilder stringBuilder = new StringBuilder(16);

        while(stringBuilder.length() < 6){
            System.out.print("请输入两个字母： ");
            String inputString = input.next();

            if(inputString.matches(regex)){
                stringBuilder.append(inputString);
            }else{
                System.out.println("输入有误，添加失败！ 请重新输入");
            }
        }

        String builderString = stringBuilder.toString();
        System.out.println("您输入的字符串是： " + builderString );

        String[] as = builderString.split("a", -1);
        System.out.println("其中a的个数是： " + (as.length - 1));

    }


    //9. 让用户在控制台输入几个文件名，中间用“,”隔开，然后只把jpg文件换行输出来。例如：hello.java,a.txt,x1.jpg,t1.ppt,m.jpg
    public static void test9( Scanner input ){

//        System.out.print("请输入几个文件名(用，隔开)： ");
//        String fileString = input.next();
        String fileString = "hello.java,a.txt,x1.jpg,t1.ppt,m.jpg ,haha.java,study.java,";

        String[] files = fileString.split(",");

        for (int i = 0; i < files.length; i++) {

            if(files[i].contains(".java")){
                System.out.println(files[i]);
            }
        }
    }


    //10. 现有一个字符串“我我....我...我.要...要要...要学....学学..学.编..编编.编.程.程.程..程”。将该字符串变成:“我要学编程”。使用正则
    public static void test10(){

        String string = "我我....我...我.要...要要...要学....学学..学.编..编编.编.程.程.程..程";
        LinkedHashSet<Character> set = new LinkedHashSet( 30 );
        char[] chars = string.toCharArray();

        for (char aChar : chars) {
            set.add(aChar);
        }

        StringBuilder stringBuilder = new StringBuilder(16);
        for (Character character : set) {
            if(character != '.'){
                stringBuilder.append(character);
            }
        }

        System.out.println(stringBuilder);

    }


}