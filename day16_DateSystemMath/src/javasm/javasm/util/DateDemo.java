package javasm.javasm.util;

import java.text.DateFormat;
import java.text.Format;
import java.util.Date;
import java.util.Scanner;

/**
 * @author: Lisa
 * @className: DateDemo
 * @description:
 * @date: 2022/2/28 10:15
 * @version: 0.1
 * @since: jdk11
 */
public class DateDemo {


    public static void main(String[] args) {
        //无参构造: 获得当前系统此刻日期时间
        //Date date = new Date();
        //System.out.println(date);

        // registerEmployee();

     /* new Thread(DateDemo::test).start();
      new Thread(DateDemo::test).start();
      new Thread(DateDemo::test).start();
      new Thread(DateDemo::test).start();*/

        test1();
    }

    public static void test1() {
        //获得当前时间的毫秒数
        Date date = new Date();
        System.out.println(date.getYear() + 1900);//1900
        System.out.println(date.getMinutes());
        System.out.println(date.getHours());
        System.out.println(date.getMonth() + 1);//2
        System.out.println(date.getDate());
        System.out.println(date.getDay());//1 获得这一天是这一周的第几天
        System.out.println(date.getTime());//获得时间毫秒数

        //不推荐使用Date里面的getTime获得毫秒数
        //与对象密切相关
        //推荐
        System.out.println(System.currentTimeMillis());//毫秒数
        System.out.println(System.nanoTime());
    }

    public static void test() {

        String[] dateStrArray = {
                "2020-01-01 12:00:00",
                "2020-01-01 12:00:00",
                "2020-01-01 12:00:00",
                "2020-01-01 12:00:00",
                "2020-01-01 12:00:00",
                "2020-01-01 12:00:00",
                "2020-01-01 12:00:00",
                "2020-01-01 12:00:00",
                "2020-01-01 12:00:00",
                "2020-01-01 12:00:00",
                "2020-01-01 12:00:00",
                "2020-01-01 12:00:00",
                "2020-01-01 12:00:00",
                "2020-01-01 12:00:00",
                "2020-01-01 12:00:00"};


        //将数组里面所有的字符串都解析成Date类型的数据
        for (String str : dateStrArray) {
            System.out.println(DateUtil.strConvertDate(str));
        }

    }


    //员工入职: 录入员工信息到公司系统里面
    //员工id name age phone 入职时间 生日 新建员工时间  更改员工信息时间  地址

    public static void registerEmployee() {
        Scanner input = new Scanner(System.in);
        Employee employee = new Employee();
        System.out.println("请录入员工name:");
        employee.setName(input.nextLine());

        System.out.println("请录入员工phone:");
        employee.setPhone(input.nextLine());

        //录入的字符串数据如何转换成一个Date类型的数据?
        //String 转 Date

        System.out.println("请录入员工生日:");//2020-01-01 12:00:00
        String birthday = input.nextLine();
        employee.setBirthday(DateUtil.strConvertDate(birthday));

        System.out.println("请录入员工入职时间:");//2020-01-01 12:00:00
        String hireDate = input.nextLine();
        employee.setHireDate(DateUtil.strConvertDate(hireDate));

        //System.out.println("请录入新建员工时间:");
        //获得当前此刻的时间即可
        employee.setCreateTime(new Date());

        //能够获得一个完整的员工信息，用户体验感不高
        //看不懂时间
        //只能看懂: 2020-01-01 12:00:00
        System.out.println("注册员工信息成功,信息如下:" + employee.toString());

        input.close();

    }


}
