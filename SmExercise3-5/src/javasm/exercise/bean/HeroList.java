package javasm.exercise.bean;

import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;

/**
 * @projectName: MyJavaStudy
 * @package: javasm.exercise.bean
 * @author: Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-03-06 16:00
 */
@Getter
@ToString
public class HeroList {

    private final Integer heroTypeId ; // 英雄定位id
    private final String locationName ; // 英雄定位名称
    private ArrayList<AbstractHero> heroes; // 英雄定位的所有英雄
    private Integer sum = 0 ; //英雄总量

    public HeroList(Integer heroTypeId, String locationName, ArrayList<AbstractHero> heroes) {
        this.heroTypeId = heroTypeId;
        this.locationName = locationName;
        this.heroes = heroes;
    }

    /**
     * @param alias
     * @param name
     * @param price
     * @param blood
     * @param attack
     * @param defense
     * @param magicResistance
     */
    public void add(String alias, String name, Integer price, Integer blood, Integer attack, Integer defense, Integer magicResistance) {

        heroes.add(new AbstractHero(alias,name,price,blood,attack,defense,magicResistance,null,null,null) );
        sum++;
    }

    public void delHero(int id) {

        int index = 0 ;
        boolean isIn = true;
        for (int i = 0; i < heroes.size(); i++) {
            if(heroes.get(i).getId() == id){
                index = i ;
                isIn = false;
                break;
            }
        }
        if(isIn){
            System.out.println("没有此英雄!");
            return;
        }
        heroes.remove(index);
        System.out.println("修改完成！");
    }
}