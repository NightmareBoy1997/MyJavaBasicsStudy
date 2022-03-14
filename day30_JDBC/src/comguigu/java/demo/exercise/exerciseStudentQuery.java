package comguigu.java.demo.exercise;

import lombok.Data;

/**
 * @projectName: JDBC
 * @package: comguigu.exercise.demo
 * @author: Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-03-09 10:00
 */
public class exerciseStudentQuery {


}


@Data
class Student{
    private int flowID;
    private int type;
    private String IDCard;
    private String examCard;
    private String name;
    private String location;
    private int grade;
}