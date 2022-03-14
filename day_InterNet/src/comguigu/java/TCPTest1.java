package comguigu.java;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *  实现TCP的网络编程
 *      例子1：客户端发送信息给服务端，服务端将数据显示在控制台上
 *
 *
 *
 *
 *
 *
 *
 *
 * @author Freak-W
 * @create 2021-10-09 16:15
 */
public class TCPTest1 {

    //客户端
    @Test
    public void client() {

        Socket socket= null;
        OutputStream os= null;
        try {
            // 1. 创建Socket对象1，指明服务器端的IP和端口
            socket = new Socket(InetAddress.getByName("192.168.42.201"),2212);
            // 2. 获取一个输出流，用于输出数据
            os = socket.getOutputStream();
            // 3. 写出数据的操作
            os.write("你好，我是客户端".getBytes());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 4. 资源的关闭
            if(os != null){
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if(socket != null){

                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }



    }

    //服务端
    @Test
    public void server()  {

        ServerSocket ss=null;
        Socket socket= null;
        InputStream is = null;
        ByteArrayOutputStream baos=null;

        try {
            // 1. 创建服务器端的ServerSocket对象，用于指明自己端口号
            ss =new ServerSocket(2212);
            // 2. 调用accept()接收来自客户端的socket
            socket = ss.accept();
            // 3. 获取输入流
            is = socket.getInputStream();

            //不建议这样写，非字节内容可能会因为超出数组出现乱码
//        byte[] bytes=new byte[1024];
//        int len;
//        while((len=is.read(bytes)!=-1)){
//
//            String str=new String(bytes,0,len);
//            System.out.println(str);
//        }

            // 4. 读取输入流中的数据
            baos=new ByteArrayOutputStream();
            byte [] buffer=new byte[1024];
            int len ;
            while((len=is.read(buffer))!=-1){

                baos.write(buffer,0,len);

            }

            System.out.println(baos.toString());

            System.out.println(" 收到了来自于 " + socket.getInetAddress().getHostName() + " 的数据");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {

        // 5. 关闭流资源
        if(is!=null){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        if(socket!=null){
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if(baos!=null){
            try {
                baos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if(ss!=null){
            try {
                ss.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

}
