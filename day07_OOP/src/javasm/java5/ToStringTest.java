package javasm.java5;

/*
 * Object类中toString()的使用：
 * 	1. 当我们输出一个对象的引用时，实际上就是调用当前对象的toString()
 * 
 * 	2. Object类中的toString()的定义：
 * 			public String toString() {
        	return getClass().getName() + "@" + Integer.toHexString(hashCode());
    		}
 * 
 *  3. 像String、Date、File、包装类等都重写了Object类中的toString()方法
 * 
 * 	4. 自定义类也可以重写toString()方法，当调用此方法时，返回对象的“实体内容”。
 * 
 * 
 */
public class ToStringTest {

}
