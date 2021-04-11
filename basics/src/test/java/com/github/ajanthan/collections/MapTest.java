package com.github.ajanthan.collections;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class MapTest {
    @Test
    public void basicTest() {
        Map<String, Integer> map = new HashMap<>();
        map.put("one", 1);
        map.put("two", 2);
        Assert.assertEquals(2, map.size());
        Assert.assertEquals(1, (int) map.get("one"));
        Assert.assertArrayEquals(new Integer[]{ 1, 2 }, map.values().toArray(new Integer[0]));
        Assert.assertArrayEquals(new String[]{ "one", "two" }, map.keySet().toArray(new String[0]));
        Assert.assertTrue(map.containsKey("one"));
        Assert.assertTrue(map.containsValue(1));
        Assert.assertTrue(map.remove("one", 1));
        Assert.assertEquals(1, map.size());
    }
}
