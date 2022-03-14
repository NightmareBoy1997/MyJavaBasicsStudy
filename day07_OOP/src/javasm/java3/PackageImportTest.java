package javasm.java3;
/*
 * 一、package关键字的使用
 * 1.为了更好的对项目中类的管理，提供包的概念
 * 2.使用package声明类或接口所属的包，声明在源文件的首行
 * 3.包：属于标识符，遵循标识符的命名规范、规范（xxyyzz）、“见名知意”
 * 4.每“.”一次，就代表一层文件目录
 * 
 * 	 补充：同一个包下，不能命名同名的接口、类
 * 
 * 二、import关键字
 * import：导入
 * 
 * 1.在源文件中显式的使用import结构导入指定包下的  类、接口！！
 * 2.声明在包的声明和类的声明之间
 * 3.如果需要导入多个结构，则并列写出
 * 4.可以使用“XXX.*”的方式，表示可以导入XXX包下的所有结构
 * 5.如果使用的类或接口是java.lang包下定义的，则可以省略import结
 * 构（String、System）
 * 6.如果使用的类或接口是本包下定义的，也可以省略
 * 7.如果在源文件中，使用了不同包下的同名的类，则必须把超出一个以外
 * 的类，以完整全类名的方式进行显示。
 * 8.使用“XXX.*”方式表明可以调用XXX包下的所有结构。但是如果使用的
 * 是XXX子包下的结构，则仍需要显示导入
 * 
 * 9.import static：导入指定类或接口中的静态结构: 属性或方法！！
 * 
 * 
 */

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Date;

import static java.lang.System.out;


public class PackageImportTest {
	public static void main(String[] args) {
	
		Arrays.toString(new int[]{1,2,3});		
		
		Person p1=new Person();  //自定义的导入结构
		
		Date date=new Date();
		java.sql.Date date1=new java.sql.Date(5555L);  //全类名的形式显示
		
		Field f1=null;   //java.lang的子包，需要显式导入
		
		out.println("666");  //import static java.lang.System.*;
		
	}
	
	
}


