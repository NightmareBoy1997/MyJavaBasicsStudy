package javasm;

import java.util.Scanner;

/**
 * @projectName: MyJavaStudy
 * @package: javasm
 * @author: Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @projectName: MyJavaStudy
 * @create: 2022-02-13 22:58
 *
 */
public class YangHuiTriangle {


    /**
     *
     *  需求： 使用二维数组打印一个杨辉三角
     *
     *  例如：
     *  1
     *  1 1
     *  1 2 1
     *  1 3 3 1
     *  1 4 6 4 1
     *  1 5 10 10 5 1
     *  1 6 15 20 15 6 1
     *  ………………
     *
     *   提示： yanghui[i][j] = yanghui[i-1][j-1] + yanghui[i-1][j]
     *
     * @author：
     * @description:
     *
     */
    public static  void  yangHuiTriangle(){

        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入要添加的行数： ");
        // 记录打印的行数
        int number = scanner.nextInt();
        // 创建数组 ，第i行有i个元素
        int [][]yanghui = new int [number][];
        for (int i = 0; i < yanghui.length; i++) {
            yanghui[i] = new int [i + 1];
            // 给每行首末位置的元素赋值
            yanghui[i][i] = yanghui[i][0] = 1 ;

            // 给第三行以后的所有中间元素赋值
//            if(i > 1){  此判断可以去除没不影响结果！！
                for (int j = 1; j < yanghui[i].length - 1; j++) {

                    yanghui[i][j] = yanghui[i-1][j] + yanghui[i-1][j-1];

//                }
            }
        }

        // 遍历数组输出结果
        for (int[] ints : yanghui) {
            for (int anInt : ints) {
                System.out.print(anInt + "  ");
            }
            System.out.println();
        }

    }


    public static void main(String[] args) {

        yangHuiTriangle();

    }
}

