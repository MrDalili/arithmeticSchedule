package Tool;

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
}
