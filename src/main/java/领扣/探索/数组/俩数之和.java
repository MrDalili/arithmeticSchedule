package 领扣.探索.数组;

import java.util.*;

public class 俩数之和 {
    public static void main(String[] args) {
        int[] array = new int[]{1,2,3,4,5,6,7,8,9};
        int count =16;
        System.out.println(Arrays.toString(fun(array,count)));
    }

    private static int[] fun(int[] array, int count) {
        HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < array.length ; i++) {
            int num = count-array[i];
            if (map.containsKey(num)){
                return new int[]{map.get(num),i};
            }
            map.put(array[i],i);
        }
        return null;
    }
}
