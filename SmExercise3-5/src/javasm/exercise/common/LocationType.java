package javasm.exercise.common;
import lombok.Getter;


/**
 * @projectName: MyJavaStudy
 * @package: javasm.exercise.common
 * @author: Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-03-06 11:01
 */
@Getter
public enum LocationType implements HeroPath { //英雄定位

    // 法师英雄
    MASTER_HERO("法师"){
        public void  goPath(){
            System.out.println("我要去中路Carry！");
        }
    },
    // 战士英雄
    WARRIOR_HERO("战士"){
        public void  goPath(){
            System.out.println("我要去上路坐牢！");
        }
    },
    // 刺客英雄
    ASSASSIN_HERO("刺客"){
        public void  goPath(){
            System.out.println("我要去野区揍野猪！");
        }
    },
    // 射手英雄
    SHOOTER_HERO("射手"){
        public void goPath(){
            System.out.println("我要去下路发育！");
        }
    },
    // 辅助英雄
    SUPPORT_HERO("辅助"){
        public void goPath() {
            System.out.println("我要去辅助射手！");
        }
    };

    private final String typeName;

    private LocationType(String typeName){
        this.typeName = typeName;
    }

}