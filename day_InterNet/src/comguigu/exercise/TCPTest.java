package comguigu.exercise;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @projectName: MyJavaStudy
 * @package: comguigu.exercise
 * @author: Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-03-01 14:53
 *
 *  实现TCP的网络编程
 *  例子1：客户端发送信息到服务端，服务端将数据显示在控制台
 *
 */
public class TCPTest {

    // 客户端
    @Test
    public void client(){

        Socket socket = null;
        OutputStream outputStream = null ;

            try {
                // 1. 创建Socket的对象，指明服务器端的IP和端口号
                InetAddress inet = InetAddress.getByName("192.168.13.250");
                socket = new Socket(inet,13201);

                // 2. 获得输出流，用于输出
                outputStream = socket.getOutputStream();

                // 3. 写出数据
                outputStream.write("我是客户端的消息".getBytes());
                outputStream.write("Collection".getBytes());

                // 4. 资源的关闭
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {

                if(socket != null ){
                    try {
                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                if(outputStream!=null){
                    try {
                        outputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

        }
    }


    // 服务器端
    @Test
    public void server(){

               // 1. 创建服务器端的serverSocket，指明自己的端口号
        try(   ServerSocket serverSocket = new ServerSocket(13201);
               // 2. 调用accept()方法，接收来自客户端的socket
               Socket socket = serverSocket.accept();
               // 3. 获取输入流
               InputStream inputStream = socket.getInputStream();
               // 4. 读取输入流的数据
               ByteArrayOutputStream byteInputStream  = new ByteArrayOutputStream();
                ) {

            // 不推荐，可能乱码
//        byte[] bytes = new byte[1024];
//        int len;
//        while (( len = inputStream.read(bytes)) != -1){
//        }

            byte[] bytes = new byte[1024];
            int len;
            while( (len = inputStream.read(bytes)) != -1 ){
                byteInputStream.write(bytes,0,len);
            }

            System.out.println(byteInputStream);

            System.out.println("收到了来自 " + socket.getInetAddress().getHostAddress() + "的消息");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}


/*
    例子2：客户端发送文件给服务端，服务端将文件保存在本地。
 */
// 客户端
class SocketTest {

    public static void main(String[] args) {
        client();
    }


    public static void client(){
        Socket socket = null;
        OutputStream outputStream = null;
        FileInputStream fileInputStream = null;

        try {
            InetAddress inetAddress = InetAddress.getByName("192.168.13.250");

            socket = new Socket(inetAddress,13022);

            outputStream = socket.getOutputStream();
            fileInputStream = new FileInputStream("day_InterNet\\src\\楼市2.jpg");
            byte[] bytes = new byte[1024];
            int len ;
            while( (len = fileInputStream.read(bytes)) != -1){
                outputStream.write(bytes,0,len);
            }


        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            if(outputStream != null){
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(fileInputStream != null){
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(socket!= null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}

// 服务器端
class ServerSocketTest2{

    public static void main(String[] args) {
        ServerSocket();

    }

    public static void ServerSocket(){
        try(  ServerSocket serverSocket = new ServerSocket(13022);
              Socket socket = serverSocket.accept();
              InputStream inputStream = socket.getInputStream();
              FileOutputStream fileOutputStream = new FileOutputStream("day_InterNet\\src\\楼市22.jpg");
        ) {
            byte[] bytes = new byte[1024];
            int len ;
            while((len = inputStream.read(bytes)) != -1){
                fileOutputStream.write(bytes,0,len);
            }
            System.out.println("获取到来自 " + socket.getInetAddress().getHostAddress() + " 的图片");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}



/*
    例子3.从客户端发送文件给服务端，服务端保存到本地。并返回“发送成功”给客户端。并关闭相应的连接
 */
// 客户端
class SocketTest3{

    public static void main(String[] args) {

        socket();

    }

    public static void socket(){

        InetAddress inetAddress = null;
        Socket socket = null;
        OutputStream outputStream = null;
        FileInputStream fileInputStream = null;
        InputStream inputStream = null;
        ByteArrayOutputStream byteArrayOutputStream = null;

        try{
            inetAddress = InetAddress.getByName("192.168.13.250");
            socket = new Socket(inetAddress,13202);

            outputStream = socket.getOutputStream();

            fileInputStream = new FileInputStream("day_InterNet\\src\\楼市2.jpg");
            int len ;
            byte[] bytes = new byte[1024];
            while((len = fileInputStream.read(bytes)) != -1){
                outputStream.write(bytes,0,len);
            }
            // 传输关闭
            socket.shutdownOutput();

            // 接受来自服务期端的数据，并显示在控制台
            inputStream = socket.getInputStream();
            byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bytes1 = new byte[20];
            while((len = inputStream.read(bytes) ) != -1){
                byteArrayOutputStream.write(bytes,0,len);
            }
            System.out.println(byteArrayOutputStream);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            if(socket != null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(outputStream != null){
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(fileInputStream != null){
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(inputStream != null){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(byteArrayOutputStream != null){
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }

    }

}

class ServerSocket3 {

    public static void main(String[] args) {

        serverSocket();
    }

    private static void serverSocket() {

        try (ServerSocket serverSocket = new ServerSocket(13202);
             Socket socket = serverSocket.accept();
             InputStream inputStream = socket.getInputStream();
             FileOutputStream fileOutputStream = new FileOutputStream("day_InterNet\\src\\楼市33.jpg");
             OutputStream outputStream = socket.getOutputStream();
        ) {
            int len;
            byte[] bytes = new byte[1024];
            while ((len = inputStream.read(bytes)) != -1) {
                fileOutputStream.write(bytes, 0, len);
            }

            System.out.println("收到了来自 " + socket.getInetAddress().getHostAddress() + " 的文件");

            // 服务器给客户端反馈
            outputStream.write("收到了，谢谢！".getBytes());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}