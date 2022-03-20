package org.javasm.supermarket.server.impl;

import org.javasm.supermarket.bean.Member;
import org.javasm.supermarket.dao.MemberDao;
import org.javasm.supermarket.dao.impl.MemberDaoImpl;
import org.javasm.supermarket.server.MemberService;
import org.javasm.supermarket.util.CacheUtil;

import java.sql.SQLException;
import java.util.List;

/**
 * @projectName: MyJavaStudy
 * @package: org.javasm.supermarket.server.impl
 * @author: Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-03-19 20:30
 */
public class MemberServiceImpl implements MemberService {
    static final private MemberDao memberDao = new MemberDaoImpl();
    static  private List<Member> allMember = CacheUtil.getAllCacheList(Member.class);

    @Override
    public void addAndDeleteMember(Member member) {
        try {
            memberDao.addAndDelete(member);

            // 更新缓存
            allMember = memberDao.findAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }





    @Override
    public List<Member> findAllMember() {
        return allMember;
    }

    @Override
    public List<Member> selectMemberByPage(int page, int size) {
        try {
            return memberDao.selectMemberByPage((page - 1)*size , size);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }


    @Override
    public void updateMember(Member member) {
        try {
            memberDao.update(member);

            // 更新缓存
            allMember = memberDao.findAll();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


}