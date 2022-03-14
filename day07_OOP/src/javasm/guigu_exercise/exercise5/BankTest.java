package javasm.guigu_exercise.exercise5;

public class BankTest {

	public static void main(String[]args){
	
		Bank bank=new Bank();
		bank.addCustomer("德玛", "西亚");
		
		bank.getCustomer(0).setAccount(new Account(1000));
		
		bank.getCustomer(0).getAccount().withdraw(500);
		bank.getCustomer(0).getAccount().deposit(10);
		System.out.println("Customer [ "+bank.getCustomer(0).getFirstName()+bank.getCustomer(0).getLastName()+" ] ,"+"余额为："+bank.getCustomer(0).getAccount().getBalance());
		
	}
}
