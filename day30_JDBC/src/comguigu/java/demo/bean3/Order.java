package comguigu.java.demo.bean3;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @projectName: JDBC
 * @package: comguigu.bean3
 * @author: Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-03-08 10:05
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    private int orderId;
    private String orderName;
    private Date orderDate;

}
