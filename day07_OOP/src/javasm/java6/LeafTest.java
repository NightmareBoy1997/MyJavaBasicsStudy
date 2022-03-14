package javasm.java6;
/*
 *  对属性可以赋值的位置：
 *   ①默认初始化
 *   ②显式初始化、⑤在代码块赋值
 *   ③构造器初始化
 *   ④对象.属性 或 对象.方法 赋值
 *
 * 执行先后顺序： ① - ② / ⑤- ③ - ④
 *
 * 由父及子，静态先行
 *
 */

class Root{
	static{
		System.out.println("父类1 Root的静态初始化块");
	}
	{
		System.out.println("父类2 Root的普通初始化块");
	}
	public Root(){
		System.out.println("父类1 Root的无参数的构造器");
	}
}
class Mid extends Root{
	static{
		System.out.println("父类2 Mid的静态初始化块");
	}
	{
		System.out.println("父类2 Mid的普通初始化块");
	}
	public Mid(){
		System.out.println("父类2 Mid的无参数的构造器");
	}
	public Mid(String msg){
		//通过this调用同一类中重载的构造器
		this();
		System.out.println("父类2 Mid的带参数构造器，其参数值："
			+ msg);
	}
}
class Leaf extends Mid{
	static{
		System.out.println("子类 Leaf的静态初始化块");
	}
	{
		System.out.println("子类 Leaf的普通初始化块");
	}	
	public Leaf(){
		//通过super调用父类中有一个字符串参数的构造器
		super("尚硅谷");
		System.out.println("子类 Leaf的构造器");
	}
}
public class LeafTest{
	public static void main(String[] args){
		new Leaf(); 
		
		System.out.println("***********************");
		

	}
}

