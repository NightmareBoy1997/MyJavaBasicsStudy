package javasm.guigu_exercise.exercise4;

/*
 * Account_Customer测试题 .2
 * 
 */
public class Customer {
	
	public static void main(String[]args){
		
		Customer test=new Customer("魏","国旗");
		Account a1=new Account(1000,2000,0.0123);
		test.setAccount(a1);
		
		test.getAccount().withdraw(960);
		test.getAccount().deposit(100);
		test.getAccount().withdraw(2000);
		
		System.out.print("Customer [ "+test.getLastName()+"."+test.getFirstName()
			+" ] "+"has a account:id "+test.getAccount().getId()+",annuallnterestRate is "
			+test.getAccount().getAnnuallnterestRate()*100+"%, "+"balance is: "+test.getAccount().getBalance());
	

		
	}
	
	
	
	

	private String firstName;
	private String lastName;
	//自定义的类也可以作为属性出现，她的属性的调用方法：当前对象调用方法+它自身的调用方法
	private Account account;	
	
	public Customer(String f,String l){
		this.firstName=f;
		this.lastName=l;
	}
	
	public String getFirstName(){
		return firstName;
	}
	public String getLastName(){
		return lastName;
	}
	public Account getAccount(){
		return account;
	}
	
	public void setAccount(Account account){
		this.account=account;
	}
	
	
	
	
}
