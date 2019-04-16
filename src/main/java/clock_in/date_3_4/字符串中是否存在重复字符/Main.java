package clock_in.date_3_4.字符串中是否存在重复字符;

public class Main {
    public static void main(String[] args) {
        String a = "abcda";
        System.out.println(fun(a));
    }

    /**
     * 如果为ASCII字符，那么用一个长度为128的数组，去记录每个字符出现的次数，如果出现次数>2，那么returnfalse
     * @param a
     * @return
     */
    public static boolean fun(String a){
        int[] arry = new int[128];
        for (int i = 0; i < a.length(); i++) {
            //a中的字符对应的ASCII码++
            arry[a.charAt(i)]++;
            if (arry[a.charAt(i)] == 2)
                return false;
        }
        return true;
    }
}
