package javasm.guigu_exercise.exercise6;
/*
 * 圆
 *  
 */
public class Circle {

	private double radius; //半径
	
	public Circle(){
		radius=1;
	}

	
	public void setRadius(double radius){
		this.radius=radius;
	}
	public double getRadius(){
		return radius;
	}

	public double findArea(){
		return Math.PI*radius*radius;
	}

	
	
}
