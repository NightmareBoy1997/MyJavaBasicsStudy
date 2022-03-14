package comguigu.java;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 *                          练 习
 *
 *  1. 请从键盘随机输入10个整数保存到List中，并按倒序、从大到小的顺序显示出来
 *
 *  2. 请把学生名与考试分数录入到集合中，并按分数显示前三名成绩学员的名字。TreeSet(Student(name,score,id)
 *
 *  3.
 *
 *  4. 对一个Java源文件中的关键字进行计数。
 *  提示：Java源文件中的每一个单词，需要确定该单词是否是一个关键字。为了高效处理这个问题，将所有的关键字保存在一个HashSet中。
 *  用contains()来测试。File file = new File("Test.java");Scanner scanner = new Scanner(file);while(scanner.hasNext()){String word = scanner.next();System.out.println(word)
 *
 *
 * @author shkstart
 * @create 2021-05-10 10:45
 */
public class LastCollectionExercise {

//     *  1. 请从键盘随机输入10个整数保存到List中，并按倒序、从大到小的顺序显示出来
    public static void main(String[]args){

        ArrayList list=new ArrayList();
        Scanner scan=new Scanner(System.in);

        for (int i = 0; i < 10; i++) {
            System.out.print("请输入要添加的数值:");
            list.add(scan.nextInt());
        }

        //排序
        Object []array=list.toArray();
        int [] number=new int[list.size()];
        for (int i = 0; i <number.length ; i++) {
            number[i]=(int)array[i];
        }

        Arrays.sort(number);

//        ArrayList list1=list.sort(new Comparator () {
//            public int compare(Object o1,Object o2){
//                if(o1 instanceof int){
//
//                }
//            }
//        });

        System.out.println( Arrays.toString(number));

        //倒序
        for (int i = list.size()-1; i >=0 ; i--) {

            System.out.println(" ---> "+list.toArray()[i]);

        }

    }


// *  2. 请把学生名与考试分数录入到集合中，并按分数显示前三名成绩学员的名字。TreeSet(Student(name,score,id)
    @Test
    public void test1(){



    }












}
