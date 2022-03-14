package javasm.exercise;

/**
 * @author Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-02-10 19:50
 *
 *
 *
 *  循环输出以下结果
 *  2 * 5 = 10
 *  4 * 10 = 40
 *  6 * 15 = 90
 *  ....
 *  ? * 100 = ?
 *
 */
public class ForResult {


    public static void main(String[] args) {

        int result = 0 ;

        for(int i = 2 , j=5 ; j<= 100 ; i +=2 , j +=5){
            if(j == 100){
                result = i * j;
                System.out.println(i + "*" + j + "=" + (i * j));
                break;
            }
            System.out.println(i + "*" + j + "=" + (i * j));
        }

        System.out.println("\n? * 100 = " + result);

    }

}
