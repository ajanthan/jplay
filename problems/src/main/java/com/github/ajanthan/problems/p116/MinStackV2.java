package com.github.ajanthan.problems.p116;

public class MinStackV2 {
    class Node {
        int data;
        int min;
        Node next;
    }

    private Node head;

    /**
     * initialize your data structure here.
     */
    public MinStackV2() {
    }

    public void push(int val) {
        Node n = new Node();
        n.data = val;
        if (head == null) {
            n.min = val;
        } else {
            int min = getMin();
            if (min > val) {
                n.min = val;
            } else {
                n.min = min;
            }
            n.next = head;
        }
        head = n;

    }

    public void pop() {
        if (head != null) {
            head = head.next;
        }
    }

    public int top() {
        return head.data;
    }

    public int getMin() {
        return head.min;
    }
}
