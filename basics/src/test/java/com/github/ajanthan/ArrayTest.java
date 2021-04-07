package com.github.ajanthan;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Array behaviours.
 */
public class ArrayTest {
    @Test
    public void arrayDeclaration() {
        int[] numbers0 = { 1, 2, 3, 4 };
        assertEquals(4, numbers0.length);
        assertEquals(1, numbers0[0]);
        assertEquals(4, numbers0[3]);

        for (int i = 0; i < numbers0.length; i++) {
            assertEquals(i + 1, numbers0[i]);
        }

        int[] numbers1 = new int[2];
        numbers1[0] = 5;
        numbers1[1] = 6;
        assertEquals(2, numbers1.length);
        assertEquals(5, numbers1[0]);
        assertEquals(6, numbers1[1]);

        int[] numbers2 = new int[4];
        int i = 0;
        for (int number : numbers0) {
            numbers2[i++] = number;
        }
        assertEquals(4, numbers2.length);
        assertEquals(1, numbers2[0]);
        assertEquals(4, numbers2[3]);
    }
}
