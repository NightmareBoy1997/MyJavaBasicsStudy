package com.javasm.demo3.dao;

import com.javasm.demo3.bean.Teacher;

import java.sql.Connection;
import java.util.Set;

/**
 * @projectName: MyJavaStudy
 * @package: com.javasm.demo3.dao
 * @author: Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-03-15 17:59
 */
public interface TeacherDao {

    int addTeacher(Connection connection , Teacher teacher);

    Teacher getTeacherById(String sql , int id);

    int addTeacherAndStudent(Connection connection, int tid, Set<Integer> idSet);

}