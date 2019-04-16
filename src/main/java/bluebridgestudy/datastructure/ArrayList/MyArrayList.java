package bluebridgestudy.datastructure.ArrayList;

import org.junit.Test;

/**
 * 用顺序方式(数组)来实现列表
 */
public class MyArrayList implements MyList {
    private Object[] elements;//真正存储元素的底层结构
    private int size;//当前元素个数
    private int capacity;//容量

//    /**
//     * 带参构造函数
//     *
//     * @param capacity
//     */
//    public MyArrayList(int capacity) {
//        this.capacity = capacity;
//        elements = new Object[capacity];
//    }

    /**
     * 默认构造函数
     */
    public MyArrayList() {
        this.capacity = 10;
        elements = new Object[capacity];
    }

    @Override
    public void add(Object element) {
        //扩容,防止溢出
        if (size == capacity){
            Object[] newList = new Object[capacity*2];
            for (int i = 0; i < size ; i++) {
                newList[i] = elements[i];
            }
            elements = newList;
        }

        elements[size++] = element;
    }

    @Override
    public void delete(Object element) {
        int index = indexOf(element);
        delete(index);
    }
    @Override
    public Object delete(int index) {
        Object e = elements[index];
        for (int i = index; i < size-1 ; i++) {
            elements[i] = elements[i+1];
        }
        size--;
        return e;
    }
    @Override
    public void update(int index, Object newElement) {
        elements[index] = newElement;
    }
    @Override
    public boolean contains(Object element) {
        return indexOf(element)>=0;
    }

    @Override
    public int indexOf(Object element) {
        for (int i = 0; i < size; i++) {
            if (element.equals(elements[i]))
                return i;
        }
        return -1;
    }
    @Override
    public Object get(int index) {
        return elements[index];
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size ; i++) {
            sb.append(elements[i]+",");
        }
        return "MyArrayList{" +
                "elements=" +sb +"]"+
                " size=" + size +
                ", capacity=" + capacity +
                '}';
    }

    @Test
    public void add(){
        MyArrayList myArrayList = new MyArrayList();
        myArrayList.add("aaa");
        myArrayList.add("bbb");
        myArrayList.add("ccc");
        myArrayList.add("ddd");
        myArrayList.add("eee");
        myArrayList.add("fff");
        myArrayList.add("ggg");
        myArrayList.add("hhh");
        myArrayList.add("iii");
        myArrayList.add("ggg");
        myArrayList.add("kkk");
        myArrayList.add("lll");
        myArrayList.add("mmm");
        System.out.println(myArrayList.toString());
        System.out.println(myArrayList.contains("ggg"));
        myArrayList.update(12,"nnn");
        System.out.println(myArrayList.toString());
        myArrayList.delete("aaa");
        myArrayList.delete(0);
        System.out.println(myArrayList.toString());

    }

}
