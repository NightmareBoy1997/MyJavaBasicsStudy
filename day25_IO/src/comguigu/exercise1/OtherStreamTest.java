package comguigu.exercise1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @projectName: MyJavaStudy
 * @package: comguigu.exercise1
 * @author: Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-02-28 15:47
 */
public class OtherStreamTest {

    public static void main(String[] args) {

//        input();



    }

    // 从键盘输入字符串，要求将读取到的整行字符串转成大写输出。然后继续
    //进行输入操作，直至当输入“e”或者“exit”时，退出程序
    public static void input() {

        try (InputStreamReader inputSteamReader = new InputStreamReader(System.in);
             BufferedReader bufferedReader = new BufferedReader(inputSteamReader)) {

            String data;
            while (true) {
                System.out.print("请输入要录入的字符(e/exit 退出)： ");
                data = bufferedReader.readLine();
                if ("e".equalsIgnoreCase(data) || "exit".equalsIgnoreCase(data)) {
                    System.out.println("程序结束！");
                    break;
                }
                String s = data.toUpperCase();
                System.out.println(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}


