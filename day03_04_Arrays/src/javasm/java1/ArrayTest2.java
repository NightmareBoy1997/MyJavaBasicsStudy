package javasm.java1;
/*
 * 二、多维数组的使用
 * 
 * 1.理解
 * 对于二维数组，可以看作是一维数组array1又作为另一个一维数组array2的元素而存在。
 其实，从数组底层的运行机制来看，其实没有多维数组。
 * 
 * 2.二维数组的使用：
 * 		①二维数组的声明和初始化
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
 * 
 */
public class ArrayTest2 {
 public static void main(String[] args) {
	//1.二维数组的声明和初始化
	 
	int []arr=new int[]{1,2,3};//一维数组的初始化。
	//静态初始化
	int [][]arr1=new int[][]{{1,2,3},{4,5},{5,6}};
	//动态初始化1
	String [][]arr2=new String[3][2];
	//动态初始化2
	String [][]arr3=new String[3][];
/*	//错误情况
	String [][]arr4=new String[][2];
	String [3][2]arr5=new String[][];
	String [][]arr6=new String[][]{{},{}};//等同于2，确定了外层数组元素个数
	*/
	
	//特殊写法
	int[] arr4[]=new int[][]{{1,2,3},{4,5},{6,7}};
	int[][]arr5 =new int[][]{{1,2,3},{4,5},{6,7}};
	int[][]arr6 ={{1,2,3},{4,5},{6,7}};
	
	//2.如何调用数组的指定位置的元素

 
	
	for(int i=0;i<arr5.length;i++){
		System.out.println(arr5[i][1]);
	}
	
	arr3[1]=new String[4];//对二维数组中的元素数组进行初始化
	System.out.println(arr3[1][0]);
	


 
}
}
