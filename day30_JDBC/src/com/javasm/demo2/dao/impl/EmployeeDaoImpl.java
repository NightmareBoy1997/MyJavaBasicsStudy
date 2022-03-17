package com.javasm.demo2.dao.impl;

import org.javasm.supermarket.bean.Employee;
import com.javasm.demo2.bean.KeyValues;
import com.javasm.demo2.dao.BaseDao;
import com.javasm.demo2.dao.EmployeeDao;
import com.javasm.server.EmployeeServer;
import com.javasm.server.impl.EmployeeServerImpl;
import com.javasm.util.Utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

/**
 * @projectName: MyJavaStudy
 * @package: com.javasm.demo2.dao.impl
 * @author: Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-03-14 14:30
 */
public class EmployeeDaoImpl extends BaseDao<Employee> implements EmployeeDao {

    Scanner scanner = new Scanner(System.in);
    static EmployeeServer employeeServer = new EmployeeServerImpl();

    /**
     *  添加员工对象
     * @return
     */
    public int addEmployee(String sql,Object... objects) {
        int number = 0;
        Connection connection = null;

        try {
            connection = Utils.getConnection();
            number = update(connection, sql, objects);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Utils.closeResource(connection,null,null) ;
        }

        return number;
    }

    /**
     * 分页查询
     *
     * @param page
     * @param size
     * @return
     */
    public List<Employee> findEmployeeByPage(String sql , int page, int size) {
//        String sql = "SELECT empno id , ename name , job ,mgr manager,hiredate hireDate ,sal salary , comm commission , deptno departmentId  FROM emp LIMIT ? ,?";
        int start = (page - 1) * size;
        List<Employee> list = getInstanceList(sql, start, size);
        list.forEach(System.out::println);
        return list;
    }

    /**
     * 获取总记录数
     *
     * @return
     */
    public Long getCount() {
        String sql = "SELECT COUNT(1) FROM emp";
        return getValue(sql);
    }


    /**
     * 分页查询--查看指定页数
     */
    public void getLimitPage(final int size) {
        String sql = "SELECT empno id , ename name , job ,mgr manager,hiredate hireDate ,sal salary , comm commission , deptno departmentId  FROM emp LIMIT ? ,?";

        long count = getCount();
        // 总页数
        int number = (int) (count / size);
        number = (count % size == 0) ? number : number + 1;

        System.out.println("目前数据一共有 << " + number + " >> 页");
        for (long i = 1; i <= number; i++) {
            System.out.print(i + "\t");
        }

        String str;
        do {
            System.out.print("请输入要查看的页数:  ");
            int rage = scanner.nextInt();
            findEmployeeByPage(sql ,  rage, size);
            System.out.print("是否继续查询?y/n:  ");
            str = scanner.next();
        } while (Objects.equals("y", str));
    }


    /**
     * 分页查询--上下导览页
     *
     * @param size
     */
    public void getLimit(final int size) {
        String sql = "SELECT empno id , ename name , job ,mgr manager,hiredate hireDate ,sal salary , comm commission , deptno departmentId  FROM emp LIMIT ? ,?";

        long count = getCount();
        // 总页数
        int number = (int) (count / size);
        number = (count % size == 0) ? number : number + 1;

        System.out.println("目前数据一共有 << " + number + " >> 页\n");
        int page = 1;
        Connection connection = Utils.getConnection();
        System.out.println("第 << 1 >> 页数据如下");
        findEmployeeByPage(sql ,1, size);

        System.out.println();
        String str;
        do {
            if (page != 1) {
                System.out.println("1.首页");
                System.out.println("2.上一页");
            }
            if (page != number) {
                System.out.println("3.下一页");
                System.out.println("4.尾页");
            }
            System.out.print("请输入要进行的操作:  ");
            int index = scanner.nextInt();
            switch (index) {
                case 1:
                    page = 1;
                    break;
                case 2:
                    page -= 1;
                    break;
                case 3:
                    page += 1;
                    break;
                case 4:
                    page = number;
                    break;
            }
            System.out.println("当前第 << " + page + " >> 页的数据如下\n");
            findEmployeeByPage(sql, page, size);
            System.out.print("\n是否继续查询?y/n:  ");
            str = scanner.next();
        } while (!Objects.equals("n", str));
    }


    /**
     * 条件查询
     */
    public List<Employee> findByParams(List<KeyValues> list , int page , int size) {
        final Connection connection = Utils.getConnection();
        StringBuilder stringBuilder = new StringBuilder("SELECT empno id , ename name , job ,mgr manager,hiredate hireDate ,sal salary , comm commission , deptno departmentId  FROM emp");
        List<Object> valueList = new ArrayList<>(10);

        if (!list.isEmpty()) {
            stringBuilder.append(" WHERE ");
            // SELECT * FROM emp WHERE job LIKE ? OR gender LIKE ?
            // 给 preparedStatement 连接占位符
            for (KeyValues keyValues : list) {
                stringBuilder.append(keyValues.getKey()).append(" LIKE ? OR ");
                valueList.add(keyValues.getValue());
            }
        }
        // 截取掉末尾 or
        String substring = stringBuilder.substring(0, stringBuilder.lastIndexOf("O"));
        // 拼接分页
        final String sql = substring.concat(" LIMIT ?,?");
        int start = (page - 1) * size;

        try {
            final PreparedStatement preparedStatement = Utils.getPreparedStatement(connection, sql);
            for (int i = 0; i < valueList.size(); i++) {
                // SELECT * FROM emp WHERE job LIKE '%员%' OR gender LIKE '%女%'
                // 给 preparedStatement 占位符赋值
                preparedStatement.setObject(i + 1, "%" + valueList.get(i) + "%");
            }
            preparedStatement.setObject(valueList.size()+1,start);
            preparedStatement.setObject(valueList.size()+2,size);

            final List<Employee> instance = getInstance(preparedStatement);

            return instance;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

}