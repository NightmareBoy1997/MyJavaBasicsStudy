package comguigu.exercise1;

import java.io.*;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/**
 * @projectName: MyJavaStudy
 * @package: comguigu.exercise1
 * @author: Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-02-25 17:38
 */
public class exercise1 {

    public static void main(String[] args) {

//        copyFile();
//        jpgMd5();
//        jpgFormat();
//        charNumber();
        copyFile1();

    }


    //1. 分别使用节点流：FileInputStream、FileOutputStream和缓冲流：
    //    BufferedInputStream、BufferedOutputStream实现文本文件/图片/视频文件的复制。并比较二者在数据复制方面的效率
    static void copyFile() {
        // 不使用缓冲流
/*        try(
                FileInputStream fileInput = new FileInputStream(new File("E:\\study1\\io.mp4"));
                FileOutputStream fileOutput = new FileOutputStream(new File("E:\\study\\io2.mp4"));
            ) {
            Date startDate = new Date();
            byte[] bytes = new byte[1024];
            int len;
            while((len = fileInput.read(bytes)) != -1){
                fileOutput.write(bytes,0,len);
            }

            Date endDate = new Date();
            long runTime = ( endDate.getTime() - startDate.getTime() ) /1000;
            System.out.println("不使用缓冲流复制所用时间： " + runTime + "秒" ); // 4

        } catch (IOException e) {
            e.printStackTrace();
        }*/

        // 使用缓冲流
        try (
                FileInputStream input = new FileInputStream(new File("E:\\study1\\io.mp4"));
                FileOutputStream output = new FileOutputStream(new File("E:\\study\\io2.mp4"));
                BufferedInputStream bufferedInput = new BufferedInputStream(input);
                BufferedOutputStream bufferedOutput = new BufferedOutputStream(output);
        ) {
            Date startDate = new Date();

            byte[] bytes = new byte[1024];
            int len;
            while ((len = bufferedInput.read(bytes)) != -1) {
                bufferedOutput.write(bytes, 0, len);
            }

            Date endDate = new Date();
            long runTime = (endDate.getTime() - startDate.getTime()) / 1000;

            System.out.println("不使用缓冲流复制所用时间： " + runTime + "秒"); // < 1

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    //2. 实现图片加密操作。
//    提示：
//
//    int b =0 ;
//    while( ( b = fis.read()) != -1 ){
//        fos.write(b ^ 5);
//    }
    static void jpgMd5() {

        try (
                FileInputStream fileInput = new FileInputStream(new File("E:\\study1\\雷无桀.jpg"));
                FileOutputStream fileOutput = new FileOutputStream(new File("E:\\study1\\雷无桀1.jpg"));
        ) {
            byte[] bytes = new byte[1024];
            int len;

            while ((len = fileInput.read(bytes)) != -1) {
                for (int i = 0; i < len; i++) {
                    bytes[i] = (byte) (bytes[i] ^ 5);
                    fileOutput.write(bytes[i]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 文件的解密
    static void jpgFormat() {

        try (
                FileInputStream fileInput = new FileInputStream(new File("E:\\study1\\雷无桀1.jpg"));
                FileOutputStream fileOutput = new FileOutputStream(new File("E:\\study1\\雷无桀2.jpg"));
        ) {
            byte[] bytes = new byte[1024];
            int len;

            while ((len = fileInput.read(bytes)) != -1) {
                for (int i = 0; i < len; i++) {
                    bytes[i] = (byte) (bytes[i] ^ 5);
                    fileOutput.write(bytes[i]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    //  3. 获取文本上每个字符出现的次数
//    提示：遍历文本的每一个字符；字符及出现的次数保存在Map中；将Map中数据写入文件
    static void charNumber() {

        File file1 = new File("day_IO\\src\\dreamer.txt");
        File file2 = new File("day_IO\\src\\dreamerMapNumber.txt");

        try (FileReader fileReader = new FileReader(file1);
             FileWriter fileWriter = new FileWriter(file2);
        ) {

            HashMap<Character, Integer> map = new HashMap(10);
            int c ;

            while ((c = fileReader.read()) != -1) {
                char ch = (char)c;

                    if (map.containsKey(ch)) {
                        int newValue = map.get(ch) + 1;
                        map.put(ch, newValue);
                    } else {
                        map.put(ch, 1);
                    }
            }

            Set<Character> keySet = map.keySet();
            Iterator<Character> iterator = keySet.iterator();
            while (iterator.hasNext()) {
                char mapChar = iterator.next();
                fileWriter.write(mapChar + " === " + map.get(mapChar) + "\n");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    //  4.  综合使用InputStreamReader 和 OutputStreamWriter 复制文件
    static void copyFile1() {

        try (
                FileInputStream fileInput = new FileInputStream(new File("day_IO\\src\\dreamer.txt"));
                FileOutputStream fileOutput = new FileOutputStream(new File("day_IO\\src\\dream1.txt"))
        ) {

            InputStreamReader inputReader = new InputStreamReader(fileInput, "UTF-8");
            OutputStreamWriter outputWriter = new OutputStreamWriter(fileOutput, "GBK");

            char[] chars = new char[10];
            int len;
            while ((len = inputReader.read(chars)) != -1) {
//                    String str = new String(chars,0,len);
//                    System.out.print(str);

//            String  string = "faklsjfklahhhhzaszhhhhtfdsshhhshhhhhhhhjskfljaklfjasljkfalk;jf";
//            outputWriter.write(string);
                outputWriter.write(chars, 0, len);
                outputWriter.flush();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /*
4. 列出当前目录下全部java文件的名称

6. 使用File类下的常用方法获取某些文件的信息。

11. 利用IO流操作文件
1)利用Java代码创建D:\temp\temp1\temp2共3个文件夹
2)在temp文件夹下创建一个1.txt文件内容为hello，创建一个Hello.java文件
3)内容为public static void main(String[] args){},在temp1文件夹下创建同样的两个文件
4)输出temp文件夹下包括其子文件夹下，所有的.java文件

12. 利用IO流操作文件
1)	利用java代码在D盘下创建一个mytemp文件夹
2)	显示D盘下所有的.Java文件，包括D盘的子文件夹下的.java文件
3)	把上述显示的文件都复制到mytemp文件夹中
*/


}





