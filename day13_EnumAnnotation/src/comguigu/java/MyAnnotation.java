package comguigu.java;

import java.lang.annotation.*;

import static java.lang.annotation.ElementType.*;

/**
 * @author Freak-W
 * @create 2021-04-07 10:41
 */
@Inherited
@Repeatable(MyAnnotations.class)
@Target({CONSTRUCTOR,FIELD,LOCAL_VARIABLE,METHOD,PACKAGE,PARAMETER,TYPE})
@Retention(RetentionPolicy.RUNTIME)
// 权限修饰符类似类的用法
public @interface MyAnnotation {
    String value() default "德玛西亚";
}



@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({CONSTRUCTOR,FIELD,LOCAL_VARIABLE,METHOD,PACKAGE,PARAMETER,TYPE})
@interface MyAnnotations {
    MyAnnotation[] value();
}

