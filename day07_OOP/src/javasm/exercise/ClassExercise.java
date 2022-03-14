package javasm.exercise;

/**
 * @projectName: MyJavaStudy
 * @package: javasm.exercise
 * @author: Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-02-15 17:13
 *
 * 	作业2
 * 	描述一个学生类，学生具备姓名、学号、性别、三个公共的属性，学生都具备吃饭与学习的行为。
 * 	测试类中为学生类的属性赋值、调用学生的方法
 * 	描述一个电脑类，具有属性：cpu，网卡，显卡，声卡，内存 方法：上网
 * 	描述学生拥有一台电脑
 *
 */
public class ClassExercise {

    public static void main(String[] args) {

        Student student = new Student("xdd",1001,"男",
                new Computer("华硕天选2","R7-5950X" , "Inter I350-T4BLK" ,
                        "华硕Xonar D-Kara" , "Rtx3090Ti" , "sn980")) ;

        System.out.println(student.show());

    }

}


class Student{

    String name ;
    int id ;
    String gender;
    Computer computer;

    public Student() {
    }

    public Student(String name, int id, String gender,Computer computer) {
        this.name = name;
        this.id = id;
        this.gender = gender;
        this.computer = computer;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", gender='" + gender + '\'' +
                ", computer=" + computer +
                '}';
    }

    public String show(){
        return "我 【 " +
                "名字： " + name +
                " , 学号： " + id +
                " , 性别： " + gender +
                " 】在用我的电脑： " + computer.name +
                "\n" + computer.play() ;
    }
}

class Computer{
    // 型号
    String name;
    // 处理器
    String cpu ;
    // 网卡
    String networkCard ;
    // 声卡
    String soundCard;
    // 显卡
    String gpu ;
    // 内存
    String memory;

    public Computer(){
    }
    public Computer(String name , String cpu, String networkCard, String soundCard, String gpu, String memory) {
        this.name = name;
        this.cpu = cpu;
        this.networkCard = networkCard;
        this.soundCard = soundCard;
        this.gpu = gpu;
        this.memory = memory;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "name='" + name + '\'' +
                ", cpu='" + cpu + '\'' +
                ", networkCard='" + networkCard + '\'' +
                ", soundCard='" + soundCard + '\'' +
                ", gpu='" + gpu + '\'' +
                ", memory='" + memory + '\'' +
                '}';
    }

    public String play(){
        return cpu + "\t" +  gpu + "\t" + networkCard  + "\t"
                + soundCard + "\t" + memory + "\n打CSGO ，4K 360HZ 非常流畅！" ;
    }

}

