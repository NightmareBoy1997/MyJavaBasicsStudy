package javasm.guigu_exercise.exercise2;
/*
 * 编写程序，定义三个重载方法并调用。方法名为mOL。
三个方法分别接收一个int参数、两个int参数、一个字符串参数。
分别执行平方运算并输出结果，相乘并输出结果，输出字符串信息。
在主类的main ()方法中分别用参数区别调用三个方法。


3.定义三个重载方法max()，第一个方法求两个int值中的最大值，
第二个方法求两个double值中的最大值，第三个方法求三个double值中
的最大值，并分别调用三个方法。

 */
public class OverloadExer {
	public static void main(String[]args){
		OverloadExer ov1=new OverloadExer();
		System.out.println(ov1.mOL(2));
		System.out.println(ov1.mOL(1,5));
		ov1.mOL("德玛西亚");
		
		System.out.println(ov1.max(5,3));
		System.out.println(ov1.max(1.333, 1.6669));
		System.out.println(ov1.max(21.5556, 3.88889,4.2222228));
		
	}
	

	public int mOL(int i){
		return i*i;
	}
	
	public int mOL(int i,int j){
		return i*j;
	}
	
	
	
	
	public void mOL(String xx){
		System.out.println(xx);
	}
	
	public int max(int i,int j){
		if(i>=j){
			return i;
		}else{
			return j;
		}
	}
	
	public double max(double i,double j){
		if(i>=j){
			return i;
		}else{
			return j;
		}
	}
	
	public double max(double i,double j,double m){
		double max=(i>j)?i:j;
		return (max>m)?max:m;
	}
	
	
}

