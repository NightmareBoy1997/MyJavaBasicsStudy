package javasm.java4;
/*
 * super关键字的使用
 * 	1. super理解为： 父类的……
 * 	2. super可以用来调用：属性、方法、构造器
 * 
 *  3. super的使用
 *  
 * 		3.1 我们在子类的方法或构造器中，通过使用“super.属性”或“super.方法”的方式，显式的调用父类中的属性或方法
 * 		但是与“this”同理，通常情况下会省略“super”。  
 * 					只有当子类和父类中定义了同名的属性或方法时，我们需要调用父类的属性或方法，则必须显式的使用
 * 		“super.”的方式，调用父类的属性或方法。
 * 
 *  4. super调用构造器
 * 		4.1 我们可以在子类的构造器中显式的使用“super（形参列表）”的方式，调用父类中声明的构造器
 * 		4.2 “super（形参列表）”的使用 与“this（形参列表）”重载构造器的调用相同，必须声明在子类构造器的首行！
 * 		4.3 我们在类的构造器中，“this（形参列表）”或“super（形参列表）” 只能二选一，不能同时出现！
 * 		4.4 如果构造器的首行没有显式的声明“this（形参列表）”或“super（形参列表）”，则默认调用的是
 * 		父类的空参构造器：super（）
 * 		4.5	在类的构造器中，至少有一个类的构造器使用“super（形参列表）”，调用父类的构造器
 * 
 * 		this会先在类自身中查找方法，然后才去父类查找，此时父类的被重写方法无法被执行
 * 
 * 	
 * 
 */
public class SuperTest {

	public static void main(String[]args){
		
		Student5 s1=new Student5("魏魏",22,"搬砖");
		s1.show();
		System.out.println("*********************************************");
		s1.show(1);
		System.out.println(s1.id);
		
		Student5 s2=new Student5(); //默认有一个 super（）
		
		Person5 s3=new Student5() ;
		s3.eat();
		System.out.println(s3.id);

	}
}



class Student5 extends Person5{

	String major;
	int id=super.id+1002;

	public Student5(){
	}
	public Student5(String major){
		this.major=major;
	}
	public Student5(String name,int age,String major){
//		this.name=name;
//		this.age=age;
		super(name,age);  //调用父类的构造器
		this.major=major;
	}

	public void eat(){
		System.out.println("学生：多吃辣条");
	}
	public void walk(){
		System.out.println("学生：走路上学");
	}
	public void study(){
		System.out.println("学生：学习"+major+"知识");
	}

	public void show(){
		System.out.println("name= "+this.name+", age= "+super.age);
		this.eat();	//子类中重写的方法,
		walk();	//子类中重写的方法
	}
	public void show(int i){
		System.out.println("name= "+this.name+", age= "+super.age);
		super.eat(); // 父类的被重写方法
		super.walk(); //父类的被重写方法
	}

}



class Person5 {
	String name;
	int age;
	int id=1001;

	public Person5(){
		System.out.println("我无处不在！");
	}
	public Person5(String name){
		this.name=name;
	}
	public Person5(String name,int age){
		this(name);
		this.age=age;
	}

	public void eat(){
		System.out.println("人：吃饭");
	}
	public void walk(){
		System.out.println("人：走路");
	}

}
