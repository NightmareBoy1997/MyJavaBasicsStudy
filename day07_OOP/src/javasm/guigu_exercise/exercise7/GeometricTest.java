package javasm.guigu_exercise.exercise7;
/*
 * 
 * 定义三个类，父类GeometricObject代表几何形状，子类Circle代表圆形，MyRectangle
 * 代表矩形。定义一个测试类GeometricTest，编写equalsArea方法测试两个对象的面积是否
 * 相等（注意方法的参数类型，利用动态绑定技术），编写displayGeometricObject方法显示
 * 对象的面积（注意方法的参数类型，利用动态绑定技术）。
 * 
 */
public class GeometricTest {
	public static void main(String[]args){
		
		GeometricObject test=new GeometricObject();
		
		Circle c1=new Circle(10.0,"绿色",100.0);
		MyRectangle m1=new MyRectangle(10.0,10.0,"绿色",100.0);
		
		System.out.println(c1.findArea());
		System.out.println(m1.findArea());
		System.out.println("两个几何图形的面积是否相等：  "+m1.equalsArea(c1));
		
		
	}
}



class GeometricObject{
	protected String color;
	protected double weight;
	
	protected GeometricObject(){
	}
	protected GeometricObject(String color,double weight){
		this.color=color;
		this.weight=weight;
	}
	
	public void setColor(String color){
		this.color=color;
	}
	public String getColor(){
		return color;
	}
	public void setWeight(double weight){
		this.weight=weight;
	}
	public double getWeight(){
		return weight;
	}
	
	public double findArea(){
		return 0.0;
	}
	
	public boolean equalsArea(GeometricObject g){
		if(this.findArea() != g.findArea()){
			return false;
		}else{
			return true;
		}
	}
	public void displayGeometricObject(){
		System.out.println("该几何图形的面积是：  "+this.findArea());
	}
	
}


class MyRectangle extends GeometricObject{
	private double width;
	private double height;
	
	public MyRectangle(){
	}
	public MyRectangle(double width,double height,String color,double weight){
		super(color,weight);
		this.width=width;
		this.height=height;
	}
	
	public void setWidth(double width){
		this.width=width;
	}
	public double getWidth(){
		return width;
	}
	public void setHeight(double height){
		this.height=height;
	}
	public double getHeight(){
		return height;
	}
	
	public double findArea(){
		return width*height;
	}
	
}


class Circle extends GeometricObject{
	private double radius;
	
	public Circle(){
	}
	public Circle(double radius,String color,double weight){
		super(color,weight);
		this.radius=radius;
	}
	
	public void setRadius(double radius){
		this.radius=radius;
	}
	public double getRadius(){
		return radius;
	}
	
	public double findArea(){
		return radius *radius*Math.PI;
	}
}