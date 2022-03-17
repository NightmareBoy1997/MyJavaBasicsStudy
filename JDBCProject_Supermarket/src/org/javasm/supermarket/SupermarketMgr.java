package org.javasm.supermarket;

import org.javasm.supermarket.menu.TypeMenu;
import org.javasm.supermarket.util.InputUtil;
import org.javasm.supermarket.util.RoleEnum;

import java.util.Objects;

/**
 * @projectName: MyJavaStudy
 * @package: org.javasm.supermarket
 * @author: Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-03-17 10:34
 */
public class SupermarketMgr {

    public void start() {
        System.out.println("\t\t\t\t  << 超市管理系统 >> \n");
        login();
    }

    /**
     * 登录账户
     */
    public void  login(){
        System.out.println("********************* 请登录账户 *********************");
        System.out.print("请输入用户名： ");
        String userName = InputUtil.next();
        System.out.print("请输入密码： ");
        String password = InputUtil.next();

        if(Objects.equals(RoleEnum.ADMIN.getName(),userName) && Objects.equals(RoleEnum.ADMIN.getPassword(),password) ){
            adminMenu();
        }else if (Objects.equals(RoleEnum.CASHIER.getName(),userName) && Objects.equals(RoleEnum.CASHIER.getPassword(),password) ){
            cashierMenu();
        }else{
            throw new RuntimeException("账户或密码错误！登录失败！");
        }
    }


    private void adminMenu(){
        System.out.println("\n欢迎你 " + RoleEnum.ADMIN.getName() );
        String inputString ;
        do {
            System.out.println("********************** 管理界面 **********************");
            System.out.println("1.类型管理");
            System.out.println("2.商品管理");
            System.out.println("3.会员管理");
            System.out.println("4.退    出");

            System.out.print("\n请选择要进行的操作: ");
            final int inputNumber = InputUtil.nextInt("^[1-4]$");
            switch(inputNumber){
                case 1:
                    new TypeMenu().menu();
                    break;
                case 2:
                    break;
                case 3 :

                    break;
                case 4:
                    System.out.print("是否继续操作？y/n: ");
                    return;
                default :
                    break;
            }
            System.out.print("是否继续操作？y/n: ");
            inputString = InputUtil.next("^[Y|N|y|n]$");
        } while (!"n".equalsIgnoreCase(inputString));

    }

    /**
     *
     */
    private void cashierMenu(){
        System.out.println("\n欢迎你 " + RoleEnum.CASHIER.getName() );
        System.out.println("********************** 管理界面 **********************");

    }





    /**
     * 根据录入的选择，确定是否退出程序
     * @return
     */
    private boolean isBreakApp() {
        final String inputString = InputUtil.next("^[Y|N|y|n]$");
        if("y".equalsIgnoreCase(inputString)){
            return false;
        }
        return true;
    }

}