package clock_in.date_3_21.扔手机;

import java.util.Scanner;

public class Main {
    private static int count = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        System.out.println(solution1(n, m));
    }

    // 返回在拥有t部手机时要测出h层内的指数，需要多少次测试
    static int solution1(int h, int t) {
        //一层楼，只要有手机，只需一次测试
        if (h == 1 && t >= 1) return 1;
        //没有楼，返回0
        if (h == 0) return 0;
        // 没有手机了，返回0
        if (t == 0) return 0;
        //只有一部手机，只能一层一层地测，测试数=层数
        if (t == 1) return h;

        int min = Integer.MAX_VALUE;
        //尝试直接从某一层开摔
        for (int cengShu = 1; cengShu <= h; cengShu++) {
            //两种情况，一种情况：手机坏了，那么在下面的那些层里面找答案
            int a = 1 + solution1(cengShu - 1, t - 1);
            //第二种情况，没坏，用现在的手机数去测试上面的h-cengshu层
            int b = 1 + solution1(h - cengShu, t);
            int tmp = Math.max(a, b);
            if (tmp < min) {
                min = tmp;
            }
        }
        return min;
    }

    /**
     *
     * @param h 楼层
     * @param t 手机数
     * @return
     */
    private static int f(int h, int t) {
        System.out.println(count++);
        //一层楼，只要有手机，只需一次测试
        if (h==1&&t>=1) return 1;
        //0层楼，有手机
        if (h==0) return 0;
        //有楼没手机
        if (t==0) return 0;
        //只有一部手机
        if (t==1) return h;
        //初始化最小值
        int min = Integer.MAX_VALUE;
        //从某一层开始摔
        for (int cengShu = 1; cengShu <= h ; cengShu++) {

            //俩种情况
            //摔坏了，那么就从下面的开始找答案，cengShu-1，t-1手机数-1
            int broke = 1 +f(cengShu-1,t-1);
            //没有摔坏，那么就从楼层到cengshu到h是下次的区间，手机数不变
            int ok = 1 +f(h-cengShu,t);
            //取二者的最小值
            int small = Math.max(broke,ok);
            //把小的赋值给min
            if (small < min){
                min = small;
            }
        }
        return min;
    }


}
