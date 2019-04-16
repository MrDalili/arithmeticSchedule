package clock_in.date_3_5.将字符串中按单词翻转;

public class Main {
    public static void main(String[] args) {
        System.out.println(reverseWord("here you are fuck you"));
    }

    public static String reverseWord(String str){
        //先将整个字符串反转
        String sb = new String(reversalString(str));
        //在对每个一单词进行反转
        //将字符串以空格分隔
        String[] s = sb.split(" ");
        //新建一个stringBuffer用来接收字符串
        StringBuffer sb1 = new StringBuffer();
        for (int i = 0; i < s.length; i++) {
            sb1.append(reversalString(s[i])+" ");
        }
        //多加了一个空格，最后去掉
        sb1.deleteCharAt(sb1.length()-1);
        return sb1.toString();
    }

    //将字符串反转返回
    public static String reversalString(String str){
        StringBuffer sb = new StringBuffer(str);
        return sb.reverse().toString();
    }
}
