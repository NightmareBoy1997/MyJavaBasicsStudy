package comguigu.bean;

import org.junit.jupiter.api.Test;

/**
 * @projectName: MyJavaStudy
 * @package: comguigu.bean
 * @author: Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-02-14 16:37
 */
public class Person {


    @Test
    public void aaaa(){

    }
    private String name ;
    private int id ;

    public Person() {
    }
    public Person(String name, int id) {
        this.name = name;
        this.id = id;
    }


    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public void test(){
        String str  = "sfsa";
    }


}

