package comguigu.exercise;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/**
 * 1. 集合、数组都是用于数据的储存
 * 2. 数组的弊端：
 * 一旦创建就确定了的长度
 *
 * @projectName: MyJavaStudy
 * @package: comguigu.exercise
 * @author: Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-02-21 14:56
 */
public class Collection {

    @Test
    public void method1(){
//        List<String> list = Arrays.asList("流川枫","樱木花道","赤木刚宪","赤木晴子","宫城良田","三井寿","木暮");
//        list.add(22); // 创建只读集合

        List<String> list = new ArrayList<String>(10);
        List<String> list1 = new ArrayList<String>(5);

        //    1、添加
        // add(Object obj)
        list.add("流川枫");
        list.add("樱木花道");
        list.add("赤木刚宪");
        list.add("宫城良田");
        list.add("木暮");
        list.add("赤木晴子");
        list.add("仙道章");
        list.add("阿福");
        list.add("鱼柱");


        list1.add("仙道章");
        list1.add("阿福");
        list1.add("鱼柱");
        list1.add("工藤彦一");

        // addAll(Collection coll)
        list.addAll(list1);

        //2、获取有效元素的个数
        // int size()
        System.out.println(list.size());

        //3、清空集合
        // void clear()
//        list.clear();
//        System.out.println(list.size());
        //4、是否是空集合
        // boolean isEmpty()
        System.out.println(list.isEmpty());

        Iterator<String> iterator1 = list.iterator();
        while(iterator1.hasNext()){
            System.out.println(iterator1.next());
        }

        //5、是否包含某个元素
        // boolean contains(Object obj)：是通过元素的equals方法来判断是否是同一个对象
        // 会调用equals()方法
        System.out.println("樱木花道 in list ？" + list.contains("樱木花道"));

        // boolean containsAll(Collection c)：也是调用元素的equals方法来比较的。拿两个集合的元素挨个比较。
        System.out.println("list vs list1 " + list.containsAll(list1));
        List list3 = list;
        System.out.println("list vs list3 " + list.containsAll(list3));

        //6、删除
        // boolean remove(Object obj) ：通过元素的equals方法判断是否是要删除的那个元素。只会删除找到的第一个元素
        list.remove("鱼柱");
        System.out.println(list);

        // boolean removeAll(Collection coll)：取当前集合的差集 , 返回判断
//        System.out.println(list.removeAll(list1));
//        System.out.println(list);

        //7、取两个集合的交集
        // boolean retainAll(Collection c)：把交集的结果存在当前集合中，不影响c
        list.retainAll(list1);
        System.out.println(list);

        //8、集合是否相等
        // boolean equals(Object obj) // 内容一样，顺序不一样也为false
        System.out.println(list.equals(list1));

        //9、转成对象数组
//         Object[] toArray()
        String [] array = list.toArray(new String[list.size()]);
        for (String s : array) {
            System.out.println(s);
        }


        //10、获取集合对象的哈希值
        // hashCode()
        System.out.println(list.hashCode());

        //11、遍历
        // iterator()：返回迭代器对象，用于集合遍历

        list.sort(new Comparator<String>(){
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });

        System.out.println(list);


        // iterator 执行完指针到达最后必须重新创建 迭代器对象
        iterator1 = list.iterator();
        while(iterator1.hasNext()){
            String obj= iterator1.next();
            if("阿福".equals(obj)){
                iterator1.remove();
            }
        }

        System.out.println(list);


    }






}


class Person1{

}