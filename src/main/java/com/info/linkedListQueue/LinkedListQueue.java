package com.info.linkedListQueue;

import com.info.linkedlist.LinkedList;
import com.info.queue.ArrayQueue;
import com.info.queue.Queue;

/**
 * Created by M on 2018/8/18.
 */
public class LinkedListQueue<E> implements Queue<E> {

    private class Node {
        public E e;

        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }

    }

    private int size;

    private Node head;

    private Node tail;

    public LinkedListQueue() {
        head = null;
        tail = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void enqueue(E e) {
        if (tail == null) {
            tail = new Node(e);
            head = tail;
        } else {
            tail.next = new Node(e);
            tail = tail.next;
        }
        size++;
    }

    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("cannnot dequeue from an empty queue");
        }
        Node returNode = head;
        head = head.next;
        returNode.next = null;
        if (head == null) {
            tail = null;
        }
        size--;
        return returNode.e;
    }

    public E getFront() {
        if (isEmpty()) {
            throw new IllegalArgumentException("cannnot dequeue from an empty queue");
        }
        return head.e;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Queue: front ");
        Node cur = head;
        while (cur != null) {
            sb.append(cur);
            sb.append(" -->");
            cur = cur.next;
        }
        sb.append(" NULL tail...");
        return sb.toString();
    }


    public static void main(String[] args) {
        LinkedListQueue queue = new LinkedListQueue();
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
