package comguigu.java;

import org.junit.jupiter.api.Test;

/**
 * @author shkstart
 * @create 2021-03-22 10:50
 */
public class StringBufferBuilderTest {

    /*
    String、StringBufferBuilderTest 三者的异同？
    String:不可变的字符序列； 底层使用char数组
    StringBuffer：可变的字符序列: 同步方法，线程安全的，效率低； 底层使用char数组
    StringBuilder：可变的字符序列: JDK5.0新增 线程不安全，效率高； 底层使用char数组

    源码分析：
    String str=new String();//new char[0]
    String str1=new String("abc") //new char[]{'a','b','c'}

    StringBuffer sb1= new StringBuffer(); //char []value =new char[16] ;底层创建一个长度是16的数组
    sb1.append('a'); //value[0]='a';
    sb1.append('b'); //value[1]='b';

    StringBuffer sb2=new StringBuffer("abc"); //char[] value=new char["abc".length()+16]

    //问题1：System.out.println(sb2.length()); // 3
            System.out.println(sb1.length()); // 0
    //问题2: 扩容问题：如果要添加的数据底层数组盛不下，那就需要扩容底层的数组
             默认情况下，扩容为原来容量的 2倍 + 2 ，同时复制原有数据

             指导意义：开发中建议大家使用：StringBuffer(int capacity) 或 StringBuilder(int capacity)

     */

    @Test
    public void test1() {
        StringBuffer sb1 = new StringBuffer("abc");
        sb1.setCharAt(0, 'e');
        System.out.println(sb1);

        StringBuffer sb2 = new StringBuffer();
        System.out.println(sb2.length());
        System.out.println(sb1.length());
    }


    /*
        StringBuffer的常用方法：
    StringBuffer append(xxx)：提供了很多的append()方法，用于进行字符串拼接
    StringBuffer delete(int start,int end)：删除指定位置的内容
    StringBuffer replace(int start, int end, String str)：把[start,end)位置替换为str
    StringBuffer insert(int offset, xxx)：在指定位置插入xxx
    StringBuffer reverse() ：把当前字符序列逆转

    public int indexOf(String str)
    public String substring(int start,int end) 返回一个从start开始到end索引结束的左闭右开的子字符串 新建！！
    public int length()
    public char charAt(int n )
    public void setCharAt(int n ,char c)

            总结：
            增：append(XXX) 【可方法链】:连续调用 ; 
            删：delete()
            改：setCharAt(int n,char char) / replace(int start ,int end , String str)
            查：charAt(int n)
            插：insert()
            长度：length()
            遍历：for() + charAt() / toString


     */

    @Test
    public void test2() {
        StringBuffer sb1 = new StringBuffer("abcdef");
        sb1.append(1);
        sb1.append('1');
        System.out.println(sb1);

        sb1.delete(0, 2);
        System.out.println(sb1);

        sb1.replace(1, 2, " lolonline ");
        System.out.println(sb1);

        sb1.insert(2, false);
        System.out.println(sb1);

        sb1.reverse();
        System.out.println(sb1);


    }

    /*
    String StringBuffer StringBuilder 三者的效率：
    StringBuilder > StringBuffer > String


     */

    @Test
    public void test3() {

//初始设置
        long startTime = 0L;
        long endTime = 0L;
        String text = "";
        StringBuffer buffer = new StringBuffer("");
        StringBuilder builder = new StringBuilder("");
//开始对比
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 20000; i++) {
            buffer.append(String.valueOf(i));
        }
        endTime = System.currentTimeMillis();
        System.out.println("StringBuffer的执行时间：" + (endTime - startTime));
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 20000; i++) {
            builder.append(String.valueOf(i));
        }
        endTime = System.currentTimeMillis();
        System.out.println("StringBuilder的执行时间：" + (endTime - startTime));
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 20000; i++) {
            text = text + i;
        }
        endTime = System.currentTimeMillis();
        System.out.println("String的执行时间：" + (endTime - startTime));

    }


}
