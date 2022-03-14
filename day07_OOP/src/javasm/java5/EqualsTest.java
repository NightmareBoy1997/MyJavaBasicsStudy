package javasm.java5;

/*
 * 
 * 面试题： == 和 equals()区别
 * 
 * 一、回顾 == 的使用：
 * 	==：运算符
 * 	1. 可以使用在基本数据类型和引用数据类型变量中
 *  2.	如果比较的是基本数据类型： 比较的是变量保存的值是否相等。（不一定类型一样）
 *  	如果比较的是引用数据类型： 比较两个对象的地址值是否相同,及两个引用是否指向同一个实例。 （类型不需要一致）
 * 补充： == 符号使用时，必须保证符号左右两边的变量类型一致。
 *
 * 二、equals()方法的使用：
 *  1. 是一个方法。
 *  2. 只适用于引用数据类型
 *  3. Object类中equals()的定义：
 *      public boolean equals(Object obj) {
        return (this == obj);
    	}
    	equals() 与 == 的作用是相同，比较地址值是否一样
 *  4. 像 String、Date、File、包装类等都重写了Object的equals()方法。重写以后，都
 *  比较的不再是地址值，而是比较两个对象的“实体内容”是否相同。
 *  
 *  5. 通常情况下，我们自定义类如果使用equals()比较内容，我们需要对Object类的equals()
 *  方法进行重写
 *  重写原则： 比较两个对象的实体内容是否相同
 *  
 */
public class EqualsTest {
	public static void main(String[]args){
	
		//基本数据类
		int i=10;
		int j=10;
		double d=10;
		System.out.println(i==j);//true
		System.out.println(i==d);//true
		
		char c=10;
		System.out.println(i==c);//true   A:65 a:97
		
		
		//引用数据类
//		String s1="tom"; //非new对象
//		String s2="tom"; //非new对象
		Man m1=new Man("tom",22);
		Man m2=new Man("tom",22);
		String s1=new String("tom");
		String s2=new String("tom");
		
		System.out.println(s1==s2);//false
		System.out.println("****************************");
		System.out.println(m1.equals(m2));//false
		System.out.println(s1.equals(s2));//true
		
		
	}
}

class Man {
	String name;
	int id=1002;

	public Man(String name, int id) {
		this.name = name;
		this.id = id;
	}

	public void earnMoney(){
		System.out.println("男人负责挣钱养家");
	}

	public void eat(){
		System.out.println("男人多吃肉，长肌肉");
	}
	public void walk(){
		System.out.println("少走路，多休息");
	}

}