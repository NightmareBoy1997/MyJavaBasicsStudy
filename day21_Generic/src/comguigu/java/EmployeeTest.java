package comguigu.java;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * @author shkstart
 * @create 2021-04-30 12:10
 */
public class EmployeeTest {


    //问题一：按照名字从小到大顺序排序
    @Test
    public void test1(){
        TreeSet<Employee> set=new TreeSet<>();

        set.add(new Employee("tom",23,new MyDate(1997,7,1)));
        set.add(new Employee("tom",23,new MyDate(1997,6,19)));
        set.add(new Employee("tom",24,new MyDate(1997,7,1)));
        set.add(new Employee("jack",26,new MyDate(1995,6,13)));
        set.add(new Employee("jetj",33,new MyDate(1988,5,24)));

        Iterator<Employee> iterator=set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }

    //问题二：按照出生日期生日从小到大排序
    @Test
    public void test2(){
        TreeSet<Employee> set=new TreeSet<>(new Comparator<Employee>() {
            @Override
            public int compare(Employee e1, Employee e2) {

                    MyDate date1=e1.getBirthday();
                    MyDate date2=e2.getBirthday();

                    //方式一：
//                    //比较年
//                    int numberYear =date1.getYear() - date2.getYear();
//                    if (numberYear != 0) {
//                        return numberYear;
//                    } else {
//                        //比较月
//                        int numberMonth = date1.getMonth() - date2.getMonth();
//                        if (numberMonth != 0) {
//                            return numberMonth;
//                        } else {
//                            //比较日
//                            int numberDay = date1.getDay() - date2.getDay();
//                            if (numberDay != 0) {
//                                return numberDay;
//                            } else {
//                                //比较年龄
//                                int number = emp1.getAge() - emp2.getAge();
//
//                                if (number != 0) {
//                                    return number;
//
//                                } else {
//                                    //比较名字
//                                    int number1 = emp1.getName().compareTo(emp2.getName());
//                                    return number1;
//                                }
//
//                            }
//                        }
//                    }

                //方式二：
                    return date1.compareTo(date2);
                }

        });

        set.add(new Employee("tom",23,new MyDate(1997,7,1)));
        set.add(new Employee("tom",23,new MyDate(1997,6,19)));
        set.add(new Employee("tom",24,new MyDate(1997,7,1)));
        set.add(new Employee("jack",26,new MyDate(1995,6,13)));
        set.add(new Employee("jetj",33,new MyDate(1988,5,24)));

        Iterator<Employee> iterator=set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }

}
