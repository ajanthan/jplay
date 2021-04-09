package com.github.ajanthan.queues;

import com.github.ajanthan.linkedlist.Node;

public class LinkedListQueue<T> implements Queue<T> {
    private Node<T> head;

    @Override
    public void enqueue(T value) {
        if (head == null) {
            head = new Node(value);
        } else {
            Node<T> current = new Node(value);
            current.next = head;
            head = current;
        }
    }

    @Override
    public T dequeue() {
        T returnVal = null;
        if (head == null) {
            return null;
        } else if (head.next == null) {
            returnVal = head.data;
            head = null;
            return returnVal;
        }
        Node<T> node = head;
        while (node != null && node.next != null) {
            if (node.next.next == null) {
                returnVal = node.next.data;
                node.next = null;
            }
            node = node.next;
        }
        return returnVal;
    }

    @Override
    public T peek() {
        if (head == null) return null;
        Node<T> node = head;
        while (node != null) {
            if (node.next == null) {
                return node.data;
            }
            node = node.next;
        }
        return null;
    }

    @Override
    public boolean isEmpty() {
        if (head == null) return true;
        return false;
    }
}
