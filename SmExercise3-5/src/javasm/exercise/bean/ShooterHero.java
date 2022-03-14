package javasm.exercise.bean;

import javasm.exercise.common.LocationType;
import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * @projectName: MyJavaStudy
 * @package: javasm.exercise.bean
 * @author: Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-03-06 16:24
 *
 *  射手类
 */
@Data
public class ShooterHero extends AbstractHero {

    //英雄定位
    private final LocationType type ;

    public ShooterHero( String alias, String name, Integer price, Integer blood, Integer attack, Integer defense, Integer magicResistance, List<String> skills, Map<String, Integer> skins, List<String> lines) {
        super(alias, name, price, blood, attack, defense, magicResistance, skills, skins, lines);
        type = LocationType.SHOOTER_HERO;
    }

    public ShooterHero() {
        type = LocationType.SHOOTER_HERO;
    }


}