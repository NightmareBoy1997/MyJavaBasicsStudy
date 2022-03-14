package comguigu.java;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 *  一、Map实现类的结构
 *  |----Map:双列数据，存储key-value对的数据  ---类似于高中的函数 y=f(x)
 *      |----HashMap:作为Map的主要实现类；线程不安全，效率高；存储null的key-value
 *          |----LinkedMap：保证在map元素遍历时，可以按照添加的顺序实现遍历
 *              原因：在原有的HashMap底层结构基础上，添加了一对指针，指向前一个和后一个元素
 *              对于频繁地遍历操作，此类的执行效率高于HashMap。
 *      |----TreeMap：保证按照添加的key-value对进行排序，实现排序遍历。此时考虑key的自然排序或定制排序，底层使用红黑树
 *      |Hashtable：作为古老的实现类；线程安全，效率低；不能储存null的key-value
 *           |----Properties：常用来处理配置文件。key-value都是String类型
 *
 *      HashMap：数组+链表 （jdk 7之前）
 *              数组+链表+红黑树 （jdk 8）
 *
 *
 *  面试题：
 *  1 . HashMap的底层实现原理？
 *  2 . HashMap 和 Hashtable 的异同？
 *  3 . CurrentHashMAP 和 Hashtable 的异同？
 *
 *
 *  二、 Map结构的理解：
 *      Map中的key：无序的、不可重复的，使用Set存储所有的key  --->key所在的类要求重写equals() 和 hashCode() (HashMap为例)
 *      Map中的value：无序的、可重复的，使用Collection存储所有的value  --->value所在的类要求重写 equals()
 *      一个键值对：key-value构成了一个Entry对象
 *      Map中的entry：无序的、不可重复的，使用Set存储所有的entry
 *
 *   三、 HashMap的底层实现原理？ 以jdk 7为例说明：
 *      HashMap map=new HashMap();
 *      在实例化以后，底层创建了一个长度是16的一维数组Entry[] table
 *      ……可能执行过多次put()……
 *      map.put(key1,value1)
 *      首先，调用key1所在类的hashCode() 计算key1的哈希值，此哈希值经过某种算法计算（ hash & length-1）以后，得到在Entry数组中存储的位置，
 *      首先，调用key1所在类的hashCode() 计算key1的哈希值，此哈希值经过某种算法计算（ hash & length-1）以后，得到在Entry数组中存储的位置，
 *          如果此位置上的数据为空，此时 key1-value1 添加成功     ----情况1
 *          如果此位置上的数据不为空，（意味着此位置上存在一个或多个数据（以链表形式存在）），比较key1和已存在的一个或多个数据
 *          的哈希值：
 *                  如果key1与存在的所有数据的哈希值都不同，此时key1 添加成功   ----情况2
 *                  如果key1和已存在的某个数据（key2-value2）的哈希值相同，继续比较：调用key1所在类的equals()，比较：
 *                          如果equals()返回false：此时 key1-value1添加成功。  ----情况3
 *                          如果equals()返回true：使用value1替换为key2的value2值    ----修改功能
 *
 *          补充：关于情况2和情况3： 此时的key1-value1 和原来的数据以链表的方式存储
 *          在不断地添加过程中，会涉及到扩容问题，当超出临界值(且要存放的位置非空)时，扩容。默认扩容方式：扩容为原来的2倍，并将原有数据复制
 *
 *      jdk 8 相较于jdk 7在底层实现方面的不同：
 *          1 . new HashMap()：底层没有立即创建长度16的数组
 *          2 . jdk 8的底层数组是： Node[] ，而不是Entry[]，但功能相同
 *          3 . 首次调用put()方法时，底层才创建数组
 *          4 . jdk 7 底层结构只有： 数组+链表  jdk 8底层结构： 数组+链表+红黑树。
 *            4.1 在形成链表时，七上八下（jdk7新的元素指向旧的，jdk8旧的指向新的）
 *            4.2 当数组的某一索引位置上的元素以链表形式存在的个数 > 8 且当前数组的长度 > 64时，此时该索引位置上的所有数据改为红黑树存储
 *
 *      HashMap源码中的重要常量：
 *      DEFAULT_INITIAL_CAPACITY : HashMap的默认容量，16
 *      DEFAULT_LOAD_FACTOR：HashMap的默认加载因子： 0.75
 *     threshold：扩容的临界值，=容量*填充因子  :16*0.75 =>12
 *      TREEIFY_THRESHOLD：Bucket中链表长度大于该默认值，转化为红黑树 :8
 *      MIN_TREEIFY_CAPACITY：桶中的Node被树化时最小的hash表容量 :64
 *
 *   四、LinkedHashMap的底层实现原理：
 *      源码中：
 *          static class Entry<K,V> extends HashMap.Node<K,V> {
 *         Entry<K,V> before, after;    //能够记录添加元素的先后顺序
 *         Entry(int hash, K key, V value, Node<K,V> next) {
 *             super(hash, key, value, next);
 *         } }
 *
 *   五、 Map的常用方法：
         添加、删除、修改操作：
                 Object put(Object key,Object value)：将指定key-value添加到(或修改)当前map对象中
                 void putAll(Map m):将m中的所有key-value对存放到当前map中
                 Object remove(Object key)：移除指定key的key-value对，并返回value
                 void clear()：清空当前map中的所有数据
         元素查询的操作：
                 Object get(Object key)：获取指定key对应的value
                 boolean containsKey(Object key)：是否包含指定的key
                 boolean containsValue(Object value)：是否包含指定的value
                 int size()：返回map中key-value对的个数
                 boolean isEmpty()：判断当前map是否为空
                 boolean equals(Object obj)：判断当前map和参数对象obj是否相等
         元视图操作的方法：
                  Set keySet()：返回所有key构成的Set集合
                 Collection values()：返回所有value构成的Collection集合
                 Set entrySet()：返回所有key-value对构成的Set集合
 *
 *     总结：常用方法：
 *     添加：put(Object key,Object value)
 *     删除：remove(Object key)
 *     修改：put(Object key,Object newValue)
 *     查询：get(Object key)
 *     长度：size()
 *     遍历：keySet()、values()、entrySet()
 *
 *
 * @author Freak-W
 * @create 2021-05-09 12:08
 */
public class MapTest {

/*     添加、删除、修改操作：
 Object put(Object key,Object value)：将指定key-value添加到(或修改)当前map对象中
 void putAll(Map m):将m中的所有key-value对存放到当前map中
 Object remove(Object key)：移除指定key的key-value对，并返回value
 void clear()：清空当前map中的所有数据*/
    @Test
    public void test1(){
        HashMap map=new HashMap();
        //添加
        map.put(1,new Person(" 德玛西亚之力 ",450,58));
        map.put(2,new Person(" 疾风剑豪 " ,6300,45));
        map.put(3,new Person(" 盲僧 ",4800,55));
        //修改
        map.put(2,"托儿所");
        System.out.println(map);


        HashMap map1=new HashMap();
        map1.put(4,new Person(" 暗裔剑魔 ",6300,65));
        map1.put(5,new Person("复仇之矛",6300,1));

        //    void putAll(Map m):将m中的所有key-value对存放到当前map中
        map.putAll(map1);
        System.out.println(map);

        //    Object remove(Object key)：移除指定key的key-value对，并返回value
        System.out.println(map.remove(2));
        System.out.println(map.remove("ss"));  //null
        System.out.println(map);

        //    void clear()：清空当前map中的所有数据
//        map1.clear(); //与map=null 不同
//        System.out.println(map1);

        Person p1=new Person(" 德邦总管 ",3150,60);
        map.put(6,new Person(" 青钢影 ",6300,1));

    }



/*  元素查询的操作：
       Object get(Object key)：获取指定key对应的value
       boolean containsKey(Object key)：是否包含指定的key
       boolean containsValue(Object value)：是否包含指定的value
       int size()：返回map中key-value对的个数
       boolean isEmpty()：判断当前map是否为空
       boolean equals(Object obj)：判断当前map和参数对象obj是否相等*/
    @Test
    public void test2(){
        HashMap map=new HashMap();
        map.put(1,new Person(" 德玛西亚之力 ",450,58));
        map.put(2,new Person(" 疾风剑豪 " ,6300,45));
        map.put(3,new Person(" 盲僧 ",4800,55));
        map.put(4,new Person(" 暗裔剑魔 ",6300,65));
        map.put(5,new Person("复仇之矛",6300,61));

        Person p1=new Person(" 德邦总管 ",3150,60);
//        Person p2=new Person("复仇之矛",6300,61);
//        map.put(6,p2);
        System.out.println(map);

        //    Object get(Object key)：获取指定key对应的value
        System.out.println(map.get(2));

        //    boolean containsKey(Object key)：是否包含指定的key
        System.out.println(map.containsKey(66)); //false

        //    boolean containsValue(Object value)：是否包含指定的value
        System.out.println(map.containsValue(p1));
        System.out.println(map.containsValue(new Person("复仇之矛", 6300, 61)));  //true，需要重写equals() 和 hashCode()

        //    int size()：返回map中key-value对的个数
        System.out.println(map.size());

        //    boolean isEmpty()：判断当前map是否为空
        System.out.println(map.isEmpty());

        //    boolean equals(Object obj)：判断当前map和参数对象obj是否相等
        map.equals(p1);

    }



/*  元视图操作的方法：
      Set keySet()：返回所有key构成的Set集合
      Collection values()：返回所有value构成的Collection集合
      Set entrySet()：返回所有key-value对构成的Set集合*/
   @Test
   public void test3(){
       HashMap map=new HashMap();
       map.put(1,new Person(" 德玛西亚之力 ",450,58));
       map.put(2,new Person(" 疾风剑豪 " ,6300,45));
       map.put(3,new Person(" 盲僧 ",4800,55));
       map.put(4,new Person(" 暗裔剑魔 ",6300,65));
       map.put(5,new Person("复仇之矛",6300,61));

       //      Set keySet()：返回所有key构成的Set集合
       Set set1=map.keySet();
       Iterator iterator=set1.iterator();
       while(iterator.hasNext()){
           System.out.println(iterator.next());
       }

       //      Collection values()：返回所有value构成的Collection集合
       Collection values=map.values();
       for(Object obj :values){
           System.out.println(obj);
       }

       //      Set entrySet()：返回所有key-value对构成的Set集合
       //遍历所有的key-value 方式一：entrySet()
       Set set2=map.entrySet();
       Iterator iterator1 = set2.iterator();
       while(iterator1.hasNext()){
           Object obj=iterator1.next();
           Map.Entry entry=(Map.Entry)obj;
           System.out.println(entry.getKey() +" ---> "+  entry.getValue());
       }
       //方式二：
       Set keySet=map.keySet();
       Iterator iterator2=keySet.iterator();
       while(iterator2.hasNext()){
           Object key = iterator2.next();
           Object value=map.get(key);
           System.out.println(key+ "---> " +value);
       }

   }


}

class Person implements Comparable{
    String name;
    //价格
    int price;
    //攻击力
    double attack;

    public Person(){
    }
    public Person(String name,int price,double attack){
        this.name=name;
        this.price=price;
        this.attack=attack;
    }






    public String toString(){
        return "name: "+name+" ,price: "+price+" ,attack: "+attack;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return price == person.price && Double.compare(person.attack, attack) == 0 && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, attack);
    }

    public int compareTo(Object obj){
        if(obj instanceof Person){
            Person per1=(Person)obj;

            int number1=this.name.compareTo(per1.name);
            if(number1!=0){
                return number1;
            }else{
                int numberPrice=this.price-per1.price;
                if(numberPrice!=0){
                    return numberPrice;
                }else{
                    return (int)(10*(this.attack-per1.attack));
                }
            }

        }else{
            throw new RuntimeException("数据类型不匹配！");
        }

    }

}