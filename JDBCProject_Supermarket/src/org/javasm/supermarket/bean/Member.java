package org.javasm.supermarket.bean;

import lombok.Data;
import org.javasm.supermarket.util.MD5Util;

import java.math.BigDecimal;

@Data
public class Member {

    private Integer id;
    private String name;
    private String password;
    private String userImage;
    private String phone;
    private BigDecimal balance;
    private double point;
    private java.util.Date createTime;
    private java.util.Date updateTime;

    public void setPassword(String newPassword) {
        this.password = MD5Util.getMD5Password(newPassword);
    }

}
