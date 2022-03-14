package javasm.java7;
/*
 * 接口的使用：
 *  1. 接口使用interface来定义 
 *  2. java中，接口和类是并列的两个结构
 *  3. 如何定义接口：定义接口中的成员
 *  
 *  		3.1 JDK7及以前 ： 只能定义全局常量和抽象方法
 *  		>全局常量：public static final的。 但是书写时可以省略
 *  		>抽象方法：public abstract的
 *  
 *  		3.2 JDK8：除了定义全局常量和抽象方法之外，还可以定义静态方法、默认方法（略）
 * 
 *  4. 接口中不能定义构造器，意味着接口不能实例化
 * 
 *  5. java开发中，接口通过让类去实现（implements）的方式来使用，
 *  	如果实现类覆盖了接口中的所有抽象方法，则此实现类就可以实例化。否则此实现类仍为抽象类
 * 
 *  6. java类可以实现多个接口--->弥补了单继承的局限性
 *  	格式：class AA extends BB implements CC,DD、EE （先继承后实现）
 *  
 *  7. 接口与接口之间可以继承，而且是多继承
 *  
 *  ***************************************************************************
 *  8. 接口的具体使用，体现了多态性
 *  9. 接口，实际上可以看做是一种规范
 *  
 *  面试题：抽象类与接口有哪些异同
 *  
 */
public class InterfaceTest {
	public static void main(String[] args) {
		
		System.out.println(Flyable.MAX_SPEED);
		System.out.println(Flyable.MIN_SPEED);
		
//		Flyable.MIN_SPEED=5;	//报错
		
		Plane p=new Plane();
		p.fly();
		p.stop();
				
		
	}
}

interface Flyable{
	
	//全局常量
	public static final int MAX_SPEED=7900;		//第一宇宙速度
	int MIN_SPEED=1;
	
	public abstract void fly();
	//省略了public abstract
	void stop();
	
//	public Flyable(){
//	}
}

interface Attackable{
	
	void attack();
	
}


class Plane implements Flyable{
	public void fly(){
		System.out.println("通过引擎起飞");
	}
	public void stop(){
		System.out.println("驾驶员减速停止");
		
	}
}

class Bullet extends Object implements Flyable,Attackable{

	@Override
	public void attack() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fly() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
		
	}
	
	
	
}