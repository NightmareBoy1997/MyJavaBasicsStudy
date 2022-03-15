package exercise.classlast.dao;

import java.sql.Connection;
import java.util.List;

/**
 * @projectName: MyJavaStudy
 * @package: calssLastExercise.dao
 * @author: Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-03-15 11:04
 */
public interface BookStoreDao {

    void updateBookStore(Connection connection , String sql , Object...objects) ;

    Connection queryById( String sql ,Object...objects);
    <T> List<T> queryList( String sql , Object...objects);
    <T> List<T> queryAll( Class<T> clazz, String sql ) ;

    Integer getValue(String sql);

    <T> T getInstanceFo(Class<T> clazz,String sql);

    void update(Connection connection ,String sql, Object... objects);

}
