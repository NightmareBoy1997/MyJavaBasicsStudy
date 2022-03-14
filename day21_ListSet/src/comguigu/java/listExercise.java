package comguigu.java;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 *  面试题：区分List中的remove(int index)和remove(Object obj)
 *
 * @author Freak-W
 * @create 2021-04-23 10:39
 */
public class listExercise {

    @Test
    public void testListRemove() {
        List list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        updateList(list);
        System.out.println(list);//
    }
    private void updateList(List list) {
//        list.remove(2);
        list.remove(new Integer(2));
    }

}
