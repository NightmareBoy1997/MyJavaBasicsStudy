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
 * @create: 2022-03-01 22:51
 */
public class UDPTest1 {

    @Test
    public void client() {

        try( DatagramSocket datagramSocket = new DatagramSocket() ) {
            String string = "午饭时间按附件撒付款垃圾费";
            byte[] bytes = string.getBytes();
            DatagramPacket datagramPacket = new DatagramPacket(bytes,0,bytes.length, InetAddress.getLocalHost(),13223);

            datagramSocket.send(datagramPacket);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void datagramSocket(){

        try(   DatagramSocket datagramSocket = new DatagramSocket(13223)  ) {

            byte[] bytes = new byte[100];
            DatagramPacket datagramPacket = new DatagramPacket(bytes,bytes.length);
            datagramSocket.receive(datagramPacket);

            byte[] dataBytes = datagramPacket.getData();
            System.out.println(new String(dataBytes));

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}


