package com.javasm.demo3.test;

import com.javasm.demo3.bean.Student;
import com.javasm.demo3.bean.Teacher;
import com.javasm.demo3.dao.StudentServerDao;
import com.javasm.demo3.dao.TeacherServerDao;
import com.javasm.demo3.dao.impl.StudentServerDaoImpl;
import com.javasm.demo3.dao.impl.TeacherServerDaoImpl;

import java.util.*;

/**
 * @projectName: MyJavaStudy
 * @package: com.javasm.demo3.test
 * @author: Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-03-15 17:57
 */
public class StudentServerImplTest {
    static StudentServerDao testStudent = new StudentServerDaoImpl();
    static TeacherServerDao testTeacher = new TeacherServerDaoImpl();

    public static void main(String[] args) {
//
//        testStudent.add();
//        testTeacher.addTeacher();
//        final List<Student> students = testStudent.getStudentListPage(2, 2);
//        students.forEach(System.out::println);

        testAddTeacher();

    }


    public static void testAddTeacher(){

        Scanner scanner = new Scanner(System.in);
        // 新增老师
        System.out.print("请输入添加的老师姓名： ");
        String name = scanner.next();

        // 查询学生信息---> 分页查询
        int size = 2 ;
        int page = 1;
        String isGo ;
        Set<Integer> idSet = new HashSet<>(16);
        String sql = "SELECT COUNT(1) FROM tb_student";
       final int value = testStudent.getValue(sql);
        int number = value/size;
        number = ( value % size == 0)? number : number + 1;
        System.out.println("\n共有 "+ number + " 页数据\n");

        do {

            System.out.println("第 << " + page + " >> 页的数据如下： ");
            List<Student> students = testStudent.getStudentListPage(page, size);
            students.forEach(System.out::println);

            String str;
            do {
                System.out.print("请选择老师具体的学生：(一次选择一个)  ");
                idSet.add( scanner.nextInt() ) ;
                System.out.print("是否继续关联学生？y/n  ");
                str = scanner.next();
            } while (!Objects.equals("n",str));

            System.out.print("是否继续分页查询？y/n  ");
            isGo = scanner.next();

            if(Objects.equals("n",isGo)){
                break;
            }
            System.out.print("请录入指定的页数:  ");
            page = scanner.nextInt();

        } while (true);

        Teacher teacher = new Teacher();
        teacher.setTeacherName(name);
        testTeacher.addTeacher(teacher,idSet);
    }


}