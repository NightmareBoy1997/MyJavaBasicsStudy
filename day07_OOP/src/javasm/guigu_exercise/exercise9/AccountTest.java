package javasm.guigu_exercise.exercise9;
/*
 * 
 * 编写一个类实现银行账户的概念，包含的属性有“帐号”、“密码”、“存款余额”、“利率”、“最小余额”，
定义封装这些属性的方法。账号要自动生成。编写主类，使用银行账户类，输入、输出3个储户的上述信息。
考虑：哪些属性可以设计成static
 * 
 * 
 */
public class AccountTest {
	public static void main(String[]args){
		Account acc1=new Account();
		Account acc2=new Account(4500.0,"wei1234");
		Account acc3=new Account(1.00,"weiabc12345");
		
		acc1.show();
		acc2.show();
		acc3.show();
		
		System.out.println(Account.getInterestRate());
	}
}

class Account{
	private static double interestRate;
	private static double minMoney=1.0;
	private static int init=1001;			//用于自动生成id
	private double balance;
	private String password="123456";
	private  int id;
	
	
	final static int i6=1;
	static final int i8=22;
	private final static int i7=1;
	static private final int i9=22;
	static final private int i10=20;		//关键字不分先后
	
	Account(){
		id=init++;
		interestRate=0.045;
	}
	Account(double balance,String password){
		this();
		this.balance=balance;
		this.password=password;
	}
	
	public int getId(){
		return id;
	}
	public static double getInterestRate(){
		return interestRate;
	}
	public static double getMinMoney(){
		return minMoney;
	}
	public void setBalance(double balance){
		this.balance=balance;
	}
	public double getBalance(){
		return balance;
	}
	public void setPassword(String password){
		this.password=password;
	}
	public String getPassword(){
		return password;
	}
	
	public void with(double amount){
		
	}
	
	public void show(){
		System.out.println("账号： "+getId()+" ,存款余额： "+getBalance()+" 利率： "+getInterestRate()+" 密码： "+getPassword());
	}
	
}