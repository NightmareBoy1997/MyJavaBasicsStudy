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
 */

public class OOPArrayTest {

	public static void main(String[] args) {

		Students[] student = new Students[20];
		for (int i = 0; i < student.length; i++) {
			// 给数组元素赋值
			student[i] = new Students();
			// 给Students对象属性赋值
			student[i].number = i + 1;
			// 年级1-6
			student[i].state = (int) (Math.random() * (6 - 1 + 1) + 1);
			// 分数0-100
			student[i].score = (int) (Math.random() * (100 - 0 + 1) + 0);
		}
		// 遍历数组
		for (int i = 0; i < student.length; i++) {
			System.out.println(student[i].info());
		}
		System.out.println("****************************************");
		for(int i=0;i<student.length;i++){
			if(student[i].state==3){
				System.out.println(student[i].info());
			}
		}
		System.out.println("******************************************");
		
		//按学生成绩冒泡排序
		for(int i=0;i<student.length-1;i++){
			for(int j=0;j<student.length-i-1;j++){
				if(student[j].score>student[j+1].score){
					//如果需要换序，交换的是数组元素，Students对象！！！
					Students temp=student[j];
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

class Students {

	int number;
	int state;
	int score;

	public String info() {
		return "学号是：" + number + "的" + state + "年级的学生的成绩是：" + score;
	}

}