package com.javasm.demo3.dao.impl;

import com.javasm.demo3.bean.Teacher;
import com.javasm.demo3.dao.TeacherDao;
import com.javasm.demo3.dao.TeacherServerDao;
import com.javasm.demo3.util.UtilRelevance;
import com.javasm.util.Utils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Set;

/**
 * @projectName: MyJavaStudy
 * @package: com.javasm.demo3.dao.impl
 * @author: Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-03-15 18:04
 */
public class TeacherServerDaoImpl implements TeacherServerDao {

    TeacherDao teacherDao = new TeacherDaoImpl();

    public int addTeacher(Connection connection ,Teacher teacher){
        return teacherDao.addTeacher(connection , teacher);
    }

    // 事务
    @Override
    public void addTeacher(Teacher teacher, Set<Integer> idSet) {
        Connection connection = null ;
        try {
            connection = Utils.getConnection();
            connection.setAutoCommit(false);
            final int tid = teacherDao.addTeacher(connection,teacher);

            System.out.println(10/0);

            teacherDao.addTeacherAndStudent( connection , tid , idSet);
            connection.commit();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            try {
                connection.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } finally {
            UtilRelevance.closeResource(connection , null ,null);
        }

    }

    @Override
    public Teacher getTeacherById() {
        return null;
    }
}