package exercise.classlast.dao;

import java.util.List;

/**
 * @projectName: MyJavaStudy
 * @package: exercise.classlast.dao
 * @author: Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-03-15 14:52
 */
public interface BookStoreServer {

    /**
     *  添加记录的方法
     */
    void add();


    <T> List<T> queryAll();



}