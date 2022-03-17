package com.javasm;

import exercise.classlast.util.DruidUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @projectName: MyJavaStudy
 * @package: com.javasm
 * @author: Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-03-16 22:22
 */
public class DbUtilsTest {
    QueryRunner queryRunner = new QueryRunner();





    /*
     获取自增的id  不能使用update方法了 ---> QueryRunner.insert()

    JDBC: SELECT last_insert_id()
        1. Statement.RETURN_GENERATED_KEYS  等价于执行完update语句， 自动执行 SELECT last_insert_id()
        2.1 resultSet = preparedStatement.getGeneratedKeys()  获取自增id的值
        2.2 resultSet.getInt(1);
     */
    public BigInteger getAutoKey(){
        final Connection connection = DruidUtils.getConnectionDruid();
        String sql = "INSERT INTO test(`name`,password)Values(?,?)";
        try {
            BigInteger maxId = queryRunner.insert(connection,sql,new ScalarHandler<BigInteger>(),"ikunkun1","ikunkun1");
            return maxId ;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }


    @Test
    public void test1(){
        System.out.println(getAutoKey());
    }






}