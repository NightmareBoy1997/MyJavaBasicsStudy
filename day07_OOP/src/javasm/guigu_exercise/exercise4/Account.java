package javasm.guigu_exercise.exercise4;
/*
 * Account_Customer测试题 .1
 * 
 * 
 * 
 * 
 */
public class Account {

	
	private int id;  //账户
	private double balance;  //余额
	private double annuallnterestRate;  //年利率
	
	public Account(int id,double balance,double annuallnterestRate){
		this.id=id;
		this.balance=balance;
		this.annuallnterestRate=annuallnterestRate;
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
	public void setBalance(double banlance){
		this.balance=balance;
	}
	public double getAnnuallnterestRate(){
		return annuallnterestRate;
	}
	public void setAnnuallnterestRate(double annuallnteresRate){
		this.annuallnterestRate=annuallnterestRate;
	}
	
	public void withdraw(double amount){
		if(balance<amount){
			System.out.println("取款失败！余额不足！");
			return;
		}
			balance-=amount;
			System.out.println("成功取出： "+amount);
	}
	public void deposit(double amount){
		if(amount>0){
		balance +=amount;
		System.out.println("成功存入： "+amount);
		}
	}
	
	
}
