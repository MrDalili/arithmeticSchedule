package 领扣.探索.数组;

import data_structure.array.Array;

import java.util.*;

public class 俩个数组的交集II {
    public static void main(String[] args) {
        int[] array1 = new int[]{1,2,2,1};
        int[] array2 = new int[]{2,2};

        System.out.println(Arrays.toString(fun(array1,array2)));
        System.out.println(Arrays.toString(fun1(array1,array2)));
    }

    //hash表的方法
    private static int[] fun(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map = new HashMap<Integer, Integer>();
        //便利第一个数组 key---内容  value---出现的次数
        for (int i = 0; i < nums1.length; i++) {
            //存在的话
            if (map.containsKey(nums1[i])){
                //在原来的次数的基础上+1
                map.put(nums1[i],map.get(nums1[i])+1);
            }else {
                //不存在的话就是1
                map.put(nums1[i],1);
            }
        }
        //存放集合的链表
        List<Integer> array = new ArrayList<Integer>();
        //遍历第二个数组
        for (int i = 0; i < nums2.length; i++) {
            //如果存在的map中出现的次数-1，list中添加这个数
            if (map.get(nums2[i]) !=null && map.get(nums2[i]) > 0){
                array.add(nums2[i]);
                map.put(nums2[i],map.get(nums2[i])-1);
            }
        }
        //返回结果
        int[] a = new int[array.size()];
        for (int i = 0; i < array.size(); i++) {
            a[i] = array.get(i);
        }
        return a;
    }

    //双指针

    private static int[] fun1(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<Integer>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int index1 = 0;
        int index2 = 0;

        while (true){
            if (index1 == nums1.length || index2 == nums2.length)
                break;
            if (nums1[index1] < nums2[index2])
                index1++;
            else if (nums1[index1] == nums2[index2]){
                list.add(nums1[index1]);
                index1++;
                index2++;
            }else
                index2++;
        }
        //返回结果
        int[] a = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            a[i] = list.get(i);
        }
        return a;
    }

}
