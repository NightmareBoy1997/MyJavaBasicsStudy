package javasm.guigu_exercise.exercise9;

public class Sss2 {

	}

class Man{

	private static Man test;
	private Man(){
	}
	
	public static Man getTest(){
		if(test==null){
			test=new Man();
		}
		return test;
	}
}

class  Person{
	private static Person test=new Person();
	private Person(){
	}
	public static Person getTest(){
		return test;
	}
}