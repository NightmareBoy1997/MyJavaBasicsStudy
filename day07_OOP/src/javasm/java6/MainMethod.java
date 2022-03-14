package javasm.java6;
/*
 * main()方法的使用说明：
 * 	1. main()方法作为程序的入口
 *  2. main()方法也是一个普通的静态方法
 *  3. main()方法可以作为与控制台交互的方式.(之前：Scanner)
 * 	  如何将可控制台获取的数据传给形参： Stirng[] args？
 * 	    运行时： java 类名 "Tom" "Xbei" "123" "false"
 * 	    sout( args[0] ) ; // "Tom"
 * 	    sout( args[3] ) ; // "false"
 *
 */
public class MainMethod {  //入口
	public static void main(String[]args){
		
		Main.main(new String[10]);
//		show();
	}
	
	public void show(){
		
	}
	
}

class Main{
	public static void main(String[]args){
		
		for(int i=0;i<args.length;i++){
			args[i]="args_"+i;
			System.out.println(args[i]);
		}
	}
}

class MainDemo{
	public static  void main(String[]args){
		
		for(int i=0;i<args.length;i++){
			System.out.println(args[i]+1+"*********");
			
			int num =Integer.parseInt(args[i]);
			System.out.println(num+1+"######");
		}
		
	}
	
}