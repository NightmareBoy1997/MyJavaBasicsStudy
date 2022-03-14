package comguigu.java;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 *
 *   |----Properties：常用来处理配置文件。key-value都是String类型的
 *
 * @author shkstart
 * @create 2021-05-10 15:58
 */
public class PropertiesTest {

    // Properties：常用来处理配置文件。key-value都是String类型的

    public static void main(String[] args) {

        FileInputStream fis= null;
        try {
            Properties pro1=new Properties();

//        pro1.put("LOL","2021.5.1");
//        pro1.put("","");
//        pro1.put("","");

            fis = new FileInputStream("jdbc.properties");
            pro1.load(fis);  //加载流对应的文件

            String name=pro1.getProperty("name");
            String password=pro1.getProperty("password");

            System.out.println(name+" --> "+password);
        } catch (IOException e) {
            e.printStackTrace();
        } finally{

            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }


}
