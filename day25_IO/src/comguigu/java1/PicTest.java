package comguigu.java1;

import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author Freak-W
 * @create 2021-05-25 16:50
 */
public class PicTest {

    // 图片的加密
    @Test
    public void test1(){

        FileInputStream fi=null;
        FileOutputStream fo=null;

        try {
            fi=new FileInputStream("卡特.jpg");
            fo=new FileOutputStream("KATE.jpg");

            int len ;
            byte[] bytes=new byte[1024];
            while((len=fi.read(bytes))!=-1){

                // 对字节数组进行修改
                // 错误的
//                for(byte b: bytes){
//                    b = (byte)(b^5);
//                }
                // 正确的
                for (int i = 0; i <bytes.length ; i++) {
                    bytes[i]=(byte)(bytes[i]^5);
                }

                fo.write(bytes,0,len);

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            if(fi!=null){
                try {
                    fi.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if(fo!=null){
                try {
                    fo.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }


    }


    // 图片的解密
    @Test
    public void test2(){

        FileInputStream fi=null;
        FileOutputStream fo=null;

        try {
            fi=new FileInputStream("KATE.jpg");
            fo=new FileOutputStream("KATEs.jpg");

            int len ;
            byte[] bytes=new byte[1024];
            while((len=fi.read(bytes))!=-1){

                // 对字节数组进行修改
                // 错误的
//                for(byte b: bytes){
//                    b = (byte)(b^5);
//                }
                // 正确的
                for (int i = 0; i <bytes.length ; i++) {
                    bytes[i]=(byte)(bytes[i]^5);
                }

                fo.write(bytes,0,len);

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            if(fi!=null){
                try {
                    fi.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if(fo!=null){
                try {
                    fo.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }





    }


    @Test
    public void test3(){






    }














}
