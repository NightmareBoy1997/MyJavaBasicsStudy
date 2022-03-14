package javasm.bike.bean;

import javasm.bike.common.BikeConstant;
import javasm.bike.common.BikeEnum;
import javasm.bike.dao.BikeDao;
import javasm.bike.dao.impl.BikeDaoImpl;
import javasm.bike.util.InputUtil;

import java.util.Arrays;

/**
 * @projectName: MyJavaStudy
 * @package: javasm.bike.bean
 * @author: Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-02-26 20:00
 */
public class SharedBikeMgr {

    private static final BikeDao bikeDao;
    private static SharedBikeCompany[] companyArray;
    public static int ofoId = 1000;
    public static int haloId = 7700;
    public static int moId = 4380;

    static {
        bikeDao = new BikeDaoImpl();

        AbstractSharedBike[] ofoBikes = new OfoBike[5];
        AbstractSharedBike[] haloBikes = new HaloBike[5];
        AbstractSharedBike[] moBikes = new MoBike[5];

        companyArray = new SharedBikeCompany[3];

        for (int i = 0; i < 5; i++) {
            ofoBikes[i] = new OfoBike(ofoId, "ofo单车" + ofoId++, BikeEnum.BIKE_CAN_BORROWED.getCode(), "null");
            haloBikes[i] = new HaloBike(haloId, "halo单车" + haloId++, BikeEnum.BIKE_CAN_BORROWED.getCode(), "null");
            moBikes[i] = new MoBike(moId, "mo单车" + moId++, BikeEnum.BIKE_CAN_BORROWED.getCode(), "null");
        }

        companyArray[0] = new SharedBikeCompany(1001, BikeConstant.OFO_COMPANY_NAME, ofoBikes, 5, 2000,1.5);
        companyArray[1] = new SharedBikeCompany(1002, BikeConstant.HALO_COMPANY_NAME, haloBikes, 5, 6720,2.0);
        companyArray[2] = new SharedBikeCompany(1003, BikeConstant.MO_COMPANY_NAME, moBikes, 5, 2500,1.0);

    }

    public static void main(String[] args) {

       SharedBikeMgr bikeMgr = new SharedBikeMgr();
        bikeMgr.menu();

    }


    // 主界面的方法
    public void menu() {

        String isGo;
        do {
            System.out.println("欢迎使用迷你共享单车管理系统\n**************************************************\n");
            System.out.println("\t\t\t1. 投放Bike");
            System.out.println("\t\t\t2. 查看Bike");
            System.out.println("\t\t\t3. 删除Bike");
            System.out.println("\t\t\t4. 借出Bike");
            System.out.println("\t\t\t5. 归还Bike");
            System.out.println("\t\t\t6. Bike排行榜");
            System.out.println("\t\t\t7. 退    出");
            System.out.println("\n**************************************************\n");

            int option = InputUtil.inputInt("^[1-7]$", "请选择要进行的操作(1-7)： ");

            switch (option) {
                case 1:
                    putBikeModule();
                    break;

                case 2:
                    bikeDao.findAllBikeInfo(companyArray);
                    break;

                case 3:
                    deleteBikeModule();
                    break;

                case 4:
                    borrowBike();
                    break;

                case 5:
                    returnBikeModule();
                    break;

                case 6:
                    rankBikeCompany();
                    break;
                case 7:
                    InputUtil.close();
                    return;

            }

            System.out.print("是否继续操作？(y|n)):  ");
            isGo = InputUtil.inputString("^[y|n]$");
        } while ("y".equals(isGo));

        InputUtil.close();
        System.out.println("程序结束");

    }

    private void rankBikeCompany() {
        System.out.println("----------> 6. Bike排行榜\n");

        Arrays.sort(companyArray, (o1, o2) -> - Integer.compare(o1.getCount() , o2.getCount()) );

        for (SharedBikeCompany company : companyArray) {
            System.out.println(company.getCompanyName() + "\t" + company.getCount());
        }

    }

    private void returnBikeModule() {
        int id = choseCompany();

        bikeDao.returnBileById(companyArray[id - 1001]);
    }

    private void deleteBikeModule() {
        int id = choseCompany();

        bikeDao.deleteBikeById( companyArray[id - 1001] );

    }

    private void borrowBike(){
        int id = choseCompany();
        bikeDao.borrowBikeById(companyArray[id - 1001]);
    }


    public  void putBikeModule() {
        System.out.println("----------> 1. 投放Bike\n");

        int id = choseCompany();
        System.out.print("请录入要投放的数量： ");
        int putNumber = InputUtil.inputInt();

        bikeDao.putBike(companyArray[id - 1001] , putNumber);

    }

    public  int choseCompany(){
        System.out.println("公司运营单车品牌列表");
        for (SharedBikeCompany company : companyArray) {
            System.out.println(company.getCompanyId() + " : " + company.getCompanyName());
        }
        System.out.print("请输入要操作的品牌序号： ");

        return InputUtil.inputInt();
    }


}