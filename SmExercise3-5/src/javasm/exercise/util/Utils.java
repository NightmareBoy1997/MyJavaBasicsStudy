package javasm.exercise.util;

import javasm.exercise.bean.AbstractHero;
import javasm.exercise.bean1.AbstractSoldier;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @projectName: MyJavaStudy
 * @package: javasm.exercise.util
 * @author: Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-03-06 11:41
 */
public class Utils {

    static InputStreamReader inputStream = new InputStreamReader(System.in);
    static BufferedReader bufferedReader = new BufferedReader(inputStream);


    /**
     * @param regex
     * @return
     * @throws IOException
     * @description 录入数字选项
     */
    public static int inputInt(String regex) throws IOException {
//        System.out.print("请输入要进行的操作： ");
        while (true) {
            String str = bufferedReader.readLine();
            if (str.matches(regex)) {
                return Integer.parseInt(str);
            } else {
                System.out.print("输入有误！请重新输入： ");
            }
        }
    }

    /**
     * @return
     * @throws IOException
     * @description 录入数字选项
     */
    public static int inputInt() throws IOException {
//        System.out.print("请输入要进行的操作： ");
        while (true) {
            int number = bufferedReader.read();
            return number;
        }
    }

    /**
     * @param regex
     * @return
     * @throws IOException
     * @description 录入字符选项
     */
    public static String inputString(String regex) throws IOException {
//        System.out.print("请输入要进行的操作： ");
        while (true) {
            String str = bufferedReader.readLine();
            if (str.matches(regex)) {
                return str;
            }
        }
    }

    /**
     * @return
     * @throws IOException
     * @description 录入字符选项
     */
    public static String inputString() throws IOException {
//        System.out.print("请输入要进行的操作： ");
        String str = bufferedReader.readLine();
        return str;
    }


    /**
     * @return
     * @throws IOException
     * @description 录入确认选项
     */
    public static char inputChar() throws IOException {
        while (true) {
            String str = bufferedReader.readLine();
            if (str.matches("^[y|n]$")) {
                return str.charAt(0);
            } else {
                System.out.print("输入有误！请重新输入： ");
            }
        }
    }

    /*
     * @return
     * @description 录入Double数字选项
     * @throws IOException
     */
    public static double inputDouble() throws IOException {
        String str = bufferedReader.readLine();
        return Double.parseDouble(str);

    }



    public static void heroAttack(AbstractHero hero, AbstractSoldier soldier,String... strings) {

        double soldierAttack = soldier.getAttack() * (1- hero.getDefense() / 100);
        int heroBlood =(int) (hero.getBlood() - soldierAttack);

        if(heroBlood<0){
            hero.setBlood(0);
        }else{
            hero.setBlood(heroBlood);
        }
        System.out.println(soldier.getName() + strings[0] +  "对你进行攻击，造成了 " + soldierAttack + " 点攻击力的伤害 " + strings[1] +
                " ,你的剩余血量： " + hero.getBlood() + " ," );

        if (heroBlood <= 0) {
            System.out.println("你已被小兵击杀，太菜了吧！");
            System.out.println("********************************* < Game Over > *********************************");
            System.exit(1);
        }

        Integer myAttack = hero.getAttack() ;
        var heroAttackNumber =  myAttack - myAttack * soldier.getDefense() / 100 ;

        int soldierBlood = soldier.getBlood() - heroAttackNumber ;

        if( soldierBlood > 0 ){
            soldier.setBlood( soldierBlood );
        }else{
            soldier.setBlood( 0 );
        }

        System.out.println("你进行反击，" + soldier.getName() + strings[2] +"有 " + soldier.getDefense() + " 的防御力，你造成了 " + heroAttackNumber + "点伤害 , "
                + soldier.getName() + " 剩余血量： " + soldier.getBlood()+ "\n") ;

    }


        public static void closeStream() throws IOException {
        bufferedReader.close();
        inputStream.close();
    }
}