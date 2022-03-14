package javasm.java5;

import org.junit.jupiter.api.Test;

/*
 * Java中的单元测试
 * 
 * 步骤：
 * 1. 选中当前工程>右键选择：build path > add libraries > Junit 4> 
 * 2. 创建java类，进行单元测试
 * 		此时java类的要求：①此类是public ②空参的构造器
 * 3. 此类中声明单元测试方法。
 * 		此时的单元测试方法：public、 void、 空参
 * 
 * 4. 次测试方法上需要声明注解：@Test ， 并导入：import org.junit.Test；
 * 
 * 5. 声明以后 ，就可以在方法体内测试相关代码
 * 6. 写完代码以后，左键双击单元测试方法名选中，右键：run as-JUnit Test
 * 
 * 说明：
 * 	1. 如果执行结果没有异常，绿条
 * 	2. 执行结果出现异常：红条
 * 
 */
public class JUnitTest {

		
	String s3="abcd";

 	@Test
	public void testEquals(){
		String s1="MM";
		String s2="MM";
		System.out.println(s1.equals(s2));
		
//		Object obj=new Object();
//		Date date=(Date)obj;
		
		System.out.println(s3);
		show();
		System.out.println(s3);
	}	
	
	public void show(){
		s3="非main方法直接调用";
		System.out.println("show()……");
	}
	
	
	
	
	
}
