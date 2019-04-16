package clock_in.date_3_5.去掉字符串中连接出现的k次的0;

public class Main {
    public static void main(String[] args) {
        System.out.println(fun2("A00000B0000000",2));
    }

    //方法1、正则表达
    //方法2、使用tongji
    public static String fun2(String str,int k){
        StringBuffer sb = new StringBuffer();
        //用来统计出现的0的次数
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if ('0'==str.charAt(i)){
                //如果当前位置为0，那么次数++
                count++;
            }else {
                //如果不为0，那么将0减至count%k在字符串后面追加
                for (int j = 0; j < count%k; j++) {
                    sb.append("0");
                }
                sb.append(str.charAt(i));
                //恢复0，等待下一次的0的出现
                count = 0;
            }
        }
        //此时需要将最后出现的0追加上
        for (int i = 0; i < count%k ; i++) {
            sb.append("0");
        }
        return sb.toString();
    }
}
