package javasm.java2;
/*
 * 可变个数形参的方法
 * 
 * 1.jdk5.0新增内容
 * 2.具体使用：
 * 		2.1  可变个数形参的格式：数据类型...变量名。多个形参变量需要都是同一类型的数据
 * 		2.2  当调用可变个数形参方法时，传入的参数个数可以是：0个,1个，……
 * 		2.3	可变个数形参方法与本类中方法名相同，形参不同的方法构成重载
 * 		2.4 可变个数形参的方法与本类中方法名相同，形参类型也相同的数组之间不构成重载。（不能够共存）
 * 		2.5 可变个数形参在方法的形参中，必须声明在末尾(由于可变，放在前面不能确定其长度)
 * 		2.6 可变个数形参在(同一条)方法的形参中，最多只能声明一个可变形参。
 * 
 */
public class MethodArgsTest {

	public static void main(String[] args) {
		MethodArgsTest test=new MethodArgsTest();
		test.show(12);
		test.show("hello");				//都匹配show(String...strs)
		test.show("hello","world");		//都匹配show(String...strs)
		
//		test.show();	// 当有多个可变个数形参的不同类型的方法时，不能为空（不确定匹配哪个）				
		
	}
	
	public void show(int i){
		
	}
	
//	public void show(String s){
//		System.out.println("show.(String)");
//	}
	
	public void show(String...strs){
		System.out.println("show(String...strs)");
		
		for(int i=0;i<strs.length;i++){
			System.out.println(strs[i]);  //遍历，等同于数组
		}
		
	}
	
//	  与可变个数形参不能共存
// 	public void show(String[] strs){
// 		
// 	}		
	
//	  The variable argument type String of the method show must be the last 
//	  parameter
//	public void show(String...strs,int i){
//		
//	}
	
	public void show(int ...i){
		
	}
	
	
	
}
