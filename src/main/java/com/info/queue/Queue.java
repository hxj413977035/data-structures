package com.info.queue;

/**
 * Created by M on 2018/7/28.
 */
public interface Queue<E> {

    int getSize();

    boolean isEmpty();

    void enqueue(E e);

    E dequeue();

    E getFront();
}
