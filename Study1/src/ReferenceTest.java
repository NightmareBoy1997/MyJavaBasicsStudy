import org.junit.jupiter.api.Test;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

/**
 * @projectName: MyJavaStudy
 * @package: PACKAGE_NAME
 * @author: Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-02-24 19:42
 * <p>
 * gc可以回收哪些引用?gc可以回收哪些引用? 引用 reference
 * .1 强引用   > 有用且必须的对象。  不能回收。
 * > 程序运行期间 内存不足了 即使不使用这个强引用关联的对象  GC宁愿抛出错误  不愿回收
 * .2 软引用 --> SoftReference 一般会与缓存结合使用
 * > 有用非必须的对象。
 * > GC可以回收软引用关联的对象。 有条件: 内存不足的时候
 * <p>
 * .3 弱引用 --> WeakReference
 * > 有用非必须的对象。
 * > 可以回收。只要将引用变为无用对象  gc就可以回收。 如 ThreadLocal
 * <p>
 * .4 虚引用 --> PhantomReference
 * > 只要是虚引用关联的引用  对象会立马被回收
 */
public class ReferenceTest {

    /*
      .1 强引用

      > 有用且必须的对象。  不能回收。
      > 程序运行期间 内存不足了 即使不使用这个强引用关联的对象  GC宁愿抛出错误  不愿回收
    */
    @Test
    public void test() {

        //userInfos  str  girlFriends
        //都属于强引用
        //1000M
        String[] strings = new String[1000 * 1024];//700M
        //有很多逻辑
        String str = "hello";//200M

        Byte[] girlFriends = new Byte[1024 * 100 * 10000];//700M
    }


    /*
      .2 软引用

      > 有用非必须的对象。
      > GC可以回收软引用关联的对象。 有条件: 内存不足的时候
    */
    public void test1() {

        //SoftReference 一般会与缓存结合使用
        String str = new String("hello");
        SoftReference<String> softReference = new SoftReference<>(str);
        System.out.println(softReference.get());

        str = null; //手动的将引用变为null

        System.gc(); // 手动调用GC回收对象，但只有当内存不足，才会回收对象

        System.out.println(softReference.get());
    }


    /*
      .3 弱引用

      > 有用非必须的对象。
      > 可以回收。只要将引用变为无用对象  gc就可以回收。 如 ThreadLocal
    */
    public void test2() {
        //ThreadLocal
        Student student = new Student("刘亦菲", 30, 1001, 89.9);
        WeakReference<Student> weakReference = new WeakReference<>(student);
        System.out.println(weakReference.get());

        student = null;//变为无用对象
        System.gc();//手动调用GC
        System.out.println(weakReference.get());
    }


    /*
      .4 虚引用
      只要是虚引用关联的引用  对象会立马被回收

    */
    private static void test3() {
        Student student = new Student("刘亦菲", 30, 1001, 89.9);
        ReferenceQueue<Student> queue = new ReferenceQueue<>();
        PhantomReference<Student> phantomReference = new PhantomReference<>(student, queue);

        System.out.println(phantomReference.get());//只要是虚引用关联的引用  对象会立马被回收
    }


}