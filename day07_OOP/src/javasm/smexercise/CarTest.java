package javasm.smexercise;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @projectName: MyJavaStudy
 * @package: javasm.smexercise
 * @author: Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-02-18 13:20
 */
public class CarTest {

    //	2.描述车、宝马、奔驰 三个类，车都具备颜色、名字、轮胎数量，还具备跑的功能
//	司机类，具有一个开车方法，可以开不同的车

    public static void main(String[] args) {

        Driver driver1 = new Driver("张三" , 28 , new BC("奔驰", "黑色" , 4));
        Driver driver2 = new Driver("赵四", 33, new BMW("宝马","橙色",4));
        var driver3 = new Driver("马六",55 , new Car("五菱宏光","银色",4));

        driver1.drive();
        driver2.drive();
        driver3.drive();

    }


}

@AllArgsConstructor
class Driver{
    private String name ;
    private int age ;
    private Car car;

    public void drive(){
        System.out.println(name + " , " + age + " 岁，开着一辆" + car.getColour() + "的" + car.getName() + "车\n" + car.go());
    }

}


@Data
@AllArgsConstructor
@NoArgsConstructor
class Car{

    private String name ;
    private String colour;
    private int wheel;

    public String go(){
        return getName() + " 可以跑得很远";
    }
}

@Data
class BMW extends Car{

    public BMW(String name , String colour,int wheel){
        setName(name);
        setColour(colour);
        setWheel(wheel);
    }

    public String go(){
        return getName() +" 很拉风，设计很美观，跑得也很快！";
    }

}


@Data
class BC extends Car{

    public BC(String name , String colour , int wheel){
        setName(name);
        setColour(colour);
        setWheel(wheel);
    }

    public String go(){
        return getName() + " 太老气，秃头大叔标配";
    }
}
