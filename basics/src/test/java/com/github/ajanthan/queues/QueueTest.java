package com.github.ajanthan.queues;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class QueueTest {
    @Test
    public void basicArrayQueueTest() {
        Queue<Integer> queue = new ArrayQueue<>();
        for (int i = 0; i < 5; i++) {
            queue.enqueue(i);
        }
        assertEquals(0, (int) queue.dequeue());
        assertEquals(1, (int) queue.dequeue());
        assertEquals(2, (int) queue.dequeue());
        assertEquals(3, (int) queue.dequeue());
        assertEquals(4, (int) queue.peek());
        assertEquals(false, queue.isEmpty());
        assertEquals(4, (int) queue.dequeue());
        assertEquals(true, queue.isEmpty());

        queue.enqueue(5);
        assertEquals(5, (int) queue.dequeue());
        assertEquals(true, queue.isEmpty());
    }

    @Test
    public void basicLinkedListQueueTest() {
        Queue<Integer> queue = new LinkedListQueue<>();
        for (int i = 0; i < 5; i++) {
            queue.enqueue(i);
        }
        assertEquals(0, (int) queue.dequeue());
        assertEquals(1, (int) queue.dequeue());
        assertEquals(2, (int) queue.dequeue());
        assertEquals(3, (int) queue.dequeue());
        assertEquals(4, (int) queue.peek());
        assertEquals(false, queue.isEmpty());
        assertEquals(4, (int) queue.dequeue());
        assertEquals(true, queue.isEmpty());

        queue.enqueue(5);
        assertEquals(5, (int) queue.dequeue());
        assertEquals(true, queue.isEmpty());
    }
}
