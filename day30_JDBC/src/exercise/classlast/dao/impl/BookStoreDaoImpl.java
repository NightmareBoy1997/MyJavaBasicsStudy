package exercise.classlast.dao.impl;

import exercise.classlast.bean.Book;
import exercise.classlast.dao.BookStoreDao;
import exercise.classlast.util.DruidUtils;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @projectName: MyJavaStudy
 * @package: calssLastExercise.dao
 * @author: Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-03-15 11:02
 */
public class BookStoreDaoImpl implements BookStoreDao {
    QueryRunner queryRunner = new QueryRunner();

    /**
     *  通用的增删改基本操作
     * @param connection
     * @param sql
     * @param objects
     */
    public void updateBookStore(Connection connection, String sql, Object... objects) {
            update(connection,sql,objects);
    }

    @Override
    public Connection queryById(String sql, Object... objects) {
        return null;
    }

    @Override
    public <T> List<T> queryList(String sql, Object... objects) {
        return null;
    }




    @Override
    public <T> List<T> queryAll(Class<T> clazz, String sql) {
        QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());
        Connection connection = null;
        try {
            connection = DruidUtils.getConnectionDruid();
            return queryRunner.query(connection,sql,new BeanListHandler<>(clazz)) ;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally{
            DbUtils.closeQuietly(connection);
        }
        return null;
    }

    @Override
    public Integer getValue(String sql) {
        return null;
    }

    @Override
    public <T> T getInstanceFo(Class<T> clazz, String sql) {
        Connection connection = null ;

        try {
            connection = DruidUtils.getConnectionDruid();

            return (T) queryRunner.query(connection,sql,new BeanHandler<>(Book .class));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            DbUtils.closeQuietly(connection);
        }


        return null;
    }

    @Override
    public void update(Connection connection, String sql, Object... objects) {
        try {
            queryRunner.update(connection,sql,objects);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

/*
    @Override
    public <T> List<T> queryAll(Class<T> clazz,String sql) {
        return queryAllInstanceList(clazz,sql);
    }

    @Override
    public Integer getValue(String sql) {
        return getMethodValue(sql);
    }

    @Override
    public <T> T getInstanceFo(Class<T> clazz, String sql) {
        return (T) queryInstance(clazz,sql);
    }

    @Override
    public void update(Connection connection ,String sql, Object... objects) {
        updateTable(connection , sql ,objects);
    }
*/





}