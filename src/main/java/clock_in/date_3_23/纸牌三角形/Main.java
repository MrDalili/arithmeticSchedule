package clock_in.date_3_23.纸牌三角形;

public class Main {
    static int count = 0;
    public static void main(String[] args) {
        int[] array = new int[]{1,2,3,4,5,6,7,8,9};
        f(array,0);
        System.out.println(count/6);
    }

    private static void f(int[] array, int k) {
        if (k==array.length){
            if (array[0]+array[1]+array[2]+array[3] == array[3]+array[4]+array[5]+array[6]&&
                    array[3]+array[4]+array[5]+array[6] == array[6]+array[7]+array[8]+array[0])
                count++;
                return;
        }
        for (int i = k; i < array.length; i++) {
            int temp = array[i]; array[i] = array[k]; array[k] = temp;
            f(array,k+1);
            temp = array[i]; array[i] = array[k]; array[k] = temp;
        }
    }

}
