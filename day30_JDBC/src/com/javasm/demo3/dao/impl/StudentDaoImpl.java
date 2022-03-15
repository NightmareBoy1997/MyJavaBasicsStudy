package com.javasm.demo3.dao.impl;

import com.javasm.demo3.bean.Student;
import com.javasm.demo3.dao.BaseDao;
import com.javasm.demo3.dao.StudentDao;
import com.javasm.util.Utils;

import java.sql.Connection;
import java.util.List;

/**
 * @projectName: MyJavaStudy
 * @package: com.javasm.demo3.dao.impl
 * @author: Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-03-15 17:10
 */
public class StudentDaoImpl extends BaseDao implements StudentDao {

    @Override
    public void addStudent(String sql , Object...objects) {
        final Connection connection = Utils.getConnection();
        update(connection,sql,objects);
    }

    @Override
    public List<Student> findStudentByPage(int page, int size) {
        int number = (page - 1) * size;
        String sql = "SELECT id , stu_name name FROM  tb_student LIMIT " + number + " , " + size;
        List<Student> list = queryAllInstanceList(Student.class, sql);

        return list;
    }

    @Override
    public Integer getValue(String sql) {
        return (Integer) getTableValue(sql);
    }


    @Override
    public void updateStudent(Student student) {

    }

    @Override
    public Student getStudentById(String sql, int id) {
        return null;
    }


}