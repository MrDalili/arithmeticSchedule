package clock_in.date_3_5.最短摘要的生成;

import java.lang.reflect.Array;
import java.security.AlgorithmConstraints;
import java.util.Arrays;

//最短摘要的生成
public class Main {
    public static void main(String[] args) {
        fun1(new String[]{"aaa","eee","bbb","ccc","aaa","ddd","eee","ccc","aaa","eee","ccc"},new String[]{"aaa","eee","ccc"});
    }
    //定义一个begin，一个end，记录上一次最短摘要的位置
    public static void fun1(String[] strings , String[] words){
        //预定义最短摘要的位置
        int begin = -1;
        int end = -1;
        int p1 = -1;
        int p2 = -1;
        //定义一个和关键字数组一样长度的数组，用来判断其是否找全
        int[] flag = new int[words.length];
        //对全文进行遍历，查看关键词
        for (int i = 0; i < strings.length ; i++) {

            if (include(strings[i],words) != -1){
                //如果不是第一次，那么每次需要把上一次的bengin给消除
                if (p1 != -1)
                    To0(flag,strings[p1],words);
                p1 = i;
                //重置为0，只需把上一个begin的值重置即可，因为中间区间的还需要判断

                //该词为关键词,将flag中该关键词的下标设为1
                flag[include(strings[i],words)] = 1;
            }else {
                continue;
            }

            int j = -1;

            if (p2 != -1){
                j = p2;
            }else {
                j = i+1;
            }

            //第二个指针寻找剩余的关键字
            for (;  j< strings.length; j++) {
                //如果找到了，且其是新找到的
                if (include(strings[j],words) != -1 ){
                    //那么就是第二个指针找到了关键字
                    //将其对应的下标置为1
                    flag[include(strings[j],words)] = 1;
                    //判断flag是否全齐
                    if (addFlag(flag) == flag.length){
                        //因为有了就置1，看长度即可
                        p2 = j;
                        //判断当前的长度跟原先的长度，谁短，短的话跟新
                        if (begin == -1 && end == -1){
                            begin = p1;
                            end = p2;
                            break;
                            }else {
                            int length = end - begin +1;
                            if (length > p2 - p1 +1){
                                begin = p1;
                                end = p2;
                            }
                                break;

                        }
                    }
                }else {
                    continue;
                }
            }
        }
        System.out.println(begin+":"+end);
        for (int i = begin; i <= end; i++) {
            System.out.print(strings[i]+" ");
        }
    }

    private static int addFlag(int[] flag) {
        int count = 0 ;
        for (int i = 0; i < flag.length; i++) {
            count += flag[i];
        }
        return count;
    }

    private static void To0(int[] flag,String p1,String[] words) {
        int index = include(p1,words);
        flag[index] = 0;
    }

    private static int include(String string,String[] words) {
        for (int i = 0; i <words.length ; i++) {
            if (string.equals(words[i]))
                return i;
        }
        return -1;
    }


}
