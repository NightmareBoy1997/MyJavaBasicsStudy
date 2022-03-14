package javasm.bike.bean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @projectName: MyJavaStudy
 * @package: javasm.bike.bean
 * @author: Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-02-26 19:57
 */
@Getter
@Setter
@AllArgsConstructor
public abstract class AbstractSharedBike {

    private Integer bikeId;// 单车编号
    private String bikeName;// 单车名称-->ofo 哈罗 摩拜
    private Integer status;// 单车状态--> 0 已借出 1 可借状态
    private String borrowTime;// 单车借出时间

}