package com.github.ajanthan.problems.p116;

import java.util.Stack;

public class MinStackV1 {
    private int min;
    private Stack<Integer> intStack;

    /**
     * initialize your data structure here.
     */
    public MinStackV1() {
        intStack = new Stack<>();
    }

    public void push(int val) {
        if (min > val) {
            intStack.push(min);
            min = val;
        }
        intStack.push(val);
    }

    public void pop() {
        if (intStack.pop() == min) min = intStack.pop();
    }

    public int top() {
        return intStack.peek();
    }

    public int getMin() {
        return min;
    }
}
