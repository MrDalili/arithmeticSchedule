package clock_in.date_3_22.加法变乘法;

import java.util.HashSet;
import java.util.Set;

public class Main {
    static Set<String> set = new HashSet<String>();
    public static void main(String[] args) {

        f(2015,49,"");
        for (String s : set) {
            if (check(s)){
                System.out.println(s);
            }
        }
    }

    private static boolean check(String s) {
        int count = 0;
        for (int i = 0; i < s.length() ; i++) {
            if (s.charAt(i) == '*')
                count++;
        }
        if (count == 2)
            return true;
        return false;
    }

    private static void f(int num, int i,String str) {
        if (i==0&&num==0){
            set.add(str);
        }
        if (i<0||num<0)
            return;
        f(num-i,i-1,str+"+"+i);
        int count = i*(i-1);
        str +=  "+"+i+"*"+(i-1)+"";
        f(num-count,i-2,str);
    }


}
