package javasm.java2;
/*
 * 方法的重载（overload）loading……
 * 
 * 1.定义：在一个同名的类中，允许存在一个以上的同名方法，只要他们的参数个数或参数类型
 * 不同即可。
 * 		“两同一不同”：同一个类、相同方法名
 * 					参数列表不同：参数类型不同，参数个数不同。
 * 
 * 
 * 2.举例：
 * 		Arrays类中的重载sort（）/binarySearch（）
 * 
 * 3.判断是否是重载：
 * 		跟方法的权限修饰符、返回值类型、形参变量名、方法体都没有关系
 * 
 * 4.在通过对象调用方法时，如何确定某一指定方法：
 * 		方法名--->参数列表
 * 
 */
public class OverLoadTest {

	public static void main(String[] args) {
		
		OverLoadTest test=new OverLoadTest();
		test.getSum(1, 2);	//把int注释，会自动提升double
		
	}
	
	
/*	public void getSum(int i,int j){
		System.out.println("1");
	}*/
	
////	public void getSum(int m,int n){
////		
////	}  //与上面重复！
//	
//	private void getSum(int i,int j){
//		
//	}	//与上面重复！
//	
//	public int getSum(int i,int j){
//		return 0;
//	}	//与上面重复！
	public void getSum(double i,double j){
		System.out.println("2");
	}
	
	public void getSum(String a1,int a2){
		System.out.println("3");
	}
	public void getSum(int a2,String a1){
		System.out.println("4");
	}	//不重复，有顺序要求
	
	
	
}
