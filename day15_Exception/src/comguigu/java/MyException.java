package comguigu.java;

/*
 * 自定义异常类
 *  1. 继承于现有的异常结构：RuntimeException、Exception
 *  2. 提供全局常量：serialVersionUID
 *  3. 提供重载的构造器
 *
 */
public class MyException extends Exception {

    static final long serialVersionUID = -7034896939L;

    public MyException() {
    }

    public MyException(String message) {
        super(message);
    }

}


 class StudentTest {

    public static void main(String[] args) {
        try {
            Student s = new Student();
            s.regist(-1001);
            System.out.println(s);
        } catch (Exception e) {
//			e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
}


class Student{

    private int id;

    public void regist(int id) throws Exception {
        if(id > 0){
            this.id = id;
        }else{
//			System.out.println("您输入的数据非法！");
            //手动抛出异常对象
//			throw new RuntimeException("您输入的数据非法！");
//			throw new Exception("您输入的数据非法！");
            throw new MyException("不能输入负数");
            //错误的
//			throw new String("不能输入负数");
        }

    }

    @Override
    public String toString() {
        return "Student [id=" + id + "]";
    }

}