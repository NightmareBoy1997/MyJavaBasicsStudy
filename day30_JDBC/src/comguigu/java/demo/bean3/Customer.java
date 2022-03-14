package comguigu.java.demo.bean3;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

/**
 * @projectName: JDBC
 * @package: comguigu.bean3
 * @author: Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-03-08 8:20
 *
 *  ORM编程思想 （Object relational mapping）
 *  一个数据表对应一个java类
 *  表的一条记录对应java类的一个对象
 *  表中的字段对应java类的属性
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    private int id ;
    private String name ;
    private String email;
    private Date birth;
}