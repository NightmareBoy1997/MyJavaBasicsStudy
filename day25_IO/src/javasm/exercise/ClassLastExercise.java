package javasm.exercise;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.*;
import java.util.*;

/**
 * @projectName: MyJavaStudy
 * @package: javasm.exercise
 * @author: Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-02-26 17:59
 * <p>
 * 6. 作业
 */
public class ClassLastExercise {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//        CreateDirectory() ;

//        path(new File("day25_IO\\src\\javasm"),"|- ") ;
//
//        inputFile(scanner);
//
//        userPassword(scanner);
//
//        student(scanner);
//
//        student(scanner);
//
//        aTest();
//
        try {
            charNumber();
        } catch (Exception e) {
            e.printStackTrace();
        }
//
//        randomNumber(scanner);
//
//        studentScore();

    }


    // 1. 使用IO技术，创建一个目录，然后复制一个文件到该目录！
    private static void CreateDirectory() {

        File file1 = new File("day25_IO\\src\\javasm\\io\\exercise/dream.txt");
        File file2 = new File("day25_IO\\src\\javasm\\io\\exercise\\dream1.txt");

        file1.mkdirs();

        try (FileReader fileReader = new FileReader(file1);
             FileWriter fileWriter = new FileWriter(file2)
        ) {

            fileReader.transferTo(fileWriter);
            System.out.println("复制完成！");

//            char[] chars = new char[5];
//            int len;
//            while ((len = fileReader.read(chars)) != -1) {
//                String string = new String(chars, 0, len);
//                System.out.print(string);
//                fileWriter.write(chars, 0, len);
//            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    // 2. 使用IO技术，开发出一个控制台的资源管理器！要求：从命令行输入一个路径！
    // 如果存在,将该目录下所有的文件和文件夹列举出来，如果不存在则输出不存在该路径。
    private static void path(File directory,String str) {
        if(! directory.exists()){
            System.out.println("文件夹不存在!");
            return ;
        }
        final File[] files = directory.listFiles();

        for (File file : files) {
            System.out.println(str + file);
            if(file.isDirectory()){
                path(file,str+"|- ");
            }
        }

    }


    // 3. 基于转换流，从控制台输入一些字符串，并将该类信息保存到日志文件”log.txt”中去。
    private static void inputFile(Scanner scanner) {

        File file = new File("day_IO\\\\src\\\\javasm\\\\io\\\\exercise\\\\log.txt");

        try (FileOutputStream output = new FileOutputStream(file, true);
             OutputStreamWriter inputWriter = new OutputStreamWriter(output,"gbk");
        ) {

            while (true) {
                System.out.print("请输入要写出的字符： ");
                String inputString = scanner.nextLine();

                inputWriter.write(inputString + "\n");

                System.out.print("是否继续录入：(y/n)  ");
                String isGo = scanner.next();
                if ("n".equals(isGo)) {
                    break;
                }
                scanner.nextLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


// 4. 从控制台进行输入用户名以及用户密码，判断是否登录成功！要求准确的用户名和密码存在配置文件中！
    private static void userPassword(Scanner scanner){

        File file = new File("day_IO\\src\\javasm\\io\\exercise\\user.txt");

        System.out.print("请输入用户名： ");
        String inputId = scanner.next();
        System.out.print("请输入密码： ");
        String inputPassword = scanner.next();

        try(FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader) )
        {
            String fileUser = bufferedReader.readLine();
            int index = fileUser.indexOf(" ");
            String userId = fileUser.substring(0,index);
            String userPassword = fileUser.substring(index+1);

            if(userId.equals(inputId) &&  userPassword.equals(inputPassword) ){
                System.out.println("登陆成功!");
            }else{
                System.out.println("密码错误，登录失败！");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


// 5. 创建一个学生类，包含属性：学号、姓名、性别，包含show（）方法用于显示学生的详细信息。
//    创建测试类，在控制台上显示添加学生信息，要求程序循环运行，并依次提示接收学生类的所有属性值，保存到学生对象中，再将学生对象保存到集合对象中，
//    并提示“是否继续添加（y/n）：”,如果选择“y”则继续添加，否则退出循环，并将保存学生数据的集合对象通过序列化保存到“student.dat”文件中。
//    实现从“student.dat”文件中反序列化保存学生数据的集合对象，并遍历打印输出学生信息。
    private static void student(Scanner scanner) {

        List<Student> list = new ArrayList<>(16);

        while(true){
            System.out.print("请输入学生信息(学号-姓名-性别-年龄)： ");
            String string = scanner.nextLine();
            String[] studentString  = string.split("-");
            Student student = new Student(Integer.parseInt(studentString[0]) , studentString[1],studentString[2].charAt(0),Integer.parseInt(studentString[3]));
            list.add(student);

            System.out.print("是够继续录入： ");
            String input;
            while(true){
                input = scanner.next();
                if(input.matches("^[y|n]$")){
                    break;
                };
            }
             if(input.equals("n")){
                 break;
             }
            scanner.nextLine();
        }

        try(   ObjectInputStream ois = new ObjectInputStream(new FileInputStream("day25_IO\\src\\javasm\\io\\exercise\\student.dat")) ;
               ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("day25_IO\\src\\javasm\\io\\exercise\\student.dat"))
                ) {

            for (Student student : list) {
                oos.writeObject(student);
                oos.flush();
            }

            Student student1 =(Student) ois.readObject();
            System.out.println(student1);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


// 6. 已知文件a.txt文件中的内容为“AAbcdea22dferwplkCC321ou1”,请编写程序读取该文件内容，要求去掉重复字母(区分大小写字母)并按照自然排序顺序后输出到b.txt文件中。即b.txt文件内容应为”123ACabcdefklopruw”这样的顺序输出。
    private static void aTest() {
        File file1 = new File("day25_IO\\src\\javasm\\io\\exercise\\a.txt");
        File file2 = new File("day25_IO\\src\\javasm\\io\\exercise\\B.txt") ;

        try( FileReader fileReader = new FileReader(file1);
             FileWriter fileWriter = new FileWriter(file2);)
        {
            char[] chars = new char[5];
            int len;
            StringBuilder stringBuilder = new StringBuilder(16);
            while( (len = fileReader.read(chars)) != -1){
                stringBuilder.append(chars,0,len);
            }
            String string = stringBuilder.toString();
            char[] chars1 = string.toCharArray();
            Arrays.sort(chars1);
            String charString = new String(chars1);

            String replaceString = charString.replaceAll("(.)\\1+", "$1");
            System.out.println(replaceString);
            fileWriter.write(replaceString);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


// 7. 读取任意txt文件内容,并统计出这个文本中每个字符以及每个字符出现的次数，并以以下格式: 字符=次数 持久化保存文件中。
    private static void charNumber() throws Exception {

        File file1 = new File("day25_IO\\src\\javasm\\dream.txt");
        File file2 = new File("day25_IO\\src\\javasm\\dreamChar.properties");

        Properties properties = new Properties();
        int len;
        char[] chars = new char[5];
        FileReader fileReader = new FileReader(file1);
        FileWriter fileWriter = new FileWriter(file2);

        try( fileReader;fileWriter ) {

            while(( len = fileReader.read(chars)) != -1){
                for (int i = 0; i < len; i++) {

                    if( (properties.get(chars[i]) !=null) ) {
                        String string = (String) properties.get(chars[i]);
                        int number = Integer.parseInt(string) + 1;
                        properties.setProperty(String.valueOf( chars[i] ), String.valueOf( number ) ) ;
                    }else{
                        properties.setProperty(String.valueOf( chars[i] ),"1");
                    }
                }
            }
            properties.store(fileWriter,"");

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


// 8. 使用集合相关的功能,存储10个1-50(含50)的随机偶数元素,要求数字不能重复,添加完成后从大到小倒序遍历输出到控制台
// 并使用IO流将集合中的元素按指定格式输出到当指定文件中, 例如: 48,44,40,38,34,30,26……
    private static void randomNumber(Scanner scanner) {

        File file = new File("day_IO\\src\\javasm\\randomNumber.txt");
        int number;
        HashSet<Integer> set = new HashSet<>(10);

        for (int i = 0; i < 10; i++) {
            System.out.print("请输入第 " + (i+1) + " 个数字: ");
            number = scanner.nextInt();
            if(!set.add(number)){
                System.out.println("数字重复,加入失败！");
                i-- ;
            }
        }

        List<Integer> list = new ArrayList(16);
        list.addAll(set);
        try( FileWriter fileWriter = new FileWriter(file) ) {
            list.sort( (i1,i2) -> - Integer.compare(i1,i2) );
            for (Integer integer : list) {
                fileWriter.write(integer + "  ");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


// 9. 已知student_info.txt文件中有如下数据：（姓名-年龄-总分)
//    张三-21-98
//    李四-23-97
//    王五-25-100
//    赵六-15-100
//    孙七-19-93
//    运用IO技术获取将该文件中的数据分别封装成5个Student(姓名为String类型,年龄为int类型,总分为int类型 )对象存入集合中（需要自己定义Student类）
//    要求：根据学生的总分进行排序（降序），如果分数相同则比较年龄，年龄较大的排在前面。并显示排序之后的结果。
    private static void studentScore() {
        File file = new File("day_IO\\src\\javasm\\io\\exercise\\student_info.txt");
        String string;
        List<Student1> list = new ArrayList<>(16);

        try( FileReader fileReader = new FileReader(file);
             BufferedReader bufferedReader = new BufferedReader(fileReader)
           ) {
            while( (string = bufferedReader.readLine() ) != null){
                String[] split = string.split("-");
                Student1 student = new Student1(split[0],Integer.parseInt( split[1] ),Double.parseDouble( split[2] ) );
                list.add(student);
            }
            list.sort( (s1,s2) -> - Integer.compare(s1.getAge(),s2.getAge()) );

            System.out.println("排序后的学生集合： ");
            Iterator<Student1> iterator = list.iterator();
            while(iterator.hasNext()){
                System.out.println(iterator.next());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}

@Data
@AllArgsConstructor
@NoArgsConstructor
class Student implements Serializable{
    private final static long SerialVersionUID = 1413276472641794l;

    private Integer id;
    private String name ;
    private char gender;
    private int age ;

    private void show(){
        System.out.println("学生id： "+ id + " ,姓名： " + name + " ,性别： "+ gender + " ,年龄： "+ age );
    }

}

@Data
@AllArgsConstructor
@NoArgsConstructor
class Student1{

    private String name ;
    private int age ;
    private double score;

    private void show(){
        System.out.println("学生姓名： " + name +" ,年龄： "+ age + " ,成绩： " + score);
    }

}