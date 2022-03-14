package javasm.guigu_exercise.exercise6;
/*
 *圆柱 
 * 
 */
public class Cylinder extends Circle{

	private double length;
	
	public Cylinder(){
		length=1;
	}
	
	
	public void setLength(double length){
		this.length=length;
	}
	public double getLength(){
		return length;
	}
	
	//圆柱的体积
	public double findVolume(){
		return super.findArea()*length; //findArea()被重写
//		return Math.PI*getRadius()*getRadius()*length;
	}
	
	public double findArea(){ //返回圆的表面积
		return 2*Math.PI*getRadius()*length;
	}
	
}
