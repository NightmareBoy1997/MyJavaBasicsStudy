package javasm;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author: Nightmare970701
 * @className:
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-02-12 16:03
 * <p>
 * <p>
 * l 任务
 * • 模拟注册登录幸运抽奖全过程
 * l 主要功能
 * • 注册
 * • 登录
 * • 幸运抽奖
 */
public class LuckyDraw {

    public static void main(String[] args) {

        // 创建记录程序参数的对象
        Flag show = new Flag();
        // 调用主界面功能选择方法 ，启动抽奖程序
        menu(show);

    }





    /**
     * 功能方法： 动态录入功能 ， 如果传入的不是单字符串或y、n ， 循环重新获取
     *
     * @param scanner
     * @return
     */
    public static char inputScanner(Scanner scanner) {

        for (; ; ) {
            String inputString = scanner.next();
            char inputChar = inputString.charAt(0);

            if (inputString.length() != 1 | (inputChar != 'y' && inputChar != 'n' && inputChar != 'N' && inputChar != 'Y')) {
                System.out.print("输入有误！请重新输入： ");
                continue;
            }
            return inputChar;
        }
    }



    /**
     * 功能方法： 将主界面是否退出询问语句获取的 ‘y’‘n’致反：
     * @param rollbackChar
     * @return
     */
    public static char rollback(char rollbackChar) {

        // 将 y/n 判断条件致反
        if (rollbackChar == 'y' | rollbackChar == 'Y') {
            rollbackChar = 'n';
        } else {
            if (rollbackChar == 'n' | rollbackChar == 'N') {
                rollbackChar = 'y';
            }
        }
        return rollbackChar;
    }



    /**
     * 4.主界面程序退出方法: 当返回false时通过主界面选择方法menu()将false赋值给isGo结束主界面循环
     * @param doExit
     * @param scanner
     * @return show.isGo
     */
    public static boolean exit(char doExit, Scanner scanner) {

        if (doExit == 'n' | doExit == 'N') {
            scanner.close();
            return false;
        }
        return true;
    }



    /**
     * 主界面功能选择 : 调用各个功能的方法执行相应操作 ，当通过程序退出exit()方法返回false时，结束主界面循环
     * @param show
     */
    public static void menu(Flag show) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Account> list = new ArrayList<>();

        // 主界面循环
        while (show.isGo) {
            System.out.println("\n*********** 欢迎进入大富翁抽奖系统 ***********\n");
            System.out.println("                   1.注 册 ");
            System.out.println("                   2.登 录 ");
            System.out.println("                   3.抽 奖 ");
            System.out.println("                   4.退 出 \n");
            System.out.println("*********************************************\n");

            System.out.print("请选择要进行的操作(1-4)： ");
            String inputString ;
            while (true) {
                inputString = scanner.next();
                if (inputString.length() != 1) {
                    System.out.println("您的输入长度有误！请重新输入！ ");
                    continue;
                }
                char isNumber = inputString.charAt(0);
                if (isNumber != '1' && isNumber != '2' && isNumber != '3' && isNumber != '4') {
                    System.out.println("您的输入的数值有误！请重新输入！ ");
                    continue;
                } else {
                    break;
                }
            }

            switch (inputString) {
                case "1":
                    // 启动注册账户方法
                    show.isGo = enrollAccount(show , scanner, list );
                    break;

                case "2":
                    // 启动登录账户的方法
                    show.isGo = loginAccount(show , scanner, list );
                    break;

                case "3":
                    // 启动抽奖方法
                    luckDraw(scanner, show.isUp);
                    break;

                case "4":
                    System.out.print("是否要退出系统？(y/n): ");
                    // 获取用户是否退出指令
                    char menuExit = inputScanner(scanner);
                    // 将 y/n 判断条件致反
                    menuExit = rollback(menuExit);
                    // 判断经过各种功能后，程序是否结束
                    show.isGo = exit(menuExit, scanner);
            }
        }
    }



    /**
     * 1. 注册操作 : 动态录入用户名密码，当密码短于 5 或 密码为纯数字时，提醒用户密码太过简单，重新输入密码
     * 注册成功然后将账户加入list ，使用集合管理账户
     * @param show
     * @param scanner
     * @param list
     * @return show.isGo
     */
    public static boolean enrollAccount(Flag show , Scanner scanner, ArrayList<Account> list ) {

        System.out.println("\n~~~~~~~~~~~~~~~~~用户注册界面~~~~~~~~~~~~~~~~~~\n");

        if (show.isUp == true) {
            System.out.println("您已经登陆，无需注册!");
            return true;
        }

        System.out.println("请填写个人注册信息 ");
        System.out.print("请输入用户名： ");
        String name = scanner.next();
        // 记录创建账户的密码
        String password;
        System.out.print("请输入密码： ");

        flag: while (true) {
            password = scanner.next();
            // 判断密码是否过于简短
            if (password.length() < 5) {
                System.out.print("密码太简短可不安全哦！请重新输入： ");
                continue;
            }

            // 判断是否为纯数字密码
            char[] array = password.toCharArray();
            char numberArray[] = {'1', '2', '3', '4', '5', '6', '7', '8', '9', '0'};
            boolean info = true;
            for (int i = 0; i < array.length; i++) {
                info = true;
                for (int j = 0; j < numberArray.length; j++) {
                    if (array[i] == numberArray[j]) {
                        info = false;
                        break;
                    }
                }
                if (info == true) {
                    break flag;
                }
            }
            System.out.print("纯数字密码安全性太低！请与字母结合重新输入： ");
        }

        System.out.println("注册成功! 请牢记您的会员号");

        // 新创建Account对象 ， 添加到Account集合中
        list.add(new Account(name, password));
        Account account = list.get(show.len);

        // 输出创建的账户名称、密码、会员id
        System.out.println(account.toString());
        show.len++;

        // 判断是否退出程序
        System.out.print("\n现在开始玩吗？(y/n): ");
        char isPlayer = inputScanner(scanner);
        return exit(isPlayer, scanner);
    }



    /**
     * 2. 登录账户的方法 : 如果登陆成功，退回主页面 。 如果失败，询问是否前往创建账户
     * @param show
     * @param scanner
     * @param list
     * @return show.isGo
     */
    public static boolean loginAccount(Flag show , Scanner scanner, ArrayList<Account> list) {

        System.out.println("\n^^^^^^^^^^^^^^^^^用户登录界面^^^^^^^^^^^^^^^^^\n");

        if (show.isUp == true) {
            System.out.println("您已经登陆，无需再次登录!");
            return true;
        }

        flag:  for (int i = 0; i < 3; i++) {

            System.out.print("请输入用户名： ");
            String inputName = scanner.next();

            System.out.print("请输入密码： ");
            String inputPassword = scanner.next();

            Account[] accountArray = list.toArray(new Account[]{});
            for (Account account : accountArray) {

                if (account.getName().equals(inputName)) {
                    if (account.getPassword().equals(inputPassword) ) {
                        System.out.println("\n欢迎你！   >> " + account.getName() + "  <<\n");
                        show.isUp = true;
                        return true;
                    } else {
                        System.out.println("密码错误！请重试： ");
                        continue flag;
                    }
                }
            }
            System.out.println("没有此账户！");

            // 前两次失败提示是否前往注册
            if (i < 2) {

                System.out.print("是否前往注册？(y/n): ");

                char isEnrollChar = inputScanner(scanner);

                // 前往注册账户
                if (isEnrollChar == 'y' | isEnrollChar == 'Y') {
                    return enrollAccount(show , scanner, list );
                }
                // 继续登录操作
                if (isEnrollChar == 'n' | isEnrollChar == 'N') {
                    continue flag;
                }
            }

        }

        // 失败3次，调用退出程序方法exit() ， 退出程序
        System.out.println("失败次数达到3次，程序结束！下次再见！");
        return exit('n', scanner);
    }



    /**
     *  3. 抽奖方法 : 用户输入会员id ， 由随机生成的5个幸运会员码逐个比较 ， 相同即为幸运会员退出程序。
     *   不同则询问用户是否继续？
     * @param scanner
     * @param isUp
     */
    public static void luckDraw(Scanner scanner, boolean isUp) {

        System.out.println("\n$$$$$$$$$$$$$$$$ 幸运锦鲤抽奖 $$$$$$$$$$$$$$$$\n");

        if (isUp == false) {
            System.out.println("您还没有登陆，请先前往登录!");
            return;
        }

        // accountId 记录用户输入的会员id ， number记录每次随机产生的会员码
        int accountId, number;
        // 记录幸运号码的索引
        int sum = 0;
        int luckNumber[] = new int[5];

        // 给accountId会员码赋值
        for (; ; ) {
            System.out.print("\n请输入您的卡号： ");
            accountId = scanner.nextInt();
            if (accountId >= 10000 | accountId < 1000) {
                System.out.print("这可不是我们店铺的会员号哦，请重试： ");
            } else {
                break;
            }
        }

        // 记录5个幸运会员号码
        System.out.print("本日的幸运号码是：  ");
        for (int i = 0 ; i < 5 ; i++ ) {
            number = (int) (Math.random() * 9000 + 1000);

            for(int j = 0 ; j< luckNumber.length ; j++){

                if (number == luckNumber[j]) {
                    i--;
                    break;
                }

                luckNumber[sum] = number;
                System.out.print(number + "   ");
                sum++;
                break;
            }
        }

        // 判断该用户是否是幸运会员
        for (int i : luckNumber) {
            if (accountId == i) {
                System.out.println("哇塞！天选之人！您是我们今天的幸运会员,今日所有消费打5折。赶紧去疯狂买买买把！");
                // 抽奖完成，退出程序
                exit('n', scanner);
            }
        }

        System.out.println("\n很遗憾！您不是我们的幸运会员。 ");
        System.out.print("\n别灰心，还有机会！继续玩吗？(y/n): ");
        char isPlayer = inputScanner(scanner);

        if(isPlayer == 'n' | isPlayer == 'N'){
            System.out.println("抽奖结束！ 今日运气不佳？ 可惜啊霉逼！ 愿佛祖保佑你！");
        }

        // 判断是否退出程序
        exit(isPlayer, scanner);

    }




}




/**
 * @author: Nightmare970701
 * @className:
 * @description: 辅助类： 记录店铺会员账户， 有名称、密码、随机生成的会员id
 * @since:
 * @version: JDK11
 * @create: 2022-02-12 16:03
 */
class Account {

    // 会员账户名称
    String name;
    // 会员账户密码
    String password;
    // 随机会员id
    int id;

    public Account() {
    }

    public Account(String name, String password) {
        this.name = name;
        this.password = password;
        this.id = (int) (Math.random() * 9000 + 1000);
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String toString() {
        return "用户名\t\t密码\t\t会员卡号\n" + name + "\t\t" + password + "\t\t" + id;
    }

}


/**
 * @author: Nightmare970701
 * @className:
 * @description: 辅助类： 记录程序运行、用户登录、用户数量的各种参数
 * @since:
 * @version: JDK11
 * @create: 2022-02-12 16:03
 */
class Flag{

    // 程序进行参数
    static boolean isGo = true;
    // 用户数量参数
    static int len ;
    // 用户登录参数
    static boolean isUp = false ;

}