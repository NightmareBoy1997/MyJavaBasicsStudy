package exercise.classlast.dao.impl;

import exercise.classlast.dao.BaseDao;
import exercise.classlast.dao.BookStoreDao;

import java.sql.Connection;
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
public class BookStoreDaoImpl extends BaseDao implements BookStoreDao {


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


    /**
     *
     */
    public void queryById(){

    }

    public void queryList(){

    }


}