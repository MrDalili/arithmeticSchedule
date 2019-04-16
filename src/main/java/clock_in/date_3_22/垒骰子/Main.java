package clock_in.date_3_22.垒骰子;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    static Map<Integer,Integer> touZiMap = new HashMap<Integer,Integer>();
    static Map<Integer,Integer> duiLiMap = new HashMap<Integer,Integer>();
    public static void main(String[] args) {
        //接受参数
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        for ( int i = 0; i < m; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            duiLiMap.put(x,y);
            duiLiMap.put(y,x);
        }
        //初始化touziMap
        init(touZiMap);
        int count = 0;
        //从1~6对第一个🎲进行分类
        for (int down = 1; down <= 6; down++) {
            count += f(touZiMap.get(down),n-1);
        }
        System.out.println(count);
    }

    /**
     *
     * @param down 第一个骰子面朝上的点数
     * @param i 骰子数
     */
    private static int f(int down, int i) {
        int ans = 0;
        if (i == 0) return 4;
        //骰子也有6种可能
        for (int up = 1; up <=6 ; up++) {

            //查看对立面,如果是对立面的一种，那么continue
            if (duiLiMap.containsKey(up)){
                if (duiLiMap.get(up) == down)
                    continue;
            }
            //不是队里面那么继续进行递归
            ans += 4*f(touZiMap.get(up),i-1);
        }
        return ans;
    }

    //初始化
    public static void init(Map map){
        map.put(1,4);
        map.put(2,5);
        map.put(3,6);
        map.put(4,1);
        map.put(5,2);
        map.put(6,3);
    }
}
