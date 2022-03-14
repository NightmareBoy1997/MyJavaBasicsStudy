package javasm.guigu_exercise.exercise6;
/*
 * (3)定义类KidsTest，在类的main方法中实例化Kids的对象someKid，用该对象访问
其父类的成员变量及方法。
 * 
 */
public class CylinderTest {

	public static void main(String[]args){
		
	Cylinder someCylinder=new Cylinder();	
	
	someCylinder.setLength(10.0);
	someCylinder.setRadius(5.0);
	
//	System.out.println("圆柱的底圆面积是： "+someCylinder.findArea());
	System.out.println("圆柱的表面积是： "+someCylinder.findArea());
	System.out.println("圆柱的体积是： "+someCylinder.findVolume());
	
	}
}
