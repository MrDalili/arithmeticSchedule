package 领扣.探索.数组;

import data_structure.array.Array;

import java.util.Arrays;

public class 加一 {
    public static void main(String[] args) {
        int[] a1 = new int[]{1,2};
        int[] a2 = new int[]{1,9,9};
        int[] a3 = new int[]{9,9,9};
        System.out.println(Arrays.toString(fun1(a1)));
        System.out.println(Arrays.toString(fun1(a2)));
        System.out.println(Arrays.toString(fun1(a3)));

    }

    private static int[] fun1(int[] nums) {
        //从最后一个开始遍历
        int i = nums.length-1;
        //如果==9，那么让这一位==0，再去看前一个
        while (i >= 0 && nums[i] == 9){
            nums[i] = 0;
            i--;
        }
        //如果i到-1了,那么就是这个数组全都是9，要添加一位
        if (i == -1){
            int[] a = new int[nums.length+1];
            //第一位=0，剩余都为1
            a[0] = 1;
            for (int j = 1; j < a.length; j++) {
                a[j] = 0;
            }
            return a;
        }else {
            //那就是第一个非9为位+1
            nums[i] = nums[i]+1;
        }
        return nums;
    }
}
