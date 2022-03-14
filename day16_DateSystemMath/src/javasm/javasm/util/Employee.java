package javasm.javasm.util;

import lombok.Data;

import java.util.Date;

/**
 * @author: Lisa
 * @className: Employee
 * @description:
 * @date: 2022/2/28 10:35
 * @version: 0.1
 * @since: jdk11
 */

@Data
public class Employee {

    private Integer id;
    private String name;
    private String phone;
    private Date birthday;
    private Date hireDate;
    private Date createTime;
    private Date updateTime;

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", birthday=" + DateUtil.dateConvertToStr(birthday) +
                ", hireDate=" + DateUtil.dateConvertToStr(hireDate) +
                ", createTime=" + DateUtil.dateConvertToStr(createTime) +
                ", updateTime=" + DateUtil.dateConvertToStr(updateTime) +
                '}';
    }
}
