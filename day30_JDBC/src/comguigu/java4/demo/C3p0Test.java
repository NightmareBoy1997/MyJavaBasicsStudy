package comguigu.java4.demo;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import comguigu.java4.bean.User;
import comguigu.java4.util.JDBCUtils;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.sql.*;

/**
 * @projectName: MyJavaStudy
 * @package: comguigu.pool
 * @author: Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-03-12 17:08
 */
public class C3p0Test {




    /*
    使用连接池查询单条记录对象的操作
     */
    @Test
    public void test(){

        Connection connection = null;
        try {
            connection = JDBCUtils.getConnectionC3p0();
            String sql = "SELECT id,name,password,address locationCity,phone FROM user WHERE id = ?";

            final User instance = getInstance(connection, User.class, sql, 1);
            System.out.println(instance);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally{
            JDBCUtils.closeResource(connection,null,null);
        }
    }


    /**
     * 通用的查询单条记录对象的操作
     *
     * @param connection
     * @param T
     * @param sql
     * @param objects
     * @param <T>
     * @return
     */
    public <T> T getInstance(Connection connection, Class<T> T, String sql, Object... objects) {

        final int length = objects.length;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            // 1. 执行预编译指令
            preparedStatement = connection.prepareStatement(sql);

            // 2. 给占位符赋值
            for (int i = 0; i < length; i++) {
                preparedStatement.setObject(i + 1, objects[i]);
            }

            // 3. 执行查询获取结果集
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                // 4. 新建对应的类对象
                T t = T.newInstance();
                final ResultSetMetaData metaData = preparedStatement.getMetaData();
                final int columnCount = metaData.getColumnCount();
                for (int i = 0; i < columnCount; i++) {
                    final Object columnValue = resultSet.getObject(i + 1);
                    final String columnLabel = metaData.getColumnLabel(i + 1);
                    final Field field = T.getDeclaredField(columnLabel);
                    field.setAccessible(true);
                    field.set(t, columnValue);
                }
                return t;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        JDBCUtils.closeResource(null, preparedStatement, resultSet);
        return null;
    }




    public Connection getConnection() throws Exception {
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource("goc3p0");
        Connection connection = comboPooledDataSource.getConnection();

        // 销毁数据库连接池
//        DataSources.destroy(cpds);
        return connection;
    }


}