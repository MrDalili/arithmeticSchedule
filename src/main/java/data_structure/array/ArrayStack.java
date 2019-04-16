package data_structure.array;

import data_structure.array.Array;

import java.util.Stack;

/**
 * 使用动态数组实现堆栈
 * @param <E>
 */
public class ArrayStack<E> extends Stack<E> {


    Array<E> array;

    /**
     * 有参构造函数，创建一个指定容量大小的堆栈
     * @param capacity
     */
    public ArrayStack(int capacity){
        array = new Array<E>(capacity);
    }

    /**
     * 无参构造函数
     */
    public ArrayStack(){
        array = new Array<E>();
    }

    /**
     * void push(E e)	向栈中加入元素	O(1) 均摊
     * E pop()	弹出栈顶元素	O(1) 均摊
     * E peek()	查看栈顶元素	O(1)
     * int getSize()	获取栈中元素个数	O(1)
     * boolean isEmpty()	判断栈是否为空	O(1)
     */
    /*******************************************/

    /**
     * push：推动、增加
     * 增加一个元素放在对战的醉葫芦面
     * @param item 所需要加的元素
     * @return
     */
    public E push(E item) {
        array.addLast(item);
        return item;
    }

    /**
     * 获取堆栈中所含元素的多少
     * @return
     */
    public int size(){
        return array.getSize();
    }

    /**
     * pop：取出
     * @return
     */
    @Override
    public E pop() {
        return array.removeLast();
    }

    /**
     * peek：查看第一个元素
     * @return
     */
    @Override
    public  E peek() {
        return array.getLast();
    }

    /**
     * 查看栈是否为空
     * @return
     */
    @Override
    public boolean empty() {
        return array.isEmpty();
    }

    /**
     * 寻找指定元素的下标
     * @param e 要寻找的元素
     * @return 下标
     */
    public int find(E e) {
        return array.find(e);
    }

}
