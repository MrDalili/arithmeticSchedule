package 领扣.探索.数组;

import java.util.Scanner;

/**
 * delete duplicates in a sorted array
 */
public class 从排序数组中删除重复项 {
    //这个是我一开始的思路，但是提交了以后发现有更牛的代码，参考了一下。。确实思路新奇
    private static int fun(int[] array) {
        //记录该数为第几个与前面不相同的数
        int count = 0;
        //循环从到尾判断即可
        //可以优化，判断一下最后一个数，如果最后一个数出现多次，那么第一次出现就直接返回了
        for (int i = 1; i < array.length; i++) {
            if (array[i] == array[i-1]){
                //如果这个数与它的前一个数相同，那么count++
                count++;
            }else {
                //如果不相同，那么把这个数向前移动count个位数
                array[i-count] = array[i];
            }
        }
        return array.length-count;
    }

    public static int fun1(int[] array){
        //记录非重复数字的个数
        int count = 0;
        //循环，遇见一个不一样的，就count++，把不一样的往前移
        for (int i = 1; i < array.length; i++) {
            if (array[i] != array[count]){
                //如果当前的这个数与非重复的数不相同，那么证明又多了一个数
                count++;
                //此时交换一下位置，将下标为i的这个数，放在count下标上，因为count这个数代表的就是现在有几个不一样的数，-1后就为这个数的第一次出现的下标
                array[count] = array[i];
            }
        }
        return count+1;
    }
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int[] n = new int[scanner.nextInt()];
        int[] n = new int[]{0,0,2,2,3,4,5,6,6,6,7,7,8,9,9,9};
        int length = fun1(n);
        for (int i = 0; i < length ; i++) {
            System.out.print(n[i]+" ");
        }
    }

}
