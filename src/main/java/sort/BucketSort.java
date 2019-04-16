package sort;

import bluebridgestudy.datastructure.链表.ListNode;
import jdk.nashorn.internal.ir.IfNode;

import java.util.Arrays;


public class BucketSort  {
    public static void main(String[] args) {
       int[] array = new int[]{7,5,3,9,5,1,4,5,6,8,5,2};
       Arrays.sort(array);
       System.out.println(Arrays.toString(array));
       sort(array);
    }
    public static void sort(int[] array){
        //获取最大的数
        int len = maxOf(array);
        //新建数组以及初始化
        ListNode<Integer>[] sort = new ListNode[len];
        for (int i = 0; i < sort.length ; i++) {
            sort[i] = new ListNode<Integer>();
        }
        //计算哈希,并且把每一个元素放进桶中
        for (int i = 0; i < array.length; i++) {
            int hashNum = hash(array[i],len,len);
            //将每个hash值放入对应的桶中
            put(sort,hashNum,array[i]);
        }
        //输出排过序的数组
        print(sort);
    }

    /**
     * 打印桶
     * @param sort
     */
    private static void print(ListNode<Integer>[] sort) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < sort.length; i++) {
            //遍历每个元素中的节点
            ListNode<Integer> p = sort[i].next;
            while (p != null){
                sb.append(p.data);
                p = p.next;
            }
        }
        sb.append("]");
        System.out.println(sb.toString());
    }

    private static int hash(int num,int len , int max){
        return (num*len)/(max+1);
    }

    private static int maxOf(int[] array){
        int max = array[0];
        for (int i = 0; i < array.length; i++) {
            if (max < array[i])
                max = array[i];
        }
        return max;
    }

    /**
     * 向桶中插入值
     * @param sort
     * @param index 下标
     * @param element 插入的元素
     */
    private static void put(ListNode<Integer>[] sort, int index, int element){
            ListNode p = sort[index].next;
            ListNode pre = sort[index];
            while (true){
                ListNode<Integer> newNode = new ListNode<Integer>(element);
                //如果下一个节点为空，那么该节点为最大的节点，
                if (p == null){
                    pre.next = newNode;
                    break;
                }
                if (p.next == null){
                    p.next = newNode;
                    break;
                }
                //判断是否为先插入的节点
                //如果下一个节点的值小于等于当前节点的大小，那么指针向前走
                if (p.next.data.compareTo(p.data) <= 0){
                    pre = p;
                    p = p.next;
                }else {
                    pre.next = newNode;
                    newNode.next = p;
                    break;
                }
            }
    }
}
