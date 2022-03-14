package javasm.javasm.util;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author: Lisa
 * @className: UserInfo
 * @description:
 * @date: 2022/2/28 11:41
 * @version: 0.1
 * @since: jdk11
 */
@Data
public class UserInfo {

    private Integer id;
    private String name;
    private String pass;
    private LocalDate birthday;
    private LocalDateTime hireDate;

    private LocalDateTime createTime;

    //local相关的对象转字符串 就调用这个类里面的format
    @Override
    public String toString() {
        return "UserInfo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pass='" + pass + '\'' +
                ", birthday=" + birthday +
                ", createTime=" + createTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) +
                '}';
    }

    //从前到后:  客户端的数据转换后端的对象----> String转Date/localDate  parse
    //从后往前: 给用户看的时候  ----->Date/localDate转String   format
}
