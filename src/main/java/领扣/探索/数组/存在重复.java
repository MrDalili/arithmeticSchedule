package 领扣.探索.数组;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class 存在重复 {
    public static void main(String[] args) {
        int[] nums = new  int[]{1,2,3,1};
        System.out.println(fun(nums));
        nums = new  int[]{1,2,3,4,57,7};
        System.out.println(fun1(nums));
    }



    /**
     * 方法一:
     *      排序了以后看这个数的左边和右边是不是一样，一样的话就说明有重复,这里的排序还可以优化
     */
    private static boolean fun(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i-1]){
                return true;
            }
        }
        return false;
    }

    /**
     * 方法二：
     *      使用set去重，最后看size和length的比较
     */

    private static boolean fun1(int[] nums) {
        Set set = new HashSet();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        if (set.size() == nums.length)
            return false;
        return true;
        }
    }
