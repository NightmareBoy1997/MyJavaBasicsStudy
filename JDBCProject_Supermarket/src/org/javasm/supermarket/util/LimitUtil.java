package org.javasm.supermarket.util;

import java.util.List;

/**
 * @projectName: MyJavaStudy
 * @package: org.javasm.supermarket.util
 * @author: Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-03-19 23:17
 */
public class LimitUtil {

    public static int getTotal(List<?> list, final int size) {
        int count = list.size();
        int number = count / size;
        final int total = count % size == 0 ? number : number + 1;
        System.out.println(" 信息展示共 << " + total + " >> 页");
        return total;
    }


    public static int selectLimitFunction(int page, int total) {
        int inputNumber;
        if(total==1){
            System.out.print("1. 结束查询");
            System.out.println("\n请选择进行的操作： ");
            inputNumber = InputUtil.nextInt("^1$");
        }else {
            if (page != 1 && page != total) {
                System.out.print("1. 进行选择\t2. 退出\t3. 首页\t4. 上一页\t5. 下一页\t6. 末页");
                System.out.println("\n请选择进行的操作： ");
                inputNumber = InputUtil.nextInt("^[1-6]$");
            } else if (page == 1) {
                System.out.print("1. 进行选择\t2. 退出\t5. 下一页\t6. 末页");
                System.out.println("\n请选择进行的操作： ");
                inputNumber = InputUtil.nextInt("^[1-2|5-6]$");
            } else {
                System.out.print("1. 进行选择\t2. 退出\t3. 首页\t4. 上一页");
                System.out.println("\n请选择进行的操作： ");
                inputNumber = InputUtil.nextInt("^[1-4]$");
            }
        }
        return inputNumber;
    }


    public static int selectLimitQuery(int page, int total) {
        int inputNumber;

        if(total==1){
            System.out.print("1. 结束查询");
            System.out.println("\n请选择进行的操作： ");
            inputNumber = InputUtil.nextInt("^1$");
        }else{
            if (page != 1 && page != total) {
                System.out.print("1. 结束查询\t2. 首页\t3. 上一页\t4. 下一页\t5. 末页");
                System.out.println("\n请选择进行的操作： ");
                inputNumber = InputUtil.nextInt("^[1-5]$");
            } else if (page == 1) {
                System.out.print("1. 结束查询\t4. 下一页\t5. 末页");
                System.out.println("\n请选择进行的操作： ");
                inputNumber = InputUtil.nextInt("^[1|4-5]$");
            } else{
                System.out.print("1. 结束查询\t2. 首页\t3. 上一页");
                System.out.println("\n请选择进行的操作： ");
                inputNumber = InputUtil.nextInt("^[1-3]$");
            }
        }
        return inputNumber;
    }

}