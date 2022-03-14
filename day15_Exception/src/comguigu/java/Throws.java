package comguigu.java;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/*
 * 异常处理的方式二：throws + 异常类型
 * 
 *  1. "throws + 异常类型"写在方法的声明处，指明此方法执行时可能会抛出的异常类型。
 *  	一旦当方法体执行时，出现异常，仍会在异常代码处生成一个异常类的对象，此对象满足throws后异常
 *  	类型时，就会被抛出。 异常代码后的代码不再执行！
 * 
 *  2. 体会：try-catch-finally：真正的将异常处理掉了。
 *  		throws的方式只是将异常抛给了方法的调用者，并没有真正将异常处理掉
 *  
 *  3. 开发中如何选择try-catch-finally 还是 throws？
 *  
 *  	3.1  如果父类中被重新写的方法没有throws方式处理异常，则子类重写的方法也不能使用throws，
 *  意味着如果子类的方法有异常，必须使用try-catch-finally方式处理
 *  	3.2 执行的方法a中，先后又调用了另外的几个方法，这几个方法是递进关系执行的。我们建议这几个方法
 *  使用throws的方式进行处理。而执行的方法s可以考虑使用try-catch-finally方式进行处理。
 * 
 */
public class Throws {
	
	public static void main(String[] args) {
		try{
			
			method2();
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}finally{
			System.out.println("加紧处理中……");
		}
		System.out.println("处理完成！");
		
		System.out.println("*******************************");
		
		method3();
		
	}
	
	public static void method3(){
try{
			
			method2();
		}catch(IOException e){
			e.printStackTrace();
		}finally{
			System.out.println("加紧处理中……");
		}
		System.out.println("处理完成！");
	}
	
	public static void method2() throws FileNotFoundException,IOException{
		method1();
	}
	

	public static void method1() throws FileNotFoundException,IOException{

			FileInputStream fis=null;
				File file = new File("hello.txt");
				fis = new FileInputStream(file);

				int data = fis.read();
				while (data != -1) {
					System.out.println((char) data);
					data = fis.read();
				}
				fis.close();
				System.out.println("哈哈哈");
		}
		
		
		

	
	
	
	
}
