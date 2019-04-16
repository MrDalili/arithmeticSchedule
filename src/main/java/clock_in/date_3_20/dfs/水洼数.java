package clock_in.date_3_20.dfs;

import java.util.Scanner;

public class 水洼数 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //int M = scanner.nextInt();
        //int N = scanner.nextInt();
        int M=5,N=5;
        char[][] a = new char[M][];
        for (int i = 0; i < M ; i++) {
                a[i] = scanner.nextLine().toCharArray();
        }
        int count = 0;
        //此时获取了所有的水洼以及干燥的陆地
        //使用迭代找到第一个水洼
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                if (a[i][j] == 'W'){
                    //如果该地为水洼，那么向四周扩散，将所有跟他链接的地方变成干燥滴地方
                    dfs(a,i,j);
                    //一次dfs结束，就是将一个连着的水洼变为干燥的地方
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    private static void dfs(char[][] a, int i, int j) {
        a[i][j] = '.';
        //向四周扩散，如果是水洼，就变成干燥的地方
        for (int k = -1; k < 2; k++) {
            for (int l = -1; l < 2; l++) {
                if (k==0&&l==0)
                    //这个是自身
                    continue;
                //判断是否满足条件
                if (i+k>=0&&i+k<=a.length-1&&j+l>=0&&j+l<=a[0].length-1){
                    //+1、0、-1都遍历一遍
                    //如果该地为w
                    if (a[i+k][j+l] == 'W')
                        dfs(a,i+k,j+l);
                }
            }
        }
    }
}
