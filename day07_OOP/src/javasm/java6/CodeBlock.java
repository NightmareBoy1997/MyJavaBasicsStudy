package javasm.java6;
/*
 * 
 * 类的成员之四：代码块（或初始化块）
 * 
 *  1. 代码块的作用：用来初始化类或对象。
 *  2. 代码块如果有修饰的话，只能用static
 *  3. 分类： 静态代码块  vs  非静态代码块
 *  
 *  4. 静态代码块
 *  	>内部可以有输出语句
 *  	>随着类的加载而执行,而且只执行一次
 *  	>作用：初始化类的信息
 *  	>如果一个类中声明了多个静态代码块，按照声明的顺序执行。但通常情况下，只需要声明一个
 *  	>静态代码块 的执行先于 非静态代码块
 *  	>静态代码块 只能调用静态结构(属性、方法)
 *  
 *  
 *  
 *  5. 非静态代码块
 *  	>内部可以有输出语句
 *  	>随着对象的创建而执行，每创建一次就执行一次
 *  	>作业：可以在创建对象时，对对象的属性进行初始化
 *  	>如果一个类中声明了多个非静态代码块，按照声明的顺序执行。但通常情况下，只需要声明一个
 *  	>非静态代码块 可以调用 非静态及静态结构(属性、方法)
 *  
 *  
 *  
 *  对属性可以赋值的位置：
 *   ①默认初始化
 *   ②显式初始化
 *   ③构造器初始化
 *   ④对象.属性 或 对象.方法 赋值
 *   ⑤在代码块赋值
 *
 * 	总结： 由父及子 ，静态先行
 *
 */
public class CodeBlock {
	public static void main(String[]args){
		String desc=Person.desc;
		
		Person s1=new Person();
		Person s2=new Person();
		System.out.println(Person.desc);
	}
	
	
}

class Person{
	
	//属性
	String name;
	int age;
	static String desc="我是一个人！";
	
	//构造器
	public Person(){	
	}
	public Person(String name,int age){
		this.name=name;
		this.age=age;
	}
	
	//代码块
	{
		//调用非静态结构
		name="tom";
		age=1;
		
		//调用静态结构
		desc="kdakldkajdk";
		info();
		System.out.println("hello！block");
	}
	
	static {
		//调用静态结构
		desc="我是一个爱学习的人";
		info();
		//非静态结构不可调用
		System.out.println("hello！static block");
	}
	
	//方法
	public void eat(){
		System.out.println("吃饭");
	}
	
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	
	public static void info(){
		System.out.println("我是一个快乐的人！");
	}
	
}