package javasm.java7;


/*
 * JDK8：除了定义全局常量和抽象方法以外，还可以定义静态方法、默认方法
 */
public class Java8Interface {
	public static void main(String[] args) {
		SubClass test=new SubClass();
		
		//知识点1： 接口中定义的静态方法，只能通过接口调用
//		test.methd1();		
		CompareA.method1();
		
		//知识点2： 通过实现类的对象，可以调用接口中的默认方法
		//如果实现类重写了接口中的默认方法，调用时仍然调用的是重写以后的方法
		test.method2();
		
		//知识点3： 如果子类(或实现类)继承的父类和实现的接口中声明了同名同参的方法，
		//那么子类在没有重写此方法的情况下，默认调用的是父类中的同名同参方法  --->方法的类优先原则
		
		//知识点4： 如果实现类实现了多个接口，二者多个接口定义了同名同参的默认方法，那么
		//实现类在没有重写方法的情况下，报错--->接口冲突（此时为抽象类）
		test.abstractMethod();
		
	}

}


class SubClass extends SuperClass implements CompareA,CompareB{
	
	public void method2(){
		System.out.println("SubClass: M416");
	}
	
	//知识点5： 在子类(或实现类)的方法中调用父类、接口中被重写的方法
	public void myMethod(){
		abstractMethod();		//调用自己的方法
		super.abstractMethod();	//调用父类的方法
		CompareA.super.abstractMethod();	//调用接口的方法
	}
	
}

class SuperClass{
	
	public void abstractMethod(){
		System.out.println("SuperClass: SACR");
	}
	
	public void myMethod(){
		abstractMethod();
	}
	
}



interface CompareA {

	public static void method1(){
		System.out.println("CompareA：AKM");
	}

	//默认方法
	public default void method2(){
		System.out.println("CompareA: M416");
	}

	default void abstractMethod(){
		System.out.println("CompareA: SACR");
	}

}


interface CompareB {

	default void abstractMethod(){
		System.out.println("CompareB: SACR");
	}

}
