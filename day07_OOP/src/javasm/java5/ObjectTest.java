package javasm.java5;
/*
 * 
 * java.lang.Object
 * 	1. Object是所有java类的根父类
 * 	2. 如果在类的声明中没有extends指明父类，则默认直接父类父类为java.lang.Object类
 * 	3. Object类中的功能（属性、方法）具有通用性
 * 		属性：无
 * 		方法：equals() / toString() / getClass() /hashCode() / clone() / finalize()…
 *
 *  4. Object类只声明了一个空参的构造器
 *
 *  数组是特殊的类
 *
 * 面试题：
 * final、finally、finalize的区别？
 *
 */
public class ObjectTest {

	public static void main(String[] args) {

		Order order = new Order();
		System.out.println(order.getClass().getSuperclass());  //获取父类的方法

	}
}

class Order{

}

