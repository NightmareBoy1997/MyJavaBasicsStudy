package comguigu.java;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 *   例题3.从客户端发送文件给服务端，服务端保存到本地。并返回“发送成功”给客户端。并关闭相应的连接
 *
 * @author Freak-W
 * @create 2021-10-10 0:13
 */
public class TCPTest4 {



        @Test
        public void client(){

            Socket socket=null;
            OutputStream os=null;
            FileInputStream fis=null;
            InputStream is=null;
            ByteArrayOutputStream baos=null;

            try {
                socket= new Socket(InetAddress.getByName("127.0.0.1"),9090);
                os=socket.getOutputStream();
                fis=new FileInputStream("批注.png");

                byte[] bytes=new byte[1024];
                int len;
                while((len=fis.read(bytes))!=-1){

                    os.write(bytes,0,len);

//                    os.flush();

                }

                //关闭数据输出
                socket.shutdownOutput();

                // 5. 接受来自服务器端的数据，并显示在控制台上
                is = socket.getInputStream();
                baos = new ByteArrayOutputStream();

                int len1;
                byte[] buffer =new byte[20];
                while((len1 =is.read(buffer))!=-1){

                    baos.write(buffer,0,len1);

                }
                System.out.println(baos.toString());


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

                if(is!=null){
                    try {
                        is.close();
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

                if(socket!=null){
                    try {
                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                if(fis!=null){
                    try {
                        fis.close();
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
            OutputStream os=null;

            try {
                serverSocket=new ServerSocket(9090);
                socket=serverSocket.accept();

                is=socket.getInputStream();
                fos=new FileOutputStream(new File("楼市2.jpg"));

                int len;
                byte[] buffer=new byte[1024];
//            StringBuilder buffer=new StringBuilder(16);
                while((len=is.read(buffer))!=-1){

                    fos.write(buffer,0,len);
//                    fos.flush();

                }

                System.out.println("图片传输完成！");


                // 6. 服务器端给予客户端反馈，关闭连接
                os = socket.getOutputStream();
                os.write("服务器端已收到！".getBytes());

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

                if(os!=null){
                    try {
                        os.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            }

        }







}
