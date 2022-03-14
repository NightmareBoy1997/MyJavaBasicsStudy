package comguigu.java4.bean;

import lombok.Data;

/**
 * @projectName: MyJavaStudy
 * @package: comguigu.pool.bean
 * @author: Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-03-12 20:41
 */
@Data
public class User {
    private int id ;
    private String name ;
    private String password;
    private String locationCity;
    private String phone;
}