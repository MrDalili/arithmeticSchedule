package clock_in.date_3_23.日期问题;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        //接受输入的值
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        //对该字符串进行分割
        String[] a = str.split("/");
        //对字符串进行重组
        //a ---- aa/bb/cc
        //b ---- cc/aa/bb
        //c ---- cc/bb/aa
        String[] b = new String[]{a[2],a[0],a[1]};
        String[] c = new String[]{a[2],a[1],a[0]};
        //将三个数组放进list中
        List<String[]> lis = new ArrayList<String[]>();
        lis.add(a);
        lis.add(b);
        lis.add(c);
        //对数组a进行判断,添加年份
        for (String[] strings:lis){
            if (Integer.parseInt(strings[0])<=59){
                strings[0] = "20"+strings[0];
            }else {
                strings[0] = "19"+strings[0];
            }
        }
        //对list进行排序
        while (lis.size() != 0){
            //每次找出最小的日期
            int minIndex = 0;
            for (int i = 0; i < lis.size(); i++) {
                //比较年份
                int minYear = Integer.parseInt(lis.get(minIndex)[0]);
                int thisYear = Integer.parseInt(lis.get(i)[0]);
                if (minYear < thisYear){
                    continue;
                }else if (minYear > thisYear){
                    minIndex = i;
                }else {
                    //出现年份相同，那么比较月份
                    int minMonth = Integer.parseInt(lis.get(minIndex)[1]);
                    int thisMonth = Integer.parseInt(lis.get(i)[1]);
                    if (minMonth < thisMonth){
                        continue;
                    }else if (minMonth > thisMonth){
                        minIndex = i;
                    }else {
                        //出现年份月份相同，那么比较日
                        int minDay = Integer.parseInt(lis.get(minIndex)[2]);
                        int thisDay = Integer.parseInt(lis.get(i)[2]);
                        if (minDay < thisDay){
                            continue;
                        }else {
                            minIndex = i;
                        }
                    }
                }
            }
            String date = lis.get(minIndex)[0]+"-"+lis.get(minIndex)[1]+"-"+lis.get(minIndex)[2];
            System.out.println(date);
            lis.remove(minIndex);
        }
    }
}
