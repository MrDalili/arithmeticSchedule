package clock_in.date_3_22.饮料换购;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int num = f(n);
        System.out.println(num);
    }

    private static int f(int pingGai) {
        if (pingGai < 3)
            return 0;
        int num = pingGai/3;
        return num+f(num+pingGai%3);
    }
}
