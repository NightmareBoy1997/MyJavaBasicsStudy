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
 * @create: 2022-03-06 16:03
 *
 *  法师类
 */
@Data
public class MasterHero extends AbstractHero {

    //英雄定位
    private final LocationType type ;

    // 法术强度
    private Integer spellPower ;

    public MasterHero(String alias, String name, Integer price, Integer blood, Integer attack, Integer defense, Integer magicResistance,
                      List<String> skills, Map<String, Integer> skins, List<String> lines, Integer spellPower) {
        super(alias, name, price, blood, attack, defense, magicResistance, skills, skins, lines);
        this.spellPower = spellPower;
        type = LocationType.MASTER_HERO;
    }

    public MasterHero() {
        type = LocationType.MASTER_HERO;
    }
}