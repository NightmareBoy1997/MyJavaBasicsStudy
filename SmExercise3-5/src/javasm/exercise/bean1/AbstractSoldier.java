package javasm.exercise.bean1;

import javasm.exercise.bean.AbstractHero;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @projectName: MyJavaStudy
 * @package: javasm.exercise.bean
 * @author: Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-03-05 22:31
 */
// 小兵类
@Data
@NoArgsConstructor
public abstract class AbstractSoldier {

    private String name ;
    private Integer blood;
    private Integer attack;
    private Integer defense;

    public AbstractSoldier(String name, Integer blood, Integer attack, Integer defense) {
        this.name = name;
        this.blood = blood;
        this.attack = attack;
        this.defense = defense;
    }

    public void action(AbstractHero hero){
        heroExit(hero);

    }

    public void heroExit(AbstractHero hero){
        var attackHero =  getAttack() - (getAttack() / hero.getDefense()) * 100 ;
        int heroBlood =  hero.getBlood() - attackHero  ;

        if (heroBlood < 0) {
            System.out.println("你已被小兵击杀，太菜了吧！");
            System.out.println("********************************* < Game Over > *********************************");
            System.exit(1);
        }
    }

}