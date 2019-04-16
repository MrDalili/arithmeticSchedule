package data_structure.array;

import data_structure.array.Array;

/**
 * 使用动态数组实现队列
 * 队列：
 *      先进先出，FIFO
 */
public class ArrayQueue<E>  {

    private Array<E> array;

    /**
     * 无参构造
     */
    public ArrayQueue() {
        array = new Array<E>();
    }

    /**
     * 构造一个指定容量大小的队列
     * @param capacity 容量大小
     */
    public ArrayQueue(int capacity){
        array = new Array<E>(capacity);
    }

    /**
     * 获取队列容量
     * @return 队列的容量
     */
    public int getCapacity(){
        return array.getCapacity();
    }

    /**
     * void enqueue(E e)	入队	O(1) 均摊
     * E dequeue()	出队	O(n)
     * E getFront()	获取队首元素	O(1)
     * int getSize()	获取队列元素个数	O(1)
     * boolean isEmpty()	判断队列是否为空	O(1)
     */
    /************************************/

    /**
     * enqueue:入队
     * 添加元素，因为先进先出，所以每次添加在数组的最后面添加
     * @param e 需要添加的元素
     * @return
     */
    public void enqueue(E e) {
        array.addLast(e);
    }

    /**
     * dequeue：出列
     * 取出元素，因为先进先出，那么从数组第一个元素将元素取出,并将其删除
     *  @return 去除的元素
     */
    public E dequeue () {
        return array.removeFirst();
    }

    /**
     * 获取队首元素
     * @return 队首元素的值
     */
    public E getFront() {
        return array.getFirst();
    }

    /**
     * 获取队列中所含元素的个数
     * @return 元素个数
     */
    public int getSize() {
        return array.getSize();
    }

    /**
     * 判断队列是否无元素
     * @return 判断结果
     */
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public String toString() {
        return array.toString();
    }
}
