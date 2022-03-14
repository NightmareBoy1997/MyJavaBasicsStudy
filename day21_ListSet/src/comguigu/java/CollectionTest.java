package comguigu.java;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * 一、集合框架的概述
 *
 *   1. 集合、数组都是对多个数据进行存储的结构，简称java容器。
 *        说明：此时的存储，主要是指内存层面的存储，不涉及持久化的存储(.txt, .jpg, .mp4 ,数据库)
 *   2.1 数组存储数据的特点：
 *         > 一旦初始化，长度就确定了
 *         > 数组一旦定义完成，其元素的类型就已经确定了。只能存储指定类型的数据及其子类
 *   2.2 数组存储数据的缺点：
 *          > 初始化以后长度就无法修改
 *          > 数组中提供的方法非常有限，对于添加、删除、插入数据等操作，非常不便，同时效率不高。
 *          > 获取数组的实际元素的个数，数组没有现成的属性或方法可用
 *          > 数组存储的特点： 有序、可重复。对于无序、不可重复的需求，不能满足。
 *
 * 二、集合框架：
 *      |----Collection接口：单列集合，用来存储一个一个的对象
 *          |----List接口：存储有序的、可重复的数据。 -->“动态”数组
 *               |----ArrayList、LinkedList、Vector
 *
 *          |----Set接口：存储无序的、不可重复的数据  -->“数学集合”
 *               |----HashSet、LinkedHashSet、TreeSet
 *
 *      |----Map接口：双列集合，用来存储一对(key-value)一对的数据  -->函数：y=f(x)，可以多对一
 *          |----HashMap、LinkedHashMap、TreeMap、Hashtable、Properties
 *
 * 三、Collection接口中的方法的使用
 *
 *      结论：
 *      向Collection接口的实现类的对象中添加数据obj时，要求obj所在的类重写equals()
 *
 *
 *
 *
 * @author Freak-W
 * @create 2021-04-07 15:28
 */
public class CollectionTest {

    @Test
    public void test1(){
        Collection coll=new ArrayList();

        //1. add(Object e);    将元素e添加到集coll合中
        coll.add("AA");
        coll.add("家");
        coll.add(123);//自动装箱
        coll.add(new Date());

        //2. size();       获取添加元素的个数
        System.out.println(coll.size());//5

        //3. addAll();     (Collection coll1):将coll1集合的元素添加到当前集合中
        Collection coll1=new ArrayList();
        coll1.add("ert");
        coll1.add("234");
        coll1.add("沙漠之鹰");
        coll.addAll(coll1);
        System.out.println(coll.size());
        System.out.println(coll);

        //4. clear()   清空集合元素
        coll.clear();
        System.out.println(coll);


        //5. isEmpty():    判断集合是否为空
        System.out.println(coll.isEmpty());
        System.out.println("*****************************");


    }

    @Test
    public void test2(){
        Collection coll=new ArrayList();
        coll.add(123);
        coll.add(545);
        coll.add(new String("tom"));
        coll.add(123);

//        Person p=new Person("tom",23,184.99);
//        coll.add(p);
        coll.add(new Person("tom",23,184.99));
        coll.add(false);

        //6. contains(Object obj):     判断当前集合是否包含Obj
        //我们在判断时，会去调用obj对象所在类的equals()
        boolean contains=coll.contains(123);
        System.out.println(contains);

        System.out.println(coll.contains(new String("tom")));
        System.out.println(coll.contains(new Person("tom",23,184.99))); //false 没有重写equals方法

        //7. containsAll(Collection coll1):     判断形参对应的coll1中的所有元素是否都存在于当前集合中
        Collection coll1= Arrays.asList(123,545);
        System.out.println(coll.containsAll(coll1));

        //8. remove():      从当前集合中移除obj元素
        System.out.println(coll);
        coll.remove(123);
        coll.remove(new Person("tom",23,184.99));
        System.out.println(coll);

        //9. removeAll()：   差集：从当前集合中移除coll1中的所有元素
        Collection coll2=Arrays.asList(123,545,5454545);
        coll.removeAll(coll2);
        System.out.println(coll);


        //10. retainAll(Collection coll1):      交集：保留当前集合和coll1集合的交集
        coll.retainAll(coll2);
        System.out.println(coll);


    }

    @Test
    public void test3(){
        Collection coll=new ArrayList(); //ArrayList是有序的
//        coll.add(123);
        coll.add(456);
        coll.add(123);
        coll.add(new String("jack"));
        coll.add(new Person("tom",23,184.99));

        Collection coll1=Arrays.asList(123,456,new String("jack"),new Person("tom",23,184.99));


        //11. equals(Object obj):     判断当前集合和形参集合的元素是否都相同 。 ArrayList是有序的，内容一样顺序不一样，也为false
        System.out.println(coll.equals(coll1));


        //12. hashCode():       返回当前对象的哈希值
        System.out.println(coll.hashCode());


        //13. 集合-->数组：toArray()
        Object [] arr=coll.toArray();
        System.out.println(Arrays.toString(arr));

        //数组-->集合： 调用Arrays类的静态方法asList(); 返回只读集合，无法修改
        List<Object> list = Arrays.asList("aa","bb","cc");
        System.out.println(list);

        List list1=Arrays.asList(new int[]{1,2,3,4});
        System.out.println(list1); //[[I@78e03bb5]  默认把int数组作为一个元素
        System.out.println(list1.size()); //1

        List list2=Arrays.asList(new Integer[]{1,2,3,4});
        System.out.println(list2); //[1, 2, 3, 4]
        System.out.println(list2.size()); //4


        //14. iterator():       返回Iterator接口的实例，用于遍历集合元素。放在IteratorTest.java中测试


    }




}





@Data
@AllArgsConstructor
@NoArgsConstructor
class Person implements Comparable {

    private String name;
    private int age;
    private double height;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", height=" + height +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        System.out.println("Person.equals()……");
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age &&
                Double.compare(person.height, height) == 0 &&
                Objects.equals(name, person.name);
    }

    //按照姓名从小到大排序
    @Override
    public int compareTo(Object o) {
        if(o instanceof Person){
            Person per=(Person)o;
//                return this.name.compareTo(per.name);
            int number=this.name.compareTo(per.name);
            if(number!=0){
                return number;
            }else{
                int number1=this.age-per.age;
                if(number1!=0){
                    return number1;
                }else{
                    return (int)(100*(this.height-per.height));
                }
            }
        }else{
            throw new RuntimeException("输入的类型不匹配！");
        }
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, age, height);
    }

}
