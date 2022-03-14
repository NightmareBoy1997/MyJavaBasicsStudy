package javasm.guigu_exercise.Exercise1;

/*4.对象数组题目：
 * 定义类Student，包含三个属性：学号number（int），年级state（int），成绩score（int）
 * ，创建20个学生对象，学号为1-20，年级和成绩都由随机数确定。
 * 问题一：打印出3年级（state值为3）的学生信息。
 * 问题二：使用冒泡排序按学生成绩排序，并遍历所有学生信息
 * 
 * 提示：
 * 1）生成随机数：Math.random（），返回值类型double。
 * 2）四舍五入取整：Math.round(aouble d),返回值类型long。
 * 
 * 此代码是对上题的改进，将操作数组的功能封装到方法中
 * 
 */

public class OOPArrayTest2 {

	public static void main(String[] args) {

		Student1[] student = new Student1[20];
		for (int i = 0; i < student.length; i++) {
			// 给数组元素赋值
			student[i] = new Student1();
			// 给Students对象属性赋值
			student[i].number = i + 1;
			// 年级1-6
			student[i].state = (int) (Math.random() * (6 - 1 + 1) + 1);
			// 分数0-100
			student[i].score = (int) (Math.random() * (100 - 0 + 1) + 0);
		}
		
		//在方法中创建对象
		OOPArrayTest2 test=new OOPArrayTest2();
		
		//遍历学生信息
		test.print(student);
		System.out.println("****************************************");
		//打印三年级的信息
		test.searchState(student, 3);
		System.out.println("******************************************");
		
		//按学生成绩冒泡排序
		test.sort(student);
		
	}
	
	/**
	 * 
	 * @Description 遍历Student1[]数组的操作
	 * @author guoqi Wei
	 * @date 2021年2月8日下午2:38:54
	 * @param student
	 */
	public void print(Student1[]student){
		for (int i = 0; i < student.length; i++) {
					System.out.println(student[i].info());
		}
	}
	/**
	 * 
	 * @Description 查找Student1数组中指定年级的学生信息
	 * @author guoqi Wei
	 * @date 2021年2月8日下午2:33:11
	 * @param student 要查找的数组
	 * @param state	要找的年级
	 */
	public void searchState(Student1[]student,int state){
		for(int i=0;i<student.length;i++){
			if(student[i].state==state){
				System.out.println(student[i].info());
			}
		}
	}
	
	/**
	 * 
	 * @Description 给 Student1数组冒泡排序
	 * @author guoqi Wei
	 * @date 2021年2月8日下午2:37:56
	 * @param student
	 */
	public void sort(Student1[] student){
		for(int i=0;i<student.length-1;i++){
			for(int j=0;j<student.length-i-1;j++){
				if(student[j].score>student[j+1].score){
					//如果需要换序，交换的是数组元素，Students对象！！！
					Student1 temp=student[j];
					student[j]=student[j+1];
					student[j+1]=temp;
				}
			}
		}
		for(int i=0;i<student.length;i++){
			System.out.println(student[i].info());
		}
	}
	
}

class Student1 {

	int number;
	int state;
	int score;

	public String info() {
		return "学号是：" + number + "的" + state + "年级的学生的成绩是：" + score;
	}

}