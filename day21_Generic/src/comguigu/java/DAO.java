package comguigu.java;

import org.junit.jupiter.api.Test;

import java.util.List;

/**
 *
 *  DAO：data(base)access object
 *  定义了操作数据库中表的通用操作   ORM思想( 数据库中的表 和 java中的类对应 )
 *
 *
 * @author Freak-W
 * @create 2021-05-17 9:34
 */
public class DAO<T>  { //操作所有表的共性操作

    //添加一条记录
    public void add(T t){

    }
    //删除一条记录
    public void remove(int indexc){

    }
    //修改一条记录
    public void update(int index,T t){

    }
    //查询一条记录
    public T getIndex(int index){
        return null;
    }
    //查询多条记录
    public List<T> getForLlist(int index){
        return null;
    }

    //举例 泛型方法:获取多少条记录了
    public <E>E getValue(){
        return null;
    }

}

class Customer {

}

class CustomerDAO extends DAO<Customer>{ //操作Customer类的具体类型

    @Test
    public void test1(){
        CustomerDAO test=new CustomerDAO();
        test.add(new Customer());

    }

}
