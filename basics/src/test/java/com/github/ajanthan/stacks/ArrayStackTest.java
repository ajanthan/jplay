package com.github.ajanthan.stacks;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ArrayStackTest {
    @Test
    public void basicTest() {
        ArrayStack<Integer> stack = new ArrayStack<>();
        for (int i = 0; i < 10; i++) {
            stack.push(i);
        }
        assertEquals(10, stack.size());
        assertEquals(9, (int) stack.pop());
        assertEquals(8, (int) stack.pop());
        assertEquals(7, (int) stack.peek());
        assertEquals(7, (int) stack.pop());
        assertEquals(7, stack.size());
    }
}
