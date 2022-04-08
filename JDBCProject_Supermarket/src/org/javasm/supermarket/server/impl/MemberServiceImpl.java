package org.javasm.supermarket.server.impl;

import org.javasm.supermarket.bean.Member;
import org.javasm.supermarket.dao.MemberDao;
import org.javasm.supermarket.dao.impl.MemberDaoImpl;
import org.javasm.supermarket.server.MemberService;
import org.javasm.supermarket.util.CacheUtil;
import org.javasm.supermarket.util.MD5Util;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

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
    static private List<Member> allMember = CacheUtil.getAllCacheList(Member.class);

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
            return memberDao.selectMemberByPage((page - 1) * size, size);
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

    @Override
    public Member findMemberByNameAndPassword(String user, String password) {
        final List<Member> memberUser = allMember.stream().filter(m -> m.getName().equals(user)).collect(Collectors.toList());
        if (memberUser.isEmpty()) {
            System.out.println("不存在此会员账户信息");
            return null;
        }
        Member member = memberUser.get(0);
        if (!member.getPassword().equals(MD5Util.getMD5Password(password))) {
            System.out.println("密码错误！");
            return null;
        }
        return member;
    }


}