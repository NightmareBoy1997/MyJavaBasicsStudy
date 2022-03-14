package comguigu.java;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * 集合遍历的操作，使用迭代器Iterator接口
 * 1. 内部方法：hasNext() 和 next()
 * hasNext() 判断是否还有下一个元素
 * next() ①指针下移 ②将下移以后的集合元素返回
 * <p>
 * 2. 集合对象每次调用iterator()方法都会得到一个新的迭代器对象，默认游标都在第一个元素之前
 * 3. 内部定义了remove()方法，可以在遍历的时候，对集合元素进行移除。不同于集合remove()
 * 如果还未调用next()或在上一次调用 next 方法之后已经调用了 remove 方法，再调用remove都会报IllegalStateException。
 *
 * 4. 遍历集合：iterator的指针已经到达最末尾，需要重新生成iterator的对象
 *
 * @author Freak-W
 * @create 2021-04-19 21:42
 */
public class IteratorTest {

    @Test
    public void test1() {
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person("tom", 23, 184.99));
        coll.add(new String("tom"));
        coll.add(false);

        Iterator iterator = coll.iterator();

        //方式一：
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
        //报异常: NoSuchElementException
//        System.out.println(iterator.next());

        //方式二：for()
        //方式三：推荐方法
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }

    //iterator
    @Test
    public void test2() {
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add("handsome");
        coll.add(new Person("tom", 23, 184.99));
        Collection coll1 = new ArrayList();
        coll1.add(123);
        coll1.add(new String("tom"));
        coll.add(new Person("jack", 24, 155.99));
        coll.addAll(coll1);

        //移除操作：删除集合中的“123”
        Iterator iterator = coll.iterator();
        while (iterator.hasNext()) {
            Object obj = iterator.next();
            if (obj.equals(123) | "tom".equals(obj)) {
                iterator.remove();
            }
        }
        //遍历集合：iterator的指针已经到达最末尾，需要重新生成iterator的对象
        Iterator iterator1 = coll.iterator();
        while (iterator1.hasNext()) {
            System.out.println(iterator1.next());
        }
    }


}
