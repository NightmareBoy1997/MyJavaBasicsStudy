package smjava1;

import lombok.Data;

import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @projectName: MyJavaStudy
 * @package: PACKAGE_NAME
 * @author: Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-02-19 14:48
 * <p>
 * 为某企业开发一个迷你 管理器，实现单
 * 车的管理，包括如下功能：
 * u投放Bike
 * u查看Bike
 * u删除Bike
 * u借出Bike
 * u归还Bike
 */
public class BikeTest {

    public static void main(String[] args) {
        menu();
    }


    // 录入数据判断
    private static int inputNumber(Scanner input) {
        int[] array = {'1', '2', '3', '4', '5', '6', '7', '8', '9', '0'};
        boolean flag = true;

        while (true) {
            String inputStr = input.next();
            if (inputStr.length() != 1) {
                System.out.print("重输：  ");
                continue;
            }

            for (int i : array) {
                if (i == inputStr.charAt(0)) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                System.out.print("重输：  ");
                continue;
            }
            return Integer.parseInt(inputStr);
        }
    }


    /**
     * 1. 投车方法：
     *
     * @param input
     * @param bikeDB
     * @return
     */
    private static void into(Scanner input, BikeDB bikeDB) throws Exception {

        while (true) {
            System.out.println("*************** 公司运营单车品牌列表 **************");
            System.out.println("****************** 1. ofo单车   ******************");
            System.out.println("****************** 2. hello单车 ******************");
            System.out.println("****************** 3. mo单车    ******************");
            System.out.println("请输入要投入的品牌序号：");

            // 记录输入的品牌编号
            int no = inputNumber(input);
            if (no > 3) {
                throw new RuntimeException("我们公司没有这个");
            }

            var bikes = bikeDB.getBikes();

            String str = "smjava.Bike";
            switch (no) {
                case 1:
                    str = "smjava.OfoBike";
                    break;
                case 2:
                    str = "smjava.HaloBike";
                    break;
                case 3:
                    str = "smjava.MoBike";
            }

            // 创建单车对象
            Class clazz = Class.forName(str);
            int bikesNumber = BikeDB.getBikesNumber();

            Constructor bikeConstructor = clazz.getDeclaredConstructor();
            bikeConstructor.setAccessible(true);

            System.out.print("请输入要投入单车的数量： ");
            int inputNumber = input.nextInt();

            for (int i = 0; i < inputNumber; i++) {

                int arrayNumber = bikesNumber + i ;
                if (arrayNumber == bikes.length - 1) {
                    System.out.println("空间不足，已经参照配置扩容 5 ");

                    bikes = Arrays.copyOf(bikes, bikes.length + 5);

                }

                Bike tempBike = (Bike) bikeConstructor.newInstance();
//                    if(tempBike instanceof OfoBike) {
//                        tempBike = (OfoBike)tempBike;
//                    }
//                    if(tempBike instanceof HaloBike) {
//                        tempBike = (OfoBike)tempBike;
//                    }
//                    if(tempBike instanceof MoBike) {
//                        tempBike = (OfoBike)tempBike;
//                    }

                bikes[arrayNumber] = tempBike;
                BikeDB.setBikesNumber(BikeDB.getBikesNumber() + 1);

                System.out.println("投入成功！ 投入的单车是： \t" + bikes[i].getName() + "\t\t编号： " + bikes[i].getId());

            }

            System.out.println("-------------------\n继续投入吗？(1：继续 ； 2： 返回)");
            while (true) {
                int into = input.nextInt();
                if (into != 1 | into != 0) {
                    System.out.print("输入错误！请重新输入: ");
                } else {

                    if (into == 1) {
                        break;
                    } else {
                        return;
                    }
                }
            }
        }
    }


    // 主界面的方法
    public static void menu() {

//        ExecutorService executorService = Executors.newFixedThreadPool(15);
//        ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor)executorService;

        boolean isGo = true;
        var input = new Scanner(System.in);
        BikeDB bikeDB = BikeDB.getBikeDB();

        while (isGo) {

            System.out.println("欢迎使用迷你共享单车管理系统\n**************************************************\n");
            System.out.println("\t\t\t1. 投放Bike");
            System.out.println("\t\t\t2. 查看Bike");
            System.out.println("\t\t\t3. 删除Bike");
            System.out.println("\t\t\t4. 借出Bike");
            System.out.println("\t\t\t5. 归还Bike");
            System.out.println("\t\t\t6. Bike排行榜");
            System.out.println("\t\t\t7. 退    出");
            System.out.println("\n**************************************************\n");


            System.out.print("请选择要进行的操作： ");
            int number = inputNumber(input);

            switch (number) {
                case 1:

                    try {
                        into(input, bikeDB);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:
                    break;

                case 5:
                    break;

                case 6:
                    break;
                case 7:
                    break;
                default:
                    throw new RuntimeException("没有此选项，弟弟");

            }


        }


    }


}


/**
 * @author: Nightmare970701
 * @className:
 * @description: 单车管理中心： 记录车子的种类、数量、借出次数等参数
 * @since:
 * @version: JDK11
 * @create: 2022-02-19 22:03
 */
@Data
class BikeDB {

    // BikeDB的唯一对象
    private static BikeDB bikeDB = new BikeDB();
    // 管理单车
    private Bike[] bikes = new Bike[10];

    // 车子的总数
    private static int bikeNumber = HaloBike.getNumber() + OfoBike.getNumber() + MoBike.getNumber();

    private BikeDB() {
    }

    public static BikeDB getBikeDB() {
        return bikeDB;
    }

    /**
     * 修改单车的总数
     *
     * @param number
     */
    public static void setBikesNumber(int number) {
        bikeNumber = number;
    }

    /**
     * 获取单车的总数
     *
     * @return
     */
    public static int getBikesNumber() {
        return bikeNumber;
    }

    /**
     *  借车方法：
     * @param bikes
     * @param id
     */
//    public void borrowBike(Bike[] bikes,int id){
//        Bike bike = bikes[id];
//        if(bike.getState() == false){
//            System.out.println("借出失败！" + bike.getName() + "车车已经被人借走了，下次来早点哦！");
//        }
//        bikes[ id ].setState(false);
//    }


    /**
     *  还车方法：
     * @param bikes
     * @param id
     */
//    public void returnBike( Bike[]  bikes , int id ){
//        var bike = bikes[id];
//
//        if(bikes)
//
//    }

}


/**
 * @author: Nightmare970701
 * @className:
 * @description: 单车类： 有型号名称、状态、编号属性
 * @since:
 * @version: JDK11
 * @create: 2022-02-19 21:42
 */
@Data
abstract class Bike {
    // 单车的型号
    private String name;
    // 单车的初始id
    private String id;
    // 单车的借出时间
    private String borrowTime;
    // 单车的状态
    private boolean state = false;
    // 单车的日租金
    private int dayMoney;

}


@Data
class OfoBike extends Bike {

    // ofo单车的型号
    private String name = "ofo单车";
    // ofo单车的初始id
    private String id = "OFO-3529";

    // ofo单车的数量
    private static int number;
    // ofo单车的借出的次数
    private static int borrowNumber;

    public OfoBike(){
        this.id = id.concat(String.valueOf(number));
        this.number++;
    }

    public OfoBike(String string , boolean state , int dayMoney){
        this();
        this.setBorrowTime(string);
        this.setState(false);
        this.setDayMoney(dayMoney);
        this.number++;
    }


    // 单车的借出时间
    private String borrowTime;
    // 单车的状态
    private boolean state = false;
    // 单车的日租金
    private int dayMoney;


    /**
     * 获取品牌车子的数量
     *
     * @return number
     */
    public static int getNumber() {
        return number;
    }

    /**
     * 获取车子的借出次数
     *
     * @return borrowNumber
     */
    public static int getBorrowNumber() {
        return borrowNumber;
    }

}

@Data
class HaloBike extends Bike {

    // 哈罗单车的型号
    private String name = "哈罗单车";
    // 哈罗单车的初始id
    private String id = "Halo-7701";

    // 哈罗单车的数量
    private static int number;
    // Halo单车的借出的次数
    private static int borrowNumber;

    public HaloBike(){
        this.id = id.concat(String.valueOf(number));
        this.number++;
    }

    /**
     * 获取品牌车子的数量
     *
     * @return number
     */
    public static int getNumber() {
        return number;
    }

    /**
     * 获取车子的借出次数
     *
     * @return borrowNumber
     */
    public static int getBorrowNumber() {
        return borrowNumber;
    }


}

@Data
class MoBike extends Bike {

    // 摩拜单车的型号
    private String name = "摩拜单车";
    // 摩拜单车的初始id
    private String id = "Mo-4399";

    // 摩拜单车的数量
    private static int number;
    // Mo单车的借出的次数
    private static int borrowNumber;

    public MoBike(){
      this.id = id.concat(String.valueOf(number));
      this.number++;
    }

    /**
     * 获取品牌车子的数量
     *
     * @return number
     */
    public static int getNumber() {
        return number;
    }

    /**
     * 获取车子的借出次数
     *
     * @return borrowNumber
     */
    public static int getBorrowNumber() {
        return borrowNumber;
    }


}