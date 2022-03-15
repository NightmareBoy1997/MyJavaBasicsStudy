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
 * @create: 2022-03-15 17:15
 */
public interface StudentServerDao {

    void add();

    void update();

    List<Student> getStudentListPage(int page , int size);

    Integer getValue(String sql);

    Student getInstanceById();

}