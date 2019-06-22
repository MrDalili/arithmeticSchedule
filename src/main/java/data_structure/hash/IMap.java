package data_structure.hash;


import java.util.Iterator;

/***
 * 一个自己实现的map的接口
 * @param <K> 键
 * @param <V> 值
 */
public interface IMap<K,V> {
    void clear();//清楚所有键值对
    boolean containsKey(Object key);//查询是否包含一个键
    boolean containsValue(Object value);//查询是否包含一个值
    V get(Object key);//通过键获取到对应的值
    boolean isEmpty();//判断IMap是否为空
    MyHashSet<K> keySet();//获得所有键的集合
    void put(K key , V value);//存放一个键值对
    void putAll(IMap<? extends K , ? extends  V> map);//将另外一个IMap中的所有键值对，存放到本IMap种
    V remove(Object key);//通过键删除一个键值对，并返回值
    int size();//IMap的大小
    V[] values();//所有值的数组
    int hash(Object key);//计算hash值
    Iterator<MyHashMap<K, V>.Node<K, V>> iterator();//迭代器
}
