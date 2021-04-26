package com.github.ajanthan.problems.p116;

import java.util.ArrayList;
import java.util.List;

public class MinStackV0 {
    class Node {
        int data;
        int min;
    }

    private List<Node> list;

    /**
     * initialize your data structure here.
     */
    public MinStackV0() {
        list = new ArrayList<>();
    }

    public void push(int val) {
        Node n = new Node();
        n.data = val;
        if (list.size() == 0) {
            n.min = val;
        } else {
            int min = getMin();
            if (min > val) {
                n.min = val;
            } else {
                n.min = min;
            }
        }
        list.add(n);
    }

    public void pop() {
        list.remove(list.size() - 1);
    }

    public int top() {
        return list.get(list.size() - 1).data;
    }

    public int getMin() {
        return list.get(list.size() - 1).min;
    }
}
