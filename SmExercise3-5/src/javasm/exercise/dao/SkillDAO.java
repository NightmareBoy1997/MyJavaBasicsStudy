package javasm.exercise.dao;

/**
 * @projectName: MyJavaStudy
 * @package: javasm.exercise.dao
 * @author: Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-03-06 10:49
 */
public interface SkillDAO {// 英雄攻击技能

    Double attacking(Integer attack , Integer defense);
    Double skillQ(Integer attack , Integer court , Integer defense , Integer  magicResistance);
    Double skillW(Integer attack , Integer court , Integer defense , Integer  magicResistance);
    Double skillE(Integer attack , Integer court , Integer defense , Integer  magicResistance);
    Double skillR(Integer attack , Integer court , Integer defense , Integer  magicResistance);

}