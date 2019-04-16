package clock_in.date_3_6.让人头皮发麻的kmp算法;

import javax.sound.midi.Soundbank;

public class Main {
    public static void main(String[] args) {
        KMP("abcabababcab","ab");
    }

    public static void KMP(String s , String p){
        //先考虑特殊情况
        if (p.length() == 0) return;
        if (s.length() < p.length()) return;
        //先根据p计算出其的next数组
        int[] next = next(p);
        //求出next数组后，开始使用i，j遍历原串与子串
        int i = 0;//在s上的指针
        int j = 0 ;//在p上面的指针
        int sLen = s.length();
        int pLen = p.length();
        //开始遍历
        while (i < sLen){
            if (j == pLen )
                break;
            //①如果j=-1，或当前字符匹配成功时，（即s[i]=p[i]），都令i++，j++
            //j=-1，因为next[0]=-1,说明p的第一位和i这个位置无法匹配，这时i，j都增加1，i移位，j从0开始
            if ( j == -1 || s.charAt(i) == p.charAt(j)){
                //说明匹配成功
                i++;
                j++;
            }else {
                //②如果j！=-1，且当前字符匹配失败，（即s[i] != p[i]）,则令i不变，j=next[j]
                //next[j]对应的时j对应的next值
                j=next[j];
            }

            //如果j的长度等于了子串的长度
            if (j == pLen){
                System.out.println(i - j );
                //将j恢复
                i = i - j + 1;
                j = 0;

            }
        }
        System.out.println("无");
    }

    private static int[] next(String p) {
        int pLen = p.length();
        int[] next = new int[pLen];
        char[] ps = p.toCharArray();
        //初始化next的第一个
        next[0] = -1;
        //如果子串长度为1，那么直接返回
        if (p.length() == 1){
            return next;
        }
        next[1] = 0;

        int j = 1;
        int k = next[j];//看看k的最长匹配前缀在哪里

        while (j<pLen-1){
            //现在要推出next[j+1],检查j和k位置上的关系即可
            if (k<0 || ps[j]==ps[k]){
                //如果k<0，那么就是无匹配，j++，k=0即可，
                //如果匹配成功那么，j++，k++
                next[++j] = ++k;
            }else {
                //否则就递推出k的值
                k = next[k];
            }
        }
        return next;
    }
}
