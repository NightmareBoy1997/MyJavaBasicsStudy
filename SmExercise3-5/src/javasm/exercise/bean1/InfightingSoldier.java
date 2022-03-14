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
 * @create: 2022-03-06 22:09
 */
@Data
@NoArgsConstructor
public class InfightingSoldier extends AbstractSoldier  { // 近战兵


    public InfightingSoldier(String name, Integer blood, Integer attack, Integer defense) {
        super(name, blood, attack, defense);
    }

    public void action(AbstractHero hero){

        String[] strings = {" 慢悠悠的跑过来拿小菜刀" , "",""};
        Utils.heroAttack(hero,this,strings);

    }
}