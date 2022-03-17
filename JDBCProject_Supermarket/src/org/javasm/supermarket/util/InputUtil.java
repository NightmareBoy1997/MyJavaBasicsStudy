package org.javasm.supermarket.util;

import java.util.Objects;
import java.util.Scanner;

/**
 * @projectName: MyJavaStudy
 * @package: org.javasm.supermarket.util
 * @author: Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-03-17 10:32
 */
public class InputUtil {
    private InputUtil() {
    }

    private static Scanner scanner = new Scanner(System.in);


    /**
     * 录入符合条件的int值
     *
     * @param regex
     * @return
     */
    public static int nextInt(String regex) {
        do {
            final String next = scanner.next();
            if (next.matches(regex)) {
                return Integer.parseInt(next);
            } else {
                System.out.print("输入失败！请重新输入： ");
            }
        } while (true);
    }

    /**
     *  录入字符
     * @return
     */
    public static String next() {

        String inputString = null;
        do {
            inputString = scanner.next();
            if (Objects.nonNull(inputString)) {
                return inputString;
            }else{
                System.out.print("不能为空，请重新输入： ");
            }
        } while (true);


    }

    /**
     * 录入符合给定的正则格式字符
     * @param regex
     * @return
     */
    public static String next(String regex) {
        String inputString = null;
        do {
            inputString = scanner.next();
            if (Objects.nonNull(inputString) && inputString.matches(regex)) {
                return inputString;
            } else {
                System.out.print("输入有误！请重新输入: ");
            }
        } while (true);
    }



}