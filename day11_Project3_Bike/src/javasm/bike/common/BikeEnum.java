package javasm.bike.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @projectName: MyJavaStudy
 * @package: javasm.bike.common
 * @author: Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-02-26 21:40
 */
@Getter
@AllArgsConstructor
public enum BikeEnum {
    BIKE_BORROWED(1,"车车已被借"),
    BIKE_CAN_BORROWED(2,"车车可借");

    private final int code;
    private final String msg;

}