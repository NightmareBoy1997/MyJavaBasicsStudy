package org.javasm.supermarket.sql;

/**
 * @projectName: MyJavaStudy
 * @package: org.javasm.supermarket.sql
 * @author: Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-03-19 21:05
 */
public interface MemberSql {
    String DELETE_MEMBER_BY_ID = "DELETE FROM member WHERE id = ?";
    String INSERT_MEMBER = "INSERT INTO member (user_name,password) VALUES(?,?) ";
    String SELECT_ALL_MEMBER = "SELECT id memberId, name , password , user_image userImage , " +
            "phone , balance , point , create_time createTime , update_time updateTime FROM member";
    String SELECT_MEMBER_BY_PAGE = "SELECT id memberId,  name , password , user_image  userImage , " +
            "phone , balance , point , create_time createTime , update_time updateTime FROM member LIMIT  ? ,  ?";
    String UPDATE_MEMBER_BY_ID = " UPDATE member SET password=? , user_image = ? , phone=? , balance = ? WHERE id = ?  ";



}