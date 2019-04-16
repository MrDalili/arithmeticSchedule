package clock_in.date_3_20.dfs;

import java.util.Scanner;

public class n皇后问题 {
    static int count = 0;
    static int n;
    static int[] array;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        array = new int[n];
        dfs(0);
        System.out.println(count);
    }

    private static void dfs(int row) {
        //对出口进行判断,如果row==n了，那就表明其走到最后一行了
        if (row == n ){
            count++;
            return;
        }

        //进行试探
        for (int clo = 0; clo < n; clo++) {

            //判断这个是否满足n皇后问题的条件，如果条件满足的话继续进行试探
            boolean ok = true;
            /**
             * 这里一定要注意，从数组0开始到数组的当前行的地方，不要想后面遍历
             */
            for (int index = 0; index < row; index++) {
                if (array[index] == clo || index+array[index]==row+clo || index-array[index] == row-clo){
                    //如果满足这些条件，那么就证明不满足n皇后问题的条件
                    ok = false;
                    break;
                }
            }
            //判断是否满足条件，进行剪枝
            if (ok){
                array[row] = clo;
                dfs(row+1);
            }
        }
    }


}
