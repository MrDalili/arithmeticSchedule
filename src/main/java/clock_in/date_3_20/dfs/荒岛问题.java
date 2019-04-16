package clock_in.date_3_20.dfs;

import java.util.Scanner;

public class 荒岛问题 {
    static int old = 0;
    static int news = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        char[][] array = new char[n][];
        for (int i = 0; i < n; i++) {
            array[i] = scanner.next().toCharArray();
        }
        //复制一个数组
        char[][] array1 = new char[n][m];
        char[][] array2 = new char[n][m];
        for (int i = 0; i < n ; i++) {
            for (int j = 0; j < m ; j++) {
                array1[i][j] = array[i][j];
                array2[i][j] = array[i][j];
            }
        }


        //第一次遍历查出来有多少个孤岛
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                //找到一个荒岛
                if (array[i][j] == '#'){
                    dsf(array,i,j);
                    old++;
                }
            }
        }
        //对水洼进行覆盖

        overthrow(array1,array2);
        //对覆盖过的水洼进行遍历
        for (int i = 0; i < array2.length; i++) {
            for (int j = 0; j < array2[i].length; j++) {
                //找到一个荒岛
                if (array2[i][j] == '#'){
                    dsf(array2,i,j);
                    news++;
                }
            }
        }

        System.out.println(old-news);
    }

    private static void overthrow(char[][] array1,char[][] array2) {
        for (int i = 0; i < array1.length; i++) {
            for (int j = 0; j < array1[0].length; j++) {
                //如果这个是陆地
                if(array1[i][j] == '#'){
                    //判断一下这个东西是否靠海

                        //判断是否越界
                    if (i-1>=0){
                            if (array1[i-1][j] == '.'){
                                array2[i][j] = '.';
                        }
                    }
                    if (i+1<= array1.length-1){
                        if (array1[i + 1][j] == '.')
                            array2[i][j] = '.';
                    }
                    if (j+1<=array1[i].length-1){
                        if(array1[i][j+1] == '.')

                            array2[i][j] = '.';
                    }
                    if (j-1>=0){
                    if (array1[i][j-1] == '.')
                            array2[i][j] = '.';
                    }
                }

            }
        }
    }

    private static void dsf(char[][] array, int i, int j) {
        array[i][j] = '.';
        if (i-1>=0){
            if (array[i-1][j] == '#')
                dsf(array,i-1,j);
        }
        if (i+1<= array.length-1){
            if (array[i+1][j] == '#')
                dsf(array,i+1,j);
        }
        if(j-1>=0){
            if (array[i][j-1] == '#')
                dsf(array,i,j-1);
        }
        if (j+1<=array[0].length-1){
            if(array[i][j+1] == '#')
            dsf(array,i,j+1);
        }
    }
}
