package clock_in.date_2_13;

import java.util.Arrays;

public class InsertSort {
    public static void main(String[] args) {
        int[] a = new int[]{1,3,5,7,2,4,6,8,-1};
        sort(a,a.length-1);
        System.out.println(Arrays.toString(a));
    }


    public static void sort(int[] arry,int k){
        //递归出口，如果下标==0时，不做处理
        if (k == 0)
            return;
        //k！=0时
        sort(arry,k-1);
        //记录此次该做判断的值
        int num = arry[k];
        //记录当前要插入的最后一个数的下标
        int index = k-1;
        //如果插入的下标还=>0，如果当此次需要插入的值小于要index中的值
        while (index>-1&&num<arry[index]){
            //将index中的值向后移一位
            arry[index+1] = arry[index];
            //index--继续判断
            index--;
        }
        //循环结束时，即在0-index范围内为最大的值，放在index+1的位置
        arry[index+1] = num;
    }
}
