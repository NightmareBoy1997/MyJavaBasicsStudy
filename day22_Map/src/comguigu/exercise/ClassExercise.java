package comguigu.exercise;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @projectName: MyJavaStudy
 * @package: comguigu.exercise
 * @author: Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-02-24 10:43
 */
public class ClassExercise {


    // 创建Car类，包含name，price属性，构造器等方法，创建测试类，在main方法中创建Set接口的实现类，
    // 添加5个以上的Car对象，遍历集合元素，验证重复元素是否过滤了；如果没有过滤，实现过滤功能；
    // 把每个小车的price降10000元，再遍历，查看price是否已改变
    @Test
    public void test1() {
        Set<Car> hashSet = new HashSet(10);

        hashSet.add(new Car("五菱宏光s2",69999));
        hashSet.add(new Car("特斯拉",31999));
        hashSet.add(new Car("奔驰",35099));
        hashSet.add(new Car("劳斯莱斯",8990000));
        hashSet.add(new Car("小鹏",150999));
        hashSet.add(new Car("奔驰",35099));
        hashSet.add(new Car("宝马",320000));
        hashSet.add(new Car("小鹏",150999));
        hashSet.add(new Car("五菱宏光mini",39999));
        hashSet.add(new Car("小鹏",190000));

        System.out.println(hashSet);
        int number = hashSet.size();
        System.out.println(number);

        Iterator<Car> iterator = hashSet.iterator();
        while(iterator.hasNext()){
            Car car = iterator.next();
            car.setPrice( car.getPrice() - 10000 );

            System.out.println(car);
        }

    }


    // 定义一个Collection接口类型的变量，引用一个Set集合的实现类，实现添加单个元素，添加另一个集合，
    // 删除元素，判断集合中是否包含一个元素，判断是否为空，清除集合，返回集合里元素的个数等常用操作。
    @Test
    public void test2() {
        Collection hashSet = new HashSet(16);
        Collection arrayList = Arrays.asList("汤姆","杰瑞","比卡","帕克");

        hashSet.add("小北");
        hashSet.add(false);
        hashSet.add(1001);
        hashSet.add('y');
        System.out.println(hashSet);

        hashSet.addAll(arrayList);
        System.out.println(hashSet);

        hashSet.remove("比卡");
        System.out.println(hashSet);

//        hashSet.clear();
//        System.out.println(hashSet);

        boolean isEmpty = hashSet.isEmpty();
        System.out.println(isEmpty);

        int number = hashSet.size();
        System.out.println(number);

        boolean isContains = hashSet.contains("小北");
        System.out.println(isContains);

        boolean isContainsAll = hashSet.containsAll(arrayList);
        System.out.println(isContainsAll);

        boolean isEquals = hashSet.equals(arrayList);
        System.out.println(isEquals);

        boolean hashRetainAll = hashSet.retainAll(arrayList);
        System.out.println(hashRetainAll);
        System.out.println(hashSet);

    }


    //    创建Set接口的实现类，添加10个以上的元素，通过Iterator遍历此集合元素。
    //    创建Set接口的实现类，添加10个以上的元素，通过foreach遍历此集合元素。
    @Test
    public void test3() {
        Set set1 = new HashSet(10);

        set1.add(12);
        set1.add("王康");
        set1.add(true);
        set1.add(12.99);
        set1.add('n');
        set1.add("xbei");
        set1.add(21);
        set1.add('v');
        set1.add("许嵩");
        set1.add(121);

        Iterator iterator = set1.iterator();
        while(iterator.hasNext()){
            Object obj = iterator.next();
            System.out.println(obj);
        }

        System.out.println("**************************************");

        for(Object obj : set1){
            System.out.println(obj);
        }

    }


    //    创建Set接口的实现类，添加10个以上的元素，要求能够排序。
    @Test
    public void test4(){

        Set<String> treeSet = new TreeSet<String>( (s1,s2) -> -s1.compareTo(s2));

        treeSet.add("w王康");
        treeSet.add("x小鬼");
        treeSet.add("x小北");
        treeSet.add("s苏酒");
        treeSet.add("j娇姨");
        treeSet.add("xxdd");
        treeSet.add("m麻木");
        treeSet.add("m马云龙");
        treeSet.add("aAZing");
        treeSet.add("s大京");

        Iterator iterator = treeSet.iterator();
        while(iterator.hasNext()){
            Object obj = iterator.next();
            System.out.println(obj);
        }




    }



//    创建ArrayList实例化对象，添加10个以上的元素，在2号位插入一个元素，获得5号位元素，
//    删除6号位元素，修改7号位的元素；
//
//    通过四种方法遍历上题中的集合
    @Test
    public void test5(){
        ArrayList arrayList = new ArrayList(16);

        arrayList.add(false);
        arrayList.add(123);
        arrayList.add(true);
        arrayList.add(123.99);
        arrayList.add(77);
        arrayList.add("java基础篇");
        arrayList.add('a');
        arrayList.add("奥利给");
        arrayList.add("yes");
        arrayList.add("collection");

        System.out.println(arrayList);

        arrayList.add(2,"冲冲冲");
        Object obj = arrayList.get(5);
        System.out.println(arrayList);
        System.out.println(obj);

        Object obj1 = arrayList.remove(4);
        System.out.println(obj1);

        arrayList.set(7,"javaee");
        System.out.println(arrayList);

        // 遍历方式1：
        Iterator iterator = arrayList.iterator();
        while(iterator.hasNext()){
            Object obj2 = iterator.next();
            System.out.println(obj2);
        }

        // 遍历方式2：
        for(Object obj3 : arrayList){
            System.out.println(obj3);
        }

        // 遍历方式3：
        for(int i =0 ; i<arrayList.size() ; i++){
            System.out.println(arrayList.get(i));
        }

        System.out.println("****************************");

        // 遍历方式4：
        Object [] objects = arrayList.toArray();
        System.out.println(Arrays.toString(objects));

    }



    // 创建LinkedList实例化对象，练习具有队列特点的方法
    @Test
    public void test(){


    }


}




@AllArgsConstructor
@NoArgsConstructor
@Data
class Car{
    private String name;
    private double price;
}