package comguigu.java;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 *  一、网络编程中的两个主要的问题：
 *      1. 如何准确的定位网络上的一台或多台主机：定位主机上特有的应用
 *      2. 找到主机后如何可靠高效率的进行数据传输
 *
 *  二、 网络编程的两个要素：
 *      1。 对应问题1：IP和端口号；
 *      2。 对应问题2：网络通信协议：TCP/IP参考模型（应用层、传输层、网络层、物理+数据链路层）
 *
 *  三、 通信要素一：IP和端口号
 *      1. IP:唯一的标识 Inter 上的计算机（通信实体）
 *      2。在Java中使用InetAddress类代表IP
 *      3. IP分类： IPV4 、 IPV6
 *      4. 域名： www.baidu.com  www.mi.com   www.lol.com
 *
 *      5. 本地回路地址： 127.0.0.1（本机） 对应着：localhost
 *
 *      6. 如何实例化InetAddress： 两个方法：getByName(String host) 、 getLocalHost()
 *              两个常用方法： getHostName() 、 getHostAddress()
 *
 *      7. 端口号：正在计算机运行的进程
 *          要求：不同的进程有不同的端口号
 *
 *      8. 端口号与IP地址的组合得出一个网络套接字：socket
 *
 *
 *
 * @author Freak-W
 * @create 2021-10-09 15:14
 */
public class InetAddressTest {

    public static void main(String[] args)  {

        try {
            //File file1=new File("hello.txt");
            InetAddress inet1= InetAddress.getByName("192.168.0.0");

            System.out.println(inet1);

            InetAddress inet2 = InetAddress.getByName("www.baidu.com");
            System.out.println(inet2);

            InetAddress inet3 =InetAddress.getByName("localhost");
            System.out.println(inet3);

            //获取本地ip
            InetAddress inet4 = InetAddress.getLocalHost();
            System.out.println(inet4);


            // getHostName() 获取主机的域名：
            System.out.println(inet4.getHostName());
            // getHostAddress() 获取主机的地址：
            System.out.println(inet4.getHostAddress());






        } catch (UnknownHostException e) {
            e.printStackTrace();
        }


    }


}
