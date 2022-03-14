package comguigu.java;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;


/**
 *
 *  Set接口的框架结构：
 *         |----Collection接口：单列集合，用来存储一个一个的对象
 *              |----Set接口：存储无序的、不可重复的数据  -->“数学集合”
 *                   |----HashSet           ：作为Set接口的主要实现类；线程不安全的；可以存储null值
 *                      |----LinkedHashSet  ：作为HashSet的子类，在添加数据的同时，每个数据还维护了两个引用，记录此数据的前一个和后一个数据
 *                                            //优点：对于频繁的遍历操作，LinkedHashSet的效率高于HashSet
 *                   |----TreeSet           ：可以按照添加对象的指定属性，进行排序
 *
 *  1. Set接口没有额外的定义新的方法，使用的是Collection的方法
 *
 *  2. 要求：向Set中添加的数据，其所在的类一定要重写hashCode()和equals()
 *     要求：重写的hashCode()和equals()尽可能保持一致性：相同的对象必须具有相等的散列码
 *      重写两个方法的小技巧：对象中用作equals()方法比计较的Field，都应该用来计算hashCode()
 *
 *
 *
 *
 * @author Freak-W
 * @create 2021-04-23 10:46
 */
public class SetTest {

    /*
   一、Set:存储无序的、不可重复的数据
    以HashSet为例说明：
    1. 无序性：不等于随机性。存储的数据在底层数组中并非按照数组索引的顺序添加，而是根据数据的哈希值。

    2. 不可重复性：保证添加的元素按照equals()判断时，不能返回true。即：相同的元素只能添加一个

   二、 添加元素的过程：以HashSet为例：
        new HashSet()创建长度 16 的数组
        我们向HashSet中添加元素a时，首先调用元素a所在类的HashCode()方法，计算元素a的哈希值，此哈希值接着通过某种算法计算出
        在HashSet底层数组中的存放位置(即:索引位置)，判断数组此位置上是否已经有元素：
            如果没有，则元素a添加成功；                                               --->情况1
            如果存在其他元素b(或以链表形式存在的多个元素)，则比较元素a与元素b的哈希值：
                如果不同：则元素a添加成功                                             --->情况2
                如果相同：进而需要调用元素a所在类的equals()方法，与其他的元素比较：
                        equals()返回true，元素a添加成功                               --->情况3
                        equals()返回false，元素a添加失败

        对于添加成功的情况2和情况3而言，元素a 与已经存在指定索引位置上的数据以链表的方式存储。
                jdk 7：元素a放到数组中，指向原来的元素。
                jdk 8：原来的元素在数组中，指向元素a
                    总结：简称“七上八下”

   HashSet底层：数组+链表的结构。

     */
    @Test
    public void test1() {
        Set set = new HashSet();
        set.add(123);
        set.add(123);
        set.add("17 up!");
        set.add("PUBG");
        set.add(new Person("王康", 25, 177.89));
        set.add(new Person("王康", 25, 177.89));
        set.add("GG");

        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

        //LinkedHashSet的使用
        //LinkedHashSet ：作为HashSet的子类，在添加数据的同时，每个数据还维护了两个引用，记录此数据的前一个和后一个数据
        //优点：对于频繁的遍历操作，LinkedHashSet的效率高于HashSet
        @Test
        public void test2(){
            Set set=new LinkedHashSet();
            set.add(123);
            set.add(123);
            set.add("17 up!");
            set.add("PUBG");
            set.add(new Person("王康",25,177.89));
            set.add(new Person("王康",25,177.89));
            set.add("GG");

            Iterator iterator=set.iterator();
            while(iterator.hasNext()){
                System.out.println(iterator.next());
            }
        }



}
