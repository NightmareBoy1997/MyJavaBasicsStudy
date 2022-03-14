package Study;

/**
 * @author Freak-W
 * @create 2021-10-19 16:25
 */
public class Person {

    public int age;
    private String name;

    public Person(){
        System.out.println("调用了 Person的空参构造器 ");
    }

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    private Person(int age){
        this.age=age;

    }


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    public void show(String file){
        System.out.println("你好，我是一个"+file);
    }

    private String showNation(String nation){

       return "i'm from "+nation;

    }


}
