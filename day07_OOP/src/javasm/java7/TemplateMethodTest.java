package javasm.java7;
/*
 *  抽象类的应用：模板方法的设计模式
 *
 */
public class TemplateMethodTest {
	public static void main(String[]args){
		
		SubTemplate test=new SubTemplate();
		test.spendTime();
		
	}
}

abstract class Template{
	
	//计算某段代码执行所需要的时间
	public void spendTime(){
		long start=System.currentTimeMillis();
		code();		//不确定易变的部分
		long end=System.currentTimeMillis();
		System.out.println("花费的时间为： "+(end-start));
	}
	
	public abstract void code();
	
}

class SubTemplate extends Template{
	
	public void code(){
		for(int i=0;i<1000;i++){
			boolean isFlag=true;
			for(int j=2;j<Math.sqrt(i);j++){
					if(i%j==0){
						isFlag=false;
						break;
						}
					}
			if(isFlag){
				System.out.println(i);
			}
		}
	}
}