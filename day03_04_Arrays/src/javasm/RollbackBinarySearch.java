package javasm;

import java.util.Arrays;

/**
 * @projectName: MyJavaStudy
 * @package: javasm.java
 * @author: Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @projectName: MyJavaStudy
 * @create: 2022-02-14 9:17
 */
public class RollbackBinarySearch {

    /**
     * 数组反转 方式一：
     *
     * @param
     * @author
     * @description: 难度不大，但是其中的 length/2 逻辑，确实是妙！！！
     */
    public static void rollback() {
        String[] array = new String[]{"aa", "bb", "cc", "dd", "ee", "ff"};

        for (int i = 0; i < array.length / 2; i++) {
            String temp = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = temp;
        }
        System.out.println(Arrays.toString(array));
    }

    /**
     * 数组反转 方式二：
     *
     * @param
     * @author：
     * @description: 基本的做法
     */
    public static void rollback1() {
        String[] array = new String[]{"aa", "bb", "cc", "dd", "ee", "ff"};
        for (int i = 0, j = array.length - 1; i < j; i++, j--) {
            String temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }

    /**
     * 二分法查找
     *
     * @author：
     * @description: 每次比较中间值，折半的方式检索 。 要求数组必须是有序的！！ 如果中间索引位置的元素大于要查找的元素，
     *      将尾索引改为 <中间索引 - 1> ， 如果小于时，将首索引改为 <中间索引 + 1>
     */
    public static void binarySearch() {

        String []array = new String[]{"aa","bb","cc","dd","ee","ff","gg","mm" };
        String select = "bb";

//        int[] array = new int[]{1, 23, 45, 55, 56, 63, 69, 73, 81, 100};
//        int select = 100;
        // 首索引
        int head = 0;
        // 尾索引
        int end = array.length - 1;
        // 中间位置的索引
        int middle;

        while (end >= head) {
            middle = (end + head) / 2;

            if (array[middle] == select) {
                System.out.println("找到了所要的元素，索引位置是： " + middle);
                return;
            }
            // 中间位置的元素大于要查找的元素
            if (array[middle].compareTo(select) > 0 ) {
                end = middle - 1;
            }
            // 中间位置的元素小于要查找的元素
            if (array[middle].compareTo(select) < 0 ) {
                head = middle + 1;
            }
        }

        System.out.println("没找到所要的元素！");
    }


    public static void main(String[] args) {

//        rollback();
//
//        rollback1();

        binarySearch();

    }


}