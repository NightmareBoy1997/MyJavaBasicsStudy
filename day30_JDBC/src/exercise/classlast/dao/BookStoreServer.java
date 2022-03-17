package exercise.classlast.dao;

import java.sql.Connection;
import java.util.List;

/**
 * @projectName: MyJavaStudy
 * @package: exercise.classlast.dao
 * @author: Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-03-15 14:52
 */
public interface BookStoreServer {

    /**
     *  添加记录的方法
     */
    void add();

    void update(Connection connection , String sql, Object... objects);

    <T> List<T> queryAll();

    <T> T getInstanceFo(String sql);

    Integer getValue(String sql);


}