package javasm.java3;

import org.junit.jupiter.api.Test;

/*
 * 类的结构之三：构造器（或构造方法、constructor）
 * construct：建设、建造  constructor：建设者  construction：CCB 
 * 
 * 一、构造器的作用：
 * 1.创建对象
 * 2.初始化对象的信息
 * 
 * 
 * 二、说明：
 * 1.如果没有显式的定义类的构造器的话，则系统默认提供一个空参的构造器
 * 		其默认的构造器的权限跟类的权限相同
 * 2.定义构造器的格式：权限修饰符 + 类名（形参列表）{}
 * 3.一个类中定义的多个构造器，彼此构成重载
 * 4.一旦我们显式的定义了类的构造器之后，系统就不再提供默认的空参构造器
 * 5.一个类中，必须有构造器，至少有一默认。
 * 
 */
public class Construct {

	public static void main(String[] args) {

	}


	@Test
	public void test(){

		//创建类的对象：new + 构造器
		Person1 p1=new Person1("tom",88);

		p1.eat();
		System.out.println("年龄是："+p1.age+" 名字是： "+p1.name);
		p1.age=5;
		System.out.println("年龄是："+p1.age+" 名字是： "+p1.name);

	}

}



class Person1{
	String name;
	int age;
	//构造器
	public Person1(){
		System.out.println("构造器");
		age=111;
	}
	public Person1(String n){
		name=n;
	}

	public Person1(String n,int i){
		name=n;
		age=i;
	}

	public void eat(){
		System.out.println("人可以吃饭");
	}
	
}