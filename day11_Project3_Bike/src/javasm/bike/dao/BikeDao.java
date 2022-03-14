package javasm.bike.dao;

import javasm.bike.bean.SharedBikeCompany;

/**
 * @projectName: MyJavaStudy
 * @package: javasm.bike.dao
 * @author: Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-02-26 20:39
 */
public interface BikeDao {

    void findAllBikeInfo( SharedBikeCompany[] companyArray );
    void putBike(SharedBikeCompany bikeCompany , int number);

    void deleteBikeById(SharedBikeCompany bikeCompany);

    void borrowBikeById(SharedBikeCompany bikeCompany);

    void returnBileById(SharedBikeCompany bikeCompany);
}
