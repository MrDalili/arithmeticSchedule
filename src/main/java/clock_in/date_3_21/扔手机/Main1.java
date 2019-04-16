package clock_in.date_3_21.扔手机;

import java.util.Scanner;

public class Main1 {
    static int[][] state;

    /**
     *
     * @param h 楼层
     * @param t 手机数
     * @return
     */
    static int f(int h, int t) {
        //一层楼，只要有手机，只需一次测试
        if (h == 1 && t >= 1) return 1;
        //没有楼，返回0
        if (h == 0) return 0;
        // 没有手机了，返回0
        if (t == 0) return 0;
        //只有一部手机，只能一层一层地测，测试数=层数
        if (t == 1) return h;

        int min = Integer.MAX_VALUE;
        //尝试每一层
        for (int cengShu = 1; cengShu <= h; cengShu++) {
            //两种情况，一种情况：手机坏了，用更少的手机去测下面的h-1层
            if (state[cengShu - 1][t - 1] == -1)
                state[cengShu - 1][t - 1] = f(cengShu - 1, t - 1);
            //第二种情况，没坏，用现在的手机数去测试h-i层
            if (state[h - cengShu][t] == -1)
                state[h - cengShu][t] = f(h - cengShu, t);
            int tmp = Math.max(state[cengShu - 1][t - 1], state[h - cengShu][t]);
            if (tmp < min) {
                min = tmp + 1;
            }
        }
        state[h][t] = min;
        return min;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N=scan.nextInt();
        state = new int[N + 1][N + 1];
        for (int i = 0; i < state.length; i++) {
            for (int j = 0; j < state[i].length; j++) {
                state[i][j] = -1;
            }
        }
   /* int N = 1000;

    // for(int i=1; i<101; i++){
    System.out.println(N + "楼===" + f(N, 3));
    // }

    m1();*/

        int res = f(N, 3);
        System.out.println(res);
    }

}
