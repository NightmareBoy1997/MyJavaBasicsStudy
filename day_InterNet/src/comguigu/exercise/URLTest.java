package comguigu.exercise;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @projectName: MyJavaStudy
 * @package: comguigu.exercise
 * @author: Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-03-01 21:52
 *
 *  URL网络编程
 *   1. URL： 统一资源定位符，对应着互联网的某一资源地址
 *   2. 格式：
 *      http://localhost：8080/examples/beauty.jpg?username=tom
 *     协议类型  主机名   端口号     资源地址       参数列表
 *
 *
 */
public class URLTest {

    public static void main(String[] args) {

        try {
            URL url = new URL("http://localhost:8080/examples/beauty.jpg?username=tom");
            // 获取协议名
            System.out.println(url.getProtocol());
            // 获取主机名
            System.out.println(url.getHost());
            // 获取端口号
            System.out.println(url.getPort());
            // 获取资源地址
            System.out.println(url.getPath());
            // 获取文件名
            System.out.println(url.getFile());
            // 获取url的查询名
            System.out.println(url.getQuery());
            System.out.println(url.getAuthority()); // localhost:8080


        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

    }

}