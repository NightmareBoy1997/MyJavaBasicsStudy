package javasm.exercise;

import java.util.Scanner;

/**
 * @author Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-02-10 19:31
 * <p>
 * 银行取款系统的密码判断，输入密码之后，进行密码判断，如果密码错误，继续输入密码。直到密码正确或者输入3次之后结束（密码可以是字符串也可以是int类型数值）
 * <p>
 */
public class BankPassword {

    public static void main(String[] args) {

//        银行取款系统的密码判断，输入密码之后，进行密码判断，如果密码错误，继续输入密码。直到密码正确或者输入3次之后结束（密码可以是字符串也可以是int类型数值）

        Scanner scanner = new Scanner(System.in);
        String passWord = "abcd";
        boolean flag = true;

        for (int i = 0; i < 3; i++) {

            System.out.print("请输入密码： ");
            String inputPassWord = scanner.next();

            if (passWord.equals(inputPassWord)) {
                System.out.println("密码正确！登陆成功！");
                flag = false;
                break;
            } else {
                System.out.println("密码错误！请重试！");
            }
        }

        if(flag){
            System.out.println("输入错误次数已达到3次！银行卡已冻结，请前往营业部门办理解冻！");
        }

    }


}
