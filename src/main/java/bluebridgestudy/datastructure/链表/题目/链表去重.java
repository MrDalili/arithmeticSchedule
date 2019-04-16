package bluebridgestudy.datastructure.链表.题目;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class 链表去重 {
    public static void main(String[] args) {
        int[] array = new int[]{1,1,3,7,6};
        Set<Integer> set = new HashSet<Integer>();
        Set<Integer> indexSet = new HashSet<Integer>();
        for (int i = 0; i < array.length; i++) {
            if (!set.contains(array[i])){
                set.add(array[i]);
            }else {
                indexSet.add(i);
            }
        }

        for (int i = 0,j = 0; i < array.length-j; i++) {
            if (indexSet.contains(i+j)){
                j++;
            }
            array[i] = array[i+j];
        }

        System.out.println(Arrays.toString(array));
    }

    private static class Node{
        public Node next;
        public Object data;

        public Node(Object data) {
            this.data = data;
            next = null;
        }
    }
}
