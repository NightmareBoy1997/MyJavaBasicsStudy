package Study.java4;

import org.junit.jupiter.api.Test;

import java.util.Optional;

/**
 * Optional 类： 为了在程序中避免出现空指针异常而创建的
 *
 * 常用方法： ofNullable( T t )
 *           ofElse( T t )
 *
 * @author Freak-W
 * @create 2021-11-04 23:42
 */
public class OptionalTest {

    /*   创建Optional类对象的方法：
        Optional.of(T t) : 创建一个 Optional 实例，t必须非空；
        Optional.empty() : 创建一个空的 Optional 实例
        Optional.ofNullable(T t)：t可以为null
    */
    @Test
    public void test1() {

        Boy boy = new Boy();
        boy = null;
        // of(T t) :保证 t 是非空的
//        Optional<Boy> Optional1 = Optional.of(boy);

        Optional<Object> optional2 = Optional.empty();
        // ofNullable(T t) : t可以是 null
        Optional<Boy> Optional3 = Optional.ofNullable(boy);

    }


    @Test
    public void test2() {

        Boy boy = new Boy();
        boy = null;
        boy=new Boy("tom",new Girl ("江疏影"));

        System.out.println(getGirlName1(boy));

    }


    // 获取男孩的女孩属性名字的方法
    public String getGirlName(Boy boy) {

        if (boy != null) {
            if (boy.getGirl() != null) {
                return boy.getGirl().getName();
            }
        }

        return null;

    }


    // 使用Optional优化以后的方法
    public String getGirlName1(Boy boy) {

        Optional<Boy> optionalBoy = Optional.ofNullable(boy);
        // 此时的boy1一定非空
        Boy boy1 = optionalBoy.orElse(new Boy("tom", new Girl("迪丽热巴")));

        Girl girl = boy1.getGirl();

        Optional<Girl> optionalGirl = Optional.ofNullable(girl);
        // girl1一定非空
        Girl girl1 = optionalGirl.orElse(new Girl("范冰冰"));

        return girl1.getName();

    }


}