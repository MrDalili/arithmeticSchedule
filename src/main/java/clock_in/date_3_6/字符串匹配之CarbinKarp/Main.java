package clock_in.date_3_6.字符串匹配之CarbinKarp;

import javax.sound.midi.Soundbank;

public class Main {
    //思路，在朴素的基础上进行hash
    //求每个需要匹配字符串长度的hash，在原串中
    //然后与字串hash进行比较，得出相同的返回下标即可
    public static void main(String[] args) {
        fun("acsadabcqeasdadwgjklikujyhtgfdcmu,ytrfdabc","mu,yt");
    }

    /**
     *使用hash散列来求字符串
     * 第一、先将子串的hash值算出来
     * 第二、将原串的hash值也算出来
     * 第三、进行匹配
     * 第四、得出结果
     * @param str 原串
     * @param substring 需要匹配的子串
     * @return
     */
    public static void fun(String str , String substring){
        //先计算出substring子串的hash值
        int hashsb = 0 ;
        for (int i = 0; i < substring.length(); i++) {
            hashsb += hashsb*31 + substring.charAt(i);
        }
        //算出原字符串中可以有多少个长度与子串相同的字符串
        int lenth = str.length() - substring.length()+1;
        //定义一个新数组，用来存放hash的
        int[] hashArray = new int[lenth];
        //在求出str中长度为substring.length的子串的哈希,只需要求满足长度的即可
        for (int i = 0; i < lenth ; i++) {
            //这个是求每一个下标开头，满足子串长度的字符串的hash，并在数组中记录下来
            for (int j = i; j <substring.length()+i ; j++) {
                hashArray[i] += hashArray[i]*31 +str.charAt(j);
            }
        }

        //遍历hash数组与子串的hash作比较
        for (int i = 0; i < hashArray.length; i++) {
            //判断哈希值是否相同
            if (hashArray[i] == hashsb){
                //判断hash值相同的情况下，验证一下是否真的相同，可能会出现hash紊乱
                StringBuffer sb = new StringBuffer();
                for (int j = i; j < substring.length()+i; j++) {
                    sb.append(str.charAt(j));
                }

                if (substring.equals(sb.toString())){
                    System.out.println("下标为:"+i);
                }
            }


        }
    }
}
