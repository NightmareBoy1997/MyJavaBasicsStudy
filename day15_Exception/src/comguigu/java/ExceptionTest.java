package comguigu.java;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

/*
 * Exception: 其它因编程错误或偶然的外在因素导致的一般性问题，可以使用针对性的代码进行处理。
 * 例如：

		>空指针访问

		>试图读取不存在的文件

		>网络连接中断

		>数组角标越界
 * 
 * 对于这些错误，一般有两种解决方法：一是遇到错误就终止程序的运行。另一种方法是由程序员在编写程序时，
 * 就考虑到错误的检测、错误消息的提示，以及错误的处理。
 *
 *
 * 捕获错误最理想的是在编译期间，但有的错误只有在运行时才会发生。
比如：除数为0，数组下标越界等
		>分类：编译时异常和运行时异常
 * 
 * 一、异常的体系结构
 * 		java.lang.Throwable
 * 			|---java.lang.Error		:一般不编写针对性的代码进行处理
 * 			|---java.lang.Throwable	：可以进行异常的处理
 * 				|----编译时异常(checked)
 * 					|-----IOException
 * 						|---FileNotFoundException
 * 					|-----ClassNotFoundException
 * 
 * 				|----运行时异常(unchecked,RuntimeException)
 * 					|------NullPointerException				空指针
 * 					|------ArraysIndexOutOfBoundsException	数组角标越界
 * 					|------ClassCastException				类型不匹配
 * 					|------NumberFormatException			数据类型转换异常
 * 					|------InputMismatchException			读取的数据类型不匹配
 * 					|------ArithmeticException				算数异常
 * 
 * 
 * 面试题：常见的异常有哪些？
 * 
 */
public class ExceptionTest {
	
	//NullPointerException
	@Test
	public void test1(){
//		int[]arr=null;
//		System.out.println(arr[2]);
		
		String str="abc";
		str=null;
		System.out.println(str.charAt(0));
		
	}
	
	//IndexOutOfBoundsException:
	@Test
	public void test2(){
		//ArrayIndexOutOfBoundsException
//		int []arr=new int[3];
//		System.out.println(arr[3]);
		
		//StringIndexOutOfBoundsException
		String str="abc";
		System.out.println(str.charAt(3));
	
	}
	
	//ClassCastException
	@Test
	public void test3(){
		Object obj=new Date();
		String str=(String)obj;
	
	}
	
	//NumberFormatException
	@Test
	public void test4(){
		String str="123";
		str="abc";
		double num=Double.parseDouble(str);

	}
	
	//InputMismatchException
	@Test
	public void test5(){
		Scanner scan=new Scanner(System.in);
		int num=scan.nextInt();
		System.out.println(num);
		
		scan.close();		//回收内存
	}
	
	//ArithmeticException
	@Test
	public void test6(){
		
		int a=2;
		int b=0;
		System.out.println(a/b);	
	}
	
//*************************************以上是运行时异常***************************************

	@Test
	public void test7() {

		FileInputStream fis=null;
		try {
			File file = new File("hello.txt");
			fis = new FileInputStream(file);

			int data = fis.read();
			while (data != -1) {
				System.out.println((char) data);
				data = fis.read();
			}
			fis.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try{
				if(fis!=null){
					fis.close();
					
				}
			}catch(IOException e){
				e.printStackTrace();
			}
		}

	}
	
	
}
