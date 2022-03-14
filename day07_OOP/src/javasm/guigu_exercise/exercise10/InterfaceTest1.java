package javasm.guigu_exercise.exercise10;
/*
 * 接口
 * 
 * 练习4
定义一个接口用来实现两个对象的比较。
interface CompareObject{
public int compareTo(Object o); //若返回值是 0 , 代表相等; 若为正数，代表当
前对象大；负数代表当前对象小
}
定义一个Circle类，声明redius属性，提供getter和setter方法
定义一个ComparableCircle类，继承Circle类并且实现CompareObject接口。在
ComparableCircle类中给出接口中方法compareTo的实现体，用来比较两个圆的半
径大小。
定义一个测试类InterfaceTest，创建两个ComparableCircle对象，调用compareTo
方法比较两个类的半径大小。
思 考 ： 参 照 上 述 做 法 定 义 矩 形 类 Rectangle 和 ComparableRectangle 类 ， 在
ComparableRectangle类中给出compareTo方法的实现，比较两个矩形的面积大小。

 */

public class InterfaceTest1{
	public static void main(String[]args){
		
		ComparableRectangle rectangle1=new ComparableRectangle(5.2,5.0);
		ComparableRectangle rectangle2=new ComparableRectangle(5.1,5.0);
		Rectangle rectangle3=new Rectangle(5.1,5.0);
		
		rectangle1.getCompareTo(rectangle2);
		rectangle1.getCompareTo(rectangle3);
		
	}	
}


interface CompareObject1{
	public int compareTo(Object object);
}

class Rectangle{
	
	private Double wide;
	private Double height;
	
	public Rectangle(Double wide,Double height){
		this.wide=wide;
		this.height=height;
	}
	
	public Double getWide(){
		return wide;
	}
	
	public Double findArea(){
		return wide*height;
	}
	
	
//			//方式二：	
//			//当属性radius声明为包装类Double类型时，可以调用包装类方法
//			return this.getRadius().compareTo(object1.getRadius());

}

class ComparableRectangle extends Rectangle implements CompareObject1{
	
	public ComparableRectangle(Double wide,Double height){
		super(wide,height);
	}
	
	public int compareTo(Object object){
		if(this==object){
			return 0;
		}else if(object instanceof ComparableRectangle){
			ComparableRectangle objectRectangle=(ComparableRectangle)object;
			
			return this.findArea().compareTo(objectRectangle.findArea());
			
		}else{
			 throw new RuntimeException("传入的类型不匹配！");
			
		}
	}
	
	public void getCompareTo(Object object){
		int index=compareTo(object);
		if(index>0){
			System.out.println("此矩形面积较大！");
		}else if(index==0){
			System.out.println("两个矩形面积一样大！");
		}else{
			System.out.println("此矩形面积较小！");
		}
	}
	
}
