package javasm.smexercise;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @projectName: MyJavaStudy
 * @package: javasm.smexercise
 * @author: Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-02-18 13:21
 */
public class DiXiaChengPetTest {

//	4.需求：为地下城勇士游戏编写怪物模块的功能
//	现怪物的种类有两种：哥布林、猫妖
//	怪物的共有的属性有：名称、血量、攻击力、防御力
//	哥布林特有的属性有：狂暴度，
//	哥布林具有的方法有：攻击（使用石头进行攻击）和 移动(缓慢移动)
//	猫妖具有的方法有：攻击（使用爪子攻击）和 移动（跳着移动)
//	现需要在测试类中进行测试两只哥布林和两只猫妖的攻击和移动方法，要求将创建的怪物对象存放在数组对象中进行统一管理，循环调用每只怪物的攻击和移动的方法。
//	要求使用多态的思想实现怪物的攻击和移动。

    public static void main(String[] args) {

        Pet []pets = new Pet[3];

        pets[0] = new GeBuLin("哥布林酋长",1099,45.5,23.0,0);
        pets[1] = new GeBuLin("冰霜哥布林",799,68.9,12.0,0);
        pets[2] = new DemonCat("暗夜猫妖",2099,77.7,23.0);
        double blood;
        for (int i = 0; i < pets.length; i++) {
            System.out.println("开始对战 " + pets[i].getName());
            int number = 0;
            while(pets[i].getBlood().intValue() > 0){

                pets[i].action();
                number++;
            }
            System.out.println("\n\n共攻击了 " + number + " 轮，终于打死了 " + pets[i].getName() + "\n\n");
        }

    }

}



@Data
@AllArgsConstructor
@NoArgsConstructor
class Pet{
    private String name ;
    private BigDecimal blood;
    private double attack;
    private BigDecimal defense;
    private final BigDecimal myAttack = new BigDecimal(59.99);
    BigDecimal number;

    public void action(){

        number = getMyAttack().subtract( getDefense() ).setScale(2 , BigDecimal.ROUND_HALF_DOWN);
        System.out.println(name + "移动，跑过来对你进行攻击，造成了 " + attack + " 点攻击力的伤害;\n你进行反击，但是"
                + name + "有 " + defense + " 的防御力，你只造成了 " + number.toString() + "点伤害 , " + name + "剩余血量： " + blood);
    }

}

@AllArgsConstructor
class GeBuLin extends Pet{
    private int rage;

public GeBuLin(String name , double blood, double attack , double defense,int rage){
    setName(name);
    setAttack(attack);
    setBlood(new BigDecimal(blood) );
    setDefense(new BigDecimal(defense) );
    this.rage = rage;
}

    public void action(){

    var attackNumber = getMyAttack().subtract( getDefense() ).setScale(2 , BigDecimal.ROUND_HALF_DOWN);
    setNumber( attackNumber ) ;

        rage++;

        var zero = new BigDecimal(0);
        if( getBlood().subtract(number).compareTo( zero ) != -1 ){
            setBlood( getBlood().subtract(number) );
        }else{
            setBlood( zero );
        }

        System.out.println(getName() + " 老爷步，慢悠悠的跑过来对你进行攻击，造成了 " + getAttack() + " 点攻击力的伤害,狂暴值增加1,当前狂暴值： " + rage + " ;\n你进行反击，但是"
                + getName() + "有 " + getDefense() + " 的防御力，你只造成了 " + number + "点伤害 , " + getName() + "剩余血量： " + getBlood());
        setAttack( getAttack() + 30*rage);
        setDefense( new BigDecimal(getDefense().doubleValue() - 8*rage ));
    }

}


@AllArgsConstructor
class DemonCat extends Pet{

    public DemonCat(String name , double blood, double attack , double defense){
        setName(name);
        setAttack(attack);
        setBlood( new BigDecimal(blood) );
        setDefense(new BigDecimal(defense) );
    }

    public void action(){

        var attackNumber = getMyAttack().subtract( getDefense() ).setScale(2 , BigDecimal.ROUND_HALF_DOWN);
        setNumber( attackNumber ) ;

        var zero = new BigDecimal(0);
        if( getBlood().subtract(number).compareTo( zero ) != -1 ){
            setBlood( getBlood().subtract(number) );
        }else{
            setBlood( zero );
        }


        System.out.println(getName() + " 悠闲的边跑边跳，跑过来对你进行攻击，造成了 " + getAttack() + " 点攻击力的伤害 ;\n你进行反击，但是"
                + getName() + "有 " + getDefense() + " 的防御力，你只造成了 " + number + "点伤害 , " + getName() + "剩余血量： " + getBlood());

    }


}