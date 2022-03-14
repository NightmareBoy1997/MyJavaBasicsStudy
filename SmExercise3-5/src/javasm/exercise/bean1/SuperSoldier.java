package javasm.exercise.bean1;

import javasm.exercise.bean.AbstractHero;
import javasm.exercise.util.Utils;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @projectName: MyJavaStudy
 * @package: javasm.exercise.bean1
 * @author: Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-03-06 22:10
 */
@Data
@NoArgsConstructor
public class SuperSoldier extends AbstractSoldier {

    // 狂暴值
    private int rage;

    public SuperSoldier(String name, Integer blood, Integer attack, Integer defense) {
        super(name, blood, attack, defense);
        this.rage = rage;
        this.rage = 0;
    }

    public void action(AbstractHero hero){

        int addAttack = rage * 30;
        rage ++;

        String string =  ", 狂暴值增加1, 当前狂暴值：" + rage + " ,攻击力增加：" + addAttack;
        String[] strings = {" 气势汹汹的挥舞大锤" ,string ," 皮糙肉厚——有 "};
        Utils.heroAttack(hero,this,strings);

    }

}