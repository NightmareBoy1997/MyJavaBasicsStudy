package javasm.smexercise;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

/**
 * @projectName: MyJavaStudy
 * @package: javasm.smexercise
 * @author: Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-02-18 13:21
 */
public class AnimalTest {

    //	3.动物、 蛇、 鱼 、三个类，编写一个方法可以接收任意的动物对象，
    // 定义一个方法可以接收任意的动物类型对象，并且要调用动物类型对象的特有方法。

    public static void main(String[] args) {

        Animal animal = new Animal("动物", 4 , "肉");
        Animal fish = new Fish("小黄鱼" , 0, "虾米");
        Animal snake = new Snake("眼镜蛇" , 0 , "老鼠");
        animal.eat();
        animal.go();

        fish.eat();
        fish.go();

        snake.eat();
        snake.go();
    }
}


@Data
@AllArgsConstructor
@NoArgsConstructor
class Animal{

    private String name;
    private int leg;
    private String food;

    public void eat(){
        System.out.println(name + "需要吃东西，吃的是：" + food);
    }

    public void go(){
        System.out.println(name + "会行走");
    }
}



@NoArgsConstructor
class Fish extends Animal {

    public Fish(String name , int leg , String food){
        setName(name);
        setFood(food);
        setLeg(leg);
    }

    public void eat(){
        System.out.println(getName() + "需要吃东西，吃的是：" + getFood() + "，鱼只有七秒记忆");
    }

    public void go(){
        System.out.println(this.getName() + "会行走，他有 " + getLeg() + " 条腿"+ "但是它游泳很快");
    }

}



@NonNull
class Snake extends Animal {

    public Snake(String name , int leg , String food){
        setName(name);
        setFood(food);
        setLeg(leg);
    }

    public void eat(){
        System.out.println(getName() + "需要吃东西，吃的是：" + getFood() + "，蛇很狡猾");
    }

    public void go(){
        System.out.println(this.getName() + "会行走，他有 " + getLeg() + " 条腿"+ ",但是它跑起来很快");
    }

}