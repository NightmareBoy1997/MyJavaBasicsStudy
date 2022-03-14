package comguigu.exercise;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

/**
 *
 * 练习5：常见算法
 *
 * @author shkstart
 * @create 2021-03-22 9:20
 */
public class exercise1 {


/*
1. 模拟一个trim方法，去除字符串两端的空格。
 */

@Test
public void test1(){
    String str1="    abcd  efg   ";
    char []arr1=str1.toCharArray();
    int fristNull=0; int lastNull=0;

    for (int i = 0; i <arr1.length ; i++) {
        if (arr1[i]!=' '){
            fristNull=i;
            break;
        }
    }

    for (int i = arr1.length-1; i >=0 ; i--) {
        if (arr1[i]!=' '){
            lastNull=i;
            break;
        }
    }
    char []arr2=new char[lastNull-fristNull+1];
    for (int i=0;i<arr2.length;i++){
        arr2[i]=arr1[fristNull+i];
    }
    String str2=new String(arr2);
    System.out.println(str2);

}




/*
2. 将一个字符串进行反转。将字符串中指定部分进行反转。比如“abcdefg”反转为”abfedcg”
 */
    // 方式一： char[]
    public String reverse(String str , int startIndex , int endIndex){
        if(str != null &&  str.length() != 0 ){

            char [] array = str.toCharArray();
//            for(int i = 0 ; i<= (endIndex - startIndex) / 2 ; i++){
//                char temp = array[startIndex + i];
//                array[startIndex + i] = array[endIndex - i];
//                array[endIndex - i] = temp;
//            }
            for(int i =startIndex , j =endIndex ; i<j ;i++ ,j--){
                char temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }


            return new String(array) ;
        }
        return null;
    }

    // 方式二：String的拼接操作
    public String reverse1(String str , int startIndex , int endIndex){

        String reverseStr = str.substring(0 , startIndex );

        for(int i = endIndex ; i >= startIndex ; i --){
            reverseStr += str.charAt(i) ;
        }

        String str1 = str.substring(endIndex + 1);

        return new String(reverseStr + str1);

    }
    // 方式二的优化：使用StringBuilder
    public String reverse2(String str , int startIndex , int endIndex){

        StringBuilder reverseStr = new StringBuilder(str.length());
        reverseStr.append(str.substring(0 , startIndex));

        for(int i = endIndex ; i >= startIndex ; i --){
            reverseStr.append(str.charAt(i));
        }

        reverseStr.append(str.substring(endIndex + 1));

        return new String(reverseStr);

    }

@Test
    public void test2(){
    String str1="abcdefghijklmn";
//    str1 = "";
    System.out.println(reverse(str1, 2, 7));
    System.out.println(reverse1(str1, 2, 7));
    System.out.println(reverse2(str1, 2, 7));

}


/*
3. 获取一个字符串在另一个字符串中出现的次数

        比如：获取“ ab”在 “abkkcadkabkebfkabkskab” 中出现的次数
*/

@Test
    public void test3(){
    String str1="ablolfflollol sfsflsolf lolsjfsdflol";
    int num=0;
    String str2="lol";
    for (int i = 0; i <str1.length() ; i++) {
        int sum=str1.indexOf(str2,i);
        if (sum!=-1){
            System.out.println(sum);
            num++;
            i+=sum+str2.length();
        }
    }
    System.out.println("\n出现的次数： "+num);
}


/*
        4.获取两个字符串中最大相同子串。比如：str1 = "abcwerthelloyuiodefabcdef“;str2 = "cvhellobnmabcdef"
        提示：将短的那个串进行长度依次递减的子串与较长的串比较。" +
*/
    public ArrayList<String> getMaxSubString(String str1 , String str2){

        if(str1 != null && str2 !=null && str1.length() != 0 && str2.length() != 0 ){

            String longString = (str1.length() >= str2.length())? str1 : str2;
            String shortString = (str1.length() < str2.length())? str1 : str2 ;
            String maxSubString;
            ArrayList<String> subList = new ArrayList<>();

            int length = shortString.length();

            for(int i = 0 ; i<length ; i++){
                for(int x= 0  , y = length - i ; y<= length ; x++ ,y++ ){
                    if(longString.contains(maxSubString = shortString.substring(x , y))){
                        subList.add(maxSubString);
                    }
//                    if(subList.size() != 0 ) {
//                        break;
//                    }
                }
                if(subList.isEmpty() != true){
                    return subList;
                }
            }

        }
        return null;
    }

@Test
public void test4(){

    String str1 = "abcwertHELLOyuiodefABCDEF“,." ;
    String str2 = "cvHELLObnmABCDE";
    ArrayList<String> subList = getMaxSubString(str1 , str2 );
//    if(subList.size() != 0){
//        String [] strings = new String[subList.size()];
//        for(int i =0 ; i<subList.size() ; i++){
//            strings[i] =(String) subList.get(i);
//            System.out.println(strings[i]);
//        }
//    }
    System.out.println(subList);

}



/*

5.对字符串中字符进行自然顺序排序。
   提示：1）字符串变成字符数组。
   2）对数组排序，选择，冒泡，Arrays.sort();
   3）将排序后的数组变成字符
 */

@Test
    public void test5(){
    String str1="sfskfnvsafsferregbdggnrjthggdg";
    char []arr1=str1.toCharArray();
    for (int i = 0; i <arr1.length-1 ; i++) {
        for (int j = 0; j <arr1.length-i-1 ; j++) {
            if (arr1[j]>arr1[j+1]){
                char temp=arr1[j];
                arr1[j]=arr1[j+1];
                arr1[j+1]=temp;
            }
        }
    }
    System.out.println(new String(arr1) );


}




}