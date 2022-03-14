package javasm.guigu_exercise.exercise8;
/*
 * 
 * 重写toString方法
 * 重写equals方法
 * 
 */
public class FieldMethodTest {
	
}
class User{
	String name;
	int age;
	
		public boolean equals(Object obj){
		if(obj==this){
			return true;
		}
		if(obj instanceof User){
			User u=(User)obj;
			//比较各个属性是否相同
			return this.age==u.age && this.name.equals(u.name);
		}
		return false;
	}
}

class User1{
	int age;
	String name;
	
	public String toString(){
		return "User1[ age= "+age+" ,name= "+name+" ]";
	}
	
	
}
	