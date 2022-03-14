package javasm.java1;

/*
 * 类中的方法
 * 
 * 方法：描述类应该具有的功能。
 * 比如：Math类：sqrt（）/random（）/……
 * 		Scanner类：nextInt（）……
 * 		Arrays类：sprt（）/binarySearch（）/toString()/equals()/……
 * 
 * 1.举例：
 * public void eat(){}
 * public void sleep(int hour){}
 * public String getName(){}
 * public String getNation(String nation){}
 * 
 * 2.方法的声明：权限修饰符 返回值类型 方法名（形参列表）{
 * 				方法体
 * 		}
 * 		注意：static、final、abstract、来修饰方法，后面再讲
 * 
 * 3.说明：
 * 		3.1关于权限修饰符：默认方法的权限修饰符都是public
 * 			java规定的权限修饰符：private、public、缺省、protected------>封装性内容
 * 		3.2返回值类型：有返回值 vs 没有返回值
 * 			3.2.1如果方法有返回值，则必须在方法声明时，指定返回值的类型。
 * 				同时，方法中，需要使用return关键字来返回指定类型的变量或常量。
 * 				如果方法没有返回值，则在方法声明时，使用void来表示。通常，没有返回值的方法中就不需要return
 * 				但是，如果使用的话，只能“return”表示结束此方法的意思
 * 
 * 			3.2.2我们定义方法该不该有返回值？
 * 				①题目要求
 * 				②凭经验，具体分析
 * 			3.3 方法名：属于标识符，遵循标识符的规则和规范。见名知意
 * 			3.4.1形参列表：方法可以声明0,1,或多个形参
 * 				格式：数据类型1 形参1；数据类型2 形参2，……
 * 			3.4.2我们定义方法时，该不该要形参？
 * 				①题目要求
 * 				②凭经验，具体分析
 * 
 * 			3.5方法体：方法功能的体现
 * 
 * return关键字的使用：
 * 		1.适用范围：使用在方法体中
 * 		2.作用：①结束方法
 * 				②针对于有返回值类型的方法，使用“return 数据”方法返回所要的数据
 * 		3.注意点：return关键字后面不可以声明执行语句。
 *
 * 5.方法的使用中，可以调用当前类的属性或方法。
 * 		特殊的：方法A中又调用了方法A：递归方法
 * 	方法中不能定义方法
 * 
 */

public class Method {

	public static void main(String[] args) {
		Customer cust1=new Customer();
		cust1.eat();
		cust1.sleep(2);
	}
}

class Customer{
	
	//属性
	String name;
	int age;
	boolean isMale;
	
	//方法
	public void eat(){
		System.out.println("客户吃饭");
	}
	public void sleep(int hour){
		System.out.println("休息了"+hour+"个小时");	
		eat();
	}
	public String getName(){
		if(age>18){
			return name;
		}else{
			return "Tom";
		}
	}
	public String getNation(String nation){
		String info="我的国籍是:"+nation;
		return info;
	}
	
	
//	public void eyes(){
//		public void swim(){
//	错误的方法内定义方法		
//		}
//	}
//	
}