package org.javasm.supermarket.dao.impl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.javasm.supermarket.bean.Member;
import org.javasm.supermarket.dao.MemberDao;
import org.javasm.supermarket.sql.MemberSql;
import org.javasm.supermarket.util.DruidUtil;

import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

/**
 * @projectName: MyJavaStudy
 * @package: org.javasm.supermarket.dao.impl
 * @author: Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-03-19 20:53
 */
public class MemberDaoImpl implements MemberDao {
    QueryRunner queryRunner = new QueryRunner(DruidUtil.getDataSource());

    @Override
    public void addAndDelete(Member member) throws SQLException {
        if (Objects.nonNull(member.getId())) {
            queryRunner.update(MemberSql.DELETE_MEMBER_BY_ID, member.getId());
            return;
        }
        queryRunner.update(MemberSql.INSERT_MEMBER, member.getName(), member.getPassword());
    }


    @Override
    public List<Member> findAll() throws SQLException {
        return queryRunner.query(MemberSql.SELECT_ALL_MEMBER, new BeanListHandler<>(Member.class));
    }

    @Override
    public List<Member> selectMemberByPage(int page, int size) throws SQLException {
       return  queryRunner.query(MemberSql.SELECT_MEMBER_BY_PAGE, new BeanListHandler<>(Member.class), page, size);
    }

    @Override
    public void update(Member member) throws SQLException {
        queryRunner.update(MemberSql.UPDATE_MEMBER_BY_ID, member.getPassword(), member.getUserImage(), member.getPhone(), member.getBalance(),member.getId());
    }


}