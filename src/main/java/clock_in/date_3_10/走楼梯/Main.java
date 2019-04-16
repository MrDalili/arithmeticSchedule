package clock_in.date_3_10.走楼梯;

import jdk.nashorn.internal.ir.IfNode;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        System.out.println(recursion(10));
        System.out.println(interation(10));
    }

    public static int recursion(int stairs){
        if (stairs <= 0) return 0;
        if (stairs == 1) return 1;
        if (stairs == 2) return 2;
        return recursion(stairs-1)+recursion(stairs-2)+recursion(stairs-3);
    }

    public static int interation(int stairs){
        if (stairs == 0) return 0;
        if (stairs == 1) return 1;
        if (stairs == 2) return 2;
        int x0 = 0;
        int x1 = 1;
        int x2 = 2;
        for (int i = 3; i <= stairs ; i++) {
            int v0 =x1;
            int v1 = x2;
            x2 = x0 + x1 + x2;
            x0 = v0;
            x1 = v1;
        }
        return x2;
    }
}
