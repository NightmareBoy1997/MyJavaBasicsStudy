package javasm.guigu_exercise.Exercise1;

/*
 * 
 * 
 * 
 */

public class PersonClassExercise {
	public static void main(String[] args) {
		Person theShy = new Person();
		theShy.name="TheShy";
		theShy.age=18;
		theShy.sex=0;
		theShy.student();
		theShy.showAge();
		System.out.println(theShy.name+"的新年龄："+theShy.addAge(2));
		
		Person wei=new Person();
		wei.name="weiguoqi";
		//wei.age=24;
		wei.sex=0;
		wei.student();
		wei.showAge();
		System.out.println(wei.name+"的新年龄："+wei.addAge(12));//12,不同对象都有独立的属性
		wei.showAge();//通过addAge已经修改了age的值，同一对象内
		
	}

}

class Person {

	String name;
	int age;
	
	/**
	 * sex:1 表明是男性 sex：0 表明是女性   //文档注释只能在前面才能生效
	 */
	int sex;
	public void student() {
		System.out.println("studying");
	}

	public void showAge() {
		System.out.println("age:" + age);
	}

	public int addAge(int i) {
		age +=i;
		return age;
	}
}