package com.info.stack;

import com.info.array.Array;

/**
 * Created by M on 2018/7/28.
 */
public class ArrayStack<E> implements Stack<E> {

    Array<E> array;

    public ArrayStack(int capacity) {
        array = new Array(capacity);
    }

    public ArrayStack() {
        array = new Array<E>();
    }


    public int getSize() {
        return array.size();
    }

    public boolean isEmpty() {
        return array.size() == 0;
    }

    public void push(E e) {
        array.addLast(e);
    }

    public E pop() {
        return array.removeLast();
    }

    public E peek() {
        return array.removeLast();
    }


    public int getCapacity() {
        return array.getCapacity();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Stack");
        sb.append("[");
        for (int i = 0; i < array.size(); i++) {
            sb.append(array.get(i));
            if (i != array.size() - 1) {
                sb.append(",");
            }
        }
        sb.append("] top");
        return sb.toString();
    }
}
