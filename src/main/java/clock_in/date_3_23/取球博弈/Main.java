package clock_in.date_3_23.取球博弈;

public class Main {
    public static void main(String[] args) {
        int num = 100;
        System.out.println(f(100));
    }

    private static boolean f(int i) {
        if (i == 0) return true;
        if (i>=1 && f(i-1) == false) return true;
        return false;
    }
}
