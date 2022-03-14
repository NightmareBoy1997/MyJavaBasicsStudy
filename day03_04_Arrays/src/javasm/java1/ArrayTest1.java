package javasm.java1;

/**
 * 
 * 一、数组的概述
 * 1.数组的理解：数组（Array），是多个同类型数据按一定顺序排列的集合，并使用一个名字命名，
 * 并通过编号的方式对这些数据进行统一管理 。
 * 
 * 2.数组相关的概念：
 * >数组名
 * >元素
 * >角标、下标、索引
 * >数组的长度：元素的个数
 * 
 * 3.数组的特点：
 * 1）数组是有序排列的
 * 2）数组属于引用数据类型的变量，元素的类型可以是任意类型（基本、引用）。
 * 3）创建数组对象会在内存中开辟连续的空间
 * 4）数组的长度一旦确定，就不能修改。
 * 
 * 4.数组的分类：
 * 		①按照维数：一维数组、二维数组、……
 * 		②按照数组元素的类型：基本数据类型元素的数组、引用数据类型元素的数组
 * 
 * 
 * 5.一维数组的使用
 * 
 * 		①一维数组的声明和初始化
 * 
 * 		②如何调用数组的指定位置的元素
 * 
 * 		③如何获取数组的长度
 * 
 * 		④如何遍历数组
 * 
 * 		⑤数组元素的默认初始化值
 * 			>数组元素是整型：0
 * 			>数组元素是浮点型：0.0
 * 			>数组元素是char类型：0或‘\u0000’,而非‘0’
 * 			>数组元素是boolean型：false
 * 
 * 			>数组元素是引用类型：null (零，空值)
 * 		⑥数组的内存解析
 * 
 */


public class ArrayTest1 {

	public static void main(String[] args) {
		
		//1.一维数组的声明和初始化
		int  num;//声明
		num =10;//初始化
		int id =101;//声明并初始化
		
		int [] ids;//声明
		//1.1 静态初始化:数组的初始化和数组的元素的赋值操作同时进行
		ids = new int[]{1001,1002,1003,1004};
		//1.2 动态初始化：数组的初始化和数组元素的赋值操作分开进行
		String [] names = new String [4];//只表明 names有2个元素，但未确定元素是什么
		
		//特殊情况，也是正确的写法
		int [] arr8={1,2,3};//类型推断
		
		/*错误的写法：只能是以上两种写法
		int [] arr1 = new int [];
		int [5] arr2= new int [5];
		int [] arr3 =new int [3]{1,2,3};
		*/
		
		//总结：数组一旦初始化完成，其长度就确定了。（内存中确定大小）
		
		//2.如何调用数组的指定位置的元素：通过角标的方式调用。
		//数组的角标（或索引）从0开始的，到数组的长度-1结束。
		names[0]="德玛";
		names[1]="剑圣";
		names[2]="赵信";
		names[3]="剑魔";
		//names[4]="亚索";数组长度超出
		
		//3.如何获取数组的长度
		//属性：length
		System.out.println(names.length);//长度5
		System.out.println(ids.length); //输入“.”可以调用
		
		//4.如何遍历数组
		/*System.out.println(names[0]);
		System.out.println(names[1]);*/
		
		for(int i = 0;i<names.length;i++){
			System.out.println(names[i]);
		}
		
		//5.数组元素的默认初始化值。
		int [] arr=new int [4];
		for(int i =0;i<arr.length;i++){
			System.out.println(arr[i]);
		}
		System.out.println("*************************");
		
		short [] arr1 =new short [4];
		for(int i =0;i<arr1.length;i++){
			System.out.println(arr1[i]);
		}
		
		float []arr2=new float [4];
		for(int i=0;i<arr2.length;i++){
			System.out.println(arr2[i]);
		}
		System.out.println("*************************");	
		
		char []arr3=new char [4];
		for(int i =0;i<arr3.length;i++){
			System.out.println("----"+arr3[i]+"----");
		}
		if(arr3[0]==0){
			System.out.println("char的数组元素默认值是0");
		}
		System.out.println("*************************");
		
		boolean []arr4=new boolean[4];
		System.out.println(arr4[1]);
		System.out.println("*************************");
		
		String []arr5=new String[4];
		System.out.println(arr5[1]);
		if(arr5[1]==null){
			System.out.println("住在山里针不戳！");
		}
		
		//6.数组的内存解析
		
		
		
	

		
	}
	

}




