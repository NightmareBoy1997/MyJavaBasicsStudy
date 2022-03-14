package javasm.bike.bean;

import lombok.Getter;
import lombok.Setter;

/**
 * @projectName: MyJavaStudy
 * @package: javasm.bike.bean
 * @author: Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-02-26 21:10
 */
@Getter
@Setter
public class OfoBike extends AbstractSharedBike {

    public OfoBike(Integer bikeId, String bikeName, Integer status, String borrowTime) {
        super(bikeId, bikeName, status, borrowTime);
    }
}