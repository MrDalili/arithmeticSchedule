package clock_in.date_3_23.尼姆堆;

public class Main {
    public static void main(String[] args) {
        int[] a = {2,5,12,14};
        f(a);
    }

    private static void f(int[] a) {
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum ^= a[i];
        }
        if (sum == 0){
            System.out.println("输"); return;
        }
        for (int i = 0; i < a.length; i++) {
            int x = sum^a[i];
            if (x <a[i])
                System.out.println(a[i]+"-->"+x);
        }
    }
}
