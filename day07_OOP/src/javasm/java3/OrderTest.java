package javasm.java3;


public class OrderTest {

	public static void main(String[]args){
			Order test=new Order();
			
			//出了Order类之后，私有的结构就不可以调用
//			test.orderPrivate=1;//The field OrderTest.orderPrivate is not visible
			test.orderDefault=2;
			test.orderPublic=3;
			
			test.methodDefault();
			test.methodPublic();
			//出了Order类之后，私有的结构就不可以调用
//			test.methodPrivate();//The method methodPrivate() from the type OrderTest is not visible
	
	}

	
	
}

 class Order {
	
	private int orderPrivate;
	int orderDefault;
	public int orderPublic;
	
	private void methodPrivate(){
		orderPrivate=1;
		orderDefault=2;
		orderPublic=3;
	}
	void methodDefault(){
		orderPrivate=1;
		orderDefault=2;
		orderPublic=3;
	}
	public void methodPublic(){
		orderPrivate=1;
		orderDefault=2;
		orderPublic=3;
	}
	
	
}

