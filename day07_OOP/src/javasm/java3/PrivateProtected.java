package javasm.java3;
/*
 * 面向对象的特征性一：封装与隐藏 	3w:what? why? how?
 * 
 * 一、问题引入：
 * 	当我们创建一个对象以后，我们可以通过“对象.属性”的方式，对对象的属性
 * 进行赋值。这里，赋值操作要收到属性的数据类型和存储范围的制约。除此之外，
 * 没有其他制约条件，但是实际问题中，我们往往需要给属性赋值加入额外的限制条件。
 * 这个条件就不能在属性声明中体现，我们只能通过方法进行限制条件的添加。（比如：
 * setLegs（））。同时我们需要避免用户再使用“对象.属性”的方式进行赋值。则需要
 * 将属性声明为私有的（private）---->此时，针对属性就体现（不等同于封装性）封装性
 * 
 * 二、封装性的体现（之一）：
 * 	我们将类的属性私有化（private），同时提供公共的（public）方法来获取（getXXX（））
 * 和设置（set XXX（））此属性的值。
 * 		
 * 	  拓展：封装性的体现：①如上 ②不对外暴露的私有方法  ③单例模式…… ④ 如果不希望类在包外被调用，可以将类设置为缺省
 * 
 * 三、封装性的体现，需要权限修饰符来配合。
 *  1.Java规定的4种权限修饰：（从小到大）private、缺省（default）、protected、public
 *  2.4种权限可以用来修饰类及类的内部结构：属性、方法、构造器、内部类
 *  3.4种权限都可以修饰内部结构
 *  	修饰类的话，只能使用缺省、public
 *  
 *  总结封装性：Java提供了4种权限修饰符来修饰类及类的内部结构，体现类及类的内部结构
 *  在被调用时的可见性的大小。
 * 
 */
public class PrivateProtected {

	public static void main(String[] args) {
		
		Animal a=new Animal();
		a.name="大黄";
//		a.age=1;
//		a.legs=4;//The field Animal.legs is not visible
//		a.legs=-4;		

		
		a.setLegs(6);
		a.getLegs();
		a.setAge(5);
		
		a.show();
		int n=a.getAge();
		System.out.println(n);
	}
	
	
}

class Animal{
	
	String name;
	
	private int age;
	private int legs;//腿的个数
	
	public void setLegs(int l){
		if(l>0 && l%2==0){
			legs=l;
		}else{
			legs=0;
			//抛出一个异常（暂时没讲）
			//System.out.println("输入有误！");
		}
	}
	
	//对私有属性的获取
	public int getLegs(){
		return legs;
	}
	
	public void eat(){
		System.out.println("动物进食！");
	}
	
	public void show(){
		System.out.println("name= "+name+",age= "+age+",legs= "+legs);
	}
	
	//提供关于属性age的get和set方法
	 void setAge(int i){
		if(i>=0){
			age=i;
		}else{
			age=0;
		}
	}
	
	 int getAge(){
		return age;
	}
	
	
	
	
}
