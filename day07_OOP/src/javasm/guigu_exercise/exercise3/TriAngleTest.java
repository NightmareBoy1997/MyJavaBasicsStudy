package javasm.guigu_exercise.exercise3;

public class TriAngleTest {

	public static void main(String[] args) {

		TriAngle test = new TriAngle(3.1,4.1);
		
		test.setBase(2.5);
		test.setHeight(4.4);
		System.out.println("三角形的底边长是： " + test.getBase() + " 高是： " + test.getHeight());
		System.out.println(test.getSum(test.getBase(), test.getHeight()));

	}

}
