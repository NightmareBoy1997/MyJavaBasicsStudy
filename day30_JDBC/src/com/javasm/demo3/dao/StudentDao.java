package com.javasm.demo3.dao;

import com.javasm.demo3.bean.Student;

import java.util.List;

/**
 * @projectName: MyJavaStudy
 * @package: com.javasm.demo3.dao
 * @author: Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-03-15 17:04
 */
public interface StudentDao {

    void addStudent(String sql, Object...objects);

    void updateStudent(Student student);

    Student getStudentById(String sql , int id);

    List<Student> findStudentByPage(int page, final int size);

    Integer getValue(String sql);

}