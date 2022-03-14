package javasm.java5;


/*
 * 关于包装类使用的面试题
 * 
 */

import org.junit.jupiter.api.Test;

public class PackagingTest {
	
	@Test
	public void Test1(){
		Object o1=true?new Integer(1) : new Double(2.0); //三元运算符要求表达式类型一致，所有Int自动提升为Double
		System.out.println(o1);		//1.0
	
	}
	
	@Test
	public void Test3(){
		Integer i=new Integer(1);
		Integer j=new Integer(1);
		System.out.println( i==j );	//false

		//Integer 内部定义了IntegerCache结构，其中定义了Integer[]，
		//保持了-128~127范围的数。如果我们使用自动装箱的方式，给Integer赋值的范围在其[-128,127]中，可以直接使用数组元素，不用去new。 目的：提高效率
		
		Integer m=1;
		Integer n=1;
		System.out.println(m==n);	//true
		
		Integer x=128;
		Integer y=128;
		System.out.println(x==y);	//false??
	}
	
	
}
