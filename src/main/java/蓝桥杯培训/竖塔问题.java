package 蓝桥杯培训;

import java.util.Arrays;

public class 竖塔问题 {
    static int[][] array = new int[][]{{9},{12,17},{10,6,8},{2,18,9,5},{19,7,10,4,16}};
    static int[][] sum = new int[array.length][array[array.length-1].length];
    public static void main(String[] args) {
        //初始化一下最后一行的值
        for (int i = 0; i < sum[array.length-1].length ; i++) {
            sum[array.length-1][i] = array[array.length-1][i];
        }
        fun();
        for (int i = 0; i < sum.length ; i++) {
            System.out.println(Arrays.toString(sum[i]));
        }
        System.out.println(sum[0][0]);
    }
    public static void fun(){
        //从倒数第二行进行计算
        for (int i = sum.length-2; i >=0 ; i--) {
            //每一行的长度
            for (int j = 0; j < array[i].length; j++) {
                int max = sum[i+1][j];
                //从左右子树中选一个最大的加起来放进sum中
                if (sum[i+1][j] < sum[i+1][j+1])
                    max = sum[i+1][j+1];
                //sum中当前元素的值就为array中的值+左右子树中最大的值
                sum[i][j] = array[i][j]+max;
            }
        }
    }
}
