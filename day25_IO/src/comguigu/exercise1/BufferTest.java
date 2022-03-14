package comguigu.exercise1;

import java.io.File;

/**
 * @projectName: MyJavaStudy
 * @package: comguigu.exercise1
 * @author: Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-02-25 17:10
 */
public class BufferTest {

    public static void main(String[] args) {

        File file1 = new File("E:\\study1\\232.iso");
        File file2 = new File("E:\\study1\\new232.iso");


        // 使用缓冲流

/*
              try(  FileInputStream fileInput = new FileInputStream(file1);
              FileOutputStream fileOutput = new FileOutputStream(file2);
              BufferedInputStream bufferedInput = new BufferedInputStream(fileInput);
              BufferedOutputStream bufferedOutput = new BufferedOutputStream(fileOutput);
                ) {
            Date startDate = new Date();

            byte[] bytes =new byte[1024];
            int len;
            while((len = bufferedInput.read(bytes)) != -1 ){
                bufferedOutput.write(bytes,0,len);
//                bufferedOutput.flush();
            }

            Date endDate = new Date();
            long timeNumber = endDate.getTime() - startDate.getTime();
            System.out.println( "复制使用了 " + timeNumber / 1000 + " 秒 "); // 71 秒

        } catch (IOException e) {
            e.printStackTrace();
        }

*/



        // 不使用缓冲流
/*
        try(  FileInputStream input = new FileInputStream(file1);
              FileOutputStream output = new FileOutputStream(file2);
        ) {
            Date startDate = new Date();

            byte[] bytes =new byte[1024];
            int len;
            while((len = input.read(bytes)) != -1 ){
                output.write(bytes,0,len);
            }

            Date endDate = new Date();
            long timeNumber = endDate.getTime() - startDate.getTime();
            System.out.println( "复制使用了 " + timeNumber / 1000 + " 秒 "); // 82 秒

        } catch (IOException e) {
            e.printStackTrace();
        }
*/










    }

}