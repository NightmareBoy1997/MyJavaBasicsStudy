package javasm.exercise;

/**
 * @author Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-02-10 19:53
 * <p>
 * <p>
 * 打印出所有的 "水仙花数"
 * 所谓 "水仙花数"是指一个三位数，其各位数字立方和等于该数本身。
 * 例如：153是一个 "水仙花数 "，因为153=1的三次方＋5的三次方＋3的三次方。
 */
public class Daffodil {

    /**
     * 获取三次方幂的方法
     *
     * @param number
     * @return 返回number的三次方 ， int类型
     */
    static int getCubeNumber(int number) {
        return number * number * number;
    }


    public static void main(String[] args) {

        for (int i = 100; i < 1000; i++) {

            int ge = (i % 10);
            int shi = ((i % 100) / 10);
            int bai = (i / 100);

            int sumNumber = getCubeNumber(ge) + getCubeNumber(shi) + getCubeNumber(bai);

            if (i == sumNumber){
                System.out.println( i + " \t ");
            }
        }
    }

}
