package clock_in.date_3_20.dfs;

import java.util.Arrays;
import java.util.Scanner;

public class 素数环 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        a[0] = 1;
//        for (int i = 1; i < n; i++) {
//            a[i] = scanner.nextInt();
//        }

        dfs(a,1);
    }

    private static void dfs(int[] a, int index) {
        //先判断是否走到尽头
        if (index == a.length && ifP(a[index-1]+1)){
            System.out.println(Arrays.toString(a));
        }
        //在这里对每一个进行试探
        for (int i = 2; i <= a.length ; i++) {
            if (check(a,index,i)){
                a[index] = i;
                //满足条件，继续遍历
                dfs(a,index+1);
                a[index] = 0;
            }
        }
    }

    private static boolean ifP(int num) {
        for (int i = 2; i < num; i++) {
            if (num % i == 0 )
                return false;
        }
        return true;
    }

    /**
     * 检查该点的值是否用过
     * @param a 数组
     * @param index 下标
     * @param i 放入的数
     * @return
     */
    private static boolean check(int[] a, int index,int i) {
        boolean flag = true;
        //检查该数是否便用过
        for (int j = 0; j < index; j++) {
            if (a[j] == i)
                return false;
        }
        //判断是否为素数
        //计算出a[index-1]+i
        int count = a[index-1]+i;

        flag = ifP(count);

        return flag;
    }


}
