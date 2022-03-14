package comguigu.exercise;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @projectName: MyJavaStudy
 * @package: comguigu.exercise
 * @author: Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-02-24 16:38
 */
public class CollectionsTest {

/*
    Collections: 操作Collection 和 Map的工具类
 *
         *  排序操作：（均为static方法）
            reverse(List)：反转 List 中元素的顺序
         shuffle(List)：对 List 集合元素进行随机排序
         sort(List)：根据元素的自然顺序对指定 List 集合元素按升序排序
         sort(List，Comparator)：根据指定的 Comparator 产生的顺序对 List 集合元素进行排序
         swap(List，int， int)：将指定 list 集合中的 i 处元素和 j 处元素进行交换
 *
         *  查找、替换
 *    Object max(Collection)：根据元素的自然顺序，返回给定集合中的最大元素
 *    Object max(Collection，Comparator)：根据 Comparator 指定的顺序，返回给定集合中的最大元素
 *    Object min(Collection)
 *    Object min(Collection，Comparator)
 *    int frequency(Collection，Object)：返回指定集合中指定元素的出现次数
 *    void copy(List dest,List src)：将src中的内容复制到dest中
 *    boolean replaceAll(List list，Object oldVal，Object newVal)：使用新值替换List 对象的所有旧值Collections常用
 *
*     特别的：    void copy(List dest,List src)：将src中的内容复制到dest中

*     Collections 类中提供了多个 synchronizedXxx() 方法，该方法可使将指定集合包装成线程同步的集合，
*   从而可以解决多线程并发访问集合时的线程安全
 **/



    @Test
    public void test1(){

        ArrayList<String> list = new ArrayList(10);
        list.add("equals");
        list.add("false");
        list.add("group");
        list.add("bast");
        list.add("double");
        list.add("java");
        list.add("false");
        list.add("having");
        list.add("animal");
        list.add("false");
        list.add("car");
//      reverse(List)：反转 List 中元素的顺序
        Collections.reverse(list);
        System.out.println(list);

//      shuffle(List)：对 List 集合元素进行随机排序
        Collections.shuffle(list);
        System.out.println(list);

//      sort(List)：根据元素的自然顺序对指定 List 集合元素按升序排序
        Collections.sort(list);
        System.out.println(list);

//      sort(List，Comparator)：根据指定的 Comparator 产生的顺序对 List 集合元素进行排序
        Collections.sort(list, (s1,s2) -> - s1.compareTo(s2) );
        System.out.println(list);

//      swap(List，int， int)：将指定 list 集合中的 i 处元素和 j 处元素进行交换
        Collections.swap(list,2,4);
        System.out.println(list);

//      void copy(List dest,List src)：将src中的内容复制到dest中  //特别的：
        List<String> list2 = Arrays.asList(new String[list.size()]);
        Collections.copy(list2,list);
        System.out.println(list2);

//      boolean replaceAll(List list，Object oldVal，Object newVal)：使用新值替换List 对象的所有旧值
        Collections.replaceAll(list2,"false","final");
        System.out.println(list2);


        HashSet set = new HashSet<String>(16);
        set.addAll(list2);

//      Object max(Collection)：根据元素的自然顺序，返回给定集合中的最大元素
        Comparable max = Collections.max(set);
        System.out.println(max);

        String max1 = Collections.max(list);
        System.out.println(max1);

//      Object max(Collection，Comparator)：根据 Comparator 指定的顺序，返回给定集合中的最大元素
//      Object min(Collection)
//      Object min(Collection，Comparator)

        int aFinal = Collections.frequency(list2, "final");
        System.out.println(aFinal);


//      int frequency(Collection，Object)：返回指定集合中指定元素的出现次数

//        Collections 类中提供了多个 synchronizedXxx() 方法，该方法可使将指定集合包装成线程同步的集合，
//*   从而可以解决多线程并发访问集合时的线程安全

    }



}