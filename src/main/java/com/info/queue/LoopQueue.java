package com.info.queue;

/**
 * Created by M on 2018/7/28.
 */
public class LoopQueue<E> implements Queue<E> {

    private E[] data;

    private int front;

    private int tail;

    private int size;

    public LoopQueue(int capacity) {
        data = (E[]) new Object[capacity + 1];
        front = 0;
        tail = 0;
        size = 0;
    }

    public LoopQueue() {
        this(10);
    }


    public int getCapacity() {
        return data.length - 1;
    }


    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return front == tail;
    }

    public void enqueue(E e) {
        if ((tail + 1) % data.length == 0) {
            // 队列已满----> 扩容
            resize(getCapacity() * 2);
        }

        data[tail] = e;
        tail = (tail + 1) % data.length;
        size++;
    }

    private void resize(int capacity) {
        E[] newData = (E[]) new Object[capacity + 1];
        for (int i = 0; i < size; i++) {
            newData[i] = data[(i + front) % data.length];
        }
        data = newData;
        front = 0;
        tail = size;
    }

    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("cannot dequeue from empty queue");
        }
        E ret = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size--;
        if (size == getCapacity() / 4 && getCapacity() / 2 != 0) {
            resize(getCapacity() / 2);
        }
        return ret;
    }

    public E getFront() {
        if (isEmpty()) {
            throw new IllegalArgumentException("cannot dequeue from empty queue");
        }
        return data[front];
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Queue size = %d, capacity = %d\n", size, getCapacity()));
        sb.append("front [");
        for (int i = front; i != tail; i = (i + 1) % data.length) {
            sb.append(data[i]);
            if ((i + 1) % data.length != tail) {
                sb.append(",");
            }
        }
        sb.append("] tail");
        return sb.toString();
    }

    public static void main(String[] args) {
        LoopQueue queue = new LoopQueue();
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
