package javasm;

/**
 * @projectName: MyJavaStudy
 * @package: javasm
 * @author: Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-02-14 15:35
 */
public class RandomSystemExit {


    // 获取随机数
    public static void randomNumber(){

        // 设置数字的范围 例如[1~35]
        int min = 1 ;
        int max = 35 ;

        // 获取随机数
        int randomNumber = (int) (Math.random() * (max - min +1 ) + min);
        System.out.println(randomNumber);

    }

    // System.exit( int status );  将整个JVM虚拟机关闭 , 释放全部内存 ！
    //  不管status为何值都会退出程序



    public static void main(String[] args) {


        for(int i = 0 ; i< 40 ; i++){
            randomNumber();

            if(i == 5){
                // 结束JVM的方法
                System.exit(1);
            }

        }

    }



}