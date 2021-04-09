package com.github.ajanthan.queues;

public interface Queue<T> {
    public void enqueue(T value);

    public T dequeue();

    public T peek();

    public boolean isEmpty();
}
