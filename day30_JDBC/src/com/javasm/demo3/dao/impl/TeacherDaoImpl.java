package com.javasm.demo3.dao.impl;

import com.javasm.demo3.bean.Teacher;
import com.javasm.demo3.dao.BaseDao;
import com.javasm.demo3.dao.TeacherDao;
import com.javasm.demo3.util.UtilRelevance;

import java.sql.*;
import java.util.Set;

/**
 * @projectName: MyJavaStudy
 * @package: com.javasm.demo3.dao.impl
 * @author: Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-03-15 18:10
 */
public class TeacherDaoImpl extends BaseDao implements TeacherDao {


    @Override
    public int addTeacher(Connection connection ,Teacher teacher) {
        String sql = "INSERT INTO tb_teacher (teacher_name) VALUES(?)";
        int autoId = 0;
        //在mysql里面 维护id自增?  SELECT LAST_INSERT_ID()  DQL----> 结果 rs
        //1.告诉mysql的服务  把id返回过来----> 将sql语句发送数据库的时候 就要告诉mysql服务器   Statement.RETURN_GENERATED_KEYS
        //2. 等价于mysql的服务在update之后  自动执行SELECT LAST_INSERT_ID()这条sql

        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setObject(1, teacher.getTeacherName());
            preparedStatement.executeUpdate();

            //3.在update之后  获得自增的id的数据  由于是一条select语句 结果还是在rs里面
            resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                autoId = resultSet.getInt(1);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            UtilRelevance.closeResource(null, preparedStatement, resultSet);
        }
        return autoId;
    }

    @Override
    public Teacher getTeacherById(String sql, int id) {
        return null;
    }

    @Override
    public int addTeacherAndStudent(Connection connection, int tid, Set<Integer> idSet) {
        // 动态拼接
        StringBuilder builder = new StringBuilder("INSERT INTO tb_teacher_student (tid,sid)VALUES");
        int size = idSet.size();
        for (int i = 1; i <= idSet.size(); i++) {
            builder.append("(?,?)");
            if (i == size) {
                break;
            }
            builder.append(",");
        }
        String sql = builder.toString();
        int result = 0;
        //insert into tb_teacher_student (tid,sid) values (?,?),(?,?),(?,?)

        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement(sql);
            //占位符赋值 奇数占位符是tid
            int count = 1;
            for (Integer integer : idSet) {
                preparedStatement.setObject(count++, tid);
                preparedStatement.setObject(count++, integer);
            }
            return preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            UtilRelevance.closeResource(null, preparedStatement, null);
        }

        return 0;
    }


}