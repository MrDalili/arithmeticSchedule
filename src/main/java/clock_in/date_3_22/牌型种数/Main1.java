package clock_in.date_3_22.牌型种数;

public class Main1 {
    static int coun = 0;
    public static void main(String[] args) {
        dfs(0,0);
        System.out.println(coun);
    }

    private static void dfs(int dianshu, int count) {
        if (count > 13)return;
        if (dianshu > 13) return;
        if (dianshu == 13){
            if (count == 13)
                coun++;
        }
        for (int i = 0; i < 5; i++) {
            count += i;
            dfs(dianshu+1,count);
            count -=i;
        }
    }


}
