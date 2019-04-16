package clock_in.date_3_11.机器人走格子;

public class Main {
    public static void main(String[] args) {
        System.out.println(recursion(3,3));
        System.out.println(iteration(3,3));
    }
    
    public static int recursion(int x , int y){
        if (x==1||y==1) return 1;
        return recursion(x-1,y)+recursion(x,y-1);
    }
    
    public static int iteration(int x, int y){
        int[][] state = new int[x+1][y+1];
        //先对数组进行初始化
        for (int i = 1; i <= x ; i++) {
            state[i][1] = 1;
        }
        for (int i = 1; i <= y ; i++) {
            state[1][i] = 1;
        }
        for (int i = 2; i <= y; i++) {
            for (int j = 2; j <=x ; j++) {
                state[j][i] = state[j-1][i] + state[j][i-1];
            }
        }
        return state[x][y];
    }
}
