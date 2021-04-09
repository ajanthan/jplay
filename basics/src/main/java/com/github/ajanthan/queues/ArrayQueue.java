package com.github.ajanthan.queues;

import java.util.ArrayList;
import java.util.List;

public class ArrayQueue<T> implements Queue<T> {
    private List<T> data;

    public ArrayQueue() {
        data = new ArrayList<>();
    }

    @Override
    public void enqueue(T value) {
        this.data.add(value);
    }

    @Override
    public T dequeue() {
        return data.remove(0);
    }

    @Override
    public T peek() {
        return data.get(0);
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }
}
