package javasm.java3;

/*
 * 面向对象的特性之 二 ：继承性
 * 
 * 一、继承性的好处：
 * 	①减少代码的冗余，提高了代码的复用性。
 * 	②便于功能的扩展
 * 	③为之后的多态性的使用，提供了前提
 * 
 * 
 * 二、继承性的格式：class A extends B{}
 * 		A：子类、派生类、subclass
 * 		B：父类、超类、基类、superclass
 * 
 * 		2.1 体现：一旦子类A继承了父类B以后，子类A就获取了父类B中声明的所有结构：属性、方法
 * 			特别的：父类中声明为private的属性或方法，子类继承父类以后，只是由于封装性的影响，无法直接调用
 * 		2.2 子类继承父类以后，还可以声明自己特有的结构：实现功能的拓展。
 * 		extends：延展、扩展
 * 
 * 三、Java中关于继承性的规定：
 * 		1.一个类可以被多个子类继承。
 * 		2.类的单继承性：一个类只能有一个父类，不同于c++
 * 		3.多层继承：子父类是相对的概念。
 * 		4.子类直接继承的父类，称为：直接父类。 间接继承的父类称为： 间接父类
 * 		5.子类继承父类以后，就获取了直接父类以及所有间接父类中声明的属性和方法
 * 
 * 四、	1.如果我们没有显式的声明一个类的父类，则此类继承于java.lang.Object类
 * 		2.	所有的java类（除Object本身）都直接或间接的继承与java.lang.Object类
 * 				意味着，所有的java类都具有java.lang.Object类声明的功能。
 *
 */
public class ExtendsTest {
	public static void main(String[]args){
		
		Person p1=new Person();
		p1.setAge(22);
		p1.eat();
		System.out.println("*******************************************");
		
		Student s1=new Student();
		s1.getAge();
		s1.eat();
//		s1.sleep();
		s1.breath();
		Creature c=new Creature();
		System.out.println(c.toString());
	}
}


class Creature {

	Person[] p1=new Person[10];

	String[]arr1=new String[5];

	public void breath(){
		System.out.println("呼吸");
	}
	public void getPerson(){
		int length = p1.length;
		System.out.println(p1[0]);
	}
	public void getPerson(Person person){

//		person=p1[0];
//		System.out.println(person.name);
		person.name="laji";
	}
	public void getArray(String s){
		s=arr1[0];
		s=s+"666";
		System.out.println(s);
	}



	public static void main(String[]args){

		Creature test=new Creature();
		System.out.println(test.p1[0]);
		test.getPerson();
		Person c=new Person();
		c.name="dema";

//		test.p1[0]=c;
//		test.getPerson();
//		System.out.println(test.p1[0].name+"\n\n");

		test.getPerson(c);
		test.getPerson();
		System.out.println(c.name);
//		System.out.println(test.p1[0].name);

//		String i="dddd";
//		test.getArray(i);
//		System.out.println(i);
	}
}


class Person extends Creature {

	String name;
	private int age;

	public Person(){

	}
	public Person(String name,int age){
		this.name=name;
		this.age=age;
	}

	public void eat(){
		System.out.println("吃饭");
		sleep();
	}
	private void sleep(){
		System.out.println("睡觉");
	}
	public void setAge(int age){
		this.age=age;
	}
	public int getAge(){
		return age;
	}
}


class Student extends Person {
    //	String name;
//	int age;
    String major;

    public Student(){
    }
    public Student(String name,int age,String major){
        this.name=name;
        this.setAge(age);
        this.major=major;
    }

    //	public void eat(){
//		System.out.println("吃饭");
//	}
//	public void sleep(){
//		System.out.println("睡觉");
//	}
    public void study(){
        System.out.println("学习");
    }

	@Override
	public String toString() {
		return "Student{" +
				"major='" + major + '\'' +
				", name='" + name + '\'' +
				", age=" + this.getAge() +
				'}';
	}

}
