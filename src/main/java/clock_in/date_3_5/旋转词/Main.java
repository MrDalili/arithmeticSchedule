package clock_in.date_3_5.旋转词;

public class Main {
    public static void main(String[] args) {
        System.out.println(fun("ab","bca"));
    }

    /**
     *
     * @param str1 给定的旋转词的集合
     * @param str2 原字符串
     * @return
     */
    public static boolean fun(String str1,String str2){
        if (str1.length() != str2.length()){
            return false;
        }
        StringBuffer sb = new StringBuffer(str1).append(str1);
        return sb.toString().contains(str2);
    }
}
