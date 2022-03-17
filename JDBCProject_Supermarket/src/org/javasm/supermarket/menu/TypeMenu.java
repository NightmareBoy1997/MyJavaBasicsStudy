package org.javasm.supermarket.menu;

import org.javasm.supermarket.util.InputUtil;

/**
 * @projectName: MyJavaStudy
 * @package: org.javasm.supermarket
 * @author: Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-03-17 14:20
 */
public class TypeMenu {
    public void menu() {
        System.out.println("---> 类型管理\n");
        System.out.println("1.新增类型");
        System.out.println("2.删除类型");
        System.out.println("3.修改类型");
        System.out.println("4.层级查询类型");
        System.out.println("5.退 出");

        String isGo;
        do {
            System.out.print("请选择要进行的操作： ");
            int inputNumber = InputUtil.nextInt("^[1-5]$");
            switch(inputNumber){
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5 :
                    System.out.println("退出类型管理");
                    return;
                default :
                    break;
            }
            System.out.print("是否继续操作？y/n: ");
            isGo = InputUtil.next("^[y|n|Y|N]$");
        } while (!"n".equalsIgnoreCase(isGo));
    }
}