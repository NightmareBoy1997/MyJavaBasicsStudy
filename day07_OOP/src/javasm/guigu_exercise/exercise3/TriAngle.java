package javasm.guigu_exercise.exercise3;
/*
 * 编写两个类，TriAngle和TriAngleTest，其中TriAngle类中声明私有的底边长
 * base和高height，同时声明公共的方法访问私有变量。
 * 此外，提供类必要的构造器。另一个类中使用这些公共方法，计算三角形面积
 * 
 * 
 * 
 * 
 */
public class TriAngle {

	private double base;
	private double height;
	
	public TriAngle(){
		base=1;
		height=1;
	}
	public TriAngle(double m,double n){
		base=m;
		height=n;
	}
	
	public void setBase(double n){
		base=n;
	}
	public double getBase(){
		return base;
	}
	public void setHeight(double n){
		height=n;
	}
	public double getHeight(){
		return height;
	}
	
	public double getSum(double n,double g){
		return height*base/2;
	}
}
