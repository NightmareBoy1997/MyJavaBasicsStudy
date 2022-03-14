package comguigu.java;

import java.io.IOException;

/*
 * 方法重写的规则之一：
 * 子类重写的方法抛出的异常类型不大于父类被重写的方法抛出的异常类型
 *
 */
public class OverrideTest {
	public static void main(String[]args){
		OverrideTest test=new OverrideTest();
		test.display(new SubClass());
	
	}
	
	
	public void display(SuperClass s){
		try{
			s.method();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	
}

class SuperClass{
	
	public void method() throws IOException{
		System.out.println("父类的method方法");
	}
	
}

class SubClass extends SuperClass{
	
	public void method(){		// 抛出类型可以没有
		System.out.println("子类的method方法");
	}
	
	
}