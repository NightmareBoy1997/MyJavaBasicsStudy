package comguigu.java;

import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

/**
 *
 * @author Freak-W
 * @create 2021-05-09 23:15
 */
public class TreeMapTest {
    //向TreeMap中添加key-value，要求key必须是同一个类的对象，因为要按照key排序：自然排序、定制排序

    @Test
    public void  test1(){
        TreeMap map1=new TreeMap();

        map1.put(new Person("d德玛西亚之力",450,1),11);
        map1.put(new Person("d德邦总管",3150,1),13);
        map1.put(new Person("j疾风剑豪",6300,4),112);
        map1.put(new Person("f复仇之矛",6300,0),34);

        Set set1=map1.keySet();
        Iterator iterator =set1.iterator();
        while(iterator.hasNext()){
            Object key=iterator.next();
            Object value=map1.get(key);
            System.out.println(key+" ---> "+value);
        }



    }

}
