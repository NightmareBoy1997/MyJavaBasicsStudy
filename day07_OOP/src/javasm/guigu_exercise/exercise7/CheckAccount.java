package javasm.guigu_exercise.exercise7;

public class CheckAccount extends Account{

	private double overdraft;
	
	public CheckAccount(){
	}
	public CheckAccount(int id,double balance,double annuallnterestRate,double overdraft){
		super(id,balance,annuallnterestRate);
		this.overdraft=overdraft;
	}
	
	public void withdraw(double amount){
		if(amount<=getBalance()){
			System.out.println("取款成功！");
			setBalance(getBalance()-amount);
			System.out.println("您的账户余额： "+getBalance());
			System.out.println("您的可透支余额： "+overdraft);
		}else if(amount<=(getBalance()+overdraft)){
			System.out.println("取款成功！");
			overdraft +=getBalance()-amount;
			setBalance(0);
			System.out.println("您的账户余额： "+getBalance());
			System.out.println("您的可透支余额： "+overdraft);
		}else{
			System.out.println("取款失败！\n超过可透支余额！");
		}
	}
	
		public void deposit(double amount){
			if(amount>=5000-overdraft){
				setBalance(amount-5000+overdraft);
				overdraft=5000;
				System.out.println("存款成功！\n您的账户余额为： "+getBalance()+"\n您的可透支余额为： "+overdraft);
			}else{
				overdraft+=amount;
				System.out.println("存款成功！\n您的账户余额为： "+getBalance()+"\n您的可透支余额为： "+overdraft);
			}
		}
	
		public static void main(String[]args){
		CheckAccount test=new CheckAccount(1122,20000,4.5,5000);
		
		test.withdraw(5000);
		test.getBalance();
		System.out.println("**********************");
		test.withdraw(18000);
		test.withdraw(1000);
		test.withdraw(3000);
		System.out.println("**********************");
		test.deposit(3000);
		
		test.deposit(1000);
		test.deposit(3000);
	}
		
}
