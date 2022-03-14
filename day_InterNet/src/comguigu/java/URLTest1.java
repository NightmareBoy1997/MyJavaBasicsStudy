package comguigu.java;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author Freak-W
 * @create 2021-10-10 13:04
 */
public class URLTest1 {

    public static void main(String[] args)  {

        HttpURLConnection uc =null;
        InputStream is=null;
        FileOutputStream fos=null;

        try {
            URL url=new URL("http://localhost:8080/examples/shumabaobei.jpg?user=name");

            uc = (HttpURLConnection) url.openConnection();
            uc.connect();

            is= uc.getInputStream();

            fos=new FileOutputStream("day28_InterNet\\数码宝贝.jpg" );

            byte[] bytes=new byte[1024];
            int len;
            while((len=is.read(bytes))!=-1){
                fos.write(bytes,0,len);
            }

            System.out.println("下载完成!");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            if(is!=null){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if(fos!=null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            uc.disconnect();

        }







    }



}
