package clock_in.date_3_4.判断变形词问题;

public class Main {
    public static void main(String[] args) {

        String a = "abadadadca";
        String b = "aacbvadadad";
        System.out.println(fun1(a,b));
    }

    public static boolean fun1(String s1,String s2){
        int[] flag = new int[128];
        //将第一个字符串中出现的字符放进flag中ascii码所对应的下标中，并++
        for (int i = 0; i < s1.length(); i++) {
            flag[s1.charAt(i)]++;
        }
        //遍历s2，酶出现一个就在其对应的ASCII码--，出现负数，或者！=的return flase；
        for (int i = 0; i < s2.length(); i++) {
            flag[s2.charAt(i)]--;
            if (flag[s2.charAt(i)]<0)
                return false;
        }

        //判断其中是否有！=0的数
        for (int i = 0; i < flag.length ; i++) {
            if (flag[i] != 0)
                return false;
        }
        return true;
    }
}
