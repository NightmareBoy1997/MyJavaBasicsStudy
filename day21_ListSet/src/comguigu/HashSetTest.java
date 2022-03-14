package comguigu;

import org.junit.jupiter.api.Test;

import java.util.HashSet;

/**
 * @projectName: MyJavaStudy
 * @package: comguigu
 * @author: Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-02-23 22:09
 */
public class HashSetTest {


    // 面试题
    @Test
    public void test() {


        HashSet set = new HashSet();
        Person2 p1 = new Person2(1001, "AA");
        Person2 p2 = new Person2(1002, "BB");
        set.add(p1);
        set.add(p2);
        p1.name = "CC";
        set.remove(p1);
        System.out.println(set);
        set.add(new Person2(1001, "CC"));
        System.out.println(set);
        set.add(new Person2(1001, "AA"));
        System.out.println(set);
    }
}



class Person2 {

    int age;
    String name;

    public Person2() {
    }
    public Person2(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person2 person2 = (Person2) o;

        if (age != person2.age) return false;
        return name != null ? name.equals(person2.name) : person2.name == null;
    }

    @Override
    public int hashCode() {
        int result = age;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

}