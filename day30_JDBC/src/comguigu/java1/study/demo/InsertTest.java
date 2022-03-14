package comguigu.java1.study.demo;

/**
 * @projectName: JDBC
 * @package: comguigu.study.demo
 * @author: Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-03-09 20:09
 */

import comguigu.java.demo.java3.util.JDBCUtils;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *  使用preparedStatement实现批量数据的操作
 *  // 向goods表中添加20000条数据
 *  CREATE TABLE goods(
 *      id int PRIMARY KEY AUTO_INCREMENT,
 *      name VARCHAR(20)
 *  );
 *
 *  update、delete本身就具有批量操作的效果
 *  insert不具备批量操作，此时的批量操作指的是批量插入，使用preparedStatement如何实现高效的批量插入？
 *
 *  方式一： Statement操作
 *  获取连接： Connection connection = JDBCUtils.getConnection();
 *  Statement statement = connection.createStatement();
 *  执行 sql语句 ： for(int i = 0 ; i<20000; i++){
 *       String sql = "insert into foods (name)values("'name_" + i + "') ";
 *       statement.execute();
 *   }
 *
 *
 *
 */
public class InsertTest {


    /**
     *  批量插入 方式二： 使用preparedStatement
     */
    @Test
    public void testInsert(){

        String sql = "insert into foods(name)values(?)";
        try(Connection connection = JDBCUtils.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

                ) {
            for (int i = 1; i <= 20000; i++) {
                preparedStatement.setObject(1,"'name_" + i);
                preparedStatement.execute();
            }

    } catch (Exception e) {
        e.printStackTrace();
    }

    }



    /**
     *  批量插入 方式三： 优化使用preparedStatement
     *  1. addBatch()\executeBatch()\clearBatch()
     *  2. mysql服务器默认是关闭批处理的，我们需要通过一个参数，让mysql开启批处理的支持。
     *  * 		 ?rewriteBatchedStatements=true 写在配置文件的url后面
     */
    @Test
    public void testInsertUp(){

        String sql = "insert into foods(name)values(?)";
        try(  Connection connection = JDBCUtils.getConnection();
              PreparedStatement preparedStatement = connection.prepareStatement(sql);

        ) {
            for (int i = 1; i <= 20000; i++) {
                preparedStatement.setObject(1,"name_" + i);

                // 1. “攒”sql
                preparedStatement.addBatch();

                if(i%500==0){
                    // 2. 执行Batch
                    preparedStatement.executeBatch();

                    // 3. 清空Batch
                    preparedStatement.clearBatch();
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }





    /**
     *  批量插入 方式四： 设置不允许自动提交数据
     *  1.
     */
    @Test
    public void testInsertUp4(){

        String sql = "insert into foods(name)values(?)";
        try(  Connection connection = JDBCUtils.getConnection();
              PreparedStatement preparedStatement = connection.prepareStatement(sql);

        ) {
            // 设置不允许自动提交数据
            connection.setAutoCommit(false);

            for (int i = 1; i <= 20000; i++) {
                preparedStatement.setObject(1,"name_" + i);

                // 1. “攒”sql
                preparedStatement.addBatch();

                if(i%500==0){
                    // 2. 执行Batch
                    preparedStatement.executeBatch();

                    // 3. 清空Batch
                    preparedStatement.clearBatch();
                }

                // 提交数据
                connection.commit();

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }



}