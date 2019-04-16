package clock_in.date_2_11;

import java.util.Arrays;

public class bubbleSort {
    public static void main(String[] args) {
        int[] array = new int[]{0,1,3,2,5,-1};
        sort(array);
        System.out.println(Arrays.toString(array));
    }

    /**
     * 从第一个往最后一个冒泡，每一个轮回需要冒泡的数量减一直到还有一个数
     * @param array
     */
    public static void sort(int[] array){
        //需要比较的轮回，并且每次将最后一位减去
        for (int i = array.length-1; i > 0; i--) {
            int index = 0;
            //从第一个数到需要排序的数
            for (int j = 0; j <= i; j++) {
                //每次与记录的最大的数的下标中的数进行比较
                if (array[j] > array[index]){
                    index = j;
                }
            }
            //交换遍历一次，index下标的值与最后一个元素进行交换
            int a = array[i];
            array[i] = array[index];
            array[index] = a;

        }
    }
}
