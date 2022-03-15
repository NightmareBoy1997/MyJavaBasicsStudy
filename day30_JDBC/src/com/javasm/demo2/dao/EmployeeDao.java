package com.javasm.demo2.dao;

import com.javasm.bean.Employee;
import com.javasm.demo2.bean.KeyValues;

import java.util.List;

/**
 * @projectName: MyJavaStudy
 * @package: javasm.demo2.dao
 * @author: Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-03-14 11:37
 */
public interface EmployeeDao {

    // 1. 添加用户
    int addEmployee(String sql,Object... objects);

    // 1. 分页查询
    List<Employee> findEmployeeByPage(String sql , int page , int size);

    // 2. 条件查询
    List<Employee>  findByParams(List<KeyValues> list,int page , int size);

}