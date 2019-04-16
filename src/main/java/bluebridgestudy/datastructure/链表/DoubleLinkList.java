//package bluebridgestudy.datastructure.链表;
//
//import bluebridgestudy.datastructure.ArrayList.MyList;
//import com.sun.xml.internal.bind.v2.model.core.ID;
//
//public class DoubleLinkList implements MyList {
//    private ListNode first;
//    private ListNode last;
//    private int size;
//
//    public DoubleLinkList() {
//        first = new ListNode(null);
//        first.next = last;
//        last = new ListNode(null);
//        last.pre = first;
//        size = 0;
//    }
//
//
//    @Override
//    public void add(Object element) {
//        ListNode newNode = new ListNode(element);
//        //那就是在最后一个节点前面加上新添加的元素
//        last.pre.next = newNode;
//        newNode.pre = last.pre;
//        last.pre = newNode;
//        newNode.next = last;
//        size++;
//    }
//
//    @Override
//    public void delete(Object element) {
//        //忽略中间的，俩边建立连接
//        ListNode p = first.next;
//        while (p != last){
//            if (p.data.equals(element)){
//                p.pre.next = p.next;
//                p.next.pre = p.pre;
//                p.pre = null;
//                p.next = null;
//                size--;
//                break;
//            }
//            p = p.next;
//        }
//    }
//
//    @Override
//    public Object delete(int index) {
//        Object element = null;
//        int i = 0;
//        //忽略中间的，俩边建立连接
//        ListNode p = first.next;
//        while (p != last){
//            if (index == i){
//                p.pre.next = p.next;
//                p.next.pre = p.pre;
//                p.pre = null;
//                p.next = null;
//                element = p.data;
//                size--;
//                break;
//            }
//            i++;
//            p = p.next;
//        }
//        return element;
//    }
//
//    @Override
//    public void update(int index, Object newElement) {
//        int i = 0;
//        //忽略中间的，俩边建立连接
//        ListNode p = first.next;
//        while (p != last){
//            if (index == i){
//                p.data = newElement;
//                break;
//            }
//            i++;
//            p = p.next;
//        }
//    }
//
//    @Override
//    public boolean contains(Object element) {
//        //忽略中间的，俩边建立连接
//        ListNode p = first.next;
//        while (p != last){
//            if (element.equals(p.data)){
//                return true;
//            }
//            p = p.next;
//        }
//        return false;
//    }
//
//    @Override
//    public int indexOf(Object element) {
//        int i = 0;
//        //忽略中间的，俩边建立连接
//        ListNode p = first.next;
//        while (p != last){
//            if (element.equals(p.data)){
//                return i;
//            }
//            i++;
//            p = p.next;
//        }
//        return -1;
//    }
//
//    @Override
//    public Object get(int index) {
//        int i = 0;
//        //忽略中间的，俩边建立连接
//        ListNode p = first.next;
//        while (p != last){
//            if (index == i){
//                return p.data;
//            }
//            i++;
//            p = p.next;
//        }
//        return null;
//    }
//
//    @Override
//    public String toString() {
//        StringBuilder sb = new StringBuilder("[");
//        ListNode p = first.next;
//        if (p == last)
//            sb.append("]");
//        while (p != last){
//            sb.append(p.data);
//            if (p.next == last)
//                sb.append("]");
//            else
//                sb.append(",");
//            p = p.next;
//        }
//
//        return sb.toString();
//    }
//}
