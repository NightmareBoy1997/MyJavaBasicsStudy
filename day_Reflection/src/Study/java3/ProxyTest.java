package Study.java3;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 *
 *  动态代理的举例：
 *
 *
 *
 * @author Freak-W
 * @create 2021-10-27 23:03
 */

interface Human{
    String getBelief();
    void eat(String food);
}

//被代理类
class SuperMan implements Human{

    @Override
    public String getBelief() {
    return "I am InMan! I call fly!";
    }

    @Override
    public void eat(String food) {
        System.out.println("我喜欢吃" + food);
    }

}


/*
要想实现动态代理，需要解决的问题
 1. 如何根据加载内存中的被代理类，动态的创建一个代理类及其对象
 2. 如何通过代理类的对象动态的调用被代理类的同名方法

 */
class ProxyFactory{

    //调用此方法，返回一个代理类的对象。 解决问题一
    public static Object getProxyInstance(Object obj){// obj : 被代理类的对象

        MyInvocationHandler handler=new MyInvocationHandler();
        handler.bind(obj);

        return Proxy.newProxyInstance(obj.getClass().getClassLoader(),obj.getClass().getInterfaces(),handler);


    }

}

class MyInvocationHandler implements InvocationHandler {

    private Object obj;

    void bind(Object obj){
        this.obj=obj;
    }

    // 当我们通过代理类的对象，调用此方法时，就会自动调用如下的 invoke()方法；
    // 将被代理类要执行的方法a的功能就生命在invoke() 中

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        // method : 即为代理类调用的方法，此方法也作为被代理类对象要调用的方法
        // obj: 被代理类的对象
        Object returnValue = method.invoke(obj,args);
        return returnValue;
    }
}



public class ProxyTest {

    public static void main(String[] args) {

        SuperMan superMan = new SuperMan();
        // proxyInstance： 代理类的对象
        Human proxyInstance = (Human) ProxyFactory.getProxyInstance(superMan);
        // 当调用方法时，会自动的调用被代理类的同名方法
        System.out.println(proxyInstance.getBelief());
        proxyInstance.eat("麻辣烫");

        System.out.println("*****************************");

        NikeClothFactory nikeClothFactory = new NikeClothFactory();
        ClothFactory proxyInstance1 = (ClothFactory) ProxyFactory.getProxyInstance(nikeClothFactory);

        proxyInstance1.produceCloth();

    }




}
