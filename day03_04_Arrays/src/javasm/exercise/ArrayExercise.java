package javasm.exercise;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: Nightmare970701
 * @className:
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-02-12 13:33
 *
 *  数组课后练习
 *
 */
public class ArrayExercise {



//    4.	作业
//	声明一个字符串的数组，空间为5个。使用循环接收五个学生的姓名。再使用循环倒序输出这5个学生的名字
        public static void student(){
                Scanner scanner = new Scanner(System.in);
                String []array = new String [5];
                for(int i = 0 ; i<array.length ; i++){
                        System.out.print("请输入第 " + (i+1) + "个学生的名字:  " );
                        array[i] = scanner.next();
                }

                for (int i = array.length-1 ; i >=0 ; i--) {
                        System.out.print(array[i] + " \t ");
                }

                scanner.close();
        }


//	声明一个int型的数组，循环接收8个学生的成绩，计算这8个学生的总分、平均分、最高分、最低分
        public static void studentScore(){
                Scanner scanner = new Scanner(System.in);
                // 确定数组长度
                System.out.print("请输入要统计的学生人数： ");
                int length = scanner.nextInt();
                double []array = new double[length];

                double sumScore = 0 , avgScore = 0 , maxScore = 0 ;
                double minScore = 100 ;

                // 数组赋值
                for(int i = 0 ; i<array.length ; i++){
                        System.out.print("请输入第 " + (i+1) + " 个学生的成绩： ");
                        array[i] = scanner.nextInt();
                        if(array[i] < 0 ){
                                throw new RuntimeException("输入有误！成绩可不能欠账哦！");
                        }
                        if( array[i] > 100 ){
                                throw new RuntimeException("你想上天啊！满分一百考一百多？");
                        }

                        // 赋值最大值、最小值、总和
                        sumScore +=array[i];
                        if(array[i] > maxScore){
                                maxScore = array[i];
                        }

                        if(array[i] < minScore){
                                minScore = array[i];
                        }
                }

                // 遍历数组
                int number = 0;
                for (double i : array) {
                        number++ ;
                        System.out.println("第 " + number + " 位同学的成绩是： " + i);
                }

                // 赋值平均值
                avgScore = sumScore / 8 ;
                System.out.println("这8个同学的总分是： " + sumScore + " ，8名同学的平均分是 " + avgScore + " ，其中 最高分是： " + maxScore + " ,最低分是： " + minScore);

                scanner.close();

        }


//	现在有如下一个数组： int[]  oldArr={1,3,4,5,0,0,6,6,0,5,4,7,6,7,0,5}; 要求将以上数组中的0项去掉，将不为0的值存入一个新的数组，生成新的数组为
//    int newArr[]={1,3,4,5,6,6,5,4,7,6,7,5};
        public static void arrayRemove(){
                int[] oldArr={1,3,4,5,2,6,6,6,3,5,4,7,6,7,1,5} ;

                System.out.print("当前数组元素为： ");
                System.out.println(Arrays.toString(oldArr));

                Scanner scanner = new Scanner(System.in);
                System.out.print("请输入要删除的数值： ");
                int delete = scanner.nextInt();

                for (int i = 0; i < oldArr.length; i++) {
                        if(oldArr[i] == delete){
                                for (int j = i; j < oldArr.length - 1 ; j++) {
                                        oldArr[j] = oldArr[j+1];
                                }
                                oldArr[oldArr.length - 1] = 0 ;

                                if(oldArr[i] == delete){
                                        i--;
                                }
                        }
                }

                System.out.print("删除 " + delete + "成功！\n" + "新数组元素为： ");
                System.out.print(Arrays.toString(oldArr));

                scanner.close();

        }


//	定义一个长度为31的整数数组，依次放入的2的若干次方，第一个放1，第二个放2，第三个放4，第四个放8。。。。并输出
//    int[] num= {1,2,4,8,16,32,64,128,256,512,1024,2028,4056,8112,16224,32448.....}
        public static void doubleArray(){

                Scanner scanner = new Scanner(System.in);
                System.out.print("请输入要添加的元素数量： ");
                int number = scanner.nextInt();

                int array[] = new int[number];

                for (int i = 0; i < array.length; i++) {
                        array[i] = (int)Math.pow(2,i);
                }

                System.out.println(Arrays.toString(array));

                scanner.close();
        }

//	int array [] = {2,432,5221,235,2,5352,1,53,5,3,5364,2,2,63,3533,2,53,532,532};
//        求所有元素和。
//        输出所有奇数下标元素。如：array[1]
//        输出所有元素中，值为奇数的。
//        将所有元素乘二。
        public static void selectArray(){
                int array [] = {2,432,5221,235,2,5352,1,53,5,3,5364,2,2,63,3533,2,53,532,532};

                int sumNumber = 0 ;
                int array2 [] = new int[array.length];

                for (int i = 0; i < array.length; i++) {
                        sumNumber += array[i];

                        if(i % 2 !=0 && i != 0){
                                System.out.print("array[ " + i + " ] ： " + array[i] + "  ");
                                System.out.println();
                        }

                        if(array[i] % 2 !=0){
                                System.out.print("奇数： " + array[i] + " 的角标： " + i + "  ");
                                System.out.println();
                        }
                        array2[i] = array[i] * 2;
                }

                System.out.println("所有元素乘2以后的新数组的元素为： " + Arrays.toString(array2));

        }


        public static void main(String[] args) {

//                student();
//
//                studentScore();
//
//                arrayRemove();
//
//                doubleArray();
//
//                selectArray();

        }



        }
