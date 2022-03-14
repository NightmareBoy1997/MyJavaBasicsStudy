package javasm.guigu_exercise.exercise5;
/*
 * 实验2.1
 */
public class Account {

	private double balance;
	
	public Account(double init_balance){
		this.balance=init_balance;
	}
	
	public double getBalance(){
		return balance;
	}
	
	public void deposit(double amt){
		if(amt>0){
		balance +=amt;
		System.out.println("成功存入： "+amt);
		}
	}	
	public void withdraw(double amt){
		if(balance<amt){
			System.out.println("余额不足，取款失败！");
			return;
		}
		balance -=amt;
		System.out.println("成功取出："+amt);
	}
	
}
