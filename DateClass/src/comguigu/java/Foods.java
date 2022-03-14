package comguigu.java;

/**
 * 商品类
 *
 * @author Freak-W
 * @create 2021-03-24 11:24
 */
public class Foods implements Comparable {

    private double price;
    private String name;

    public Foods(){

    }
    public Foods(String name, double price){
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
        if(obj instanceof Foods){
            Foods goods=(Foods) obj;
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
