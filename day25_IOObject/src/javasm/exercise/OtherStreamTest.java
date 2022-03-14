package javasm.exercise;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.*;

/**
 * @projectName: MyJavaStudy
 * @package: comguigu.exercise1
 * @author: Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-02-28 15:47
 */
public class OtherStreamTest {

    public static void main(String[] args) {

        objectInputStream();
        objectOutputStream();



    }

    // 序列化的过程
    private static void objectOutputStream() {

        Person p1 = new Person("tom",1021);
        Person p2 = new Person("jack",1012);

        try( ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("day_IOInputStreamOutputStream\\src\\object.txt")) ) {

            oos.writeObject( p1 );
            oos.flush();
            oos.writeObject( p2 );
            oos.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    // 反序列化的过程
    private static void objectInputStream() {

        try( ObjectInputStream ois = new ObjectInputStream(new FileInputStream("day_IOInputStreamOutputStream\\src\\object.txt")) ) {

            Person p1 = (Person) ois.readObject();
            Person p2 = (Person) ois.readObject();
            System.out.println(p1);
            System.out.println(p2);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }


    }


}


@Data
@NoArgsConstructor
@AllArgsConstructor
class Person implements Serializable {

    private String name;
    private Integer id;

    private static final long serialVersionUID = 684979447467710L;

}

