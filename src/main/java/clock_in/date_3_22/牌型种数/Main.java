package clock_in.date_3_22.牌型种数;

import com.sun.media.sound.FFT;

public class Main {
    static int count = 0;

    public static void main(String[] args) {
        int[] data = new int[]{4,4,4,4,4,4,4,4,4,4,4,4,4};
        int[] help = new int[data.length];
        ff(data,help,13,0);
       // f1(help,13,0);
        System.out.println(count);
    }
    public static void ff(int[] data , int[] help ,int glod ,int k){
        if (k == help.length){
            if (glod == 0) {
                count++;
            }
            return;
        }
        for (int i = 0; i <= Math.min(glod,data[k]); i++) {
           help[k] = i;
           ff(data,help,glod-i,k+1);
        }
        help[k] = 0;
    }

    public static void f1   (int[] help , int glod,int k){
        if (k == help.length )
            return;
        if (glod == 0){
            count++;
            return;
        }
        //给每一个都添加东西
        for (int i = 0; i <=4 ; i++) {
            glod -= i;
            help[k] = i;
            f1(help,glod,k+1);
            glod += i;
        }

    }
}
