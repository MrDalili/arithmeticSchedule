package clock_in.date_3_23.包子凑数;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] baozi = new int[n];
        for (int i = 0; i < baozi.length; i++) {
            baozi[i] = scanner.nextInt();
        }

        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < 10000; i++) {
            if (!f(i,baozi))
                list.add(i);
        }

        for (Integer integer : list) {
            System.out.println(integer);
        }
    }

    static boolean f(int num,int[] baozi){
        if (num == 0)
            return true;
        if (num < 0)
            return false;
        for (int i = 0; i <baozi.length ; i++) {
            if (f(num-baozi[i],baozi))
                return true;
        }
        return false;
    }
}
