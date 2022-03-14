package javasm.guigu_exercise.Exercise1;

/*
 * 2.利用面向对象的编程方法，设计类Circle计算圆的面积。
 * 
 */
public class CircleTest {
	public static void main(String[] args) {

		Circle c1 = new Circle();
		// int a1=c1.area(3.1415926);
		c1.radius=3.0;
		System.out.println(c1.findArea());
	}
}


//圆的类
class Circle {
	//属性
	double radius;
	
	
	//求圆的面积
	public double findArea() {
		double area =(Math.PI * radius * radius);
		return area;
	}

}