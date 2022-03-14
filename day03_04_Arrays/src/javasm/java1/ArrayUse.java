package javasm.java1;

public class ArrayUse {
	public static void main(String[] args) {

//1.数组的复制：赋值array2的变量等于array1，修改array2的偶索引元素，打印array1。
		
		String array1[]=new String[]{"AA","BB","CC","DD"};
		String array2[]=array1;
		for(int i=0;i<array2.length;i++){
			System.out.print(array2[i]+"  ");
		}
		System.out.println();
		
		for(int i=0;i<array2.length;i++){
			if(i%2==0){
					array2[i] +=i;
			}
			System.out.print(array1[i]+"  ");
		}//此时输出的array1的元素发生了变化，因为array2只是跟array1共用一个内存地址，array2并不是新开辟的内存
	
		System.out.println();
		
//真正的复制新数组的方式：
		String array3[]=new String[]{"AA","BB","CC","DD","EE"};
		String array4[]=new String[4];
		for(int i=0;i<array4.length;i++){
			array4[i]=array3[i];
			System.out.print(array4[i]+"  ");
		}
		System.out.println();
		
//1.1数组的反转：
		for(int i=0;i<array3.length/2;i++){
			String temp=array3[i];
			array3[i]=array3[array3.length-1-i];
			array3[array3.length-1-i]=temp;
		}
		for(int i=0;i<array3.length;i++){
			System.out.print(array3[i]+"  ");
		}
		System.out.println();
		
		//方式二：
		for(int i=0,j=array3.length-1;i<j;i++,j--){
			String temp=array3[i];
			array3[i]=array3[j];
			array3[j]=temp;
	
		}
		for(int i=0;i<array3.length;i++){
			System.out.print(array3[i]+"  ");
		}
		System.out.println();
		
//数组的查找：
//1.1线性查找：
		boolean isFlag=true;
		String dest="DD";
		for(int i=0;i<array3.length;i++){
			if(dest.equals(array3[i])){
				System.out.println("找到了位置在:"+i);
				isFlag=false;
				break;
			}
		}
			if(isFlag){
				System.out.println("很遗憾，没有找到！");
			}
//1.2二分法查找：
//前提,所要查找的数组必须有序。
		int array[]=new int[]{1,2,3,4,8,9,7,12,45,88};
		int dest1=12;
		boolean isFlag1=true;
		int head=0;//初始的首索引
		int end=array.length-1;//初始的末索引
		
		while(head<=end){
			int middle=(head+end)/2;
			if(dest1==array[middle]){
				System.out.println("找到了，位置在："+middle);
				isFlag1=false;
				break;
			}else if(dest1>array[middle]){
				head=middle+1;
			}else{//dest1<array[middle]
				end=middle-1;
			}
		
		}
		if(isFlag1){
			System.out.println("很遗憾，没有找到！");
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
