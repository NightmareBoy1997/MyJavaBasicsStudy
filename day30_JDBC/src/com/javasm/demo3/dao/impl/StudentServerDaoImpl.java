package com.javasm.demo3.dao.impl;

import com.javasm.demo3.bean.Student;
import com.javasm.demo3.dao.StudentDao;
import com.javasm.demo3.dao.StudentServerDao;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

/**
 * @projectName: MyJavaStudy
 * @package: com.javasm.demo3.dao.impl
 * @author: Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-03-15 17:15
 */
public class StudentServerDaoImpl implements StudentServerDao {
    StudentDao studentDao = new StudentDaoImpl();

    @Override
    public void add() {
        Scanner scanner = new Scanner(System.in);
//        SimpleDateFormat simpleDateFormat = new  SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

        System.out.print("请输入添加的学生姓名： ");
        String name = scanner.next();
        System.out.print("请输入添加的学生年龄： ");
        int age = scanner.nextInt();
        System.out.print("请输入添加的学生分数： ");
        Double score = scanner.nextDouble();
//        System.out.print("请输入创建时间： ");
//        String createTimeStr = scanner.next();
//        Date createTime = simpleDateFormat.parse(createTimeStr);
//
//        System.out.print("请输入修改时间： ");
//        String updateTimeStr = scanner.next();
//        Date updateTime = simpleDateFormat.parse(updateTimeStr);

        System.out.print("请输入金额： ");
        String moneyStr = scanner.next();
        BigDecimal money = new BigDecimal(moneyStr);

        String sql = "INSERT INTO tb_student(stu_name,stu_age,stu_score,money)VALUES(?,?,?,?) ";

        studentDao.addStudent(sql , name,age,score,money);
    }


    @Override
    public void update() {

    }

    @Override
    public List<Student> getStudentListPage(int page , int size) {
        return studentDao.findStudentByPage(page,size);
    }

    @Override
    public Integer getValue(String sql) {
        return studentDao.getValue(sql);
    }


    @Override
    public Student getInstanceById() {
        return null;
    }
}