package comguigu.java;

import lombok.Cleanup;
import org.junit.jupiter.api.Test;

/*
 * 一、异常的处理：抓抛模型
 * 		
 * 过程一：“抛”：程序在正常执行的过程中，一旦出现异常，就会在异常代码处生成一个对应异常类的对象
 * 				并将此对象抛出。
 * 				一旦抛出对象以后，程序执行终止
 * 
 * 		关于异常对象的产生： ① 系统自动生成的异常对象
 * 						  ② 手动的生成一个异常对象，并抛出(throw)
 * 
 * 
 * 过程二：“抓”：可以理解为异常处理的方式：① try-catch-finally		② throws	
 * 
 * 二、try-catch-finally的使用
 * 
 * try{
 * 		//可能出现异常的代码
 * 
 * }catch(异常类型1  变量名1){
 * 		处理异常的方式
 * }catch(异常类型2 变量名2){
 * 		处理异常的方式
 * }…………
 * finally{
 * 		//一定会执行的代码
 * }
 * 
 * 说明：
 *  1. finally是可选的
 *  2. 使用try将可能出现异常代码包装起来，在执行过程中，一旦出现异常，就会生出一个对应异常类的对象，
 *  	根据此对象的类型，去catch中进行匹配。 （类似switch-case）
 *  3. 一旦try中的异常对象匹配到某一catch时，就会进入catch中进行异常的处理，一旦处理完成,
 *  	就跳出try-catch结构(在没有写finally的情况)。继续执行后面的代码。
 *  4. catch中的异常类型，如果没有子父类关系，则声明的先后顺序没有关系。
 *  	catch中的异常类型，如果满足子父类关系，一定要把子类声明在父类上，否则报错
 *  5. 多个catch 可以合并到一个catch处理(前提是同一等级)
 *  6. 常用的异常对象处理方式： ① String getMessage()	② printStackTrace()
 *  7. 在try结构中声明的变量，在出了try结构以后，就不能在调用
 *  8. try-catch-finally结构可以嵌套
 *
 * 体会1： 使用try-catch-finally处理编译时异常，使得程序在编译就不在报错，但是运行时仍可能报错。
 * 		相当于使用try-catch-finally讲一个编译时可能出现的异常，延迟到运行时出现
 * 体会2： 开发中，由于运行时异常比较常见，所以我们通常就不针对运行时异常写try-catch-finally了。
 * 		针对编译时的异常，我们是一定要考虑异常的处理
 *
 *
 *  try-catch-finally中finally的使用：
 *
 *  1. finally是可选的
 *  2. finally中声明的是一定会被执行的代码，即使catch中又出现异常、try中有return语句、catch
 *  中有return语句等情况。
 *
 *  3. 像数据库连接、输入输出流、网络编程Socket等资源，JVM是不能自动回收的，我们需要手动的进行资源的释放
 *  。此时的资源释放，就需要声明在finally中。（垃圾回收）
 *
 */
public class CryCatchFinally {
	
	@Test
	public void test1(){
		String str="123";
		str="abc";
		int num=1;
		try{			
			num=Integer.parseInt(str);
			System.out.println("hello---1");	//被跳过，无法执行
		}catch(NumberFormatException e){
//			System.out.println("出现数值转换异常了，不要着急……");
			
			//方式一：
			System.out.println(e.getMessage());//getMessage()方法返回String类型 ;
			
			//方式二：
//			e.printStackTrace();//printStackTrace()方法打印问题
			
//		}catch(NullPointerException e){
//			System.out.println("出现空指针异常，不要着急……");
//		}catch(Exception e){
//			System.out.println("出现异常，不要着急……");
//		}
//		 *  5. 多个catch 可以合并到一个catch处理(前提是同一等级)
		}catch(NullPointerException | ArrayIndexOutOfBoundsException | ClassCastException  e ){
			System.out.println("出现异常，不要着急……");
		}

		System.out.println("hello---2");		//正常执行
		System.out.println(num);
	}
	
	




//	@Test
//	public void test2() {
//
//		// 只有实现了Closeable接口的才能关闭资源
//		@Cleanup // 释放资源 ，自动调用close方法
//		FileInputStream fis=null;
//		try {
//			File file = new File("hello.txt");
//			fis = new FileInputStream(file);
//
//			int data = fis.read();
//			while (data != -1) {
//				System.out.println((char) data);
//				data = fis.read();
//			}
//			fis.close();
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}finally{
//			try{
//				if(fis!=null){
//					fis.close();
//
//				}
//			}catch(IOException e){
//				e.printStackTrace();
//			}
//		}
//
//	}


/*
	以下是： try-catch-finally中finally的使用：
 */
	@Test
	public void test3(){
		int  a=10;
		int b=0;

		try{
			System.out.println(a/b);

		}catch(NullPointerException e){
			e.printStackTrace();

		}catch(ArithmeticException e){
//			e.printStackTrace();

			int []arr=new int[2];
			System.out.println(arr[2]);
		}finally{
			System.out.println("处理中……");
		}

		System.out.println("处理完成！");

	}

	@Test
	public void method1(){

		int num=method();
		System.out.println(num);

	}

	public int method(){

		try{
			int[]arr=new int[2];
			System.out.println(arr[2]);
			return 1;
		}catch(ArrayIndexOutOfBoundsException e){
			e.printStackTrace();
			return 2;
		}finally{
			System.out.println("finally一定会执行！");
		}
	}




}


class CloneableTest implements Cloneable{

	public void close(){
		System.out.println("我被关闭了.....");
	}


	@Test
	public void test(){

		@Cleanup
		CloneableTest clone1 = new CloneableTest();

	}

}