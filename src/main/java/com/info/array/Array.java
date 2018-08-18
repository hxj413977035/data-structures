package com.info.array;

/**
 * Created by M on 2018/7/26.
 */
public class Array<T> {

    private T[] data;

    private int size;

    /**
     * 初始化指定容量的数组
     *
     * @param capacity
     */
    public Array(int capacity) {
        data = (T[]) new Object[capacity];
    }

    /**
     * 默认初始化容量为10的数组
     */
    public Array() {
        this(10);
    }

    /**
     * 获取数组元素个数
     *
     * @return
     */
    public int size() {
        return size;
    }

    /**
     * 获取数组的容量
     *
     * @return
     */
    public int getCapacity() {
        return data.length;
    }

    /**
     * 向数组的末尾添加一个元素
     *
     * @param e
     */
    public void addLast(T e) {
//        if (size == data.length) {
//            throw new IllegalArgumentException("add fail,Array is full");
//        }
//        data[size] = e;
//        size++;
        add(size, e);
    }

    /**
     * 向数组指定位置添加一个元素
     *
     * @param index
     * @param e
     */
    public void add(int index, T e) {
        if (size == data.length) {
            resize(2 * data.length);
        }
        if (index < 0 || index > data.length) {
            throw new IllegalArgumentException("add fail,Array is full");
        }
        for (int i = size; i > index; i--) {
            data[i] = data[i - 1];
        }
        data[index] = e;
        size++;
    }



    private void resize(int newCapacity) {
        T[] newData = (T[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    /**
     * 向数组头部增加一个元素
     *
     * @param e
     */
    public void addFirst(T e) {
        add(0, e);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Array size = %d, capacity = %d\n", size, data.length));
        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append(data[i]);
            if (i != size - 1) {
                sb.append(",");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    /**
     * 获取指定位置的元素
     *
     * @param index
     * @return
     */
    public T get(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("get fail,index is illegal");
        }
        return data[index];
    }

    /**
     * 设置元素
     *
     * @param index
     * @param e
     */
    public void set(int index, T e) {
        if (index < 0 || index > data.length) {
            throw new IllegalArgumentException("set fail,index is illegal");
        }
        data[index] = e;
        size++;
    }

    /**
     * 查询数组中是否包含某个元素
     *
     * @param e
     * @return
     */
    public boolean contains(T e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 查找数组中某个元素的位置
     */
    public int find(T e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 查找数组中某个元素的位置(多次出现返回位置数组,未找到返回空数组)
     */
    public Array findElements(T e) {
        Array result = new Array();
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                result.addLast(i);
                continue;
            }
        }
        return result;
    }

    /**
     * 删除数组中指定位置的元素
     *
     * @param index
     */
    public T delete(int index) {
        if (index < 0 || index > data.length) {
            throw new IllegalArgumentException("delete fail,required index < 0 and index > data.length");
        }
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        T ret = data[index];
        size--;
        data[size] = null;
        if (size == data.length / 4 && data.length / 2 != 0) {
            resize(data.length / 2);
        }
        return ret;
    }

    /**
     * 删除第一个人元素
     *
     * @return
     */
    public T removeFirst() {
        return delete(0);
    }

    /**
     * 删除最后一个元素
     *
     * @return
     */
    public T removeLast() {
        return delete(size - 1);
    }

    /**
     * 删除指定元素
     *
     * @param e
     */
    public void removeElement(T e) {
        int index = find(e);
        if (index != -1) {
            delete(index);
        }
    }

    /**
     * 删除数组中所有指定的元素
     *
     * @param e
     * @return
     */
    public boolean removeAllElement(T e) {
        Array arr = findElements(e);
        if (arr.size > 0) {
            for (int i = 0; i < arr.size; i++) {
                delete((Integer) arr.get(i));
            }
            return true;
        }
        return false;
    }

    /**
     * 获取第一个元素
     * @return
     */
    public T getFirst(){
        return get(0);
    }

    /**
     * 获取最后一个元素
     * @return
     */
    public T getLast(){
        return get(size - 1);
    }
}
