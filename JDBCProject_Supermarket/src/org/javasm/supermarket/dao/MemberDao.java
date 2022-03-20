package org.javasm.supermarket.dao;

import org.javasm.supermarket.bean.Member;

import java.sql.SQLException;
import java.util.List;

/**
 * @projectName: MyJavaStudy
 * @package: org.javasm.supermarket.dao
 * @author: Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-03-19 20:52
 */
public interface MemberDao {

    void addAndDelete(Member member) throws SQLException;


    List<Member> findAll() throws SQLException;

    List<Member> selectMemberByPage(int page, int size) throws SQLException;

    void update(Member member) throws SQLException;

}
