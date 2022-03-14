package javasm.guigu_exercise.exercise3;

public class BoyGirlTest {

	public static void main(String[] args) {

		Boy boy = new Boy("罗密欧", 21);
		boy.shout();

		Girl girl = new Girl("朱丽叶", 18);

		girl.marry(boy);
		girl.compare(girl);
		
		Girl girl1=new Girl("祝英台",19);
		Boy boy1=new Boy("梁山伯",22);
		
		girl1.marry(boy1);
		int compare=girl1.compare(girl);
		if(compare>0){
			System.out.println(girl1.getName()+"大");
		}else if(compare<0){
			System.out.println(girl.getName()+"大");
		}else{
			System.out.println("一样大");
		}
	}
}