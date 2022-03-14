package javasm.exercise;

/**
 * @author Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-02-10 19:44
 *
 *  求1到100之间所有能被3整除的整数的总和
 *
 */
public class SumNumber {

    public static void main(String[] args) {

        Thread numberThread = new Thread(){
            public void run(){

                int sumNumber = 0;

                for(int i = 1 ; i <= 100 ;i++ ){

                    if(i % 3 == 0 ){
                        sumNumber += i;
                    }
                }

                System.out.println("1到100之间所有能被3整除的整数的总和是： " + sumNumber);
            }
        };

        numberThread.setName("求和任务1 ");
        numberThread.start();

    }


}

