package comguigu.java4.demo;

import comguigu.java4.bean.User;
import comguigu.java4.util.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * @projectName: MyJavaStudy
 * @package: comguigu.java4.demo
 * @author: Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-03-12 22:15
 * <p>
 * commons-dbutils 是 Apache 组织提供的一个开源 JDBC工具类库，封装了针对于数据库的增删改查操作。
 */
public class ApacheDBUtilsTest {

    QueryRunner queryRunner = new QueryRunner();

    @Test
    public void test() {
        try {


//            testInsert();
//            testQuery1();
//            testQueryList();
//            testQueryMap();
            testQueryMapList();

        } catch (Exception throwables) {
            throwables.printStackTrace();
        }
    }


    /**
     *  测试插入操作
     */
    public void testInsert() {
        String sql = "INSERT INTO user (name , password,address,phone)VALUES(?,?,?,?)";
        Connection connection = null;

        try {
            connection = JDBCUtils.getConnectionC3p0();
            final int update = queryRunner.update(connection,sql, "蔡徐坤", "jinitaimei", "guangxi", "214234142");
            System.out.println(update);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.closeResource(connection,null,null);
        }

    }


    /**
     *  测试查询 : BeanHandler : 是 ResultSetHandler 接口的实现类，用于封装表中的一条记录
     */
    public void testQuery1(){
        String sql = "SELECT * FROM user WHERE id = ?";
        Connection connection = null;
        BeanHandler<User> handler = new BeanHandler(User.class);

        try {
            connection = JDBCUtils.getConnectionC3p0();
            final User user = queryRunner.query(connection, sql, handler, 14);
            System.out.println(user);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.closeResource(connection,null , null );
        }
    }

    /**
     *  测试查询集合 ： BeanListHandler: 是ResultSetHandler的实现类，用于封装表中多条记录构成的集合
     */
    public void testQueryList(){
        String sql = "SELECT * FROM user WHERE id < ?";
        Connection connection = null;
        BeanListHandler<User> handler = new BeanListHandler(User.class);

        try {
            connection = JDBCUtils.getConnectionC3p0();

            final List<User> userList = queryRunner.query(connection, sql, handler, 15);
            userList.stream().forEach(System.out::println);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.closeResource(connection,null , null );
        }


    }



    /**
     *  测试查询 : MapHandler : 是 ResultSetHandler 接口的实现类，对应表中的一条记录的各个属性，
     *  将字段和对应的值作为Map的key和value
     */
    public void testQueryMap(){
        String sql = "SELECT * FROM user WHERE id = ?";
        Connection connection = null;
        MapHandler handler = new MapHandler();
        try {
            connection = JDBCUtils.getConnectionC3p0();
            final Map<String, Object> map = queryRunner.query(connection, sql, handler, 14);
            System.out.println(map);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.closeResource(connection,null , null );
        }
    }

    /**
     *  测试查询集合 ： MapListHandler: 是ResultSetHandler的实现类，用于封装表中多条记录的属性值Map构成的集合
     *  将字段和对应的值作为Map的key和value
     */
    public void testQueryMapList(){
        String sql = "SELECT * FROM user WHERE id < ?";
        Connection connection = null;
        MapListHandler handler = new MapListHandler( );

        try {
            connection = JDBCUtils.getConnectionC3p0();

            final List<Map<String, Object>> maps = queryRunner.query(connection, sql, handler, 15);
            maps.stream().forEach(System.out::println);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.closeResource(connection,null , null );
        }


    }


    /**
     *  scalarHandler : 用于查询特殊值
     */
    public void testScalar(){

    }


}