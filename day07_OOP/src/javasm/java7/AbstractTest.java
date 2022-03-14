package javasm.java7;
/*
 * abstract关键字的使用
 * 
 *  1. abstract：抽象的
 *  2. abstract可以用来修饰的结构：类、方法
 * 
 *  3. abstract修饰类：抽象类
 *  		> 此类不能实例化。
 *  		> 抽象类一定有构造器，便于子类实例化时调用（涉及：子类对象实例化的全过程）
 *  		> 开发中，都会提供抽象类的子类，让子类对象实例化，完成相关操作。 --> 抽象的适用前提： 继承性
 * 
 *  4. abstract修饰方法：抽象方法
 *  		> 抽象方法只有方法的声明，没有方法体。
 *  		> 包含抽象方法的类，一定是抽象类。反之，抽象类不一定有抽象方法
 *  		> 若子类重写了父类的所有抽象方法，此子类才可以实例化。
 *  			如果子类没有都重写所有方法，此子类也是抽象类，需要abstract修饰。
 * 
 * 
 *  abstract使用的注意事项：
 *   1. abstract不能用来修饰：属性、构造器、代码块等结构
 *   2. abstract不能用来修饰私有方法、静态方法、final的方法、final的类
 * 
 */
public class AbstractTest {
	public static void main(String[]args){
	//一旦类抽象了，就不可以实例化
//	Person p1=new Person();
//	p1.eat();
		
		
	}
}

abstract class Creature{
	public abstract void breath();
}


abstract class Person extends Creature{
	String name;
	int age;
	
	public Person(){
		
	}
	public Person(String name,int age){
		this.name=name;
		this.age=age;
	}

	//不是抽象方法
//	public void eat(){
//		
//	}
	public abstract void eat(); 	//抽象方法
	
	public void walk(){
		System.out.println("人走路！");
	}		
	public void sleep(){
		System.out.println("人睡觉！");
	}
}


class Student extends Person {
	
	public Student(){
		super();
	}
	
	//抽象方法被继承！！
	public  void eat(){
		System.out.println("学生吃饭!");
	}
	
	//父类的父类抽象方法
	public void breath(){
		System.out.println("学生应该呼吸新鲜的没有雾霾的空气！");
	}
	public void sleep(){
		System.out.println("睡觉！");
	}

	
}