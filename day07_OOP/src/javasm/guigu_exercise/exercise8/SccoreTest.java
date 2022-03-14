package javasm.guigu_exercise.exercise8;

import java.util.*;

/*
 * 利用Vector代替数组处理：从键盘读入学生成绩（以负数代表输入结束），找出
最高分，并输出学生成绩等级。

 * 若与最高分相差10分内：A等；20分内：B等；30分内：C等；其它：D等
 * 
 * 提示：数组一旦创建，长度就固定不变，所以在创建数组前就需要知道它的
长度。而向量类java.util.Vector可以根据需要动态伸缩。

 (创建Vector对象：Vector v=new Vector();
给向量添加元素：v.addElement(Object obj); //obj必须是对象
取出向量中的元素：Object obj=v.elementAt(0);
注意第一个元素的下标是0，返回值是Object类型的。
计算向量的长度：v.size();)
 * 
 */
public class SccoreTest {
	public static void main(String[]args){
		Scanner s1=new Scanner(System.in);
		int maxScore=0;
		
		Vector v=new Vector();
		for(;;){
			System.out.print("请输入学生成绩（以负数结束）： ");
			int score=s1.nextInt();
			if(score<0){
				break;
			}
			if(score>100){
				System.out.println("输入的数据非法！请重新输入");
				continue;
			}
			maxScore=(score>maxScore)?score:maxScore;
			//jdk5.0之前
			//Integer inScore=new Integer(score);
			
			v.addElement(score);
		}
		
		for(int i=0;i<v.size();i++){
			Object obj=v.elementAt(i);
			char c1;
			
			//jdk 5.0之后 自动拆箱
			int num=((Integer)obj).intValue();
			int score=(Integer)obj;
			
			if(score>=maxScore-10){
				c1='A';
			}else if(score>=maxScore-20){
				c1='B';
			}else if(score>=maxScore-30){
				c1='C';
			}else{
				c1='D';
			}
			
//			boolean b1=new Integer(score) instanceof Object;
			
			//jdk5.0之前
//			int score=(Integer)obj;
//			if(score>=maxScore-10){
//				c1='A';
//			}else if(score>=maxScore-20){
//				c1='B';
//			}else if(score>=maxScore-30){
//				c1='C';
//			}else{
//				c1='D';
//			}
			System.out.println("编号： "+(i+1)+" 的学生成绩是：  "+obj+" 等级是： "+c1);
		}
		
		
		
	}
	
	
}
