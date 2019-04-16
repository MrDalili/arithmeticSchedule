package clock_in.date_2_13;


import java.util.Arrays;

public class SelectSort {
    public static void main(String[] args) {
        int[] array = new int[]{0,1,3,2,5,-1,3,4,5,4,3,21,-6,234,6,23,1};
        sort(array);
        System.out.println(Arrays.toString(array));
    }

    /**
     * 选择排序，给定一个数组，俩俩比较将较大的数向后移动
     * @param arry
     */
    public static void sort(int[] arry){
        //比较次数，以及每次过一遍后，最后一个下标-1
        for (int i = arry.length-1; i >=0 ; i--) {
            //每次比较到当前最后一个数前面的一位
            for (int j = 0; j < i; j++) {
                if (arry[j]>arry[j+1]){
                    Tool.kit.swapNum(arry,j,j+1);
                }
            }
        }
    }
}
