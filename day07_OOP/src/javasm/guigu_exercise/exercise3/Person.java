package javasm.guigu_exercise.exercise3;
/*
 *  1.创建程序，在其中定义两个类：Person和PersonTest。定义如下：
 * 用setAge（）设置人的合法年龄（0~130），用getAge（）返回人的年龄
 * 
 * 2.练习2
 *  2.1 在定义的Person类添加构造器，利用构造器设置所有人的age属性都初始化为18
 *  2.2修改类的构造器，增加name属性，使得每次创建Person类的对象同时初始化name和age
 * 
 */
public class Person {

	private int age;
	private String name;
	
	public Person(){
		age=18;
	}
	public Person(String a,int i){
		name=a;
		age=i;
	}
	
	
	public void setName(String n){
		name=n;
	}
	public String getName(){
		return name;
	}
	
	public void setAge(int i){
		
		if(i<0 || i>130){
  			throw new RuntimeException("输入的数据有误！");//抛出异常
//  			System.out.println("输入的数据有误！");
// 			return;
		}
			age=i;
	}
		
	public int getAge(){
		return age;
	}
	
/*	//方法目的不确定
	public int doAge(int a){
		age=a;
		return age;
	}*/

	
	
}
