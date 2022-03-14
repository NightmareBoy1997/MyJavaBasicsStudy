package exercise;

/*
 * 
 * 编写应用程序EcmDef.java，接收命令行的两个参数，要求不能输入负数，计算两数相除。对 数 据 类 型
 * 不 一 致 (NumberFormatException) 、 缺 少 命 令 行 参 数(ArrayIndexOutOfBoundsException、
 * 除0(ArithmeticException)及输入负数(EcDef 自定义的异常)进行异常处理
 *
 * 疑问：double除0.0可以运行？
 *
 */
public class EcmDef {

	public static void main(String[] args) {
		
		try{
			int a=Integer.parseInt(args[0]);
			int b=Integer.parseInt(args[1]);
		method(a,b);
		}catch(ArrayIndexOutOfBoundsException e){
			System.out.println("空指针");
			System.out.println(e.getMessage());
		}catch(NumberFormatException e){
			System.out.println("类型不一致");
			e.printStackTrace();
		}catch(ArithmeticException e){
			System.out.println("除数为0！");
		}catch(EcDef e){
			System.out.println(e.getMessage());
		}
		
		System.out.println("执行完成！");
		
		
		
	}
	
	public static double method(int a,int b) throws NumberFormatException,ArrayIndexOutOfBoundsException,ArithmeticException,EcDef {
		if(a<0 || b<0){
			throw new EcDef("不能输入负数！");
		}else{
			return a/b;
		}
	}
	
	
	
}

class EcDef extends Exception{
	
	static final long e=-2987487489723l;
	
	public EcDef(){}
	public EcDef(String message){
		super(message);
	}
	
}