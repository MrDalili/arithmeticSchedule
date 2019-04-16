package clock_in.date_3_4.判断两字符串的字符集是否相同;

import sun.reflect.generics.tree.VoidDescriptor;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String s1 = "abcde";
        String s2 = "cbadadb";
        System.out.println(fun1(s1,s2));
    }
    //使用HashMap存储
    //思想是使用hash来解决问题
    public static boolean fun1(String s1 , String s2){
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < s1.length(); i++) {
            char varchar = s1.charAt(i);
            if (map.get(varchar) == null){
                //如果map中没有这个字符，那么在map中存入该键
                map.put(varchar,1);
            }
        }

        //判断s2中的字符是否在map中都存在
        for (int i = 0; i < s2.length(); i++) {
            char varchar = s2.charAt(i);
            if(map.get(varchar) != null){
                return false;
            }
        }
        return true;
    }
}
