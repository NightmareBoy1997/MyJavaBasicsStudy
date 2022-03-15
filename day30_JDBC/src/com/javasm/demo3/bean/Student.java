package com.javasm.demo3.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @projectName: MyJavaStudy
 * @package: com.javasm.demo3.bean
 * @author: Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-03-15 17:08
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    private Integer id;
    private String name;
    private Integer stuAge;
    private double stuScore;
    private java.util.Date createTime;
    private java.util.Date updateTime;
    private BigDecimal money;

}