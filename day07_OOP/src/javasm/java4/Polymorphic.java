package javasm.java4;


/*
 * 面向对象特征之三：多态性
 * 		实现代码的通用性
 *
 *   1. 理解多态性：可以理解为一个事物的多种形态
 *   2. 何为多态性：
 *   	对象的多态性：父类的引用指向子类的对象（或子类的对象赋给父类的引用）
 *
 *   3. 多态的使用：虚拟方法调用
 * 		有了对象的多态性以后，内存中实际是加载了子类特有的属性和方法的，但是由于变量声明为父类类型，
 * 导致在编译期，只能调用父类中声明的属性和方法，	但是在运行期，我们实际执行的是子类重写父类的方法
 *
 * 	总结：编译 看左边，运行 看右边。
 *
 * 	 4. 多态性的使用前提： ①类的继承性关系 ②重写方法
 *
 *	 5. 对象的多态性：只适于方法，不适应属性（属性默认都看左边，但由于属性无法重写和覆盖 ，实际子类两套属性都有）
 *
 *虚拟方法调用：
 *	动态绑定 ：   子类中定义了与父类同名同参数的方法，在多态情况下，将此时父类的方法称为虚拟方法，父
类根据赋给它的不同子类对象，动态调用属于子类的该方法。这样的方法调用在编译期是 无法确定 的。
 *
 *	与重载的不同之处：
 *		对于重载而言，在方法调用之前，编译器就已经确定了所要调用的方法，这称为“早绑定”或“静态绑定”；
		而对于多态，只有等到方法调用的那一刻，解释运行器才会确定所要调用的具体方法，这称为“晚绑定”或“动态绑定”。
 *
 *		引用一句Bruce Eckel的话：“不要犯傻，如果它不是晚绑定，它就不是多态。”
 *
 *	总结：继承性的代码使用条件：b is a？（如 Student is Person--yes，Dog no Person--not extends）
 *
 *
 *********************************************************************************
 *
 *
 *
 *
 *
 */
public class Polymorphic {
	public static void main(String[]args){

		Man man=new Man();
		Person6 person=new Person6();
		Woman woman=new Woman();

		man.eat();
		man.walk();
		man.age=30;
		man.name="刘春";
		man.earnMoney();
		System.out.println("***********************");

		//********************************************************"
		//对象的多态性:父类的引用指向子类的对象
		Person6 p1=new Man();
//		Person p2=new Woman();
		//多态的使用：当调用子父类同名同参数的方法时，实际执行的是子类重写父类的方法----虚拟方法调用
		p1.eat();
		p1.walk();
		System.out.println(p1.id);


		System.out.println("*********************************");
		p1.name="tom";

//		p1.earnMoney(); 子类特有的方法、属性无法调用。编译时，p1是Person类型
//		p1.isSmoking=true;
		//有了对象的多态性以后，内存中实际上是加载了子类特有的属性和方法的，但是由于变量声明为父类类型，
//导致编译时，只能调用父类中声明的属性和方法。子类特有的属性和方法不能调用。

		//如何调用子类的属性和方法？
		//强制类型转换符，向下转型【只能是父类向子类转换】 (多态其实是一种向上转型，类似数据的自动类型提升)



		//Man m1=p2; 只能是子类赋给父类
		Person6 m2=man;//

		Man m1=(Man)p1; //强制类型转换符
		m1.isSmoking=true;

		//使用强转时，可能出现ClassCastException的异常
//		Woman w1=(Woman)p1;
//		w1.goShopping();

		/*
		 * instanceof
		 *
		 * a instanceof A：判断对象a是否是A的实例。如果是，返回 true，否则返回false
		 *
		 * 使用情景：为了避免在向下转型时出现ClassCastException的异常，我们在转换之前进行
		 * instanceof 的判断。返回true 表示可以转换，false则不能
		 *
		 * 如果 a instanceof A 返回true，则 a instanceof B 也返回true
		 * 其中，类B是类A的父类（即A的所有父类都能转换）。
		 *
		 */
		if(p1 instanceof Woman){
//			Woman w1=(Woman)p1;
//			w1.goShopping();
			System.out.println("Woman 可以转换");
		}

		if(p1 instanceof Man){
			System.out.println("Man 可以转换");
		}
		if(p1 instanceof Object){
			System.out.println("Object 可以转换");
		}
	}

}

	



class Person6 {
	String name;
	int age;
	int id=1001;

	public void eat(){
		System.out.println("吃饭");
	}
	public void walk(){
		System.out.println("走路");
	}

}



class Man extends Person6 {
	boolean isSmoking;
	int id=1002;

	Man(){
	}

	{}

	public void earnMoney(){
		System.out.println("男人负责挣钱养家");
	}

	public void eat(){
		System.out.println("男人多吃肉，长肌肉");
	}
	public void walk(){
		System.out.println("少走路，多休息");
	}

}



class Woman extends Person6 {
	boolean isBeauty;

	public void goShopping(){
		System.out.println("女人喜欢购物");
	}

	public void eat(){
		System.out.println("女人少吃肉，减肥");
	}
	public void walk(){
		System.out.println("女人多走路,少睡觉");
	}

}


class Person1 {

	String name;

	Person1() {

	}

	Person1(int i, String str) {
		this();
	}

	Person1(int i, String str, char char1, String name) {
		this(i, str);

		this.name = name;

	}


	{
		String name1 = "tom";
		this.name = name1;
	}

	public String test() {
		System.out.println();
		return null;
	}


	class Man {

//		String name2 = this.test();

	}

}

