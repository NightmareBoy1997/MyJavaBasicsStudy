package javasm.guigu_exercise.exercise3;

public class BoyTest {


	
}

class Boy{
	
	private String name;
	private int age;
	
	
	public Boy() {
	
	}
	
	public Boy(String name, int age) {
		this.name = name;
		this.age = age;
	}


	public void setName(String name){
		this.name=name;
	}
	public String getName(){
		return name;
	}
	public void setAge(int age){
		this.age=age;
	}
	public int getAge(){
		return age;
	}
	
	public void marry(Girl girl){
		System.out.println("我想娶"+girl.getName());
	}
	
	public void shout(){
		if(age>=22){
			System.out.println("你可以合法登记了！");
		}else{
			System.out.println("不能合法登记！");
		}
		
	}
	
	
}

class Girl{
	
	private String name;
	private int age;
		
	public Girl() {
	
	}
		
	public Girl(String name, int age) {
		this.name = name;
		this.age = age;
	}



	public void setName(String name){
		this.name=name;
	}
	public String getName(){
		return name;
	}
	public void setAge(int age){
		this.age=age;
	}
	public int getAge(){
		return age;
	}
	
	public void marry(Boy boy){
		System.out.println("我想嫁给 "+boy.getName());
		boy.marry(this);	//!!
	}
	
	/**
	 * 
	 * @Description 比较两个对象的大小
	 * @author guoqi Wei
	 * @date 2021年2月14日下午8:55:09
	 * @param girl 
	 * @return 正数：当前对象大  负数：当前对象小 0：当前对象与形参对象想等
	 */
 	public int compare(Girl girl){
//		if(this.age>girl.age){
//			return 1;
//		}else if(this.age<girl.age){
//			return -1;
//		}else{
//			return 0;
//		}
		return this.age-girl.age;
	}
	
	
	
}