package javasm.java6;
/*
 * static关键字的使用
 * 
 *  1. static：静态的
 *  2. static可以用来修饰：属性、方法、代码块、内部类（除构造器）。
 * 
 * 	3. 使用static修饰属性：静态变量、类变量
 * 		3.1  属性，按是否使用static修饰，又分为：静态属性  vs 非静态属性（实例变量）
 * 		实例变量：我们创建类的多个对象，每个对象都 独立的 拥有一套类中的非静态属性。修改一个类的非静态属性，
 * 				不会影响其他对象中的属性。
 * 		静态变量：创建一个类的多个对象，多个对象共享一个静态变量。当通过某一个对象修改静态变量时，会导致
 * 				其他对象调用此静态属性时，是修改过的。
 * 
 * 		3.2 static修饰属性的其他说明：
 * 			① 静态变量随着类的加载而加载。  可以通过“类.静态变量”的方式进行调用
 * 			② 由此，静态对象的加载要早于对象的创建
 * 			③ 由于类只会加载一次，则静态变量在内存中也只会加载一份。 存在方法区的静态域中。
 * 
 * 			④ 		类变量    	  实例变量
 * 			类		 yes			no
 * 			对象	 yes			yes
 * 
 * 		3.3 静态属性举例： System.out、Math.PI
 * 		
 * 
 *  4. 使用static修饰方法 ：静态方法
 *  	① 随着类的加载而加载，可以通过“类.静态方法”的方式调用
 *  	② 			静态方法		非静态方法
 *  		类		  yes			no
 *  		对象	  yes			yes
 *  	③ 静态方法中，只能调用静态方法或静态属性
 *  	  非静态方法中，即可以调用非静态方法或属性，也可以调用静态的方法或属性
 *  
 *  5. static注意点
 *  	5.1 在静态的方法内，不能使用this.及super.关键字
 * 		5.2 关于静态属性和静态方法的使用，可以从生命周期的角度理解
 * 
 *  6.1 开发中，如何确定一个属性是否声明为static的？
 *  		> 属性是可以被多个对象共享的，可以通用性
 *  		> 类中的常量也常常声明为static
 *  
 *  	开发中，如何确定一个方法是否声明为static的？
 *  		> 操作静态属性的方法，通常设置为static
 *  		> 工具类的方法，习惯上声明为static的。 比如：MAth、Arrays、……
 *  
 */
public class StaticTest {
	public static void main(String[]args){
		
		
		Chinese.show(); //类直接调用静态方法
		
		Chinese c1=new Chinese();
		c1.name="马云";
		c1.age=66;
		c1.color="yellow";
		
		Chinese c2=new Chinese();
		c2.name="王健林";
		c2.age=65;
		c2.color="black";
		
		System.out.println(c1.color);
		
	}		
}




class Chinese{
	String name;
	int age;
	static String color;

	
	public void eat(){
		System.out.println("中国人吃中餐");
	}
	public static void show(){
		System.out.println("我是一个中国人！");
		//可以调用静态结构，不能调用非静态结构
//		eat();
		walk();
		System.out.println(color); //Chinese.color前面的Chinese默认省略，类似this
	}
	public static void walk(){
		System.out.println("走路");
	}
}
