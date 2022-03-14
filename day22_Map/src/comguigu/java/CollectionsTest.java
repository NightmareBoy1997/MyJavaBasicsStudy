package comguigu.java;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Collections: 操作Collection 和 Map的工具类
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
 *          特别的：    void copy(List dest,List src)：将src中的内容复制到dest中

                     //错误的,报异常: IndexOutOfBoundsException: Source does not fit in dest
                             List dest=new ArrayList();
                             Collections.copy(dest,list);
                     //正确的
                     List dest=Arrays.asList(new Object[list.size()]);
                     Collections.copy(dest,list);
                     System.out.println(dest);
 *
 *
 *     Collections 类中提供了多个 synchronizedXxx() 方法，该方法可使将指定集合包装成线程同步的集合，
 *      从而可以解决多线程并发访问集合时的线程安全
 *
 *
 * 面试题： Collection 和 Collection 的区别？
 *
 *
 * @author shkstart
 * @create 2021-05-10 16:46
 */
public class CollectionsTest {

    @Test
    public void test1(){
        List list=new ArrayList();
        list.add(123);
        list.add(762);
        list.add(556);
        list.add(923);

//         reverse(List)：反转 List 中元素的顺序
        Collections.reverse(list);
        System.out.println(list);

//         shuffle(List)：对 List 集合元素进行随机排序
        Collections.shuffle(list);
        System.out.println(list);

//         sort(List)：根据元素的自然顺序对指定 List 集合元素按升序排序
        Collections.sort(list);
        System.out.println(list);

//         sort(List，Comparator)：根据指定的 Comparator 产生的顺序对 List 集合元素进行排序
/*        Collections.sort(list,new Comparator(){
       public int compareTo(){
          }
 });*/
//        System.out.println(list);

//         swap(List，int， int)：将指定 list 集合中的 i 处元素和 j 处元素进行交换
        Collections.swap(list,2,0);
        System.out.println(list);

    }


    @Test
    public void test2(){
        List list=new ArrayList();
        list.add(123);
        list.add(762);
        list.add(762);
        list.add(762);
        list.add(556);
        list.add(923);


//      Object max(Collection)：根据元素的自然顺序，返回给定集合中的最大元素
//      Object max(Collection，Comparator)：根据 Comparator 指定的顺序，返回给定集合中的最大元素
//      Object min(Collection)
//      Object min(Collection，Comparator)

//      int frequency(Collection，Object)：返回指定集合中指定元素的出现次数
        int number=Collections.frequency(list,762);
        System.out.println(number);

//      void copy(List dest,List src)：将src中的内容复制到dest中

        //错误的,报异常: IndexOutOfBoundsException: Source does not fit in dest
//        List dest=new ArrayList();
//        Collections.copy(dest,list);
        //正确的
        List dest=Arrays.asList(new Object[list.size()]);
        Collections.copy(dest,list);
        System.out.println(dest);

//      boolean replaceAll(List list，Object oldVal，Object newVal)：使用新值替换List 对象的所有旧值Collections常用


//      Collections 类中提供了多个 synchronizedXxx() 方法，该方法可使将指定集合包装成线程同步的集合，
//        从而可以解决多线程并发访问集合时的线程安全
            List list2=Collections.synchronizedList(list);  //返回的list2是线程安全的

    }

}
