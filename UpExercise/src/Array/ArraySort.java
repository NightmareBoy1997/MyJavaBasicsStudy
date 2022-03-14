package Array;

import java.util.Arrays;

/**
 * @author: Nightmare970701
 * @className:
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-02-12 10:58
 */
public class ArraySort {

    /**
     * @author Nightmare970701
     * @description:  冒泡排序: 将相邻的两个元素进行比较，最大的值放在右端。
     * N个数字要排序完成，总共进行N-1趟排序，每i趟的排序次数为(N-i)次，所以可以用双重循环语句，
     * 外层控制循环多少趟，内层控制每一趟的循环次数。
     *
     * @since:
     * @version: JDK11
     * @create: 2022-02-13 15:42
     */
    public static void bubbleSort(){
        int []array = {1,-3,41,2,0,10,2,42,43,55,-12,4,-3,-56};
        // 排序之前
        System.out.println("排序之前的数组为： " + Arrays.toString(array));

        // 排序操作,依次与其后元素比较,将小的值移到前面
        int length = array.length;
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - i - 1; j++) {
                if(array[j] > array[j+1]){
                    int temp = array[j+1] ;
                    array[j+1] = array[j];
                    array[j] = temp;
                }
            }
        }

        // 排序之后
        System.out.println("排序之后的数组为： " + Arrays.toString(array));
    }



    /**
     * @author Nightmare970701
     * @description: 选择排序： 交换次数少于冒泡 。
     *      从第一个元素开始，分别与后面的元素相比较，找到最小的元素与第一个元素交换位置；从第二个元素开始，
     *      分别与后面的元素相比较，找到剩余元素中最小的元素，与第二个元素交换；
     *      重复上述步骤，直到所有的元素都排成由小到大为止
     *
     * @since:
     * @version: JDK11
     * @create: 2022-02-13 15:42
     */
    public static void chooseSort(){
        // 初始化数组
        int []array = {1,-3,41,2,0,10,2,42,43,55,-12,4,-3,-56};
        System.out.println(Arrays.toString(array));

        int length = array.length;

        // 排序操作
        for(int i = 0 ; i<length - 1 ; i++){

            // 数组元素的最小值
            int min = array[i];
            // 数组元素的最小值的索引
            int minIndex = i;

            for(int j = i + 1  ; j < length ; j++){

                if(array[j] < min){
                    // 找到最小值及索引
                    min = array[j];
                    minIndex = j;
                }
            }

            // 最小值与当前元素交换
            if(array[i] > min){
                int temp = array[i];
                array[i] = array[minIndex];
                array[minIndex] = temp;
            }
        }

        // 遍历数组
        System.out.println(Arrays.toString(array));
    }



    /**
     * @author Nightmare970701
     * @description: 插入排序 ：
     *
     * 将指针指向某个(第二个)元素，假设该元素左侧的元素全部有序，将该元素抽取出来，然后按照从右往左的顺序分别与其左边的元素比较，
     * 遇到比其大的元素便将元素右移，直到找到比该元素小的元素或者找到最左面发现其左侧的元素都比它大，停止.
     * 此时会出现一个空位，将该元素放入到空位中，此时该元素左侧的元素都比它小，右侧的元素都比它大；
     * 指针向后移动一位，重复上述过程。
     *
     * @since:
     * @version: JDK11
     * @create: 2022-02-13 15:42
     */
    public static void insertSort(){
        // 初始化数组
        int []array = {1,-3,41,2,0,10,2,42,43,55,-12,4,-3,-56};

        // 排序之前
        System.out.println(Arrays.toString(array));

        int length = array.length;
        for (int i = 1 ; i < length  ; i++) {
            int temp = array[i];

            int leftIndex = i -1 ;

            // 将左侧比temp大的元素右移
            while(leftIndex >= 0 && array[leftIndex] > temp){
                array[leftIndex + 1] = array[leftIndex];
                leftIndex -- ;
            }

            // 当前填补空位
            array [leftIndex + 1] = temp ;
        }

        // 遍历数组
        System.out.println(Arrays.toString(array));

    }

    public static void main(String[] args) {

        bubbleSort();

        chooseSort();

        insertSort();


    }


}
