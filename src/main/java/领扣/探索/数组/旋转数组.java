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
        int m = 4;
        int[] array = new int[]{1,2,3};
        fun1(array,m);
        System.out.println(Arrays.toString(array));
        array = new int[]{1,2,3,4,5,6};
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
        if(k == 0)
            return;
        //先对k求余
        k = k % nums.length;
        //如果k==0，那么久直接return
        if (k == 0)
            return;
        //计算最因数
        int li = lowestCommonMultiple(nums.length, k);
        //接下来的情况就是向右移动了
        //从第一个开始yidong
        //看length与k之间的关系
            //那就是他要走k轮，从0~k
            for (int j = 0; j < li ; j++) {
                int cache = nums[j];
                int nextCache = nums[j];
                int index = j;
                do {
                    cache = nextCache;
                    index = (index + k) % nums.length;
                    nextCache = nums[index];
                    nums[index] = cache;
                }while (j != index);
            }
        }


    public static int lowestCommonMultiple(int num1 , int num2){
        //意外条件
        if (num1 == 0 || num2 == 0)
            return 1;
        //辗转相除法计算最小公倍数
        int dubbo = 0;
        while (num2 != 0){
            dubbo = num1 % num2;
            num1 = num2;
            num2 = dubbo;
        }
        return num1;
    }
}
