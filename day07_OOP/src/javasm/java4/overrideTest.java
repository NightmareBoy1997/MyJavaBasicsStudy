package javasm.java4;
/*
 * 方法的重写(override/overwrite)
 * 
 * 	1.重写：子类继承父类以后，可以对父类中同名同参的方法进行覆盖操作。
 * 	
 * 	2.应用：重写以后，子类的对象在程序执行时，子类的方法将覆盖父类的方法(即实际执行的是子类重写过父类的方法)。
 * 
 *  3.重写的规定：
 *  		方法的声明：权限修饰符 返回值类型 方法名（形参列表）{
 *  					//方法体
 *  				}
 * 			约定俗称：子类中的叫重写的方法，父类中的叫被重写的方法
 * 		   ① 子类重写的方法的方法名和形参列表与父类被重写的相同
 * 		   ② 子类重写的方法的权限修饰符不小于父类被重写的
 * 				>特殊的：子类中不能重写父类中声明为private权限的方法
 * 		   ③ 返回值类型：
 * 				>父类被重写的方法的返回值是void，则子类的重新方法的返回值只能是void
 * 				>父类被重写的方法的返回值是A类型，则子类的重写方法的返回值可以是A类或A类的子类
 * 				>父类被重写的方法的返回值是基本数据类型（比如：int），则子类的重写方法的返回值必须是相同的基本数据类型（必须是int）
 *
 * 		   ④ 子类重写的方法抛出的异常类型 不大于 父类被重写方法抛出的异常类型（异常处理）
 * 		*****************************************************************************************
 * 			  子类和父类中的同名同参数的方法 要么都声明是非static（考虑重写），要么都声明是static的（不是重写）
 * 				>static方法不可以被重写
 * 
 */

public class overrideTest {
	public static void main(String[]args){
		
		Student test=new Student();
		test.major="化学";
		
		test.study();
		test.eat();
		test.walk(11);
		test.sleep();
		test.show();
	}
}



class Student extends Person2{

	String major;

	private int age;

	public Student(){

	}
	public Student(String major){
		this.major=major;
	}

	public void study(){
		System.out.println("学习,专业是： "+major);
	}

	//对父类的eat（）方法进行了重写
	public static void eat(){
		System.out.println("学生要多吃辣条");
	}

	//不构成重写
	public void show(){
		System.out.println("我是一个学生");
	}

	//返回值类型是父类的返回值类型A或A的子类
	public String info(){
		return null;
	}

	//报错,基本数据类型没有子类，子类只能返回一致的类型
//	public int info1(){
//		return 2;
//	}

//	public String go(){
//		return super.major;
//	}

}



class Person2 {

	String name;
	int age;

	public Person2(){

	}
	public Person2(String name,int age){
		this.name=name;
		this.age=age;
	}

	public static void eat(){
		System.out.println("吃饭");
	}
	public void sleep(){
		System.out.println("睡觉");
	}
	public void walk(int ditance){
		System.out.println("走路走了 "+ditance+"公里" );
		show(); //private私有方法
		eat();
	}

	private void show(){
		System.out.println("我是一个人");
	}

	public Object info(){
		return null;
	}

	public double info1(){
		return 1.0;
	}

}
