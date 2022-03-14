package comguigu.exercise;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @projectName: MyJavaStudy
 * @package: comguigu.exercise
 * @author: Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-02-23 15:18
 */
public class ArrayListTest {

    @Test
    public void method2(){

        ArrayList<String> list = new ArrayList<String>(10);
        List<String> list1 = new ArrayList<String>(10);

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

        //void add(int index, Object ele):在index位置插入ele元素
        list.add(0,"樱木花道");
        System.out.println(list);

        //boolean addAll(int index, Collection eles):从index位置开始将eles中的所有元素添加进来
        list.addAll(7,list1);
        System.out.println(list);

        //Object get(int index):获取指定index位置的元素
        String str1 = list.get(5);
        System.out.println(str1);

        //int indexOf(Object obj):返回obj在集合中首次出现的位置
        int index = list.indexOf("赤木晴子");
        System.out.println(index);

        //int lastIndexOf(Object obj):返回obj在当前集合中末次出现的位置
        int lastIndex = list.lastIndexOf("仙道章");
        System.out.println(lastIndex);

        //Object remove(int index):移除指定index位置的元素，并返回此元素
        String str2 = list.remove(11);
        boolean ifRemove = list.remove("樱木花道");
        System.out.println(str2);
        System.out.println(ifRemove);


        //Object set(int index, Object ele):设置指定index位置的元素为ele
        list.set(11,"仙道章");
        System.out.println(list);

        //List subList(int fromIndex, int toIndex):返回从fromIndex到toIndex位置的子集合
        List<String> list2 = list.subList(3,5);
        System.out.println(list2);

    }



}