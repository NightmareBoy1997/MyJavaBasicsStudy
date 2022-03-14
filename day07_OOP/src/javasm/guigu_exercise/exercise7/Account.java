package javasm.guigu_exercise.exercise7;
/*
 * 实验 类的继承，super (一)
 * 
 * 1、写一个名为 Account 的类模拟账户。该类的属性和方法如下图所示。该类包括的属性：
账号 id，余额 balance，年利率 annualInterestRate；包含的方法：访问器方法（getter 和
setter 方法），返回月利率的方法 getMonthlyInterest()，取款方法 withdraw()，存款方法
deposit()。

 * 
 * 
 */
public class Account {

	private int id;
	private double balance;
	private double annuallnterestRate;
	
	public Account(){
		
	}
	public Account(int id,double balance,double annuallnterestRate){
		this.id=id;
		this.balance=balance;
		this.annuallnterestRate=annuallnterestRate/100;
	}
	
	public int getId(){
		return id;
	}
	public void setId(int id){
		this.id=id;
	}
	public double getBalance(){
		return balance;
	}
	public void setBalance(double balance){
		this.balance=balance;
	}
	public double getAnnuallnterestRate(){
		return annuallnterestRate;
	}
	public void setAnnuallnterestRate(double annuallnterestRate){
		this.annuallnterestRate=annuallnterestRate/100;
	}
	
	public double getMonthlylnterest(){
		return  annuallnterestRate/12;
	}
	
	public void withdraw(double amount){
		if(balance<amount){
			System.out.println("余额不足！\n您的账户余额为： "+balance);
		}else{
			System.out.println("取款成功！");
			balance -=amount;
		}
	}
	public void deposit(double amount){
		balance +=amount;
		System.out.println("存款成功！本次存入"+amount);
	}
	
	
	public static void main(String[]args){
		
		Account test=new Account(1122,20000,4.5);
		
		test.withdraw(30000);
		System.out.println("您的账户余额为： "+test.getBalance());
		
		test.withdraw(2500);
		test.deposit(3000);
		System.out.println("您的帐户余额为： "+test.getBalance());
		System.out.println("月利率为： "+test.getMonthlylnterest()*100+"%");
	}
	
	
}
