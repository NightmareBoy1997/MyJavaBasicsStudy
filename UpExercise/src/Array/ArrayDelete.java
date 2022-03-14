package Array;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-02-12 10:42
 *
 *      Arrays 的方法：
 *          copyOf(Object [] oldArray , int newArraylength)  新建数组将原数组元素赋值，可用于扩容操作或截断操作
 *          sort(Object [] ) :
 *
 */
public class ArrayDelete {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 数组元素是连贯的， 空间是固定的
        System.out.print("请输入要添加元素的个数： ");
        int length = scanner.nextInt();
        String [] array = new String[length];

        // 动态获取数组元素的值
        for (int i = 0; i < array.length; i++) {
            System.out.print("请输入第 " + (i+1) + " 各元素的值： ");
            array[i] = scanner.next();
        }

        // 显示原数组
        System.out.println("原数组为： " + Arrays.toString(array));

        // 动态获取要删除的元素内容
        System.out.print("请输入要删除的元素值： ");
        String delete = scanner.next();


        // 删除数据就是把指定索引位置的内容变成默认值
        for (int index = 0; index < length; index++) {
            if(delete.equals(array[index])){

                array[index] = null;
                // 后面元素前移
                for (int j = index; j < length - 1; j++) {
                    array[j] = array[j + 1];
                }
                array[length - 1] = null;

                // 重点： 解决删除元素连续的难题
                if(delete.equals(array[index])){
                    index -- ;
                }
            }
        }

        System.out.println("删除 "  + delete +  " 之后的数组为： " + Arrays.toString(array));

        scanner.close();
    }
}