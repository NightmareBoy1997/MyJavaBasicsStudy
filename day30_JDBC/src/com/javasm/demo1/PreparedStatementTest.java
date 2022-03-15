package com.javasm.demo1;

import org.junit.jupiter.api.Test;
import com.javasm.util.Utils;

/**
 * @projectName: JDBC
 * @package: study.demo1
 * @author: Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-03-11 14:44
 */
public class PreparedStatementTest {

    @Test
    public void addTest(){

        String sql = "insert into tb_userinfo(name,gender,phone)VALUES(?,?,?)";
        Utils.update(sql , "王康","男","13021348575");


    }

}