package 领扣.探索.数组;

import java.util.Arrays;
import java.util.Scanner;

public class 旋转数组 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        int m = scanner.nextInt();
        int[] array = new int[k];
        for (int i = 0; i < array.length ; i++) {
            array[i] = scanner.nextInt();
        }
        System.out.println(Arrays.toString(fun(array,m)));
    }

    private static int[] fun(int[] nums, int k) {
        return nums;
    }
}
