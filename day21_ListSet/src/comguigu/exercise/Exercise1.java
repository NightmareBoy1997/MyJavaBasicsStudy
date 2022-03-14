package comguigu.exercise;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * @projectName: MyJavaStudy
 * @package: comguigu.exercise
 * @author: Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-02-23 21:17
 */
public class Exercise1 {

/*
1. 定义一个 Employee 类。该类包含：private 成员变量 name,age,birthday，
其中 birthday 为MyDate 类的对象；并为每一个属性定义 getter, setter 方法；
并重写 toString 方法输出 name, age, birthday
MyDate 类包含:private 成员变量 year,month,day；并为每一个属性定义 getter, setter 方法；
创建该类的 5 个对象，并把这些对象放入 TreeSet 集合中（下一章：java.util.TreeSet 需使用泛型来定义）
分别按以下两种方式对集合中的元素进行排序，并遍历输出：
1).使 Employee 实现 Comparable 接口，并按 name 排序
2). 创建 TreeSet 时传入 Comparator 对象，按生日日期的先后排
*/


//        1).使 Employee 实现 Comparable 接口，并按 name 排序
//        2). 创建 TreeSet 时传入 Comparator 对象，按生日日期的先后排

    public static void main(String[] args) {

        TreeSet<Employee> treeSet = new TreeSet<Employee>();
        treeSet.add(new Employee(22,"m马超",new MyDate(220,4,22)));
        treeSet.add(new Employee(25,"z赵云",new MyDate(198,9,28)));
        treeSet.add(new Employee(33,"z张飞",new MyDate(189,5,9)));
        treeSet.add(new Employee(41,"l刘备",new MyDate(182,2,16)));
        treeSet.add(new Employee(36,"g关羽",new MyDate(186,7,23)));
        treeSet.add(new Employee(58,"h黄忠",new MyDate(179,10,1)));

        Iterator<Employee> iterator = treeSet.iterator();

        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }


        System.out.println("***********************************");

        Comparator<Employee> comparator = Comparator.comparingInt(e -> e.getBirthday().getYear());
        TreeSet<Employee> treeSet1 = new TreeSet(comparator);

        treeSet1.add(new Employee(22,"m马超",new MyDate(220,4,22)));
        treeSet1.add(new Employee(25,"z赵云",new MyDate(198,9,28)));
        treeSet1.add(new Employee(33,"z张飞",new MyDate(189,5,9)));
        treeSet1.add(new Employee(41,"l刘备",new MyDate(182,2,16)));
        treeSet1.add(new Employee(36,"g关羽",new MyDate(186,7,23)));
        treeSet1.add(new Employee(58,"h黄忠",new MyDate(179,10,1)));

        Iterator<Employee> iterator1 = treeSet1.iterator();
        while(iterator1.hasNext()){
            System.out.println(iterator1.next());
        }

    }


}



@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
class Employee implements Comparable<Employee> {
    private int age;
    private String name ;
    private MyDate birthday;

    public int compareTo(Employee employee){

        if(this.name.compareTo(employee.getName()) == 0 ){
            return - Integer.compare(this.age,employee.getAge());
        }
        return this.name.compareTo(employee.getName());
    }


}


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
class MyDate{

    private int year;
    private int month;
    private int day;

}