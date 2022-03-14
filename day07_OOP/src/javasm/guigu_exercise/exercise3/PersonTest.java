package javasm.guigu_exercise.exercise3;
/*
 *
 * 
 * 在PersonTest类中实例化Person类的对象b，调用setAge（）和getAge（）方法，体现Java的封装性
 * 
 */
public class PersonTest {

	public static void main(String[]args){
		
		Person p1=new Person("tom",55);
		
		System.out.println("年龄是："+p1.getAge()+" 年龄是： "+p1.getName());
		
		p1.setAge(13);

		System.out.println("年龄是："+p1.getAge()+" 年龄是： "+p1.getName());
		
	}
	
	
}
