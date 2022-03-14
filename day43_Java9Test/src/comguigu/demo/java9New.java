package comguigu.demo;

import comguigu.bean.Person;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.*;
import java.util.stream.Stream;

/**
 * @projectName: MyJavaStudy
 * @package: comguigu.demo
 * @author: Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-02-14 16:36
 */
public class java9New {

    // jdk 9新特性 ： 团队协作 module-info
    @Test
    public void ModuleTest() {
        Person person1 = new Person("tom", 1001);
        System.out.println("名字: " + person1.getName());
    }


    // Java 9 新特性五： 钻石操作符的升级
    //      ： 匿名实现类 new Comparator<Object> 的泛型 <> 中的 数据类型Object 可以省略
    @Test
    public void Genericity() {

        // jdk 8 以前, 钻石操作符<> 与 匿名内部类不能共存 ，报错
        Comparator<Object> comparator = new Comparator<>() {

            @Override
            public int compare(Object o1, Object o2) {
                return 0;
            }

        };

        // jdk7 中的新特性： 类型推断
        ArrayList<String> list = new ArrayList<>();
    }


    // jdk 9 新特性六： try操作升级
    @Test
    public void tryTest() {

        // jdk 8 之前资源关闭操作 ：
        InputStreamReader reader = null;
        try {
            reader = new InputStreamReader(System.in);
            char[] chars = new char[20];
            int len;
            if ((len = reader.read(chars)) != -1) {
                String str = new String(chars);
                System.out.println(str);
            }
            ;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


        // jdk 8 中资源关闭的操作 ： 可以实现资源的自动关闭
        //  要求将必须关闭的所有资源 必须 在try()中初始化

        try (InputStreamReader reader2 = new InputStreamReader(System.in);) {
            char[] chars = new char[20];
            int len;
            if ((len = reader2.read(chars)) != -1) {
                String str = new String(chars);
                System.out.println(str);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        // jdk 9 中资源的关闭操作：
        // 不要求在try()中初始化 ， 只需将所有资源的变量放在()中
        // 此时将资源属性改为final 是一个常量 ， 不能对资源进行修改
        InputStreamReader reader3 = new InputStreamReader(System.in);
        OutputStreamWriter writer = new OutputStreamWriter(System.out);
        try (reader3; writer) {
            char[] chars = new char[20];
            int len;
//            reader = null; // 报错，不能进行修改
            if ((len = reader3.read(chars)) != -1) {
                String str = new String(chars);
                System.out.println(str);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    // java 9 新特性八： 集合工厂方法：创建只读集合
    @Test
    public void readList() {

        // jdk 8 的写法：
        List<String> nameList = new ArrayList<String>();
        nameList.add("tom");
        nameList.add("bod");
        nameList.add("xbei");
        // unmodifiableList()、unmodifiableMap():  返回只读的集合
        nameList = Collections.unmodifiableList(nameList);
        System.out.println(nameList);
//        nameList.add("jos"); 报 java.lang.UnsupportedOperationException 异常

        // asList() 返回的list也是只读的
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
//        list.add(2); 报 java.lang.UnsupportedOperationException 异常


        // jdk 9 创建只读集合的写法：
        List<Integer> list1 = List.of(1, 3, 4, 7, 9, 2, 5);
        System.out.println(list1);
        Set<Integer> set1 = Set.of(1, 3, 4, 7, 9, 2, 5);
        System.out.println(set1);
        Map<Integer, String> map = Map.of(6, "tom", 4, "jack", 1, "shou", 7, "su999", 2, "xdd", 8, "myl", 5, "mamu");
        System.out.println(map);

//        list1.add(2); // 报 java.lang.UnsupportedOperationException 异常
//        set1.add(2); // 报 java.lang.UnsupportedOperationException 异常
//        map.put(11 , "xiaohu"); // 报 java.lang.UnsupportedOperationException 异常

    }


    // jdk 9新特性九： InputStream 数据传输的优化  新方法： transferTo()
    @Test
    public void inputStreamTransferTo() {
        ClassLoader cl = this.getClass().getClassLoader();

        try (InputStream is = cl.getResourceAsStream("Hello.txt");
             OutputStream os = new FileOutputStream("src\\HelloJava.txt",false);
        ) {
            is.transferTo(os);  // 将输入流的所有数据自动复制到输出流中
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    // jdk 9 新特性十 : Stream API的加强
    // 4个方法 ： takeWhile()、 dropWhile()、ofNullable()、iterate()
    @Test
    public void streamApi(){

        List<Integer>  list = Arrays.asList(1,23,43, 2 , 55 , 67 ,76,82,14,29,5,214,42,101) ;
        Stream<Integer> integerStream = list.stream();
        // 1.takeWhile(): 返回从开头开始的按照指定条件尽量多的数据 ， 遇到首个不满足的结束
//        integerStream.takeWhile(i -> i <56).forEach(System.out :: print); // 1 23 43 2 55

        System.out.println();
        // 2.dropWhile()： 与takeWhile()相反， 不能同时使用！！ ，返回剩余元素
        integerStream.dropWhile(i -> i < 56).forEach(System.out::print); // 67 76 82 14 29 5 214 42 101
        System.out.println();

        // 可以包含null，但不能 只有 null
        Stream<String> ofStream = Stream.of("tom", "xbei", "shou", "su999", null);
        ofStream.forEach(System.out::print);
//        Stream<String> ofStream1 = Stream.of( null); // java.lang.NullPointerException
//        ofStream1.forEach(System.out::println);
        Stream<String> ofStream2 = Stream.of( null ,null,null);
        ofStream2.forEach(System.out::println); // null ,null
        System.out.println("***");

        // 3.ofNullable() 形参变量是可以为null的单参数
        String str = "17";
        str = null ;
        Stream<String> ofNullableStream1 = Stream.ofNullable(str);
//        ofNullableStream1.forEach(System.out::println);
        // 获取元素个数
        System.out.println(ofNullableStream1.count());

        // 无限流
        Stream.iterate(1997, x -> x+1).limit(10).forEach(System.out::println);
        System.out.println();
        // 4.iterate() 新增的重载方法，增加终止条件 ，类似for循环
        Stream.iterate( 1997 , x -> x <= 2022 , x -> x+1 ).forEach(System.out::println);

    }


    //java9新特性十一： Optional提供新的stream()
    @Test
    public void streamOptional(){

        List<String> nameList = new ArrayList<String>();
        nameList.add("tom");
        nameList.add("bod");
        nameList.add("xbei");

        Optional<List<String>> optional = Optional.ofNullable(nameList);
        Stream<List<String>> stream = optional.stream();
//        System.out.println(stream.count());
        stream.flatMap(x -> x.stream()).forEach(System.out::println);

    }



}

