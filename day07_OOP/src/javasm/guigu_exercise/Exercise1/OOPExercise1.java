package javasm.guigu_exercise.Exercise1;

/*
 * 
 * 
 * 
 * 
 */

public class OOPExercise1 {
	public static void main(String[]args){
		
		Student theshy=new Student();
		System.out.println(theshy.say());
		
		
		
		
		
		
		
	}
	
	
}
class Student{
//创建类，设计类的属性	
	String name;
	String gender;
	int age;
	int id;
	double score;
	
	public String say(){
		name="TheShy";
		gender="男";
		age=18;
		id=001;
		score=59.9;
		return "该学生的个人信息:   名字："+name+"   性别:"+gender+"   年龄："+age+"   学生编号："+id+"   他的成绩是："+score;
	}

}



