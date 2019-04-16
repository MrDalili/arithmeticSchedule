package clock_in.date_3_4.替换字符串中的空格;

import javax.sound.midi.Soundbank;

public class Main {
    public static void main(String[] args) {
        System.out.println(fun("a b c 11111111111111",6));
    }
    public static  String fun(String str ,int length){
        char[] a = str.toCharArray();
//        //判断其中有多少个空格
//        int count = 0;
//        for (int i = 0; i < a.length; i++) {
//            if (' ' == a[i]){
//                count += 3;
//            }
//        }
        //定义俩个指针，p1用来遍历数组，p2用来填充数组
        int b = 0 ;
        for (int p1 = length-1 , p2=a.length-1 ; p1 >=0 ; p1--) {
            if (a[p1] == ' '){
                a[p2--]='0';
                a[p2--]='2';
                a[p2--]='%';
            }else {
                a[p2--]=a[p1];
            }
            b= p2;
        }
        //字符数组转化为字符串需要用newString
        String c = new String(a);
        return c.substring(b+1,c.length());
    }
}
