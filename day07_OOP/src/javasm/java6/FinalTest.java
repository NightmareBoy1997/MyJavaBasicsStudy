package javasm.java6;
/*
 * final:最终的
 * 
 *  1. final可以用来修饰的结构：类、方法、变量
 * 
 *  2. final 用来修饰一个类:此类不能被继承。
 *  		比如：String类、System类、StringBuffer类
 *  
 *  3. final 用来修饰方法：表明此方法不可以被重写
 *  		比如：Object类的getClass();
 *  
 *  4. final 用来修饰变量：此时的“变量”就变成了常量(对象创建以后不可修改！创建之前的显式赋值、构造器、代码块可以赋值)
 * 			4.1 final 修饰属性： 可以赋值的位置：显式初始化、代码块、构造器
 * 			4.2 final 修饰局部变量：
 * 						尤其是使用final修饰形参时，表明形参是一个常量。调用方法时，给常量形参赋一个实参。一旦赋值以后，
 * 						就只能在方法中使用此形参，但不能重新赋值
 * 	
 * 
 *  static final 用来修饰属性：全局常量
 * 
 */
public class FinalTest {
	
	final int WIDTH=0;
	final int LEFT;
	final int RIGHT;
	
	{
		LEFT=1;
	}
	
	public FinalTest(){
		RIGHT=2;
	}
	public FinalTest(int n){
		RIGHT=n;
	}
	
	public void set(final int n){
//		n +=1;
		System.out.println(n);
	}
	
	public static void main(String[]args){
		
		final int num=20;
//		num +=21;
		
		
	}
}

final class FinalA{
		
}
//class FinalB extends FinalA{
//	
//}

class aa{
	public final void show(){
		
	}
}
class bb extends aa{
//	public void show(){
//		
//	}
}
