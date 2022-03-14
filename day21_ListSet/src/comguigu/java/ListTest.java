package comguigu.java;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 *
 *  1. List结构框架：
 *      |----Collection接口：单列集合，用来存储一个一个的对象
 *          |----List接口：存储有序的、可重复的数据。 -->“动态”数组，替换原有数组
 *               |----ArrayList    ：作为List接口的主要实现类；线程不安全，效率高；底层使用Object[] elementData存储
 *               |----LinkedList   ：对于频繁的插入和删除操作，使用此类效率比ArrayList高，底层使用双向链表存储
 *               |----Vector       ：作为List接口的古老实现类；线程安全，效率低；底层使用Object[] elementData存储
 *
 *  2.  ArrayList的源码分析：
 *          2.1 jdk 7 的情况下：
 *               ArrayList arrayList=new ArrayList（）; //创建了长度是10的Object[] elementData数组
 *               List.add(123); //elementData[0]=new Integer(123);
 *               ……
 *               ist.add(11); //如果此次的添加导致elementData数组容量不够，则扩容。默认情况下，扩容为原来容量的1.5倍，
 *               同时将原有数据复制
 *
 *          结论：建议开发中使用带参的构造器：
 *
 *          2.2 jdk 8 的ArrayList的变化：
 *              ArrayList List=new ArrayList(); //底层Object[] elementData初始化为{},并没有创建长度为10的数组
 *              如果 new Array(number) 输入的形参number < 10 ，默认是长度10的数组
 *              List.add(123); //第一次调用add()时，底层才创建了长度为10的数组，并将123添加到elementData[]
 *              ……
 *              后续添加和扩容跟 jdk7 相同
 *
 *          2.3 小结：jdk7 的ArrayList对象创建 类似于单例的饿汉式，而 jdk8 的类似于单例的懒汉式，延迟数组的创建，节省内存
 *
 *   3. linkedList的源码分析：
 *          LinkedList List=new LinkedList(); //内部声明了Node类型的first和last属性，默认为null
 *          List.add(); //将123封装到Node中，创建了Node对象
 *
 *          其中，Node定义为： 体现了LinkedList的双向链表的说法
 *              private static class Node<E> {
                 E item;
                 Node<E> next;
                 Node<E> prev;

                 Node(Node<E> prev, E element, Node<E> next) {
                 this.item = element;
                 this.next = next;
                 this.prev = prev;
                    }
                 }
 *
 *   4. Vector的源码分析：jdk7和jdk8中通过Vector()构造器创建对象时，底层都创建了长度为10的数组
 *                      在扩容方面，默认扩容为原来数组长度的2倍
 *
 *  面试题：ArrayList、linkedList、Vector三者的异同？
 *      同：三个类都是实现的List接口，存储数据的特点相同：存储有序的、可重复的数据
 *      不同：如上
 *
 *   5. List接口的常用方法：
         void add(int index, Object ele) :在index位置插入ele元素
         boolean addAll(int index, Collection eles) :从index位置开始将eles中的所有元素添加进来
         Object get(int index) ：获取指定index位置的元素
         int indexOf(Object obj) :返回obj在集合中首次出现的位置，不存在返回-1
         int lastIndexOf(Object obj) ：返回obj在当前集合中末次出现的位置，不存在返回-1
         Object remove(int index) :移除指定index位置的元素，并返回此元素
         Object set(int index , Object ele) :设置指定index位置的元素为ele
         List subList(int formIndex, int toIndex) ：返回从formIndex到toIndex位置左闭右开的子集合
 *
 *
 *     总结：常用方法
 *          增：add(Object obj)
 *          删：remove(int index) / remove(Object obj)
 *          改：set(int index, Object ele)
 *          查：get(Object obj)
 *          插：add(int index , Object ele)
 *          长度：size()
 *          遍历：① Iterator迭代器 ② 增强for循环 ②普通循环
 *
 *
 * @author Freak-W
 * @create 2021-04-22 16:10
 */
public class ListTest {

    @Test
    public void test1(){
        ArrayList list=new ArrayList();
        list.add(123);
        list.add(new String("six!"));
        list.add(new Person("jack",23,184.99));
        list.add("six!");

        for(Object obj:list){
            System.out.println(obj);
        }
        System.out.println("****************");

        //1. void add(int index, Object ele) :在index位置插入ele元素
        list.add(1,"nice!");

        System.out.println(list);


        //2. boolean addAll(int index, Collection eles) :从index位置开始将eles中的所有元素添加进来
        List list1= Arrays.asList(1,3,5);

        list.addAll(1,list1);
//        list.add(list1);
        System.out.println(list);


        //3. Object get(int index) ：获取指定index位置的元素
        System.out.println(list.get(4)); //nice!


        //4. int indexOf(Object obj) :返回obj在集合中首次出现的位置，不存在返回-1
        System.out.println(list.indexOf("six!")); //5

        //5. int lastIndexOf(Object obj) ：返回obj在当前集合中末次出现的位置，不存在返回-1
        System.out.println(list.lastIndexOf("six!")); //7

    }

    @Test
    public void test2(){
        ArrayList list=new ArrayList();
        list.add(123);
        list.add("stk");
        list.add("17 up!");
        list.add("PUBG");
        list.add("17 up!");

        //6. Object remove(int index) :移除指定index位置的元素，并返回此元素
        System.out.println(list.remove(1)); //stk 删除第一个
        // 重载的 boolean remove( Object object) : 移除首个内容为object的元素 ， 返回结果
        System.out.println(list.remove("17 up!")); //[123, stk, PUBG, 17 up!]

        //7. Object set(int index , Object ele) :设置指定index位置的元素为ele
        list.set(0,"奥利给！");
        System.out.println(list);

        //8. List subList(int formIndex, int toIndex) ：返回从formIndex到toIndex位置左闭右开的子集合
        System.out.println(list.subList(1,list.size())); //[PUBG, 17 up!]
        System.out.println(list.subList(1,2)); //[PUBG]

    }

    @Test
    public void test3(){
        ArrayList list=new ArrayList();
        list.add("17 up!");
        list.add("PUBG");
        list.add("17 up!");

        //方式一：Iterator迭代器
        Iterator iterator=list.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("\n*************\n");

        //方式二：增强for循环
        for(Object obj : list){
            System.out.println(obj);
        }
        System.out.println("\n*************\n");

        //方式三：普通循环
        for (int i = 0; i <list.size() ; i++) {
            System.out.println(list.get(i));
        }



    }


    // 面试题：
    @Test
    public void testListRemove() {
        List list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        updateList(list);
        System.out.println(list);//
    }
    private void updateList(List list) {
//        list.remove(2);
        list.remove(new Integer(2));
    }





}
