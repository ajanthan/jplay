package com.github.ajanthan.collections;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayListTest {
    @Test
    public void basicTest() {
        List<Integer> nums = new ArrayList<>();
        nums.add(1);
        nums.add(2);
        Assert.assertEquals(1, (int) nums.get(0));
        Assert.assertEquals(2, nums.size());
        Assert.assertTrue(nums.contains(2));
        nums.remove(0);
        Assert.assertFalse(nums.contains(1));
        List<Integer> nums1 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
        int i = 0;
        for (int num : nums1) {
            Assert.assertEquals((int) nums1.get(i), num);
            i++;
        }
    }
}
