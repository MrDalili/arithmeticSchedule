package 蓝桥杯培训;

public class 动态规划之最短路径问题 {
    static int[][] tu = new int[][]{
            {0,2,4,0,0,0,0},
            {0,0,0,3,3,1,0},
            {0,0,0,1,3,1,0},
            {0,0,0,0,0,0,1},
            {0,0,0,0,0,0,3},
            {0,0,0,0,0,0,4},
            {0,0,0,0,0,0,0}
    };
    //存放每个点向后节点的最小值
    static int[][] min = new int[7][7];
    public static void main(String[] args) {
        //计算出每个点到最后一个点的最短距离
        for (int i = tu.length-2 ; i >= 0 ; i++) {

        }
    }
}
