package com.javasm.demo2.bean;

import lombok.*;

/**
 * @projectName: MyJavaStudy
 * @package: javasm.demo2.bean
 * @author: Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-03-14 11:28
 */
@AllArgsConstructor
@Data
@NoArgsConstructor
public class KeyValues {
    // 筛选查询的值
    private String key;
    private String value;
}