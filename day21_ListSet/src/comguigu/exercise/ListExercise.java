package comguigu.exercise;

import lombok.*;

import java.util.*;

/**
 * @projectName: MyJavaStudy
 * @package: comguigu.exercise
 * @author: Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-02-23 11:43
 * <p>
 * 面试题：区分List中的remove(int index)和remove(Object obj)
 */
public class ListExercise {

    public static void main(String[] args) {


        @Cleanup
        Scanner input = new Scanner(System.in);
//        numberSort(input);
//        studentScore(input);
        javaPackage();

    }


    //    练 习
    //1.请从键盘随机输入10个整数保存到List中，并按倒序、从大到小的顺序显示出来
    public static void numberSort(Scanner input) {
        ArrayList<Integer> list = new ArrayList(10);

        for (int i = 1; i <= 10; i++) {
            System.out.print("请输入第 " + i + " 个整数:  ");
            int number = input.nextInt();
            list.add(number);
        }

        Comparator<Integer> comparator1 = (i1, i2) -> -i1.compareTo(i2);
        TreeSet<Integer> set1 = new TreeSet(comparator1);
        set1.addAll(list);

        Iterator<Integer> iterator1 = set1.iterator();
        while (iterator1.hasNext()) {
            System.out.println(iterator1.next());
        }


        //        2.请把学生名与考试分数录入到集合中，并按分数显示前三名
        //        成绩学员的名字。
        //        TreeSet(Student(name,score,id));
        //        练 习


    }


    // 2.请把学生名与考试分数录入到集合中，并按分数显示前三名成绩学员的名字。
    //TreeSet(Student(name,score,id));
    public static void studentScore(Scanner input) {

        Comparator<Student1> comparator = (s1, s2) -> -Double.compare(s1.getScore(), s2.getScore());
        TreeSet<Student1> set = new TreeSet(comparator);

        for (int i = 1; i < 7; i++) {
            System.out.print("请输入第 " + i + " 个学生的名字： ");
            String name = input.next();
            System.out.print("请输入第 " + i + " 个学生的成绩： ");
            double score = input.nextDouble();

            set.add(new Student1(score, name));
        }

        Iterator<Student1> iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }


    //        4. 对一个Java源文件中的关键字进行计数。
//        提示：Java源文件中的每一个单词，需要确定该单词是否是一个关键字。为
//        了高效处理这个问题，将所有的关键字保存在一个HashSet中。用contains()
//        来测试。
//        File file = new File("Test.java");
//        Scanner scanner = new Scanner(file);
//        while(scanner.hasNext()){
//        String word = scanner.next();
//        System.out.println(word);
//        }
    public static void javaPackage() {
        HashSet<String> hashSet = new HashSet<>(10);

        hashSet.add("File");
        hashSet.add("Scanner");
        hashSet.add("While");
        hashSet.add("Select");
        hashSet.add("Group By");
        hashSet.add("Oder By");
        hashSet.add("File");
        hashSet.add("Scanner");
        hashSet.add("While");

        System.out.println(hashSet.contains("FileInputStream"));
        System.out.println(hashSet.contains("Select"));

    }


}


@AllArgsConstructor
@NoArgsConstructor
@Data
class Student1 {

    @NonNull
    private double score;
    private String name;

}