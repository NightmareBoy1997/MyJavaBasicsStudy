package comguigu.java;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

/**
 * @author shkstart
 * @create 2021-04-30 13:01
 */
public class Exercise {

        //练习一：在list内去除重复数字，要求简单 (自定义类元素需要类重写hashCode() )
        public static List duplicateList(List list) {
            HashSet set = new HashSet();
            set.addAll(list);
            return new ArrayList(set);
        }

        @Test
        public void test1() {
            List list = new ArrayList();
            list.add(new Integer(1));
            list.add(new Integer(2));
            list.add(new Integer(2));
            list.add(new Integer(4));
            list.add(new Integer(4));
            List list2 = duplicateList(list);
            for (Object integer : list2) {
                System.out.println(integer);
            }
        }

        @Test
        public void test2(){

            HashSet set = new HashSet();
            Person p1 = new Person(1001,"AA");
            Person p2 = new Person(1002,"BB");
            set.add(p1);
            set.add(p2);
            p1.name = "CC";
            System.out.println(set);

            set.remove(p1);
            System.out.println(set);
            set.add(new Person(1001,"CC"));
            System.out.println(set);

            System.out.println(set);
            set.add(new Person(1001,"AA"));
            System.out.println(set);
        }



    class   Person{

        String name;
        int id;

        Person(){
        }
        Person(int id,String name){
            this.name=name;
            this.id=id;
        }

        public void eat(){
            System.out.println("人吃饭！");
        }
        public void sleep(){
            System.out.println("人睡觉！");
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", id=" + id +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Person person = (Person) o;
            return id == person.id && Objects.equals(name, person.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, id);
        }
    }






}
