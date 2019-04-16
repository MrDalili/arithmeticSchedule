package clock_in.date_3_19.背包问题之黄金矿工;

import java.util.Scanner;

public class Main {
    public static int[][] price;
    static int[][] glodInfo ;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //用于采矿的总人数
        int totalPeople = scanner.nextInt();
        //总金矿数
        int goldOreNum = scanner.nextInt();
        //初始化一个数组二维数组，0------金矿所需要的人数  1-------金矿可以开发出的金子数量
        glodInfo = new int[goldOreNum+1][2];
        //每一种人数代表一种情况
        price = new int[goldOreNum+1][totalPeople+1];
        //循环获取每个金矿所需要的人数以及可以开辟出来的资源
        for (int i = 1; i < glodInfo.length; i++) {
            for (int j = 0; j < 2; j++) {
                glodInfo[i][j] = scanner.nextInt();
            }
        }
        
        //初始化一下用于动态规划的二维数组
        for (int i = 0; i < price.length; i++) {
            for (int j = 0; j < price[i].length; j++) {
                price[i][j] = -1;
            }
        }

        System.out.println(bag(totalPeople, goldOreNum));
    }

    /**
     *
     * @param people 挖矿的人数
     * @param goldNumIndex 金矿的个数
     * @return
     */
    public static int bag(int people , int goldNumIndex){
        //先定义一个可以返回的最大值
        int max;
        //查看这种情况是否出现过，如果出现过就从数组中直接取值,return
        if (price[goldNumIndex][people] != -1){
            return price[goldNumIndex][people];

        }

        //先考虑边界的情况
        //如果已经到了最后一个矿山，剩余人数还大于该矿所需要的人数，那么返回该矿山的金子
        if (goldNumIndex == 0 && people>=glodInfo[goldNumIndex][0]){
            return glodInfo[goldNumIndex][1];
        }

        //如果到了最后一个矿山，生于人数小于矿山需要的人数，则返回0
        if (goldNumIndex == 0 && people<glodInfo[goldNumIndex][0]){
            return 0;
        }

        //如果人数小于当前的人数那么就将金矿的序号-1，返回下一个金矿，如果都不满足，那么就到了index=0且人数不够用的情况
        if (people<glodInfo[goldNumIndex][0]){
            max = bag(people,goldNumIndex-1);
            //将其放进动态规划的库中
            price[goldNumIndex][people] = max;
            return max;
        }
        //获得最大值
        max = Math.max(bag(people-glodInfo[goldNumIndex][0],goldNumIndex-1)+glodInfo[goldNumIndex][1],
                bag(people,goldNumIndex-1));
        //走到这里是因为没有出现这种情况，所以要放进数组
        price[goldNumIndex][people] = max;
        //如果没有到最后一个矿山，那么便进行递归
        return max;
    }
}
