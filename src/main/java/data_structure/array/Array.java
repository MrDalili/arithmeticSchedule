package data_structure.array;

import java.applet.Applet;

/**
 * 用数组创建动态数组
 * @param <E>
 */
public class Array<E> {
    //内部的数组
    private E[] array;
    //数组长度
    private int size;

    /**
     * 默认无参构造函数，创建长度为10的数组
     */
    public Array() {
        this(10);
    }

    /**
     * 有长度的有参构造函数，创建用户需要长度的数组
     * @param length
     */
    public Array(int length){
        array = (E[]) new Object[length];
        size = 0;
    }

    /**
     * 获取该数组种元素的个数
     * @return 数组种元素的个数
     */
    public int getSize(){
        return size;
    }

    /**
     * 获取给数组的长度
     * @return 数组的长度
     */
    public int getCapacity(){
        return array.length;
    }

    /**
     * 判断数组中的元素是否为0
     * @return 数组元素是否为0
     */
    public boolean isEmpty(){
        return size == 0;
    }

    /**
     * 获得数组中的第一个元素
     * @return 数组中的第一个元素
     */
    public E getFirst(){
        //判断给数组size是否>0，=0则报错
        if (size == 0)
            throw new IllegalArgumentException("size is null");
        return get(0);
    }

    /**
     * 获取数组中的最后一个元素
     * @return 数组中的最后一个元素
     */
    public E getLast(){
        //判断数组的size是否>0,=0则报错
        if (size == 0)
            throw new IllegalArgumentException("size is null");
        return array[size-1];
    }

    /**
     * 移除最后一个元素，并返回该元素的值
     * @return 移除元素的值
     */
    public E removeLast(){
        //判断数组的size是否>0,=0则报错
        if (size == 0)
            throw new IllegalArgumentException("size is null");
        return remove(this.size-1);
    }

    /**
     * 移除第一个元素，并返回该元素的值
     * @return 移除元素的值
     */
    public E removeFirst(){
        //判断数组的size是否>0,=0则报错
        if (size == 0)
            throw new IllegalArgumentException("size is null");
        return remove(0);
    }
    /***********************************/

    /**
     * 对数组进行扩容,或缩减
     */
    public void resize(int length){
        //将数组的长度扩展1倍
        E[] array1 = (E[]) new Object[length];
        //将原数组中的内容移动到新数组中,即可完成扩容
        for (int i = 0; i < size; i++) {
            array1[i] = array[i];
        }
        //将新数组指向array
        array = array1;
    }

    /**
     *向数组中指定的下标添加指定的元素
     * @param index 待添加元素的下标
     * @param e 需要添加的元素
     */
    public void  add(int index , E e){
        //害怕发生size==capacity，所以要判断capacity是否等于size，等于的话就代表容器满了，需要扩容
        if (size == getCapacity()){
            resize(this.getCapacity()*2);
        }
        //判断该元素是否合法
        if (index < 0 || index > array.length){
            throw new  IllegalArgumentException("index is illegal:index-->"+index);
        }
        //index合法向指定下标插入
        //index-1后的每一个元素向后移动一位
        for (int i =size-1; i >=index ; i--) {
            array[i+1] = array[i];
        }
        array[index] = e;
        size++;
    }

    /**
     * 向数组最后面添加一个元素
     * @param e 待添加的元素
     */
    public void addLast(E e){
        add(size,e);
    }

    /**
     * 像数组种第一个元素之前添加一个元素
     * @param e 待添加的元素
     */
    public void addFirst(E e){
        add(0,e);
    }

    /**
     * 获取任意索引所对应的值
     * @param index 需要获取元素的下标
     * @return 给下标所对应的值
     */
    public E get(int index){
        //判断下标是否合法
        if (index < 0 || index>= this.size)
            throw new IllegalArgumentException("index is illegal:index-->"+index);
        return array[index];
    }

    /**
     * 修改数组中下标所对应的值
     * @param index 数组索引
     * @param e 新的元素
     */
    public void update(int index , E e){
        //判断下标是否合法
        if (index < 0 || index >= this.size)
            throw new IllegalArgumentException("index is illegal:index-->"+index);
        //修改
        array[index] = e;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Array:size="+size+",capacity="+this.getCapacity()+"[");
        for (int i = 0; i < size ; i++) {
            if (i == size-1){
                sb.append(array[i]+"]");
            }
            sb.append(array[i]+",");
        }
        return sb.toString();
    }

    /**
     * 查找元素，存在则返回该元素所在下标，不存在返回-1
     * @param e 查找元素
     * @return 该元素下标
     */
    public int find(E e){
        for (int i = 0; i < size; i++) {
            if (array[i].equals(e)){
                return i;
            }
        }
        return -1;
    }

    /**
     * 判断查找元素是否存在与数组中
     * @param e 需判断的元素
     * @return 是否存在
     */
    public boolean contains(E e){
        for (int i = 0; i < size; i++) {
            if (array[i].equals(e)){
                return true;
            }
        }
        return false;
    }

    /**
     * 从数组中删除制定下标的元素，并且返回给元素
     * @param index 需要删除的元素下标
     * @return 该下标对应内容
     */
    public E remove(int index){
        //判断下标是否合法
        if (index < 0 || index >= this.size)
            throw new IllegalArgumentException("index is illegal:index-->"+index);
        //将该元素取出
        E data = array[index];
        //将该元素后面的元素向前移动
        for (int i = index; i < size; i++) {
            array[i] = array[i+1];
        }
        //数组大小-1
        size--;
        //使用防震荡处理，查看capacity是否>>>size，如果是那么进行缩小
        if ((this.getCapacity()/this.size)==2||(this.getCapacity()/this.size)==4)
            this.resize(this.getCapacity()>>1);
        return data;
    }

    /**
     * 删除数组中所存在的元素
     * @param e 需要删除的元素
     */
    public void removeElement(E e){
        int index = find(e);
        if (index != -1)
            remove(index);
    }



}

