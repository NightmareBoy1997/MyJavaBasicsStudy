package comguigu.java;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 *  UDP的网络编程:
 *
 *
 * @author Freak-W
 * @create 2021-10-10 11:26
 */
public class UDPTest1 {

    //发送端
    @Test
    public void sender()  {

        DatagramSocket socket=null;
        DatagramPacket datagramPacket=null ;


        try {
            String str="我是UDP网络协议发送的消息！";
            byte[] bytes=str.getBytes();
            socket =new DatagramSocket();
            InetAddress inet=InetAddress.getLocalHost();
            datagramPacket = new DatagramPacket(bytes,0,bytes.length,inet,6677);

            socket.send(datagramPacket);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(socket!=null){
                socket.close();
            }
        }

    }



    //接收端
    @Test
    public void receive()  {

        DatagramSocket socket =null;


        try {
            socket = new DatagramSocket(6677);
            byte[] bytes=new byte[1024];
            DatagramPacket datagramPacket = new DatagramPacket(bytes,0,bytes.length);
            socket.receive(datagramPacket);

            System.out.println(new String(datagramPacket.getData(),0,datagramPacket.getLength()));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            if(socket!=null){
                socket.close();
            }

        }


    }












}
