package javasm.bike.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @projectName: MyJavaStudy
 * @package: javasm.bike.dao
 * @author: Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-02-26 20:41
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SharedBikeCompany {
    private Integer companyId;// 公司id
    private String companyName;// ofo 哈罗 摩拜
    private AbstractSharedBike[] sharedBikes;// 公司持有共享单车
    private Integer sum;//公司单车总量
    private Integer count;// 公司单车借出次数
    private Double money;

}