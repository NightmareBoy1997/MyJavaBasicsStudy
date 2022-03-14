package comguigu.java1;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 *
 *  一、说明：java中的对象，正常情况下，只能进行比较： == 或 ！=。 不能< 或 >
 *      但是在开发场景中，我们需要对对象进行排序，就需要比较大小。
 *      如何实现？ 使用两个接口中的任何一个：Comparable 或 Comparator
 *
 *  二、Comparable接口 与 Comparator接口的使用
 *      Comparable接口的方式一旦一定，保证Comparable接口实现类的对象在任何位置都可以比较大小
 *      Comparator接口属于临时性的比较
 *
 * @author Freak-W
 * @create 2021-03-24 11:06
 */
public class CompareTest {

    /*
    Comparable接口的使用举例：  自然排序
    1.像String、包装类等实现了Comparable接口，重写了compareTo(obj)方法，给出了比较两个对象大小的方式
    2.像String、包装类重写compareTo()方法以后，进行了从小到大的排序
    3. 重写compareTo()的规则
            如果当前对象this大于形参对象obj，则返回正整数，
            如果当前对象this小于形参对象obj，则返回负整数，
            如果当前对象this等于形参对象obj，则返回零。

    4.对于自定义类，如果需要排序，我们可以让自定义类实现comparable接口，重写compareTo(obj)方法
        在compareTo()方法中指明如何排序
     */
    @Test
    public void test1(){
        String []arr1=new String[]{"MM","GG","AA","JJ","DD"};
        //
        Arrays.sort(arr1);
        System.out.println(Arrays.toString(arr1));
    }



    @Test
    public void test2(){
        Goods[]arr1=new Goods[5];

        arr1[0]=new Goods("辣条",13.5);
        arr1[1]=new Goods("卤蛋",13.99);
        arr1[2]=new Goods("d蛋糕",15.0);
        arr1[3]=new Goods("鸡腿",19.9);
        arr1[4]=new Goods("h花牛苹果",15.0);

//        goods1.compareTo(goods2);
        Arrays.sort(arr1);
        System.out.println(Arrays.toString(arr1));
    }


    /*
    Comparator接口的使用： 定制排序
    1.背景：
    当元素的类型没有实现java.lang.Comparable接口而又不方便修改代码，或者实现了java.lang.Comparable接口
    的排序规则不适合当前的操作，
    那么可以考虑使用 Comparator 的对象来排序，强行对多个对象进行整体排序的比较。

    2.重写compare(Object o1，Object o2)方法，比较o1和o2的大小：
    如果返回正整数，则o1大于o2；
    如果返回负数，则o1小于o2；
    如果返回0，表示一样大。
     */

    //按照字符串从大到小的顺序排序
    @Test
    public void test3(){
        String []arr1=new String[]{"AA","DD","GG","BB","JJ","ZZ","ee"};
        Arrays.sort(arr1,new Comparator(){
            public int compare(Object o1,Object o2){
                if(o1 instanceof String && o2 instanceof String ){
                    String str1=(String)o1;
                    String str2=(String)o2;

                    return -str1.compareTo(str2);

                }
//                return 0;
                throw new RuntimeException("传入的类型不匹配！");

            }


        });
        System.out.println(Arrays.toString(arr1));

    }

    @Test
    public void test4(){
        Goods []arr1=new Goods[5];

        arr1[0]=new Goods("z辣条",13.5);
        arr1[1]=new Goods("y卤蛋",13.99);
        arr1[2]=new Goods("d蛋糕",15.0);
        arr1[3]=new Goods("j鸡腿",19.9);
        arr1[4]=new Goods("a花牛苹果",15.0);

        Arrays.sort(arr1,new Comparator(){

            //指明商品比较大小排序的方式：按照商品名称从高到低排序，再按照价格从低到高排序
            public int compare(Object o1,Object o2){
                if(o1 instanceof Goods && o2 instanceof Goods){
                    Goods goods1=(Goods)o1;
                    Goods goods2=(Goods)o2;

                    if(goods1.getName().equals(goods2.getName())){
                        return -Double.compare(goods1.getPrice(),goods2.getPrice());
                    }else{
                        return goods1.compareTo(goods2);
                    }
                }
                throw new RuntimeException("传入的数据类型不匹配！");
            }
        });
        System.out.println(Arrays.toString(arr1));
    }
}





/**
 * 商品类
 */
class Goods implements Comparable {

    private double price;
    private String name;

    public Goods(){

    }
    public Goods(String name,double price){
        this.name=name;
        this.price=price;
    }

    public void setName(String name){
        this.name=name;
    }
    public String getName(){
        return name;
    }
    public void setPrice(double price){
        this.price=price;
    }
    public double getPrice(){
        return price;
    }

    public String toString(){
        return "[ name: "+name+", price: "+price+" ]";
    }

    //指明商品比较大小排序的方式：按照价格从低到高排序，再按照商品名称从高到低排序
    public int compareTo(Object obj){

        //方式一：
        if(obj instanceof Goods){
            Goods goods=(Goods) obj;
            if(this.price>goods.price){
                return 1;
            } else if(this.price<goods.price){
                return -1;
            }else{
                return -this.name.compareTo(goods.name); //-compareTo()表示倒序！！
            }


            //方式二：
//            return Double.compare(this.price,goods.price);

        }
        throw new RuntimeException("传入的数据类型不一致！");
    }
}
