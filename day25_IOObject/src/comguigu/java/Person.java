package comguigu.java;

import java.io.Serializable;

/**
 *
 *  Person需要满足如下的要求，方可序列化：
 *  1. 需要实现接口：    Serializable ：标识接口
 *  2. 当前类提供一个全局常量：serialVersionUID
 *  3. 除了当前的Person类需要实现Serializable接口之外，还必须保证其内部的属性也必须是可序列化的(默认情况下，
 *  基本数据类型也是可序列化的)
 *
 *  4. 序列化机制：
 *      对象的序列化对象序列化机制允许把内存中的Java对象转换成平台无关的二进制流，从而允许把这种二进制流持
 *      久地保存在磁盘上，或通过网络将这种二进制流传输到另一个网络节点。//当其它程序获取了这种二进制流，就可
 *      以恢复成原来的Java
 *
 *
 * @author Freak-W
 * @create 2021-09-13 21:14
 */
public class Person implements Serializable {

    public static final long serialVersionUID=324242342l;

    private String name;
    private int age;
    private double height;
    private double weight;

    private Account id;

    public Person (String name,int age,double height,double weight,Account id){
        this.name=name;
        this.age=age;
        this.height=height;
        this.weight=weight;
        this.id=id;

    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", height=" + height +
                ", weight=" + weight +
                ", id=" + id +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}


class Account implements Serializable{
    private double  balance;
    public static final long SerialVersionUID=34242424l;

    public Account(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}


