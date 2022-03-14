package IfSwitch;

/**
 * @projectName: MyJavaStudy
 * @package: javasm
 * @author: Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @projectName: MyJavaStudy
 * @create: 2022-02-13 22:09
 */
public class PrimeNumber {

    /**
     * 需求： 输出100以内的质数 质数： 只能被1和本身整除的自然数
     * @author 尚硅谷康师傅
     * @description: 利用开放的方式， 优化代码减少运行次数
     */
    public static void primeNumber(){

        flag : for(int i = 2 ; i <= 100 ; i++){

            // Math.sqrt(int i) 开方的方法
            for (int j = 2; j <= Math.sqrt(i) ; j++) {
                if(i % j ==0){
                continue flag;
                }
            }
                System.out.print(i + "\t");
        }
    }

    public static void main(String[] args) {

        primeNumber();

    }
}