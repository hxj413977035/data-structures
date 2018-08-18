package com.info.stack;

/**
 * Created by M on 2018/7/28.
 */
public interface Stack<E> {

    int getSize();

    boolean isEmpty();

    void push(E e);

    E pop();

    E peek();
}
