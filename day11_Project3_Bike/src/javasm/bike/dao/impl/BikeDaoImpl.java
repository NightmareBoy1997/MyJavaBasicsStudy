package javasm.bike.dao.impl;

import javasm.bike.bean.*;
import javasm.bike.common.BikeEnum;
import javasm.bike.dao.BikeDao;
import javasm.bike.util.DateUtil;
import javasm.bike.util.InputUtil;

import java.util.Arrays;

/**
 * @projectName: MyJavaStudy
 * @package: javasm.bike.dao.impl
 * @author: Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-02-26 20:48
 */
public class BikeDaoImpl implements BikeDao {

    @Override
    public void findAllBikeInfo(SharedBikeCompany[] companyArray) {
        System.out.println("----------> 2. 查看Bike\n");
        System.out.println("|————————————————————————————————————————————————————|");
        System.out.println("| 公司序号 | 公司名称 | 公司单车数量 | 公司单车借出次数 |");
        System.out.println("|————————————————————————————————————————————————————|");
        for (SharedBikeCompany company : companyArray) {
            int sum = company.getSum();
            System.out.println(company.getCompanyId() + "\t\t" + company.getCompanyName() + "\t\t\t" + company.getSum() + "\t\t\t  " + company.getCount());

            getBikeInfo(company, sum);
            System.out.println("---------------------------------------------------\n");
        }
    }


    private void getBikeInfo(SharedBikeCompany company, int sum) {
        System.out.println("单车序号" + "\t" + "单车品牌" + "\t\t" + "单车状态" + "\t  " + "借出时间");
        AbstractSharedBike[] bikes = company.getSharedBikes();
        for (int i = 0; i < sum; i++) {
            AbstractSharedBike bike = bikes[i];
            String msg = (bike.getStatus() == BikeEnum.BIKE_BORROWED.getCode()) ? BikeEnum.BIKE_BORROWED.getMsg() : BikeEnum.BIKE_CAN_BORROWED.getMsg();
            System.out.println(bike.getBikeId() + "\t\t" + bike.getBikeName() + "\t\t" + msg + "\t\t" + bike.getBorrowTime());
        }
    }


    @Override
    public void putBike(SharedBikeCompany bikeCompany, int number) {

        AbstractSharedBike[] bikes = bikeCompany.getSharedBikes();
        int companyId = bikeCompany.getCompanyId();

        int sum = bikeCompany.getSum();
        if (number > (bikes.length - sum)) {

            System.out.println("空间不足！空间不足，已经参照配置扩容");

            bikes = Arrays.copyOf(bikes, (sum + number) * 2);

        }

        for (int i = 0; i < number; i++) {

            switch (companyId) {
                case 1001:
                    bikes[sum++] = new OfoBike(SharedBikeMgr.ofoId, "ofo单车" + SharedBikeMgr.ofoId++, BikeEnum.BIKE_CAN_BORROWED.getCode(), "");
                    break;

                case 1002:
                    bikes[sum++] = new HaloBike(SharedBikeMgr.haloId, "halo单车" + SharedBikeMgr.haloId++, BikeEnum.BIKE_CAN_BORROWED.getCode(), "");
                    break;

                case 1003:
                    bikes[sum++] = new MoBike(SharedBikeMgr.moId, "mo单车" + SharedBikeMgr.moId++, BikeEnum.BIKE_CAN_BORROWED.getCode(), "");
                    break;
            }
        }

        bikeCompany.setSum(sum);
        bikeCompany.setSharedBikes(bikes);
        System.out.println("投放 " + number + " 辆" + bikeCompany.getCompanyName() + "单车成功！");
    }


    @Override
    public void deleteBikeById(SharedBikeCompany bikeCompany) {
        String companyName = bikeCompany.getCompanyName();
        int sum = bikeCompany.getSum();

        System.out.println(" << "+ companyName + " >> 品牌单车信息如下");
        getBikeInfo(bikeCompany, sum);

        System.out.print("请选择要删除的单车id: ");
        int bikeId = InputUtil.inputInt();

        AbstractSharedBike[] bikes = bikeCompany.getSharedBikes();
        for (int i = 0; i < sum; i++) {
            AbstractSharedBike bike = bikes[i];
            if(bike.getBikeId() == bikeId){
                if(bike.getStatus().equals(BikeEnum.BIKE_BORROWED.getCode())){
                    System.out.println("id为 " + bikeId + " 的单车已经被借出，删除失败！");
                    return ;
                }

                for (int j = i; j < sum - 1 ; j++) {
                    bikes[j] = bikes[j+1];
                }
                bikes[ sum-1 ] = null;
                sum --;

                bikeCompany.setSharedBikes(bikes);
                bikeCompany.setSum(sum);
                System.out.println("删除id为 " + bikeId + " 成功！");
                return;
            }
        }
            System.out.println("没有此id的单车");

    }


    @Override
    public void borrowBikeById(SharedBikeCompany bikeCompany) {

        String companyName = bikeCompany.getCompanyName();
        int sum = bikeCompany.getSum();

        System.out.println(" << " + companyName + " >> 品牌单车信息如下");
        getBikeInfo(bikeCompany, sum);

        System.out.print("请选择要借出的单车id: ");
        int bikeId = InputUtil.inputInt();

        AbstractSharedBike[] bikes = bikeCompany.getSharedBikes();
        for (int i = 0; i < sum; i++) {
            AbstractSharedBike bike = bikes[i];
            if (bike.getBikeId() == bikeId) {
                if (bike.getStatus().equals(BikeEnum.BIKE_BORROWED.getCode())) {
                    System.out.println("id为 " + bikeId + " 的单车已经被借出，借出失败！");
                    return;
                }

                System.out.print("请录入要借出的时间:(yyyy-MM-dd HH-mm-ss) ");
                String borrowTime = InputUtil.inputLineString("^(20\\d{2})-(0\\d|1[1-2])-([0-2]\\d|3[0-1]) ([0-1]\\d|2[0-4])-([0-5]\\d)-([0-5]\\d)$");
                bikes[i].setStatus(BikeEnum.BIKE_BORROWED.getCode());
                bikes[i].setBorrowTime(borrowTime);
                int count = bikeCompany.getCount() + 1;
                bikeCompany.setCount( count );
                System.out.println("借出id为 " + bikeId + " 成功！");
                return;
            }

        }
    }


    @Override
    public void returnBileById(SharedBikeCompany bikeCompany) {

        String companyName = bikeCompany.getCompanyName();
        int sum = bikeCompany.getSum();

        System.out.println(" << "+ companyName + " >> 品牌单车信息如下");
        getBikeInfo(bikeCompany, sum);

        System.out.print("请选择要归还的单车id: ");
        int bikeId = InputUtil.inputInt();

        AbstractSharedBike[] bikes = bikeCompany.getSharedBikes();
        for (int i = 0; i < sum; i++) {
            AbstractSharedBike bike = bikes[i];
            if(bike.getBikeId() == bikeId){
                if(bike.getStatus().equals(BikeEnum.BIKE_CAN_BORROWED.getCode())){
                    System.out.println("id为 " + bikeId + " 的单车未被借出，无法归还！");
                    return ;
                }

                System.out.print("请录入归还的时间:(yyyy-MM-dd HH-mm-ss) ");
                String backTime = InputUtil.inputLineString("^(20\\d{2})-(0\\d|1[1-2])-([0-2]\\d|3[0-1]) ([0-1]\\d|2[0-4])-([0-5]\\d)-([0-5]\\d)$");

                String borrowTime = bike.getBorrowTime();
                double money = DateUtil.getDuration(backTime,borrowTime) * bikeCompany.getMoney();
                System.out.println("您的借车时间： " + borrowTime );
                System.out.println("借出时长 << " + money +" >>,需要支付金额： " + money );
                System.out.println("归还id为 " + bikeId + " 成功！");

                bikes[i].setStatus(BikeEnum.BIKE_CAN_BORROWED.getCode());
                bikes[i].setBorrowTime("null");
                return;
            }
        }
        System.out.println("没有此id的单车");

    }


}