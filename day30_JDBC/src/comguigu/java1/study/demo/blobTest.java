package comguigu.java1.study.demo;

import comguigu.java.demo.java3.util.JDBCUtils;
import lombok.Data;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.sql.*;

/**
 * @projectName: JDBC
 * @package: comguigu.study.demo
 * @author: Nightmare970701
 * @description: 测试使用preparedStatement操作blob数据
 * @since:
 * @version: JDK11
 * @create: 2022-03-09 10:07
 */
public class blobTest {


    /**
     * 向customers插入一条blob类型的字段
     */
    @Test
    public void insertInto() {

        String sql = "insert into customers(name ,email , birth,photo)values(?,?,?,?)";

        try (Connection connection = JDBCUtils.getConnection();
             FileInputStream fileInputStream = new FileInputStream("src/gongqijun.jpg");
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ) {

            preparedStatement.setObject(1, "宫崎骏");
            preparedStatement.setObject(2, "GongQiJun@163.com");
            java.util.Date date1 = new java.util.Date();
            Date date = new Date(date1.getTime());
            preparedStatement.setObject(3, date);

            preparedStatement.setBlob(4, fileInputStream);

            preparedStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    /**
     *
     */
    @Test
    public void testQuery(){
        String sql = "select id,name,email,birth,photo from customers where id=?";

        ResultSet resultSet = null;

        try(Connection connection = JDBCUtils.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            FileOutputStream fileOutputStream = new FileOutputStream("src/baozouluoli1.jpg");
                ){
            preparedStatement.setObject(1,24);

            resultSet = preparedStatement.executeQuery();

            if(resultSet.next()){
                final ResultSetMetaData metaData = resultSet.getMetaData();
                final int columnCount = metaData.getColumnCount();

                Customer customer = new Customer();

                for (int i = 0; i < columnCount - 1; i++) {
                    final Object columnValue = resultSet.getObject(i + 1);
                    final String columnLabel = metaData.getColumnLabel(i + 1);
                    final Field field = Customer.class.getDeclaredField(columnLabel);
                    field.setAccessible(true);
                    field.set(customer,columnValue);
                }
                System.out.println(customer);
                Blob blob = resultSet.getBlob(5);
                final InputStream binaryStream = blob.getBinaryStream();
                binaryStream.transferTo(fileOutputStream);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            if(resultSet!=null){
                try {
                    resultSet.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }

    }




    /**
     *
     */
    @Test
    public void update(){

        String sql = "update potho from customers where id=?";

        try(Connection connection = JDBCUtils.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            FileInputStream fileInputStream = new FileInputStream("src/ig4k.jpg");
                ){
            preparedStatement.setObject(1,22);
            preparedStatement.setBlob(1,fileInputStream);

            preparedStatement.execute();

        }catch(Exception e){
            e.printStackTrace();
        }



    }




    @Test
    public void test2(){
        try {
            JDBCUtils.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}


@Data
class Customer{
    private int id ;
    private String name;
    private String email;
    private Date birth;
}


