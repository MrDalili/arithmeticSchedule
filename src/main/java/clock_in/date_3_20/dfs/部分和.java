package clock_in.date_3_20.dfs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 部分和 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int[] array = new int[num];
        for (int i = 0; i < num; i++) {
            array[i] = scanner.nextInt();
        }
        int result = scanner.nextInt();

        dfs(array,0,result,new ArrayList<Integer>(),0,result);


    }

    static void dfs(int[] array, int i, int result, ArrayList<Integer> integers,int index,int r){
        //判断边界
        //满足的情况
        if (result == 0){
            String s = "YES("+r+"=";
            for (Integer integer : integers) {
                s +=integer+"+";
            }
            s = s.substring(0,s.length()-1);
            s+=")";
            System.out.println(s);
        }
        //不满足的情况
        if (i==array.length || result<0)
            return;
        //状态转移
        integers.add(array[i]);
        //要么使用当前的数字进行求和
        dfs(array,i+1,result-array[i],integers,index+1,r);
        integers.remove(index);
        //要么不使用当前的数字进行求和，下标+1
        dfs(array,i+1,result,integers,index,r);
    }
}
