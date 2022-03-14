package javasm.guigu_exercise.exercise5;
/*
 * 实验2.3
 * 
 */
public class Bank {

	private int numberOfCustomers;//记录客户的个数
	private Customer[] customers=new Customer[100];//存放客户的数组
	
	public Bank(){
		
	}
	
	//添加客户
	public void addCustomer(String firstName,String lastName){
		Customer cust=new Customer(firstName,lastName); 
//		customers[numberOfCustomer]=cust;
//		numberOfCustomer++;
		customers[numberOfCustomers++]=cust;
	}
	
	//获取客户的个数
	public int getNumberOfCustomers(){
		return numberOfCustomers;
	}
	
	//获取指定位置客户
	public Customer getCustomer(int index){
//		return customers[index]; //容易报异常，角标越界、空指针
		if(index>=0 && index<numberOfCustomers){
			return customers[index];
		}
		return null;
	}
	
	
	
}
