package 领扣.探索.数组;

import java.util.Scanner;

/**
 * The best time to buy stocks
 */
public class 买卖股票的最佳时机II {

    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
        int[] sharePrice = new int[]{1,2,3,4,6,5,6,2,7};
        System.out.println(fun(sharePrice));
    }

    /**
     * 就是从某一天开始找到一个增长序列，直到第二个开始
     */
    private static int fun(int[] sharePrice) {
        //记录总利润
        int profit = 0;
        for (int i = 0; i < sharePrice.length-1; i++) {
            //如果明天的利润比今天的高，那么则继续持仓，看明天和后天的关系，并将利润记录
            if (sharePrice[i+1] > sharePrice[i])
                profit += sharePrice[i+1]-sharePrice[i];
        }
        return profit;
    }
}
