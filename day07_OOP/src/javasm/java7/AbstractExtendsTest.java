package javasm.java7;
/*
 * 抽象类的匿名子类
 * 
 */
public class AbstractExtendsTest {
	public static void main(String[]args){
		
		method(new Student());	//匿名对象
		
		Worker worker =new Worker();
		method1(worker);		//非匿名类的非匿名对象
		method1(new Worker());	//非匿名类的匿名对象
		System.out.println("*************************");
		
		
		//创建了一个匿名子类的对象：p
		Person p=new Person(){
			public void eat(){
				System.out.println("多吃好吃的");
			}
			@Override
			public void breath() {
				System.out.println("好好呼吸");
			}
		} ;
		method1(p);		//调用
		System.out.println("*************************");
		
		
		//匿名子类的匿名对象
		method1(new Person(){
			public void eat(){
				System.out.println("多吃有营养的东西");
			}
			public void breath(){
				System.out.println("多呼吸新鲜空气");
			}
		}	
				);
		
		
	}
	
	public static void  method1(Person p){
		p.breath();
		p.eat();
	}
	
	public static void method(Student s){
		
	}
	
	
}

class Worker extends Person {

	@Override
	public void eat() {
		
		
	}

	@Override
	public void breath() {
		
	}
	
	
	
}