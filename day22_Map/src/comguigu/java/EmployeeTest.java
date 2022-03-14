package comguigu.java;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author shkstart
 * @create 2021-04-30 12:10
 */
public class EmployeeTest {


    //问题一：按照名字从小到大顺序排序
    @Test
    public void test1(){
        Set set=new TreeSet();

        set.add(new Employee("tom",23,new MyDate(1997,7,1)));
        set.add(new Employee("tom",23,new MyDate(1997,6,19)));
        set.add(new Employee("tom",24,new MyDate(1997,7,1)));
        set.add(new Employee("jack",26,new MyDate(1995,6,13)));
        set.add(new Employee("jetj",33,new MyDate(1988,5,24)));

        Iterator iterator=set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }

    //问题二：按照出生日期生日从小到大排序
    @Test
    public void test2(){
        Set set=new TreeSet(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof Employee && o2 instanceof Employee) {
                    Employee emp1 = (Employee) o1;
                    Employee emp2 = (Employee) o2;
                    MyDate date1=emp1.getBirthday();
                    MyDate date2=emp2.getBirthday();

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
                } else {
                    throw new RuntimeException("传入的数据类型不匹配！");
                }
            }

        });

        set.add(new Employee("tom",23,new MyDate(1997,7,1)));
        set.add(new Employee("tom",23,new MyDate(1997,6,19)));
        set.add(new Employee("tom",24,new MyDate(1997,7,1)));
        set.add(new Employee("jack",26,new MyDate(1995,6,13)));
        set.add(new Employee("jetj",33,new MyDate(1988,5,24)));

        Iterator iterator=set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }

}




class Employee implements Comparable{

    private String name;
    private int age;
    private MyDate birthday;

    public Employee(){
    }
    public Employee(String name,int age,MyDate birthday){
        this.age=age;
        this.name=name;
        this.birthday=birthday;
    }

    public int getAge(){
        return age;
    }
    public void setAge(int age){
        this.age=age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MyDate getBirthday() {
        return birthday;
    }

    public void setBirthday(MyDate birthday) {
        this.birthday = birthday;
    }

    public String toString(){
        return "[ name: "+name+", age: "+age+",birthday: "+birthday+" ]";
    }


    public int compareTo(Object obj){
        if(obj instanceof Employee){
            Employee objdate=(Employee)obj;
            int number=this.name.compareTo(objdate.name);

            if(number!=0){
                return number;
            }else{
                int number1=this.age-objdate.age;

                if(number1!=0){
                    return number1;
                }else{
                    return 0;
                }

            }


        }else{
            throw new RuntimeException("传入的数据类型不匹配！");
        }
    }

}


class MyDate implements Comparable{
    private int year;
    private int month;
    private int day;

    public MyDate(){
    }

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return "MyDate{" +
                "year=" + year +
                ", month=" + month +
                ", day=" + day +
                '}';
    }

    public int compareTo(Object obj){
        if(obj instanceof MyDate){
            MyDate date1=(MyDate)obj;

            //比较年
            int numberYear =this.year - date1.year;
            if (numberYear != 0) {
                return numberYear;
            } else {
                //比较月
                int numberMonth = this.month - date1.month;
                if (numberMonth != 0) {
                    return numberMonth;
                } else {
                    //比较日
                    int numberDay = this.day - date1.day;
                    return numberDay;
                }
            }


        }else{
            throw new RuntimeException("传入的数据类型不匹配！");
        }

    }

}
