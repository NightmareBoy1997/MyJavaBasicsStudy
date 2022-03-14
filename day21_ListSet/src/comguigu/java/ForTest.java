package comguigu.java;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;

/**
 *
 *  jdk5.0 新增了foreach循环，用于遍历集合、数组
 *
 *
 * @author Freak-W
 * @create 2021-04-22 15:46
 */
public class ForTest {

    @Test
    public void test1() {
        Collection coll1 = new ArrayList();
        coll1.add(123);
        coll1.add(456);
        coll1.add(new String("tom"));
        coll1.add(new Person("jack", 23, 145.00));

        //for( 集合元素类型 局部变量 : 集合对象 )
        //内部仍然调用了迭代器
        for (Object obj : coll1) {
            System.out.println(obj);
        }
    }

    @Test
    public void test2() {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        //for( 数组元素类型 局部变量 : 数组元素 )
        for (int number : arr) {
            System.out.println(number);
        }
    }

}