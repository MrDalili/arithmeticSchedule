package clock_in.date_3_23.k倍区间;

import java.util.Scanner;

public class Main {
    static int num = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }

        for (int i = 0; i < array.length; i++) {
            for (int j = array.length-1; j >= i ; j--) {
                int count = 0;
                for (int l = j; l >= i; l--) {
                    count+=array[l];
                }
                if (count % k == 0)
                    num++;
            }
        }

        System.out.println(num);
    }
}
