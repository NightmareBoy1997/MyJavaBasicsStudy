package comguigu.exercise;

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
 * @create: 2022-03-01 15:30
 * <p>
 * 练 习
 * 1.服务端读取图片并发送给客户端，客户端保存图片到本地
 * 2.客户端给服务端发送文本，服务端会将文本转成大写在返回给客户
 */
/*
1.服务端读取图片并发送给客户端，客户端保存图片到本地
 */
public class SocketExercise {

    public static void main(String[] args) {
        socket();
    }

    private static void socket() {

        Socket socket = null;
        OutputStream outputStream = null;
        InputStream inputStream = null;
        FileInputStream fileInputStream = null;

        try {
            InetAddress inetAddress = InetAddress.getByName("192.168.13.250");

            socket = new Socket(inetAddress, 13223);

            fileInputStream = new FileInputStream("day_InterNet\\src\\ig冠军4K.jpg");

            outputStream = socket.getOutputStream();

            int len;
            byte[] bytes = new byte[1024];
            while ((len = fileInputStream.read(bytes)) != -1) {
                outputStream.write(bytes, 0, len);
            }

            socket.shutdownOutput();

            inputStream = socket.getInputStream();
            byte[] bytes1 = new byte[100];
            while ((len = inputStream.read(bytes1)) != -1) {
                System.out.print(new String(bytes1, 0, len));
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }


}

class ServerSocketTest4 {

    public static void main(String[] args) {

        serverSocket();

    }

    private static void serverSocket() {

        try (ServerSocket serverSocket = new ServerSocket(13223);
             Socket socket = serverSocket.accept();
             InputStream inputStream = socket.getInputStream();
             FileOutputStream fileOutputStream = new FileOutputStream("day_InterNet\\src\\ig牛逼.jpg");
             OutputStream outputStream = socket.getOutputStream();
        ) {

            int len;
            byte[] bytes = new byte[1024];
            while ((len = inputStream.read(bytes)) != -1) {
                fileOutputStream.write(bytes, 0, len);
            }
            System.out.println("收到了来自： " + socket.getInetAddress().getHostAddress() + " 的一张图片");

            String string = "收到了你的图片，很猛！";
            byte[] bytes1 = string.getBytes();
            outputStream.write(bytes1);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}


/*
2.客户端给服务端发送文本，服务端会将文本转成大写在返回给客户
 */
// 客户端
class SocketTest5 {

    public static void main(String[] args) {
        socket();
    }

    private static void socket() {

        Socket socket = null;
        OutputStream outputStream = null;
        InputStream inputStream = null;

        try {
            InetAddress inetAddress = InetAddress.getByName("192.168.13.250");

            socket = new Socket(inetAddress, 13223);

            outputStream = socket.getOutputStream();

            String string = "igniubi";
            outputStream.write(string.getBytes());

            socket.shutdownOutput();

            inputStream = socket.getInputStream();
            int len;
            byte[] bytes1 = new byte[100];
            while ((len = inputStream.read(bytes1)) != -1) {
                System.out.print(new String(bytes1, 0, len));
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }

    }


}


// 服务器端
class ServerSocketTest5 {

    public static void main(String[] args) {

        serverSocket();

    }

    private static void serverSocket() {

        try (ServerSocket serverSocket = new ServerSocket(13223);
             Socket socket = serverSocket.accept();
             InputStream inputStream = socket.getInputStream();
             FileOutputStream fileOutputStream = new FileOutputStream("day_InterNet\\src\\ig牛逼.jpg");
             OutputStream outputStream = socket.getOutputStream();
        ) {

            int len;
            String clientString = null;
            byte[] bytes = new byte[100];
            while ((len = inputStream.read(bytes)) != -1) {
                clientString = new String(bytes, 0, len);
            }
            System.out.println("收到了来自： " + socket.getInetAddress().getHostAddress() + " 的文档");

            if (!clientString.isEmpty()) {
                clientString = clientString.toUpperCase();
            }

            byte[] bytes1 = clientString.getBytes();
            outputStream.write(bytes1);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}