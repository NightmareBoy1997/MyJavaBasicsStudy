package comguigu.exercise;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @projectName: MyJavaStudy
 * @package: comguigu.exercise
 * @author: Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-03-01 11:15
 *
 *  一、 网络编程中的两个主要问题
 *   1. 如何准确地定位网络上的一台或多台主机
 *   2. 如何可靠高速的数据传输
 *
 *  二、 网络编程的两个要素
 *   1. 对应问题一： IP和端口号
 *   2. 对用问题二： 提供网络通信协议：TCP\IP参考模型（应用层\传输层\网络层\物理 + 数据链路层）
 *
 *  三、 通信要素一： IP和端口号
 *   1. IP： 唯一的标识 Internet 上的计算机
 *   2. 在java中使用InetAddress 类代表IP
 *   3. IP 分类 ： IPV4 、 IPV6 / 万维网、 局域网
 *   4. 域名： www.baidu.com  www.vip.com  www.jd.com
 *   5. 本地回路地址： 127.0.0.1 对应的域名 localhost
 *   6. 如何实例化： InetAddress：两个方法：getByName(String host) \ getLocalHost()
 *          两个常用方法： getHostName() / getHostAddress()
 *   7. 端口号： 正在计算机运行的进程
 *     要求： 不同的进程有不同的端口号
 *     范围： 被规定为16位的整数 0~65535
 *   8. 端口号与IP地址的组合得出一个网络套接字：socked
 *
 *  通信要素二：
 *
 */
public class InetTest {
    public static void main(String[] args) {

        try {
            // 获取指定IP地址
            InetAddress inetAddress = InetAddress.getByName("192.168.13.250");
            System.out.println(inetAddress);

            InetAddress inetAddress1 = InetAddress.getByName("www.baidu.com");
            System.out.println(inetAddress1);

            // 获取本机IP
            InetAddress localhost = InetAddress.getByName("localhost");
            InetAddress localHost = InetAddress.getLocalHost();
            System.out.println(localhost);
            System.out.println(localHost);

            // getHostName()
            System.out.println(localHost.getHostName());

            // getHostAddress()
            System.out.println(localHost.getHostAddress());

        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

    }





}