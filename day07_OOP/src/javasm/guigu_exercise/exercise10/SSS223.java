package javasm.guigu_exercise.exercise10;


public class SSS223 {
	public static void main(String[]args){
		Circle1 test=new Circle1(5.0){		
			public double findArea(){
				return radius*Math.PI;
			}
		};
		System.out.println(test.findArea());
		
		
		
		
		
	}
}

abstract class Circle1{
	double radius;
	
	public Circle1(double radius){
		this.radius=radius;
	}
	
	public abstract double findArea();
	
	
}


class TestMain{
	
	public static void main(String[]args){
		Test.Test2 t1=new Test.Test2(184.2, 135.0);
		Test t21=new Test();
		Test.Test1 t2=t21.new Test1("tom", 22);
		
		System.out.println(t1.toString());
		System.out.println(t2.toString());
		
		//创建接口的匿名实现类
		AA a=new AA(){
			public int ms(){
				return 2;
			}
		};
		
	}	
}


class Test{
 
	class Test1{
		String name;
		int age;
		
		public Test1(String name,int age){
			this.name=name;
			this.age=age;
		}
		
		public String toString(){
			return "name: "+name+" age: "+age;
		}
		
	}
	
	 protected static class Test2{
		double height;
		double weight;
		
		public Test2(double height,double weight){
			this.height=height;
			this.weight=weight;
		}
		
		public String toString(){
			return "height: "+height+" weight: "+weight;
		}
		
	}
	
}


interface AA{
	
	public abstract int ms();
	
	
}