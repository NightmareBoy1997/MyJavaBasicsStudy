package comguigu.java;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NonNull;

import java.util.Scanner;

/**
 * @projectName: MyJavaStudy
 * @package: javasm.exercise
 * @author: Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-02-17 20:03
 * <p>
 * 模拟实现用户购买商品的功能，使用数组模拟商品列表，当购买的商品不存在或者商品库存为0时，抛出自定义异常。
 * 用户购买某一个商品时，对异常进行处理，并对库存进行改变。
 */
public class BuyFoods {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Food[] foods = new Food[5];

        foods[0] = new Food("可乐", 10);
        foods[1] = new Food("奥利奥", 6);
        foods[2] = new Food("炫迈", 3);
        foods[3] = new Food("卫龙", 5);
        foods[4] = new Food("红牛", 3);

        System.out.println("欢迎光临 《国足超市》\n现有商品:");
        System.out.print("\t\t");
        for (Food food : foods) {
            System.out.print(food.getName() + " : " + food.getNumbers() + "  ");
        }

        System.out.print("\n请输入要购买的商品： ");
        String name = input.next();
        System.out.print("请输入要购买的数量： ");
        int number = input.nextInt();

        for (int i = number; i > 0; i--) {
            buyFood(foods, name);
        }
    }


    public static void buyFood(Food[] foods, String name) {

        for (Food food : foods) {
            String foodName = food.getName();
            if (foodName.equals(name)) {
                int foodNumber = food.getNumbers();
                if (foodNumber > 0) {
                    food.setNumbers(foodNumber - 1);
                    System.out.println("购买" + food.getName() + "成功！ 剩余库存： " + food.getNumbers());
                    return;
                } else {

                    try {
                        throw new MyException1(StatueEnum.MY_STATUE_ENUM_NO_FOOD);
                    } catch (MyException1 m) {
//                        m.printStackTrace();
                        StatueEnum statueEnum = m.getStatueEnum();
                        System.out.println(statueEnum.getMessage());

                        System.out.print(statueEnum.getCode());
                        System.out.println(statueEnum.getMessage());
                        System.out.println("别着急！ 正在补货^-^......\n \t\t叮！补货成功！补货5件\n");


                        food.setNumbers(5);
                        buyFood(foods, name);
//                        System.out.println("购买成功！");
//                        food.setNumbers( food.getNumbers()-1 );
                        return;

                    }
                }
            }
        }
        throw new MyException1(StatueEnum.MY_STATUE_ENUM_NULL_FOOD);
    }
}


@Getter
class MyException1 extends RuntimeException {

    static final long serialVersionUID = -7034896939L;
    private StatueEnum statueEnum;

//    public MyException(){
//    }

    public MyException1(StatueEnum statueEnum) {
        super(statueEnum.getMessage());
        this.statueEnum = statueEnum;
    }

    public MyException1(StatueEnum statueEnum, Throwable cause) {
        super(statueEnum.getMessage(), cause);
        this.statueEnum = statueEnum;
    }


}

@Getter
@AllArgsConstructor
enum StatueEnum {

    MY_STATUE_ENUM_MATH(1001, "\t输入数字别乱输，OK？"),
    MY_STATUE_ENUM_ZERO(1002, "\t除数不能为 0 ，上过小学吗你！"),
    MY_STATUE_ENUM_NO_FOOD(1003, "\t咦！库存不足了"),
    MY_STATUE_ENUM_NULL_FOOD(1004, "\t没有这个商品哦！");

    private final int code;
    private final String message;

}


@Data
class Food {
    @NonNull
    private String name;
    private int numbers;

    public Food(String name, int numbers) {
        this.name = name;
        this.numbers = numbers;
    }
}


