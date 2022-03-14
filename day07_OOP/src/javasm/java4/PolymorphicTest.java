package javasm.java4;
/*
 * 多态性的使用举例一：
 * 
 * 
 */
public class PolymorphicTest {
	
	public static void main(String[] args) {
		
		PolymorphicTest test=new PolymorphicTest();
		test.func(new Dog());
		
		test.func(new Cat());
	}
	
	
	public void func(Animal animal){ // animal=new Dog();
		animal.eat();
		animal.shout();
	}
	
}

class Animal{
	
	public void eat(){
		System.out.println("动物：进食");
	}
	public void shout(){
		System.out.println("动物：叫");
	}
	
}

class Dog extends Animal{
	
	public void eat(){
		System.out.println("狗：吃狗粮");
	}
	public void shout(){
		System.out.println("汪！汪！汪！");
	}
	
}

class Cat extends Animal{
	
	public void eat(){
		System.out.println("猫：吃鱼");
	}
	public void shout(){
		System.out.println("喵!喵!喵！");
	}
	
}


//举例二：

class Order{
	
	public void method(Object j){  //可以适用所有类
		
	}
	
}
