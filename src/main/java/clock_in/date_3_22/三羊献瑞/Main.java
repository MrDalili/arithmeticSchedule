package clock_in.date_3_22.三羊献瑞;

import org.ietf.jgss.Oid;
import org.junit.Test;

public class Main {
    public static void main(String[] args) {
        int[] a = new int[]{1,1,1,1,1,1,1,1,1,1};
        int[] b = new int[a.length];
        fun(a,b,0,4);
    }


    public static void fun(int[] data , int b[] ,int k,int glod){
        System.out.println(k);
        //如果一次的交换完成
        if ( k == data.length-1 ){
            if ( glod == 0){
                //判断是否满足条件
                int[] array = new int[4];
                int index = 0;
                //将选出来的数放进来
                for (int i = 0; i < b.length; i++) {
                    if (b[i] == 1){
                        array[index] = i;
                        index++;
                    }
                }
                //求全排列做运算
                fun1(array,0);
            }
        }
        for (int i = 0; i < Math.min(data[i],glod); i++) {
            b[k] = i;
            fun(data,b,k+1,glod-i);
        }
        //回溯
        b[k] = 0;
    }

    private static void fun1(int[] array, int k) {
        if (k == array.length-1){
            //此为一种情况，对该种情况进行判断
            //将数字转化为字符串
            String num = "1";
            for (int i = 0; i < array.length; i++) {
                num += i;
            }
            for (int i = 0; i <=9 ; i++) {
                String num1 = "1"+num.charAt(1)+i+num.charAt(3);
                for (int p = 0; p <=9 ; p++) {
                    for (int j = 0; j <=9 ; j++) {
                        String num2 = p +num.charAt(3)+num.charAt(2)+j+"";
                        int num11= Integer.parseInt(num1);
                        int num22 = Integer.parseInt(num2);
                        int num00 = Integer.parseInt(num);
                        if (num11+num22 == num00){
                            System.out.println(num11+"+"+num22+"="+num00);
                        }
                    }
                }
            }


        }
        for (int i = k; i <= array.length; i++) {
            int temp = array[i]; array[i] = array[k]; array[k] = temp;
            fun1(array,k+1);
            //回溯
            temp = array[i]; array[i] = array[k]; array[k] = temp;
        }
    }

    @Test
    public  void  fun(){
        for (int q = 10000; q <19999 ; q++) {
            String num1 = q+"";
            for (int i = 0; i <= 9 ; i++) {
                String num11 = "1"+num1.charAt(1)+i+num1.charAt(3);
                for (int p = 1; p <=9 ; p++) {
                    for (int j = 0; j <=9 ; j++) {
                        String num22 = p +""+num1.charAt(3)+""+num1.charAt(2)+j+"";
                        int n1 = Integer.parseInt(num11);
                        int n2 = Integer.parseInt(num22);
                        if (n1+n2 == q ){
                            if (num1.charAt(4)!=num11.charAt(2) && num22.charAt(0)!=num1.charAt(0)&&num22.charAt(0)!=num1.charAt(1)&&
                            num22.charAt(0)!=num1.charAt(2)&&num22.charAt(0)!=num1.charAt(3)&&
                                    num22.charAt(0)!=num1.charAt(4)&&num1.charAt(0)!=num1.charAt(1)&&num1.charAt(0)!=num1.charAt(2)&&
                                    num1.charAt(0)!=num1.charAt(3)&&num1.charAt(0)!=num1.charAt(4)&&num1.charAt(1)!=num1.charAt(2)&&
                                    num1.charAt(1)!=num1.charAt(3)&&num1.charAt(1)!=num1.charAt(4)&&num1.charAt(2)!=num1.charAt(3)&&
                                    num1.charAt(2)!=num1.charAt(4)&&num1.charAt(3)!=num1.charAt(4)&&num22.charAt(3)!=num1.charAt(0)
                                    &&num22.charAt(3)!=num1.charAt(1)&&num22.charAt(3)!=num1.charAt(2)&&num22.charAt(3)!=num1.charAt(3)
                                    &&num22.charAt(3)!=num1.charAt(4)&&num22.charAt(2)!=num11.charAt(2)&&num22.charAt(3)!=num11.charAt(2)
                                    &&num11.charAt(2)!=num1.charAt(0)&&num11.charAt(2)!=num1.charAt(1)&&num11.charAt(2)!=num1.charAt(2)
                                    &&num11.charAt(2)!=num1.charAt(3)&&num11.charAt(2)!=num1.charAt(4)&&num22.charAt(0)!=num11.charAt(2))
                            System.out.println(n1+"+"+n2+"="+q);
                        }
                    }
                }
            }

        }
        }


}
