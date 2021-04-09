package com.github.ajanthan.stacks;

import java.util.ArrayList;
import java.util.List;

public class ArrayStack<T> {
    private List<T> data;

    public ArrayStack() {
        data = new ArrayList<>();
    }

    public void push(T value) {
        data.add(value);
    }

    public T pop() {
        if (data.size() == 0) return null;
        return data.remove(data.size() - 1);
    }

    public T peek() {
        if (data.size() == 0) return null;
        return data.get(data.size() - 1);
    }

    public int size() {
        return data.size();
    }
}
