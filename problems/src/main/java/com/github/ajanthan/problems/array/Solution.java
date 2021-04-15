package com.github.ajanthan.problems.array;

import java.util.*;

public class Solution {
    public int singleNumberV0(int[] nums) {
        Arrays.sort(nums);
        int single = nums[0];
        for (int i = 1; i < nums.length; ) {
            if (single == nums[i]) {
                if (++i < nums.length) {
                    single = nums[i];
                }
            }
            i++;
        }
        return single;
    }

    public int singleNumberV1(int[] nums) {
        List<Integer> noDuplicateList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (noDuplicateList.contains(nums[i])) {
                noDuplicateList.remove((Integer) nums[i]);
            } else {
                noDuplicateList.add(nums[i]);
            }
        }
        return noDuplicateList.get(0);
    }

    public int singleNumberV2(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer k = map.get(nums[i]);
            if (k != null) map.put(nums[i], k + 1);
            else map.put(nums[i], 1);
        }
        for (int i = 0; i < nums.length; i++) {
            if (map.get(nums[i]) == 1) return nums[i];
        }
        return 0;
    }

    public int singleNumberV3(int[] nums) {
        int uniqueSum = 0, allSum = 0;
        Set<Integer> uniqueNumbers = new HashSet<>();
        for (int i : nums) {
            if (!uniqueNumbers.contains(i)) {
                uniqueNumbers.add(i);
                uniqueSum += i;
            }
            allSum += i;
        }
        return 2 * uniqueSum - allSum;
    }

    public int singleNumberV4(int[] nums) {
        int r = 0;
        for (int i : nums) {
            r ^= i;
        }
        return r;
    }
}
