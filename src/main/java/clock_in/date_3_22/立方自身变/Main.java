package clock_in.date_3_22.立方自身变;

import java.util.ArrayList;

/**
 * 也可以用
 *      字符串、
 *      我用的list
 */
public class Main {
    public static void main(String[] args) {
        for (int i = 0; i < 10000; i++) {
            long a = (long) Math.pow(i,3);
            ArrayList<Long> set = fun(a);
            int count = 0;
            for (Long aLong : set) {
                count += aLong;
            }
            if (count == i){
                System.out.println(i);
            }
        }
    }


    public static ArrayList<Long> fun(long i){
        ArrayList<Long> set = new ArrayList<Long>();
        while (i != 0){
            set.add(i%10);
            i = i/10;
        }
        return set;

    }
}
