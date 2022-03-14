package javasm.guigu_exercise.exercise7;
/*
 * 
 * 多态性练习5
 * 
 * 
 */

public class Exercise05 {
	
	void method(Person p){
		System.out.println(p.getInfo()+"\n*************");
	}
	
	void getMethod(){
		int index=(int)(Math.random()*100);
		if(index %2==0){
		method(new Student());
		}else if(index %3==0){
		method(new Graduate());
		}else{
		method(new Person());
		}
	}
	
	public static void main(String[]args){
//		Person person=new Person();
//		Student student=new Student();
//		Graduate graduate=new Graduate();
//		
//		System.out.println(person.getInfo()+"\n************");
//		System.out.println(student.getInfo()+"\n************");
//		System.out.println(graduate.getInfo()+"\n************");
		
		Exercise05 test=new Exercise05();
		
		test.getMethod();	
		
	}
}

class Person{
	
	protected String name="perdon";
	protected int age=50;
	
	public String getInfo(){
		return "Name: "+name+"\nage: "+age;
	}	
}

class Student extends Person{
	
	protected String school="北大";
	
	public String getInfo(){
		return super.getInfo()+"\nschool: "+school;
	}
}	

class Graduate extends Student{
	
	public String major="IT";
	
	public String getInfo(){
	return super.getInfo()+"\nmajor: "+major;	
	}
	
}


	
	
	
