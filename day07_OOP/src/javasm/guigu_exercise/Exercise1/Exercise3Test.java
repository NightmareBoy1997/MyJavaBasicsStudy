package javasm.guigu_exercise.Exercise1;

/*3.1编写程序，声明一个method方法，在方法中打印一个10*8的*矩形，在main方法中调用
 * 
 *3.2修改上一个程序，在method方法中，除打印一个10*8的*矩形外，在计算该矩形的面积
 *，并将其作为方法返回值，在main方法中调用该方法，接收返回的面积值并打印。 
 * 
 * 3.3修改上一个程序，在method方法提供m和n两个参数，方法中打印一个m*n的*型矩形
 * ，并计算该矩形的面积
 * 
 */

public class Exercise3Test {
	public static void main(String[] args) {

		Rectangle r1=new Rectangle();
		System.out.println("面积为："+r1.printRectangle(5,3));//可以打印出矩形
	}
}

class Rectangle {
	char x='*';

	
public int printRectangle(int m,int n){
	
	for(int i=0;i<m;i++){
		for(int j=0;j<n;j++){
		System.out.print(x+"   ");	
		}
		System.out.println();
	}
	return m*n;
}

	
	
}
