package com.github.ajanthan;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class ArrayListTest {
    @Test
    public void declare() {
        List<String> names = new ArrayList<>();
        names.add("one");
        names.add("two");
        names.add("three");

        for (String name : names) {
            assertTrue(names.contains(name));
        }
    }
}
