package javasm.guigu_exercise.exercise10;

import java.util.Calendar;

/*
 * 
 * 编写工资系统，实现不同类型员工(多态)的按月发放工资。如果当月出现某个
Employee对象的生日，则将该雇员的工资增加100元。

（5）定义PayrollSystem类，创建Employee变量数组并初始化，该数组存放各类雇员对象的引用。
利用循环结构遍历数组元素，输出各个对象的类型,name,number,birthday,以及该对象生日。
当键盘输入本月月份值时，如果本月是某个Employee对象的生日，还要输出增加工资信息。
 * 
 * 
 * 
 * 
 * 
 */

public class PayrollSystem{
	public static void main(String []args){
		
		//方式一：键盘输入月份
//		System.out.print("请输入本月的月份： ");
//		Scanner scanner=new Scanner(System.in);
//		int month=scanner.nextInt();
		
		//方式二
		Calendar calendar=Calendar.getInstance();
		int month=calendar.get(Calendar.MONTH);
	
		Employee []array=new Employee[3];
		array[0]=new SalariedEmployee("马云",001,new MyDate(1955,6,3),299.0);
		array[1]=new HourlyEmployee("马化腾",003,new MyDate(1976,1,9),300,20);
		array[2]=new SalariedEmployee("王健林",004,new MyDate(1945,3,13),7999);
		
		for(int i=0;i<array.length;i++){
			System.out.println(array[i].toString());
			int index=array[i].getBirthday().getMonth();
			double salary=array[i].earnings();
			if(index==month+1){
				salary+=100;
				System.out.println("生日快乐！获得生日奖金100！");
			}
			System.out.println(" MonthlySalary: "+salary);
		}
		
		
	}
}

/*（2）MyDate类包含:
private成员变量year,month,day ；
toDateString()方法返回日期对应的字符串：xxxx年xx月xx日*/

class MyDate{
	private int year;
	private int month;
	private int day;
	
	public MyDate(int year,int month,int day){
		this.year=year;
		this.month=month;
		this.day=day;
	}
	
	public String toDateString(){
		return year+"年 "+month+"月 "+day+"日 ";
	}
	public int getMonth(){
		return month;
	}
	
}

/*（1）定义一个Employee类，该类包含：
private成员变量name,number,birthday，其中birthday 为MyDate类的对象；
abstract方法earnings()；toString()方法输出对象的name,number和birthday。*/

abstract class Employee{
	private String name;
	private int number;
	private MyDate birthday;
	
	public Employee(String name,int number,MyDate birthday){
		this.name=name;
		this.number=number;
		this.birthday=birthday;
	}
	
	public abstract double earnings();
	
	public String toString(){
		return "name: "+name+" number: "+number+" birthday: "+birthday.toDateString();
	}
	public MyDate getBirthday(){
		return birthday;
	}
	
}


/*（3）定义SalariedEmployee类继承Employee类，实现按月计算工资的员工处
理。该类包括：private成员变量monthlySalary；
实现父类的抽象方法earnings(),该方法返回monthlySalary值；toString()方法输
出员工类型信息及员工的name，number,birthday。*/

class SalariedEmployee extends Employee{
	private double monthlySalary;
	
	public SalariedEmployee(String name,int number,MyDate birthday,double monthlySalary){
		super(name,number,birthday);
		this.monthlySalary=monthlySalary;
	}
	
	public double earnings(){
		return monthlySalary;
	}
	public String toString(){
		return "[ "+super.toString()+" ]";
	}
	
}


/*（4）参照SalariedEmployee类定义HourlyEmployee类，实现按小时计算工资的
员工处理。该类包括：
private成员变量wage和hour；
实现父类的抽象方法earnings(),该方法返回wage*hour值；
toString()方法输出员工类型信息及员工的name，number,birthday。*/

class HourlyEmployee extends Employee{
	private int wage;
	private int hour;
	
	public HourlyEmployee(String name,int number,MyDate birthday,int wage,int hour){
		super(name,number,birthday);
		this.wage=wage;
		this.hour=hour;
	}
	
	public double earnings(){
		return wage*hour;
	}
	public String toString(){
		return "[ "+super.toString()+" ]";
	}
	
}

