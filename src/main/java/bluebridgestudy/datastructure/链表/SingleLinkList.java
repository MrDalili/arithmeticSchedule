//package bluebridgestudy.datastructure.链表;
//
//import bluebridgestudy.datastructure.ArrayList.MyList;
//
//public class SingleLinkList implements MyList {
//    private ListNode first;
//    private int size;
//
//    public SingleLinkList() {
//        this.size = 0;
//    }
//
//    @Override
//    public void add(Object element) {
//        if (first == null){
//            first = new ListNode(element);
//        }else {
//            ListNode p = first;
//            //找到最后一个节点然后添加即可
//            while (p != null){
//                //如果下一个节点是空的，那么安装上即可
//                if (p.next == null){
//                    ListNode newNode = new ListNode(element);
//                    p.next = newNode;
//                    break;
//                }
//                p = p.next;
//            }
//        }
//        size++;
//    }
//
//    @Override
//    public void delete(Object element) {
//        //当前结点
//        ListNode p = first;
//        //记录前驱节点
//        ListNode pre = null;
//        while (p != null){
//
//            if (element.equals(p.data)){
//                if (pre == null){
//                    //看是不是要删除第一个节点
//                    this.first = this.first.next;
//                    this.size--;
//                    break;
//                }
//                pre.next = p.next;
//                p.next = null;
//                this.size--;
//                break;
//            }
//            //记录前驱节点
//            pre = p;
//            //查看下一个节点
//            p = p.next;
//
//        }
//    }
//
//    @Override
//    public Object delete(int index) {
//        int i = 0;
//        Object element = null;
//        //记录当前结点
//        ListNode p = first;
//        //记录前驱
//        ListNode pre = null;
//        while (p != null){
//            if (i == index){
//                if (pre == null){
//                    first = first.next;
//                    this.size--;
//                    break;
//                }
//                pre.next = p.next;
//                p.next = null;
//                element = p.data;
//            }
//            i++;
//            pre = p;
//            p = p.next;
//        }
//
//        return element;
//    }
//
//    @Override
//    public void update(int index, Object newElement) {
//        int i = 0;
//        //记录当前结点
//        ListNode p = first;
//        while (p != null){
//            if (i == index){
//                p.data = newElement;
//            }
//            i++;
//            p = p.next;
//        }
//    }
//
//    @Override
//    public boolean contains(Object element) {
//        ListNode p = first;
//        while (p != null){
//            if (element.equals(p.data))
//                return true;
//            p = p.next;
//        }
//        return false;
//    }
//
//    @Override
//    public int indexOf(Object element) {
//        int i = 0;
//        //记录当前结点
//        ListNode p = first;
//        while (p != null){
//            if (element.equals(p.data))
//                return i;
//            p = p.next;
//            i++;
//        }
//        return -1;
//    }
//
//    @Override
//    public Object get(int index) {
//        int i = 0;
//        //记录当前结点
//        ListNode p = first;
//        while (p != null){
//            if (index == i)
//                return p.data;
//            p = p.next;
//            i++;
//        }
//        return null;
//    }
//
//    @Override
//    public String toString() {
//        StringBuilder sb = new StringBuilder("[");
//        ListNode p = first;
//        while (p != null){
//            sb.append(p.data);
//            if (p.next == null)
//                sb.append("]");
//            else
//                sb.append(",");
//            p = p.next;
//        }
//        sb.append("   size="+size);
//        return sb.toString();
//    }
//}
