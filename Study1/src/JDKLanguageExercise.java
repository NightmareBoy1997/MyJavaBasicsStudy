/**
 * @author Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-02-09 17:04
 *
 *
 * 5.作业
 * 1.不利用Integer.parseInt()方法将一个给定的字符串转变为Int型数值,并检测自己实现的方法和Integer.parseInt()的性能差距。
 *  2.编写一个Student类，包含name、age等属性，要求使用System.out.println()打印Student类的对象引用时，输出的为name的值！
 *
 */
public class JDKLanguageExercise {

    public static void main(String[] args) {

//1.不利用Integer.parseInt()方法将一个给定的字符串转变为Int型数值,并检测自己实现的方法和
// Integer.parseInt()的性能差距。
        String str = "abc1234ab6j7k8";

        StringBuilder stringBuilder = new StringBuilder();
        char[] array1 = str.toCharArray();
        for(int i= 0 ; i<array1.length ; i++){
            if(Character.isDigit(array1[i])){
                int number = (int) array1[i];
                stringBuilder.append(number);
            }
        }

//        Integer number =(Integer)stringBuilder;

        //使用Integer.parseInt()方式
//        System.out.println(Integer.parseInt(str)); //包含字符类型，报错



        // 2.
        Student student1 = new Student("tom" , 19 , 1001 , 88.8);
        System.out.println(student1.getName());


    }

}

 class Student{
    // 2.编写一个Student类，包含name、age等属性，要求使用System.out.println()打印Student类的对象引用时，输出的为name的值！
    private String name;
    private int age;
    private int id;
    private double score;

    public Student(){

    }
    public Student(String name,int age,int id , double score){
        super();
        this.name = name;
        this.age = age;
        this.id = id;
        this.score = score;
    }

    public String getName(){
        return name;
    }

}