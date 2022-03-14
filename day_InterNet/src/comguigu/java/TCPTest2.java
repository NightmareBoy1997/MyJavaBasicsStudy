package comguigu.java;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *  实现TCP的网络编程
 *  例题2：客户端发送文件给服务器端，服务器端将文件保存在本地
 *
 *
 *
 * @author Freak-W
 * @create 2021-10-09 17:08
 */
public class TCPTest2 {

    @Test
    public void client(){

        Socket socket=null;
        OutputStream os=null;
        FileInputStream fis=null;

        try {
            socket= new Socket(InetAddress.getByName("127.0.0.1"),9090);
            os=socket.getOutputStream();
            fis=new FileInputStream("批注.png");

            byte[] bytes=new byte[1024];
            int len;
            while((len=fis.read(bytes))!=-1){

                os.write(bytes,0,len);

                os.flush();

            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            if(os!=null){
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if(socket!=null){

                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }

    }


    @Test
    public void server(){

        ServerSocket serverSocket=null;
        Socket socket=null;
        InputStream is=null;
        FileOutputStream fos=null;

        try {
            serverSocket=new ServerSocket(9090);
            socket=serverSocket.accept();

            is=socket.getInputStream();
            fos=new FileOutputStream(new File("楼市.jpg"));

            int len;
            byte[] bytes=new byte[1024];
//            StringBuilder buffer=new StringBuilder(16);
            while((len=is.read(bytes))!=-1){

                fos.write(bytes,0,len);
                fos.flush();

            }


        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            if(fos!=null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if(is!=null){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if(socket!=null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if(serverSocket!=null){
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }

    }



}
