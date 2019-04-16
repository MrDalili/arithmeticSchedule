package clock_in.date_3_23.分巧克力;

import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[][] qiaokeli = new int[n][2];
        for (int i = 0; i < n; i++) {
            qiaokeli[i][0] = scanner.nextInt();
            qiaokeli[i][1] = scanner.nextInt();
        }

        //开始遍历寻找
        //计算出最大的课程性，然后从大到小取试探
        long area = 0;
        for (int i = 0; i < qiaokeli.length; i++) {
            area += qiaokeli[i][0]*qiaokeli[i][1];
        }
        long len = area/k;
        for (long i = len; i >= 1; i--) {
            //可以满足小孩的个数
            int count = 0;
            //dfs进行遍历
            for (int j = 0; j < qiaokeli.length; j++) {
                int[][] daxiao = new int[qiaokeli[j][0]][qiaokeli[j][1]];
                count += dfs(daxiao, (int) i);
            }
            if (count >= k){
                System.out.println(i+"*"+i+"的蛋糕分给每个小朋友，可以分"+count);
            }
        }

    }

    //遍历
    private static int dfs(int[][] qiaokeli,int len) {
        int count  = 0;
        for (int i = 0; i < qiaokeli.length; i++) {
            for (int j = 0; j < qiaokeli[i].length; j++) {
                if (qiaokeli[i][j] == 0){
                    if (check(qiaokeli,i,j,len)){
                        count++;
                    }
                }
            }
        }
        return count;
    }

    private static boolean check(int[][] qiaokeli, int i, int j, int len) {
        if (len+i>qiaokeli.length)
            return false;
        if (len+j>qiaokeli[0].length)
            return false;
        //如果面积足够，那么就把这区间内的东西转化为1
        for (int k = 0; k < len; k++) {
            for (int l = 0; l < len; l++) {
                qiaokeli[i+k][j+l] = 1;
            }
        }
        return true;
    }
}
