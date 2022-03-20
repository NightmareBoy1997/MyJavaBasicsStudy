package org.javasm.supermarket.server;

import org.javasm.supermarket.bean.Member;

import java.util.List;

/**
 * @projectName: MyJavaStudy
 * @package: org.javasm.supermarket.dao
 * @author: Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-03-19 20:30
 */
public interface MemberService {

    void addAndDeleteMember(Member member);


    List<Member> findAllMember();

    List<Member> selectMemberByPage(int page, int size);

    void updateMember(Member member);

}
