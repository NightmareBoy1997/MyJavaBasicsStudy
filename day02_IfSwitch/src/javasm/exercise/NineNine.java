package javasm.exercise;

/**
 * @author Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-02-10 19:54
 *
 *  输出乘法口诀表
 *
 */
public class NineNine {

    public static void main(String[] args) {

        for(int i = 1 ; i <= 9 ; i++){
            for(int j = 1 ; j <= i ; j++){
                System.out.print(i + "*"+ j + " = " + (i*j) + " \t ");
            }
            System.out.println();
        }

    }









}
