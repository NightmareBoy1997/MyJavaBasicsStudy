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
public class InterfaceTest{
	public static void main(String[]args){
	
	ComparableCircle circle1=new ComparableCircle(3.0);
	ComparableCircle circle2=new ComparableCircle(2.9);
	Circle circle3=new Circle(3.0);
	
	circle2.isCompare(circle1);
	circle2.isCompare(circle3); //类型不匹配
	System.out.println("66");
	
	}
}



abstract interface CompareObject{
	
	public abstract int compareTo(Object object);
	
}


class Circle{
	private Double radius;
	
	public Circle(Double radius){
		this.radius=radius;
	}
	
	public void setRadius(Double radius){
		this.radius=radius;
	}
	public Double getRadius(){
		return radius;
	}
	
}


class ComparableCircle extends Circle implements CompareObject{
	
	public ComparableCircle(Double radius) {
		super(radius);
	}

	public int compareTo(Object object){
		if(this==object){
			return 0;
		}else if(object instanceof ComparableCircle){
			ComparableCircle object1=(ComparableCircle)object;
			
			//错误的
//			return (int)(this.getRadius()-object1.getRadius());
			
			//方式一：
//			if(this.getRadius()>object1.getRadius()){
//				return 1;
//			}else if(this.getRadius()<object1.getRadius()){
//				return -1;
//			}else{
//				return 0;
//			}
		
			//方式二：	
			//当属性radius声明为包装类Double类型时，可以调用包装类方法
			return this.getRadius().compareTo(object1.getRadius());
		
		
		}else{
//			return 0;
			throw new RuntimeException("传入的类型不匹配！");
		}
	}
	
	public void isCompare(Object object){
		if(this.compareTo(object)>0){
			System.out.println("此圆较大！");
		}else if(this.compareTo(object)<0){
			System.out.println("此圆较小！");
		}else{
			System.out.println("两个圆一样大!");
		}
	}
	
}