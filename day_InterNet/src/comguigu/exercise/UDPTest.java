package comguigu.exercise;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @projectName: MyJavaStudy
 * @package: comguigu.exercise
 * @author: Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-03-01 21:33
 *
 *  UDP协议的网络编程
 *
 */
public class UDPTest {

    // 发送端
    @Test
    public void sender(){

        try(DatagramSocket socket = new DatagramSocket()) {
            InetAddress inetAddress = InetAddress.getLocalHost();

            String string  = "弹幕轰炸！";
            byte[] bytes = string.getBytes();

            DatagramPacket datagramPacket = new  DatagramPacket(bytes,0,bytes.length,inetAddress,13223);

            socket.send(datagramPacket);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    // 接收端
    @Test
    public void receiver(){

        try(   DatagramSocket datagramSocket = new DatagramSocket(13223);

                ) {

            byte[] bytes = new byte[100];

            DatagramPacket datagramPacket  = new DatagramPacket(bytes,0,bytes.length);
            datagramSocket.receive(datagramPacket);

            System.out.println(new String(datagramPacket.getData(),0,datagramPacket.getLength()));

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}