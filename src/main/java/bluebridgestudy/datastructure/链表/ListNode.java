package bluebridgestudy.datastructure.链表;

/**
 * 链表节点
 */
public class ListNode<T extends Comparable<T>>{
     public T data;
     public ListNode<T> next;
     public ListNode<T> pre;

    public ListNode() {
        data = null;
        next = null;
    }

    public ListNode(T data) {
        this.data = data;
    }



}
