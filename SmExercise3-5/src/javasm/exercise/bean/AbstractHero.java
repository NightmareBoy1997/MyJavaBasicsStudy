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
 * @create: 2022-03-05 22:40
 */
@Data
public class AbstractHero { // 英雄类


    private static int number = 0 ;
    //英雄Id
    private Integer id = 1000 ;
    //英雄称号
    private String alias ;
    //英雄名称
    private String name ;
    //英雄价格
    private Integer price ;
    //英雄血量
    private Integer blood ;
    //英雄攻击力
    private Integer attack ;
    //英雄物理防御
    private Integer defense ;
    //英雄魔法抗性
    private Integer magicResistance ;
    //英雄技能
    private List<String> skills;
    //英雄皮肤
    private Map<String,Integer> skins ;
    //英雄台词
    private List<String> lines ;
    private LocationType type ;


    public AbstractHero(String alias, String name, Integer price, Integer blood, Integer attack, Integer defense, Integer magicResistance,
                        List<String> skills, Map<String, Integer> skins, List<String> lines) {
        this.id = id + number ;
        this.alias = alias;
        this.name = name;
        this.price = price;
        this.blood = blood;
        this.attack = attack;
        this.defense = defense;
        this.magicResistance = magicResistance;
        this.skills = skills;
        this.skins = skins;
        this.lines = lines;
        number ++;
    }

    public AbstractHero(){
        this.id = id + number ;
        number ++;
    }

    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }

    public LocationType getType() {
        return type;
    }

}




