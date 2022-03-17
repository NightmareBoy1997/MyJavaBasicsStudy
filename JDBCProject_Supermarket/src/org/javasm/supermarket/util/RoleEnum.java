package org.javasm.supermarket.util;

import lombok.Getter;

/**
 * @projectName: MyJavaStudy
 * @package: org.javasm.supermarket
 * @author: Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-03-17 10:40
 */
@Getter
public enum  RoleEnum {

    ADMIN("admin","12345") ,
    CASHIER("cashier","12345");

    private String name ;
    private String password ;

    RoleEnum(String name ,String password){
        this.name = name;
        this.password = password;
    }

}