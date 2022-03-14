import lombok.*;

/**
 * @projectName: MyJavaStudy
 * @package: PACKAGE_NAME
 * @author: Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-02-16 22:34
 * <p>
 * 注解插件 lombok 的使用
 */
@Setter  //对本类里面非静态的属性生成set/get方法
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder // 建造者模式： 快速构建对象  前提: 有有参构造。构造器多个形参可不分顺序赋值
public class LombokTest {
    //领域模型----> do vo
    //实体类
    //私有的属性  set/get  构造
    private int id;
    private int age;
    @NonNull
    private String bookName;
    private double bookPrice;

    public static void main(String[] args) {


        // 构造器多个形参可不分顺序赋值
//    LombokTestBuilder test1 = LombokTest.builder().age(22).bookName("dsklfj").id(1001).bookPrice(89.99);
        LombokTest test1 = LombokTest.builder().age(22).bookName("dsklfj").id(1001).bookPrice(89.99).build();

        System.out.println(test1.toString());


    }




}

