package Study.java1;

/**
 * @author Freak-W
 * @create 2021-10-20 16:16
 */
@MyAnnotation(value="hi")
public class Person extends Creature<String> implements Comparable<String>,MyInterface{

    private String name;
    int age;
    public int id;

    public Person(){

   }
    @MyAnnotation
   private Person(String name){
        this.name=name;
   }


   Person(String name,int age){
        this.name=name;
        this.age=age;
   }



    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", id=" + id +
                '}';
    }

    @MyAnnotation(value="nation")
   private String show(String nation){
       System.out.println("我的国籍是： "+nation);
        return nation;
   }

    public String display(String interests,int age){
        return interests + age;
    }

    @Override
    public int compareTo(String o) {
        return 0;
    }

    @Override
    public void info() {
        System.out.println("我是一个人！");
    }

    private static void showDesc(){
        System.out.println("Person的私有静态方法");
    }



}
