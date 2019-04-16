package bluebridgestudy.datastructure.ArrayList;

/**
 * 线性表或链表的接口定义
 */
public interface MyList {
    /**
     * 添加一个新元素
     * @param element
     */
    void add(Object element);

    /**
     * 删除一个指定元素
     * @param element
     */
    void delete(Object element);

    /**
     * 根据下表删除一个指定元素
     * @param index
     */
    Object delete(int index);

    /**
     * 根据下标修改元素
     * @param index
     * @param newElement
     */
    void update(int index , Object newElement);

    /**
     * 查询是否存在这个元素
     * @param element
     * @return
     */
    boolean contains(Object element);

    /**
     * 返回指定内容的下标
     * @param element
     * @return
     */
    int indexOf(Object element);

    /**
     * 返回指定下标的内容
     * @param index
     * @return
     */
    Object get(int index);
}
