package 蓝桥杯培训;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 网球比赛，4名选手，每一个选手要和剩下的每一个选手进行比赛
 * 1个运动员一天只能赛一场，把赛程表排出来
 *
 * 1 2 3 4
 * 2 1 4 3
 * 3 4 1 2
 * 4 3 2 1
 *
 * 思路：二分法
 *
 */
public class 网球比赛 {
    //全局矩阵
    static int[][] game ;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();

        game = new int[(1<<k)+1][(1<<k)+1];

        plan(k);
        print();
    }

    private static void print() {
        for (int[] ints : game) {
            System.out.println(Arrays.toString(ints));
        }
    }


    /**
     * 打印二维数组
     * @param k
     */
    private static void plan(int k) {
        game[1][1] = 1; game[1][2] = 2; game[2][1] = 2; game[2][2] = 1;
        for (int i = 1; i < k; i++) {
            int temp = 1 << i;
            //右下角的
            for (int j = 1; j <= temp; j++) {
                for (int l = 1; l <= temp; l++) {
                    game[j + temp][l] = game[j][l] + temp;
                    game[j][l + temp] = game[j][l] + temp;
                    game[j + temp][l + temp] = game[j][l];

                }
            }
        }
    }


}
