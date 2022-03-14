package comguigu.demo;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

/**
 * @projectName: MyJavaStudy
 * @package: comguigu.demo
 * @author: Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-02-15 11:22
 */
public class Java10_11New {


    // java 10新特性一 ：局部变量的类型推断
    // 根据 所赋的值 去推断类型
    @Test
    public void java10NewVar(){

        // 1.声明变量时，根据 所赋的值 去推断变量的类型
        var i =23;
        var str = new String("tom");
        var list1 = new ArrayList<String>();
        var list2 = new ArrayList<>(); // 此时<>未指明泛型时，默认为 <Object>


        list1.add("tom");
        list2.add("tom");

        String str1 = list1.get(0);
//        String str2 = list2.get(0); // 类型不匹配

        // 2.遍历操作
        for(var s : list1){
            System.out.println(s);
            System.out.println(s.getClass());
        }


        // 3. 无法使用的情况
        // ① 不赋值、赋值为null时 ，无法进行推断
//        var s2 = null;
//        var s1 ; // 报错，无法在没有初始值设定项的变量上推断类型：“var”
//        s1 = "abs";

        // ② Lambda表达式 ,左边的函数式接口不能声明为var
//        Supplier<var> sup = () -> Math.random(); // 返回类型错误：无法将double转换为var
//        var sup1 = () -> Math.random(); // 无法推断类型：lambda表达式需要显式目标类型

        // ③ 方法引用，左边的函数式接口不能声明为var
//        Consumer<String> con = System.out :: println;
//        var con = System.out :: println;

        // ④ 数组的静态初始化，注意如下的情况也不可以
        int []array = {1,2,3,4};
//        var array1 = {1,2,3,4};

        // ⑤ 方法的返回类型 : 如下的method1

        // ⑥ 方法的参数类型 ：如下的method2

        // ⑦ 构造器的参数类型

        // ⑧ 属性

        // ⑨ catch()块
//        try {
//
//        } catch (var e) {
//            e.printStackTrace();
//        }
    }

    // 方法的返回类型
//    public var method1() {
//        return 0;
//    }
//    // ⑥ 方法的参数类型
//    public void method2(var v) {
//    }
//    // ⑦ 构造器的参数类型
//    public Java10New( var v){
//
//    }
    // ⑧ 属性
//    var num = 10 ;


    // java 10 新特性二： 集合中新增的copyOf() ：用于创建一个只读的集合
    @Test
    public void list(){

        var list1 = List.of("java","python", "C");
        var copy1 = List.copyOf(list1);
        System.out.println(list1 == copy1); // true

//        ArrayList<String> list21 =ArrayList.of("java","python", "C");
        var list2 = new ArrayList<String>();
        list2.add("sfksj");
        var copy2 = List.copyOf(list2);
        System.out.println(list2 == copy2); // false

        // 示例1跟示例2代码基本一致，为什么一个true 一个false
        // 结论： copy(Xxx coll) : 如果参数coll本身就是一个只读集合，则copyOf()返回值即为当前coll
        // 如果coll不是只读集合，就copyOf()就返回一个新的集合，此集合是只读的

    }



    // java 11 新特性一： String中新增的方法
    @Test
    public void java11NewString(){
        // isBlank() : 是否为空白
        System.out.println(" \t  \n ".isBlank()); // true

        // strip() : 去除首位空白
        System.out.println("  \t \n  name \n".strip()); // name

        // stripTrailing() : 去除尾部空白
        System.out.println("-----" + " \t  \n name \t\n   ".stripTrailing() + "-----");

        // stripLeading() : 去除首部空白
        System.out.println("-----" + " \t  \n name\t \n   ".stripLeading() + "-----");

        // repeat() : 复制字符串
        String str1 = "abc";
        String str2 = str1.repeat(5);
        System.out.println(str2);

        // lines().count() : 行数统计
        String str3 = "a\nbcd" ;
        System.out.println(str3.lines().count());

    }


    // java 11 新特性二： Optional新增的方法
    @Test
    public void java11NewOptional(){
        Optional<Object> optional = Optional.empty();
        System.out.println(optional.isPresent()); // 判断内部的value是否存在
        System.out.println(optional.isEmpty());  //  判断内部的value是否为空

        optional = Optional.of("cdefg");
//        Optional optional1 = optional.of("abc"); // 通过对象调用方法也能实现创建Optional对象
        Object orElseThrow = optional.orElseThrow();
        // orElseThrow() : value非空，返回value；否则抛出异常 java.util.NoSuchElementException
        System.out.println(orElseThrow);


        Optional<String> op1 = Optional.of("hello");
        optional = optional.empty();
        // or() : value非空，返回对应的Optional；value为空，返回形参封装的Optional
        Optional<Object> op2 = optional.or(() -> op1);
        System.out.println(op2);

        // or() 区别于 orElse() : 返回的是value的值
        Object abc = optional.orElse("abc");
        System.out.println(abc);

    }


    // java 11 新特性二 ：局部变量的类型推断的升级
    @Test
    public void java11NewVar(){

        // 错误的形式： 必须要有的类型，可以加上 var
//        Consumer<String> con1 = ( (@Deprecated t ) -> System.out.println());
        // 正确的形式：
        // 使用var的好处是在使用 lambda 表达式时给参数加上注解。
        Consumer<String> con2 = (@Deprecated var t ) -> System.out.println(t.toUpperCase());

    }


    //java11新特性四：HttpClient替换原有的HttpURLConnection。
    @Test
    public void test4(){
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder(URI.create("http://127.0.0.1:8080/test/")).build();
            HttpResponse.BodyHandler<String> responseBodyHandler = HttpResponse.BodyHandlers.ofString();
            HttpResponse<String> response = client.send(request, responseBodyHandler);
            String body = response.body();
            System.out.println(body);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test5(){
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(URI.create("http://127.0.0.1:8080/test/")).build();
        HttpResponse.BodyHandler<String> responseBodyHandler = HttpResponse.BodyHandlers.ofString();
        CompletableFuture<HttpResponse<String>> sendAsync = client.sendAsync(request, responseBodyHandler);
        sendAsync.thenApply(t -> t.body()).thenAccept(System.out::println);
        //HttpResponse<String> response = sendAsync.get();
        //String body = response.body();
        //System.out.println(body);

    }

}