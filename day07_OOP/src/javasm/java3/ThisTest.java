package javasm.java3;

import org.junit.jupiter.api.Test;

/*
 * this关键字的使用：
 * 1.this可以用来修饰、调用：属性、方法、构造器
 * 
 * 2.this修饰属性和方法：
 * 		this理解为：当前对象或当前正在创建的对象
 * 	
 * 	 2.1 在类的方法中，我们可以使用“this.属性”或“this.方法”的方式
 * 来调用当前对象属性或方法。
 * 但是，通常情况下，我们都选择省略“this.”。特殊情况下如果方法的形参
 * 和类的属性同名时，我们必须显式的使用“this.变量”的方式，来表明此变
 * 量是属性，而非形参。
 * 	 2.2 在类的构造器中，我们可以使用“this.属性”或“this.方法”的方式
 * 来调用当前正在创建的对象属性或方法。
 * 但是，通常情况下都省略“this.” 。特殊情况下如果构造器的形参和类的属性同名时，
 * 我们必须显式的使用“this.变量”的方式，来表明此变量是属性，而非形参。
 * 
 * 3.this调用构造器
 * 	① 我们在类的构造器中，可以显式的使用“this（形参列表）”方式，调用本
 * 类中指定的其他构造器。
 *  ② 构造器中不能通过“this（形参列表）”方式调用自己，否则死循环
 *  ③ 如果一个类中有n个构造器，则最多有n-1个构造器使用“this（形参列表）”
 *  ④ 规定：“this（形参列表）”必须声明在当前构造器的首行
 *  ⑤ 一个构造器内部，最多只能声明一个“this（形参列表）”来调用其他构造器
 *  
 * 	多次调用构造器，但其中的重复嵌套的同一方法体不会多次执行
 */
public class ThisTest {


	@Test
	public void thistest() {
		Person2 p1 = new Person2("tom",15);
//		p1.setAge(2);
//		p1.setName("tom");
		System.out.println("年龄是： "+p1.getAge()+" 名字是： "+p1.getName());
	}

}


class Person2 {

	private int age;
	private String name;
	
	public Person2(){
		this.eat();
	} 
	public Person2(int age){
		this();
		System.out.println("构造器2");
	}
	public Person2(String name ,int age){
		this(age);		//	多次调用构造器，但其中的重复嵌套的同一方法体不会多次执行
		this.age=age;
		this.name=name;
//		this(); //报错
	}

	public void setName(String name) {
		name = name;	//就近原则,无法区分属性和形参
	}

	public String getName() {
		return name;
	}

	public void setAge(int age) {
		this.age = age;		//	this：表示这个对象
	}

	public int getAge(){
		return age;
	}

	public void eat(){
		System.out.println("人吃饭");
		this.study();	//前面默认省略的this
	}

	public void study(){
		System.out.println("人学习");
	}
	
}
