package com.javasm.demo3.dao;

import com.javasm.demo3.bean.Teacher;

import java.util.Set;

/**
 * @projectName: MyJavaStudy
 * @package: com.javasm.demo3.dao
 * @author: Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-03-15 18:01
 */
public interface TeacherServerDao {

    void addTeacher(Teacher teacher, Set<Integer> idSet);

    Teacher getTeacherById();

}