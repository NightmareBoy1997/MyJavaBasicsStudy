package com.javasm.server.impl;

import com.javasm.demo2.dao.EmployeeDao;
import com.javasm.demo2.dao.impl.EmployeeDaoImpl;
import com.javasm.server.EmployeeServer;

/**
 * @projectName: MyJavaStudy
 * @package: com.javasm.server.impl
 * @author: Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-03-15 13:13
 */
public class EmployeeServerImpl implements EmployeeServer {
    private static EmployeeDao employeeDao = new EmployeeDaoImpl() ;

    /**
     *  实现添加记录的操作
     * @param sql
     * @param objects
     * @return
     */
    public int addEmployee(String sql,Object... objects) {



        final int number = employeeDao.addEmployee(sql, objects);
        return number;
    }



}