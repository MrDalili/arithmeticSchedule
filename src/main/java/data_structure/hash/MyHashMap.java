package data_structure.hash;

import java.util.Iterator;

public class MyHashMap<K,V> implements IMap<K,V> {
    private int length = 16;//类中存放键值对节点长度的数组
    private Node[] buckets = new Node[length];//相当于一个桶，存放hash后结果的链表头节点数组
    private int size = 0;//当前桶中有多少个元素

    @Override
    public void clear() {
        for (int i = 0; i < length; i++) {
            //遍历让每一个头指针位空
            buckets[i] = null;
        }
        //map清空，size应=0
        size = 0;
    }

    @Override
    public boolean containsKey(Object key) {
        //此处应该直接hash一下，然后判断一不一样，一样的话就有，不一样的话就没有
        int hIndex = hash(key);
        if (buckets[hIndex] != null){
            //有值，而且可能冲突，遍历一下都看看
            Node first = buckets[hIndex];
            while (first != null) {
                if (first.key == key || ((key != null) && key.equals(first.key)))
                    return true;
                first = first.next;
            }
        }
        return false;
    }

    //全遍历一遍
    @Override
    public boolean containsValue(Object value) {
        for (int i = 0; i < length; i++) {
            if (buckets[i] != null) {
                Node first = buckets[i];
                while (first != null){
                    if (first.value.equals(value))
                        return true;
                    first = first.next;
                }
            }
        }
        return false;
    }

    @Override
    public V get(Object key) {
        int hashIndex = hash(key);
        Node first = buckets[hashIndex];
        //判断一下是否为空
        if (first != null){
            while (first != null){
                if (first.key == key && ((key != null) && key.equals(first.key)))
                    return (V)first.value;
                first = first.next;
            }
        }
        return null;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public MyHashSet<K> keySet() {
        MyHashSet<K> myHashSet = new MyHashSet<K>();
        for (int i = 0; i < length; i++) {
            Node n = buckets[i];
            while (n != null){
                myHashSet.add((K) n.key);
                n = n.next;
            }
        }
        return myHashSet;
    }

    //重点是有重复的怎么处理，做替换处理，更新操作
    @Override
    public void put(K key, V value) {
        Node<K,V> node = new Node<K, V>(key,value);
        //先hash一下
        int hashIndex = hash(key);
        //现在就去这个下标所对应的链表中去插入该键值对
        if (buckets[hashIndex] == null){
            buckets[hashIndex] = node;
            size++;
        }else {
            //这是hash冲突的情况了，要判断这个值是否出现，出现的话覆盖，没出现的话添加到最后面去
            Node<K,V> first = buckets[hashIndex];
            Object f = first.key;
            //判断一下是不是覆盖了
            while (first != null){
                if (f == key && (key != null && key.equals(f))){
                    //出现了key相等的情况
                    //覆盖原来的value
                    first.value = value;
                    //直接跳出，因为只会有一个key
                    break;
                }else {
                    if (first.next == null){
                        //这是最后一个元素
                        first.next = node;
                        size++;
                        break;
                    }
                }
                first = first.next;
            }
        }
    }

    class MapIterator implements Iterator<Node<K,V>>{
        int i =0;
        Node node = null;
        Node next = null;
        //看遍历完没有，那就要获取当前的指针
        @Override
        public boolean hasNext() {
            //如果当前节点是空的，或者当前节点的下一个是空的，那么就证明当前结点不是第一个节点就是某个链表的最后一个节点
            if (node == null || (node.next == null)){
                i++;
                //遍历接下来的桶，看看有没有空的
                while (i<length && buckets[i] == null){
                    i++;
                }
                if (i == 16)
                    return false;
                //如果遍历完了也是空的，那么node就是最后一个元素
                if (buckets[i] == null)
                    return false;
                else {
                    //如果不是空的，那么就将指针指向这个元素
                    next = buckets[i];
                    return true;
                }
            }
            next = node.next;
            return true;
            }

        @Override
        public Node next() {
            node = next;
            return next;
        }

        @Override
        public void remove() {

        }

    }

    @Override
    public void putAll(IMap<? extends K, ? extends V> map) {

    }

    @Override
    public Iterator<Node<K, V>> iterator() {
        return new MapIterator();
    }

    @Override
    public V remove(Object key) {
        int hashIndex = hash(key);
        Node first = buckets[hashIndex];
        Node pre = null;
        while (first != null){
            //第一次进入，pre还未初始化
            if (pre == null){
                //先判断是不是相等
                if (first.key == key || ((key != null) && key.equals(first.key))){
                    //判断是不是只有一个元素
                    if (first.next == null ) {
                        buckets[hashIndex] = null;
                        size--;
                        return (V)first.value;
                    }
                    else {
                        //有2个以上的元素
                        buckets[hashIndex] = first.next;
                        size--;
                        return (V)first.value;
                    }
                }
                pre = first;
                first = first.next;
            }else{
                //已经有前驱了
                if (first.key == key || ((key != null) && key.equals(first.key))){
                    //如果相等那么久跳过中间的节点输出
                    pre.next = first.next;
                    size--;
                    return (V) first.value;
                }
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public V[] values() {
        return null;
    }

    /**
     * 计算hash值
     * 将key的hashcode向右移动16位，在与原先的hashcode做异或
     */
    @Override
    public int hash(Object key) {
        int h ;
        return key == null ? 0 : ((h = key.hashCode()) ^ (h>>16)) & length-1;
    }




    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("MyHashMap{");
        for (int i = 0; i < buckets.length ; i++) {
            if (buckets[i] != null){
                //如果这个节点不为空，遍历一下
                Node n = buckets[i];
                while (n != null){
                    s.append("\n"+n.key.toString()+"--->");
                    s.append(n.value.toString());
                    n = n.next;
                }
            }
        }
        return s.append("}").toString();
    }

    /**
     * 内部类，用来存放键值对的
     */
     class Node<K,V>{
        public K key;
        public V value;
        public Node next;//下一个节点
        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }
    }
}
