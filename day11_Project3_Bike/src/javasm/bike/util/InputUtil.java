package javasm.bike.util;

import java.util.Scanner;

/**
 * @projectName: MyJavaStudy
 * @package: javasm.bike.util
 * @author: Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-02-26 20:02
 */
public class InputUtil {

    private final static Scanner scanner;

    static {
        scanner = new Scanner(System.in);
    }

    private InputUtil(){

    }

    public static int inputInt(String regex , String msg){
        System.out.print(msg);

        while(true){
            String numberString = scanner.next();
            if(numberString.matches(regex)){
                return Integer.parseInt(numberString);
            }else{
                System.out.println("输入有误！");
            }
        }
    }

    public static int inputInt(){
        int  number = scanner.nextInt();
        return number ;
    }

    /**
     *
     */
    public static void close(){
        scanner.close();
    }

    /**
     *
     * @param regex
     * @return
     */
    public static String inputString(String regex) {
        while(true){

            String inString = scanner.next();
            if(inString.matches(regex)){
                return inString;
            }else{
                System.out.println("输入有误！");
            }
        }
    }


    public static String inputLineString(String s) {
        scanner.nextLine();
        return scanner.nextLine();
    }
}