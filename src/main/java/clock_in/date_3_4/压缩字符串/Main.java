package clock_in.date_3_4.压缩字符串;

import com.sun.deploy.net.cookie.CookieUnavailableException;

public class Main {
    public static void main(String[] args) {
        System.out.println(fun("aaaaabbbbbcccccddddddabcd"));
    }
    //使用stringBuilder
    public static String fun(String str){
        //用来统计一个字母出现的次数
        int count = 0;
        //用来记录上一次出现的字母
        char lastchar = ' ';
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < str.length(); i++) {
            //去出当前的字符
            char varchar = str.charAt(i);
            //判断是否为第一次，如果为第一次直接初始化
            if (sb.length() == 0) {
                sb.append(varchar);
                count++;
            }else if (varchar != lastchar){
                //查看当前的字母是否与上一次字母相等，如果不相等那么直接将出现次数追加，以及将新的字母追加，初始化出现次数为1
                sb.append(count);
                sb.append(varchar);
                count = 1;
            }else if (varchar == lastchar){
                //如果与上一次出现的字母相等那么次数++
                count++;
            }
            //将此次的字母记录下来
            lastchar = varchar;
        }
        sb.append(count);
        //判断长度是否比原来的短，如果短则返回原先的
        if (sb.length()>str.length()){
            return str;
        }
        return sb.toString();
    }
}
