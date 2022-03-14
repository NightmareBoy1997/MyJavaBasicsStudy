package javasm.exercise.demo;

import javasm.exercise.bean.*;
import javasm.exercise.bean1.AbstractSoldier;
import javasm.exercise.bean1.InfightingSoldier;
import javasm.exercise.bean1.RemoteSoldier;
import javasm.exercise.bean1.SuperSoldier;
import javasm.exercise.common.LocationType;
import javasm.exercise.util.Utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 * @projectName: MyJavaStudy
 * @package: javasm.exercise.demo
 * @author: Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-03-05 22:20
 */
public class LeagueOfLegends {

    static HeroList[] heroLists = new HeroList[5];

    static {
        heroLists[0] = new HeroList(1, LocationType.MASTER_HERO.getTypeName(), new ArrayList<AbstractHero>(10));
        heroLists[1] = new HeroList(2, LocationType.WARRIOR_HERO.getTypeName(), new ArrayList<AbstractHero>(10));
        heroLists[2] = new HeroList(3, LocationType.ASSASSIN_HERO.getTypeName(), new ArrayList<AbstractHero>(10));
        heroLists[3] = new HeroList(4, LocationType.SHOOTER_HERO.getTypeName(), new ArrayList<AbstractHero>(10));
        heroLists[4] = new HeroList(5, LocationType.SUPPORT_HERO.getTypeName(), new ArrayList<AbstractHero>(10));

        heroLists[0].getHeroes().add(new MasterHero("流浪法师", "瑞兹", 450, 2368, 99,
                34, 33, null, null, null, 23));
        heroLists[0].getHeroes().get(0).setLines(List.of("要快，但也要谨慎!", "灾难始终慢我一步!"));
        heroLists[0].getHeroes().get(0).setSkills(List.of("超负荷", "符文禁锢", "法术涌动", "曲境折跃"));
        heroLists[0].getHeroes().get(0).setSkins(new HashMap<String, Integer>());
        heroLists[0].getHeroes().get(0).getSkins().put("部落精神", 23);
        heroLists[0].getHeroes().get(0).getSkins().put("地狱男爵", 99);


        heroLists[1].getHeroes().add(new WarriorHero("德玛西亚之力", "盖伦", 450, 3532, 131,
                57, 36, null, null, null));
        heroLists[1].getHeroes().get(0).setLines(List.of("人在塔在!", "正义，要么靠法律，要么靠武力"));
        heroLists[1].getHeroes().get(0).setSkills(List.of("致命打击", "勇气", "审判", "德玛西亚正义"));
        heroLists[1].getHeroes().get(0).setSkins(new HashMap<String, Integer>());
        heroLists[1].getHeroes().get(0).getSkins().put("孤高游侠", 49);
        heroLists[1].getHeroes().get(0).getSkins().put("神王", 99);

        heroLists[3].getHeroes().add(new ShooterHero("寒冰射手", "艾希", 450, 1992, 157,
                21, 30, null, null, null));
        heroLists[3].getHeroes().get(0).setLines(List.of("正中眉心!", "众志成城，我们是，阿瓦罗萨人"));
        heroLists[3].getHeroes().get(0).setSkills(List.of("冰霜射击", "万箭齐发", "鹰击长空", "魔法水晶箭"));
        heroLists[3].getHeroes().get(0).setSkins(new HashMap<String, Integer>());
        heroLists[3].getHeroes().get(0).getSkins().put("极地女神", 10);
        heroLists[3].getHeroes().get(0).getSkins().put("女皇", 99);

    }

/*    王者荣耀:
    英雄:
    id name 语录 List<皮肤>  price  分类

    //上架 优化(修改) 查看单个  查询所有英雄信息
    //查询指定类别里面所有的英雄

    皮肤:
    id name  price  皮肤关联英雄  皮肤状态
    // 查询指定英雄的所有皮肤
    // 上架  下架  查看所有皮肤  */

    public static void main(String[] args) {

        loginGame();

    }


    private static void loginGame() {
        int inputNumber = 0;
        boolean isGo = true;

        do {

            System.out.println("==================== 欢迎来到英雄联盟 ====================\n");
            System.out.println("====================== 1. 英雄上架 ======================");
            System.out.println("====================== 2. 英雄查看 ======================");
            System.out.println("====================== 3. 英雄优化 ======================");
            System.out.println("====================== 4. 英雄下架 ======================");
            System.out.println("====================== 5. 进入峡谷 ======================");
            System.out.println("====================== 6. 退出游戏 ======================\n");
            try {

                System.out.print("请输入要进行的操作： ");
                inputNumber = Utils.inputInt("^[1-6]$");

                switch (inputNumber) {
                    case 1:
                        System.out.println("----> 1. 英雄上架\n");
                        int addNumber = lookHeroType();
                        addHero(addNumber);
                        isGo = exit();
                        break;

                    case 2:
                        System.out.println("----> 2. 英雄查看\n");
                        findAllHero();
                        isGo = exit();
                        break;

                    case 3:
                        System.out.println("----> 3. 英雄优化\n");
                        int setNumber = findAllHero();
//                    int setNumber = lookHeroType();
                        setHero(setNumber);
                        isGo = exit();
                        break;

                    case 4:
                        System.out.println("----> 4. 英雄下架\n");
                        int delNumber = findAllHero();
                        delHero(delNumber);
                        isGo = exit();
                        break;
                    case 5:
                        System.out.println("----> 5. 进入峡谷\n");
//                        System.out.print("请选择要玩的英雄类型id： ");
                        int heroGameNumber = findAllHero();
                        happy(heroGameNumber);
                        isGo = exit();
                        break;
                    case 6:
                        System.out.println("----> 6. 退出游戏\n");
                        isGo = exit();
                        break;
                    default:
                        System.out.println("输入有误！程序退出！");
                        return;
                }


            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        while (isGo);


    }


    /**
     * 下架英雄
     *
     * @param delNumber
     * @throws IOException
     */
    private static void delHero(int delNumber) throws IOException {
        HeroList heroList = heroLists[delNumber];
        System.out.print("请输入要下架的英雄id： ");
        int id = Utils.inputInt("^10[0-1][0-9]$");
        heroList.delHero(id);
    }

    /**
     * 修改英雄
     *
     * @param setNumber
     */
    private static void setHero(int setNumber) throws IOException {

        ArrayList<AbstractHero> heroes = heroLists[setNumber].getHeroes();
        int sum = heroLists[setNumber].getSum() + 1000;
        System.out.print("请选择要修改的英雄id： ");
        int id = Utils.inputInt("^10[0-1][0-6]$");

        int index = 0;
        boolean isIn = true;
        for (int i = 0; i < heroes.size(); i++) {
            if (heroes.get(i).getId() == id) {
                index = i;
                break;
            }
        }
        if (isIn) {
            System.out.println("没有此英雄！");
            return;
        }

        AbstractHero setHero = heroes.get(index);

        System.out.println("1. 修改金额");
        System.out.println("2. 增加皮肤");
        System.out.println("3. 增加台词");
        System.out.println("请选择要修改的选项: ");
        int set = Utils.inputInt("^[1-3]$");

        switch (set) {
            case 1:
                System.out.print("请输入修改后的价格： ");
                setHero.setPrice(Utils.inputInt("^[0-6][0-9]00$"));
                break;
            case 2:
                System.out.print("请输入要添加的皮肤名称： ");
                String skinsName = Utils.inputString();
                System.out.print("请输入要添加的皮肤价格： ");
                int money = Utils.inputInt("^[1-9][0-9]$");
                setHero.getSkins().put(skinsName, money);
                break;
            case 3:
                System.out.print("请输入要添加的英雄台词： ");
                setHero.getLines().add(Utils.inputString());
                break;
        }
        System.out.println("修改完成！");
    }


    /**
     * 遍历英雄定位
     */
    private static int lookHeroType() throws IOException {
        for (int i = 0; i < 5; i++) {
            System.out.println(heroLists[i].getHeroTypeId() + " " + heroLists[i].getLocationName());
        }
        System.out.print("请输入要选择的类别id： ");
        return Utils.inputInt("^[1-5]$") - 1;
    }


    /**
     * 遍历查看英雄属性
     *
     * @throws IOException
     */
    private static int findAllHero() throws IOException {
        int typeNumber = lookHeroType();

        System.out.println("|--ID--|----称号----|---名称---|--价格--|--血量--|--攻击力--|--物理防御--|--魔法抗性--|-----------英雄技能-----------|-----------英雄皮肤-----------|-----------英雄台词-----------|");

        ArrayList<AbstractHero> heroes = heroLists[typeNumber].getHeroes();
        for (AbstractHero hero : heroes) {
            System.out.println("  " + hero.getId() + "\t" + hero.getAlias() + "\t\t" + hero.getName() + "\t" + hero.getPrice() + "\t\t" + hero.getBlood() + "\t\t\t" + hero.getAttack() + "\t\t\t" + hero.getDefense() + "\t\t" + hero.getMagicResistance()
                    + "\t\t" + hero.getSkills() + "\t" + hero.getSkins() + "\t\t" + hero.getLines());
        }
        return typeNumber;
    }

    /**
     * 添加英雄
     *
     * @param addNumber
     * @throws IOException
     */
    private static void addHero(int addNumber) throws IOException {
        HeroList list = heroLists[addNumber];
        System.out.print("请输入英雄称号： ");
        String alias = Utils.inputString();
        System.out.print("请输入英雄名称： ");
        String name = Utils.inputString();
        System.out.print("请输入英雄价格： ");
        int price = Utils.inputInt("^\\d+$");

        System.out.print("请输入英雄血量： ");
        Integer blood = Utils.inputInt();
        System.out.print("请输入英雄攻击力： ");
        Integer attack = Utils.inputInt();
        System.out.print("请输入英雄物理防御： ");
        Integer defense = Utils.inputInt();
        System.out.print("请输入英雄魔法抗性： ");
        Integer magicResistance = Utils.inputInt();

        list.add(alias, name, price, blood, attack, defense, magicResistance);
        System.out.println("添加成功！");

    }


    /**
     * 退出程序方法
     *
     * @return
     * @throws IOException
     */
    private static boolean exit() throws IOException {
        System.out.print("是否要退出(y/n)?： ");
        char char1 = Utils.inputChar();
        if (char1 == 'y') {
            Utils.closeStream();
            return false;
        }
        return true;
    }


    //
    private static void happy(int heroGameNumber) throws IOException {

        ArrayList<AbstractHero> heroes = heroLists[heroGameNumber].getHeroes();
        int sum = heroLists[heroGameNumber].getSum() + 1000;
        System.out.print("请输入要选择的英雄id： ");
        int id = Utils.inputInt("^10[0-1][0-9]$");
        System.out.println();
        
        int index = 0;
        boolean isIn = true;
        for (int i = 0; i < heroes.size(); i++) {
            if (heroes.get(i).getId() == id) {
                index = i;
                isIn = false;
                break;
            }
        }
        if (isIn) {
            System.out.println("没有此英雄！");
            return;
        }

        AbstractHero gameHero = heroes.get(index);

        Set<String> skins = gameHero.getSkins().keySet();
        int skinsNubmer = 1;
        for (String string : skins) {
            System.out.println(skinsNubmer + "号皮肤：" +  string);
            skinsNubmer++;
        }
        System.out.print("请选择你的皮肤： ");
        int gameHeroSkins = Utils.inputInt();
        if(gameHeroSkins > gameHero.getSkins().size()){
            System.out.println("未拥有此皮肤，将以原皮肤进入游戏");
        }

//        switch(heroGameNumber) {
//            case 1:
//                MasterHero gameHero =(MasterHero) heroes.get(index);
//                break;
//            case 2:
//                WarriorHero gameHero =(WarriorHero) heroes.get(index);
//                break;
//            case 3 :
//                AssassinHero gameHero =(AssassinHero) heroes.get(index);
//                break;
//            case 4:
//                ShooterHero gameHero =(ShooterHero) heroes.get(index);
//                break;
//            case 5:
//                SupportHero gameHero =(SupportHero) heroes.get(index);
//                break;
//        }

        gameHero.getType().goPath();

        System.out.println("\n\t\t >>>> 3 <<<< \n\t\t >>>> 2 <<<< \n\t\t >>>> 1 <<<< \n全军出击！\n");

        pk(gameHero);



    }

    public static void pk(AbstractHero gameHero) {

        AbstractSoldier[] soldiers = new AbstractSoldier[4];

        soldiers[0] = new InfightingSoldier("近战小兵", 580, 45, 23);
        soldiers[1] = new InfightingSoldier("近战小兵", 580, 45, 23);
        soldiers[2] = new RemoteSoldier("远程小兵", 490, 77, 23);
        soldiers[3] = new SuperSoldier("超级兵", 2099, 77, 55);
        double blood;
        for (int i = 0; i < soldiers.length; i++) {
            System.out.println("开始对战 " + soldiers[i].getName());
            int number = 0;
            while (soldiers[i].getBlood() > 0) {
                soldiers[i].action(gameHero);
                number++;
            }
            System.out.println("\n共攻击了 " + number + " 轮，终于打死了 " + soldiers[i].getName() + "\n你的剩余血量： " + gameHero.getBlood() + "\n");
        }

    }


}