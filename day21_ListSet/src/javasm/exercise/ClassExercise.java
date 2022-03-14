package javasm.exercise;

import lombok.*;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @projectName: MyJavaStudy
 * @package: javasm.exercise
 * @author: Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-02-28 11:38
 */
public class ClassExercise {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//        employeeList();
//        employeeSet();
        football();

//        accountTest();
//        studentSet();
        listDate(scanner);

    }


    // 1.创建好员工基类和程序员、项目经理子类的基础上，创建一个测试类。创建一个ArrayList集合对象，要求保存两个程序员和两个项目经理的对象，
// 并循环调用show的方法显示详细信息
    private static void employeeList() {
        ArrayList<Employee> list = new ArrayList(10);

        Programmer programmer1 = new Programmer(1008, "tom", 25, 7999, "Java开发工程师");
        Programmer programmer2 = new Programmer(1003, "jack", 33, 10000, "Python大数据开发工程师");
        Manager manager1 = new Manager(1002, "sbjj", 25, 6099, "银行");
        Manager manager2 = new Manager(1001, "ntcj", 25, 5550, "电商平台");

        list.add(programmer1);
        list.add(programmer2);
        list.add(manager1);
        list.add(manager2);

        Iterator<Employee> iterator = list.iterator();
        while (iterator.hasNext()) {
            Employee employee = iterator.next();
            employee.show();
        }

    }


    // 2.创建一个HashMap对象，要求保存两个程序员对象和两个项目经理对象，使用员工的编号做为主键，并循环调用show的方法显示详细信息
    private static void employeeSet() {
        Map<Integer, Employee> map = new HashMap(16);
        Programmer programmer1 = new Programmer(1008, "tom", 25, 7999, "Java开发工程师");
        Programmer programmer2 = new Programmer(1003, "jack", 33, 10000, "Python大数据开发工程师");
        Manager manager1 = new Manager(1002, "sbjj", 25, 6099, "银行");
        Manager manager2 = new Manager(1001, "ntcj", 25, 5550, "电商平台");

        map.put(programmer1.getId(), programmer1);
        map.put(programmer2.getId(), programmer2);
        map.put(manager1.getId(), manager1);
        map.put(manager2.getId(), manager2);

        Set<Integer> set = map.keySet();
        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext()) {
            int key = iterator.next();
            map.get(key).show();
        }
    }


    // 3.基于集合，传入字符串时间，返回该时间是周几，中文显示（星期一）
    private static void listDate(Scanner scanner) {

        System.out.print("请输入时间(年-月-日 时：分：秒)：  ");
        String dateString = scanner.nextLine();

        List<String> list =  List.of("星期一","星期二","星期三","星期四","星期五","星期六","星期天");
        System.out.println(list.getClass());

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        TemporalAccessor parse = dateTimeFormatter.parse(dateString);
        LocalDateTime localDateTime = LocalDateTime.from(parse);

        int day = localDateTime.getDayOfWeek().getValue();;

        System.out.println(list.get(day-1));


    }


    //5.  已知有十六支男子足球队参加2008 北京奥运会。写一个程序，
//    把这16 支球队随机分为4个组。采用List集合和随机数  2008北京奥运会男足参赛国家：
//    科特迪瓦,阿根廷,澳大利亚,塞尔维亚,荷兰,尼日利亚,日本,美国,中国, 新西兰, 巴西, 比利时, 韩国, 喀麦隆, 洪都拉斯, 意大利
    private static void football() {
        String[] strings = {"科特迪瓦","阿根廷","澳大利亚","塞尔维亚","荷兰","尼日利亚","日本","美国","中国","新西兰","巴西","比利时","韩国","喀麦隆","洪都拉斯","意大利"};

        List<String> list = new ArrayList(16);
        list.addAll(Arrays.asList(strings));

        ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();
        int number = 1;
        int index;
        for (int i = 1; i <= 16; i++) {
            index = threadLocalRandom.nextInt(list.size());
            System.out.print(list.get(index)+"  ");
            list.remove(index);
            if( i % 4 == 0){
                System.out.println("    是第 " + number + " 组\n");
                number++;
            }
        }
    }


    // 4.创建Student类，属性包括id[1-40],score[0-100],所有属性随机生成。创建Set集合，保存20个对象，找到分数最高与最低的学生
    private static void studentSet() {

        HashSet<Student> set = new HashSet(20);
        System.out.println("学生成绩列表：");
        for (int i = 0; i < 20; i++) {
            Student student = new Student();
            set.add(student);
        }

        Iterator<Student> iterator = set.iterator();
        while (iterator.hasNext()) {
            Student student1 = iterator.next();
            System.out.println("id: " + student1.getId() + " 的学生成绩是： " + student1.getScore());
        }


        Student max = Collections.max(set, (s1, s2) -> Double.compare(s1.getScore(), s2.getScore()));
        Student min = Collections.min(set, (s1, s2) -> Double.compare(s1.getScore(), s2.getScore()));
        System.out.println("\n分数最高的学生学号是： " + max.getId() + " ,分数是： " + max.getScore());
        System.out.println("分数最低的学生学号是： " + min.getId() + " ,分数是： " + min.getScore());

    }


    //6. 设计Account 类如下：
//    private long id;
//    private double balance;
//    private String password; 要求完善设计，使得该Account 对象能够自动分配自增id。给定一个List 如下：
//    List<Account> list = new ArrayList<>();
//   list.add(new Account(10.00, “1234”));
//    list.add(new Account(15.00, “5678”));
//   list.add(new Account(0, “1010”)); 要求把List 中的内容放到一个Map 中，该Map 的键为id，值为相应的Account 对象。 最后遍历这个Map，打印所有Account 对象的id 和余额
    private static void accountTest() {
        List<Account> list = new ArrayList<>();
        list.add(new Account(10.00, "1234"));
        list.add(new Account(15.00, "5678"));
        list.add(new Account(0, "1010"));

        HashMap<Long, Account> map = new HashMap<>(16);
        for (Account account : list) {
            map.put(account.getId(), account);
        }

        Set<Long> ids = map.keySet();
        Iterator<Long> iterator = ids.iterator();
        while (iterator.hasNext()) {
            long id = iterator.next();
            System.out.println(id + " == " + map.get(id));
        }
    }


}


@Getter
@ToString
class Student {

    private Integer id;
    private Double score;

    Student() {
        this.id = (int) (Math.random() * 40 + 1);
        double score = Math.random() * 100 + 1;
        NumberFormat numberFormat = new DecimalFormat("#######.##");
        String formatScore = numberFormat.format(score);

        this.score = Double.parseDouble(formatScore);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        return id != null ? id.equals(student.id) : student.id == null;
    }

    @Override
    public int hashCode() {
        return 0;
    }
}


@Data
class Account {

    private static int number = 1000;
    private long id;
    private double balance;
    private String password;

    public Account(double balance, String password) {
        this.id = number++;
        this.balance = balance;
        this.password = password;
    }

}

@Data
@AllArgsConstructor
@NoArgsConstructor
class Employee {
    private Integer id;
    private String name;
    private Integer age;
    private Integer salary;

    void show() {
        System.out.println("我是" + name + ",年龄" + age + ",我的工号是 " + id + ",我的工资： " + salary);
    }

    ;

}

@Data
@NoArgsConstructor
class Programmer extends Employee {
    private String type;

    void show() {
        System.out.println("我是程序员" + getName() + ",年龄" + getAge() + ",我的工号是 " + getId() + " ,我的类目是 " + type + ",我的工资：" + getSalary() + "\t我讨厌加班！");
    }

    public Programmer(Integer id, String name, Integer age, Integer salary, String type) {
        super(id, name, age, salary);
        this.type = type;
    }

}

@Data
@NoArgsConstructor
class Manager extends Employee {
    private String project;

    public Manager(Integer id, String name, Integer age, Integer salary, String project) {
        super(id, name, age, salary);
        this.project = project;
    }

    void show() {
        System.out.println("我是产品经理" + getName() + ",年龄" + getAge() + ",我的工号是 " + getId() + " ,我的项目是 " + project + ",我的工资： " + project + getSalary() + "\t我不正常");
    }

}