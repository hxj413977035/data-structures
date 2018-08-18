package com.info.queue;

import com.info.array.Array;

/**
 * Created by M on 2018/7/28.
 */
public class ArrayQueue<E> implements Queue<E> {

    private Array<E> array;

    public ArrayQueue(int capatity) {
        array = new Array<E>(capatity);
    }

    public ArrayQueue() {
        array = new Array<E>();
    }


    public int getSize() {
        return array.size();
    }

    public boolean isEmpty() {
        return array.size() == 0;
    }

    public void enqueue(E e) {
        array.addLast(e);
    }

    public E dequeue() {
        return array.removeFirst();
    }

    public E getFront() {
        return array.getLast();
    }

    public int getCapacity() {
        return array.getCapacity();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Queue:");
        sb.append("front [");
        for (int i = 0; i < array.size(); i++) {
            sb.append(array.get(i));
            if (i != array.size() - 1) {
                sb.append(",");
            }
        }
        sb.append("] tail");
        return sb.toString();
    }

    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue();
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
            System.out.println(queue);
            if (i % 3 == 2) {
                queue.dequeue();
                System.out.println(queue);
            }
        }

    }
}
