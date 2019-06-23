package 领扣.探索.数组;

import java.util.Arrays;
import java.util.Scanner;

public class 旋转数组 {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int k = scanner.nextInt();
//        int m = scanner.nextInt();
//        int[] array = new int[k];
//        for (int i = 0; i < array.length ; i++) {
//            array[i] = scanner.nextInt();
//        }
        int m = 2;
        int[] array = new int[]{1,2,3,4,5,6,7,8};
        fun1(array,m);
        System.out.println(Arrays.toString(array));
        array = new int[]{1,2,3,4,5,6,7};
        fun2(array,m);
        System.out.println(Arrays.toString(array));
    }

    /**
     * 最垃圾的，一次一次往右边移动,用到中间变量了
     */
    private static void fun1(int[] nums, int k) {
        //循环n次，向右移动n次
        for (int i = 0; i < k; i++) {

            int a = nums[0];
            int b = nums[0];
            int flag =0;
            for (int j = 1; j < nums.length; j++) {
                if (j == nums.length - 1){
                    nums[0] = nums[nums.length-1];
                    if (flag % 2 ==0)
                        nums[j] = b;
                    else
                        nums[j] = a;
                    continue;
                }
                if (flag % 2 ==0) {
                    a = nums[j];
                    nums[j] = b;

                }
                else{
                    b = nums[j];
                    nums[j] = a;
                }
                flag++;
            }

        }
    }

    /**
     * 还算可以的，对k取模，然后一次移到位
     */
    private static void fun2(int[] nums, int k){
        //先对k求余
        k = k % nums.length;
        //如果k==0，那么久直接return
        if (k == 0)
            return;
        //接下来的情况就是向右移动了
        //从第一个开始yidong
        int start = 0;
        int i = 0;
        //看length与k之间的关系
        if (nums.length % k ==0){
            //那就是他要走k轮，从0~k
            for (int j = 0; j < k ; j++) {
                int index = j;
                int cache;
                while (j != index){
                    cache = nums[j];
                    int nextIndex = (index + k) % nums.length;
                    nums[i] = nums[nextIndex];
                    nums[nextIndex] = cache;
                }
            }
        }else {
            //
            int index = 0;
            int cache;
            do {
                cache = nums[index];
                int nextIndex = (k + index) % nums.length;
                nums[index] = nums[start];
                nums[nextIndex] = cache;
            }while (index == start);
        }
    }
}
