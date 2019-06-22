package data_structure.hash;

/**
 * 实现hashSet接口
 * @param <E>
 */
public interface IHashSet<E> {
    void add(E key);//添加元素
    void remove(E key);//移除元素
    void clear();//清除set中元素
    boolean contains(E key);//是否包含一个元素
    boolean isEmpty();//是否位空
    int size();//空间大小
    int hash(Object o);//计算hash

}
