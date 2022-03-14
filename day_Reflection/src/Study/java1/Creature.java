package Study.java1;

import java.io.Serializable;

/**
 * @author Freak-W
 * @create 2021-10-20 16:17
 */
public class Creature<T> implements Serializable {

    private char gender;
    public double weight;

    private void breath(){
        System.out.println("生物呼吸！");
    }

    public void eat(){
        System.out.println("生物吃东西！");
    }


}
