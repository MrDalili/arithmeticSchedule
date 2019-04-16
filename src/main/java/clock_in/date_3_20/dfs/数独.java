package clock_in.date_3_20.dfs;

import java.util.Scanner;
import java.util.concurrent.CountDownLatch;

public class 数独 {
    public static void main(String[] args) {
//        获取输入的数据
        //Scanner scanner = new Scanner(System.in);
        int[][] table = new int[][]{
                {0, 5, 0, 6, 0, 1, 0, 0, 0},
                {0, 0, 7, 0, 9, 0, 0, 2, 0},
                {3, 0, 0, 0, 0, 4, 0, 0, 1},
                {9, 0, 0, 0, 0, 0, 1, 3, 0},
                {0, 0, 8, 0, 5, 0, 7, 0, 0},
                {0, 2, 6, 0, 0, 0, 0, 0, 8},
                {7, 0, 0, 9, 0, 0, 0, 0, 5},
                {0, 9, 0, 0, 4, 0, 3, 0, 0},
                {0, 0, 0, 2, 0, 8, 0, 1, 0},
        };
        dfs(table,0,0);
    }

    static void dfs(int[][] table , int x ,int y ){
        if (x == 9){
            //如果x==9了的话，那么就是x已经将9行全部遍历完了
            System.out.println("ok");
        }
        //如果满足条件的话
        if (table[x][y] == 0){
            //数组中的数为0，那么就是没有填的空
            for (int i = 1; i < 10; i++) {
                //那么想该数组中遍历这些数，每一个都进行尝试
                table[x][y] = i;
                //对该地方进行检查
                boolean flag = check(table,x,y,i);
                if (flag){
                    //如果满足检查，那么继续进行深度遍历
                    //这个x+(y+1)/9----->因为y是从0-8，如果y到9了，那么就是可以被9整除，表明y到了最边上，x要向下进一行了
                    dfs(table,x+(y+1)/9,(y+1)%9);
                }
                //这时候要进行回溯，以为table[x][y]只是其中的一种，其他还要用

            }
            table[x][y] = 0;
        }
        else {
            //表明这个位置原本有数，那么进行下一个
            dfs(table,x+(y+1)/9,(y+1)%9);
        }
    }

    static boolean check(int[][] table, int x, int y, int i) {
//
//        for (int j = 0; j < 9; j++) {
//            if (table[x][j] == i)return false;
//            if (table[j][y] == i)return false;
//        }
        //判断y方向上有没有相同的
        for (int j = 0; j < 9 ; j++) {
            if (j == x){
                //因为如果横坐标纵坐标相同肯定就是本身，所以continue
                continue;
            }
            if (table[j][y] == i){
                //如果出现相同的数，那么不符合条件
                return false;
            }
        }
        //判断x方向上有没有相同的
        for (int j = 0; j < 9; j++) {
            if (j == y){
                //很坐标相同，纵坐标变化
                continue;
            }
            if (table[x][j] == i){
                //如果出现相同的数
                return false;
            }
        }
//        for (int j = 0; j < 9; j++) {
//            if (table[x][i] == y || table[j][x] == x) {
//                return false;
//            }
//        }
        //判断9宫格中有没有相同的
        for (int j = (x*3)/3 ; j < (x/3+1)*3 ; j++) {
            for (int k = (y*3)/3 ; k < (y/3+1)*3 ; k++) {
                if (j == x && k == y)
                    continue;
                if (table[j][k] == i)
                    return false;
            }
            
        }
        return true;
    }
}
