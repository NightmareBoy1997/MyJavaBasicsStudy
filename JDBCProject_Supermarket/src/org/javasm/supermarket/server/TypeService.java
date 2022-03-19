package org.javasm.supermarket.server;

import org.javasm.supermarket.bean.Type;

/**
 * @projectName: MyJavaStudy
 * @package: org.javasm.supermarket.server.impl
 * @author: Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-03-17 15:07
 */
public interface TypeService {

    /**
     * 显式所有类型的信息
     */
    void findAllType();

    boolean addType(Type type);

    boolean updateType(Type type);

    boolean deleteType(int typeId);
}