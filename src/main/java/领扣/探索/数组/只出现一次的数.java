package 领扣.探索.数组;

public class 只出现一次的数 {
    public static void main(String[] args) {
        int[] array = new int[]{1,2,3,4,5,6,1,2,3,4,5,6,7};
        System.out.println(fun(array));
    }

    private static int fun(int[] nums) {
        int count  = nums[0];
        for (int i = 1; i < nums.length; i++) {
            count ^= nums[i];
        }
        return count;
    }
}
