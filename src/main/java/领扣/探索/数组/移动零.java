package 领扣.探索.数组;

import java.util.Arrays;

public class 移动零 {
    public static void main(String[] args) {
        int[] a = new int[]{1,0};
        System.out.println(Arrays.toString(fun(a)));
        a = new int[]{1,0};
        System.out.println(Arrays.toString(fun1(a)));
    }


    private static int[] fun1(int[] nums) {
        //数非0指针
        int noZeroIndex = 0;
        //从头向后移动的指针
        int slowPoint = 0;
        while (noZeroIndex < nums.length && slowPoint < nums.length){

            //找到内容不为0的
            while (noZeroIndex < nums.length && nums[noZeroIndex] == 0){
                noZeroIndex++;
            }
            //如果指针没有越界
            if (noZeroIndex < nums.length && slowPoint < nums.length){
                int swap = nums[noZeroIndex];
                nums[noZeroIndex] = nums[slowPoint];
                nums[slowPoint] = swap;
                slowPoint++;
                noZeroIndex++;
            }

        }
        for (int i = slowPoint ; i < nums.length ; i++) {
            nums[i] = 0;
        }
        return nums;
    }

    private static int[] fun(int[] nums) {

        int start = 0;
        int end = nums.length - 1;

        while (start < end) {
            while (start < end && nums[start] != 0) {
                start++;
            }
            while (end > start && nums[end] == 0) {
                end--;
            }
            if (start < end) {
                int swap = nums[start];
                nums[start] = nums[end];
                nums[end] = swap;
            }
        }
        return nums;
    }
    

}