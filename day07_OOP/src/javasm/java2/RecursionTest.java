package javasm.java2;

/*
 * 递归方法的使用（了解）
 *
 *1. 递归方法：一个方法体内调用自身。
 *2. 本身是一种隐式循环，会重复执行某段代码，但这种重复执行的方式无须
 *循环控制
 *   **递归方法一定要有已知方向递归，否则就变成死循环
 *
 */
public class RecursionTest {
    public static void main(String[] args) {

        RecursionTest r1 = new RecursionTest();

        System.out.println(r1.getSum(100));
        System.out.println(r1.getSum1(10));
        System.out.println(r1.getf(10));
    }

    //例1：计算1-n之间所有自然数的和

    public int getSum(int i) {

        if (i == 1) {
            return 1;
        } else {
            return i + getSum(i - 1);
        }
    }

    //例2：计算1-n之间所有自然数的乘积 :n!

    public int getSum1(int i) {

        if (i == 1) {
            return 1;
        } else {
            return i * getSum1(i - 1);
        }
    }

    //例3：已知一个数列：f（0）=1，f（1）=4，f（n+2）=2*f（n+1）+f（n）
    //其中n是大于0的整数，求f（10）的值

    public int getf(int i) {
        if (i == 0) {
            return 1;
        } else if (i == 1) {
            return 4;
        } else {
            return 2 * getf(i - 1) + getf(i - 2);    //防止溢出
        }
    }

    //例4：斐波那契数列

    //例5：汉诺塔问题

    //例6：快速排序


}
