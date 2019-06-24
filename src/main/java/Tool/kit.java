package Tool;

import org.junit.Test;

public class kit {
    /**
     * 给定一个数组，交换给定下标的俩个数
     * @param array 给定数组
     * @param index1 需要交换位置的元素1
     * @param index2 需要交换位置的元素2
     */
    public static void swapNum(int[] array,int index1,int index2){
        int a = array[index1];
        array[index1] = array[index2];
        array[index2] = a;
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

    @Test
    public void lowerCommonMultiple(){
        System.out.println(lowestCommonMultiple(12,16));
    }
}
