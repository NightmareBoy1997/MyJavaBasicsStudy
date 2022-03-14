package javasm.java5;

import org.junit.jupiter.api.Test;

/*
 *  包装类的使用：
 *  1. java提供了8种基本数据类型对应的包装类，使得基本数据类型的变量具有类的特征
 *  
 * 	2.基本数据类型、包装类、String三者之间的相互转换 
 * 		除 int-Integer、char-Character，其他都是类型首字母大写(Double、Byte……)
 * 		数值型(int、float……)的包装类 的 同一父类是：Number
 *
 * 3.整数缓存池
	  在一些包装类里面  提供这个整数缓存池思想。
	  Integer.IntegreCache.cache -128-127 Integer[]
	  ByteCache ...
	  ShortCache ...
	  LongCache ...
	  CharacterCache----> 0-127  ASCII
 *
 */
public class Packaging {
	
	//String类型--->基本数据类型、包装类:调用包装类的parseXxx(String s)
	@Test
	public void Test4(){
		String str1="123";
//		int num1=(int)str1;			报错
//		Integer in1=(Integer)str1;	报错
		
		System.out.println(str1+1);//1231
		int num2=Integer.parseInt(str1);
		System.out.println(num2+1);//124
		
		String str2="true1";
		Boolean b1=Boolean.parseBoolean(str2);
		if(b1){									//if()成功运行
			System.out.println("转换成功！"); 
		}else{
			System.out.println("格式问题");
		}

	}

	//基本数据类型、包装类--->String:调用String重载的valueOf(Xxx xxx)
	@Test
	public void Test3(){
		int num1=10;
		//方式一
		String str1=num1+"";
		//方式二、
		float f1=12.3f;
		String str2=String.valueOf(f1);
		
		Double d1=new Double(12.4);
		String str3=String.valueOf(d1); //得益于自动装、拆箱的
		System.out.println(str1);
		System.out.println(str2); //12.4
		
	}
	
	
	
	//Jdk5.0新特性：自动装箱与拆箱
	@Test
	public void Test2(){
	
		//自动装箱:基本数据类型--->包装类的对象
		int num1=10;
		Integer in1= num1;	
		boolean b1=true;	
		Boolean b2=b1;		
		
		//自动拆箱
		System.out.println(in1.toString());
		int num2=in1;
		int num3=in1+1;
	}
	
	public void method(Object obj){
		System.out.println(obj);
	}
	
	
	
	
	
	
	//包装类--->基本数据类型：调用包装类的xxxValue()
	@Test
	public void test1(){
		Integer in1=new Integer(12);
		
		System.out.println(in1+1);
		int i1=in1.intValue();
		System.out.println(i1+1);
		
		
		Float fo1=new Float(11.1f);
		
		float fo2=fo1.floatValue();
		System.out.println(fo2);
	}
	
	
	//基本数据类型--->包装类：调用包装类的构造器
	@Test
	public  void testByte(){
		
		Byte b1=2;
		Integer i1=new Integer(20);
		//Integer i1=20; 等同于String s1="tom";

		b1.toString();
		System.out.println(b1.toString());
		System.out.println(b1);
		System.out.println(i1);
		
		Integer i2=new Integer("123");
		System.out.println(i2);
		
//		Integer i3=new Integer("sss");  //编译通过，导致运行终止
//		System.out.println(i3);			//类型不同，报错
		
		Float f1 =new Float(12.2);
		Float f2 =new Float(12.2f);
		Float f3 =new Float("12.2");
		System.out.println(f1);
		System.out.println(f2);
		System.out.println(f3);
		
		Boolean boo1=new Boolean(true);
		Boolean boo2=new Boolean("TrUe"); //输出 true，忽略大小写
		Boolean boo3=new Boolean("true223"); //编译运行没问题，输出false
		
		System.out.println(boo1);
		System.out.println(boo2);
		System.out.println(boo3); //false
		
		Order1 order1=new Order1();
		System.out.println(order1.isMale);		//默认值false
		System.out.println(order1.isFemale);	//null，此时的isFemale是对象
		
	}
}

class Order1{
	boolean isMale;
	boolean isFemale;
	
}