package com.github.ajanthan.stacks;

import com.github.ajanthan.linkedlist.Node;

public class LinkedListStack<T> {
    private Node<T> root;

    public void push(T value) {
        if (root == null) {
            root = new Node<>(value);
        } else {
            Node<T> node = new Node(value);
            node.next = root;
            root = node;
        }
    }

    public T pop() {
        if (root == null) return null;
        Node<T> node = root;
        root = root.next;
        return node.data;
    }

    public T peek() {
        if (root == null) return null;
        return root.data;
    }

    public int size() {
        int size = 0;
        Node<T> currentNode = root;
        while (currentNode != null) {
            size++;
            currentNode = currentNode.next;
        }
        return size;
    }
}
