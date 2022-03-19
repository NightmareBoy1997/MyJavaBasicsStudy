package org.javasm.supermarket.sql;

/**
 * @projectName: MyJavaStudy
 * @package: org.javasm.supermarket.sql
 * @author: Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-03-17 15:45
 */
public interface TypeSql {

    String SELECT_ALL_TYPE = "SELECT id,prent_id prentId , type_name typeName ,prent, type_status typeStatus, " +
            "create_time createTime , update_time updateTime  FROM type";


    String SELECT_TYPE_BY_ID ="SELECT id,prent_id prentId , type_name typeName ,prent, type_status typeStatus, " +
            "create_time createTime , update_time updateTime  FROM type WHERE id = ?" ;

    String UPDATE_TYPE_BY_ID = "UPDATE type SET prent_id =? , type_name = ? , prent = ?, type_status = ? , " +
            "update_time = NOW()  WHERE id = ? " ;

    String INSERT_TYPE = "INSERT INTO type ( prent_id, type_name, prent, type_status , " +
            "create_time , update_time )VALUES( ?,?,0,1,NOW(),NOW() )" ;

    String DELETE_TYPE_BY_ID = "DELETE FROM type  WHERE id = ?";
}
