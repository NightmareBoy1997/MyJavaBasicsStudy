package javasm.java2;

/*
 * 自定义数组工具类测试
 * 
 */
public class ArrayUtilTest {
	public static void main(String[]args){
		
		ArrayUtil util=new ArrayUtil();
		int []arr1=new int[]{-1,5,6,88,-66,-128,-3060,3090,6800};
		util.sort(arr1);
		util.print(util.copy(arr1));
		System.out.println(util.getIndex(arr1,5));
	}
}



/*
 * 自定义数组工具类
 *
 */
class ArrayUtil {

	//求数组的最大值
	public int getMax(int[] arr){
		int maxValue=arr[0];
		for(int i=0;i<arr.length;i++){
			if(arr[i]>maxValue){
				maxValue=arr[i];
			}
		}
		return maxValue;
	}

	public void getMax(String arr){

	}		//	两个数组构成了重载


	//求数组的最小值
	public int getMin(int[] arr){
		int minValue=arr[0];
		for(int i=0;i<arr.length;i++){
			if(minValue>arr[i]){
				minValue=arr[i];
			}
		}
		return minValue;
	}

	//求数组的总和
	public int getSum(int[] arr){
		int sum=0;
		for(int i=0;i<arr.length;i++){
			sum +=arr[i];
		}
		return sum;
	}

	//求数组的平均值
	public int getAvg(int[] arr){
		return getSum(arr)/arr.length;	//调用其他方法
	}

	//反转数组
	public void reverse(int []arr){
		for(int i=0;i<arr.length/2;i++){
			int temp=arr[i];
			arr[i]=arr[arr.length-i-1];
			arr[arr.length-i-1]=temp;
		}
	}

	//复制数组
	public int[] copy(int[] arr){
		int[]arr1=new int[arr.length];
		for(int i=0;i<arr1.length;i++){
			arr1[i]=arr[i];
		}
		return arr1;
	}

	//数组冒泡排序
	public void sort(int[]arr){
		for(int i=0;i<arr.length-1;i++){
			for(int j=0;j<arr.length-i-1;j++){
				if(arr[j]>arr[j+1]){
					int temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
				}
			}
		}
	}

	//遍历数组
	public void print(int[]arr){
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}

	//查找指定元素
	public int getIndex(int[]arr,int dest){
		for(int i=0;i<arr.length;i++){
			if(dest==arr[i]){
				return i;
			}
		}
		return -1;
	}


}
