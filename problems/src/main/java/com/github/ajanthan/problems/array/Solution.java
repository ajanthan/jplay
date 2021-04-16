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

    public int majorityElementV0(int[] nums) {
        Map<Integer, Integer> occurrences = new HashMap<>();
        for (int num : nums) {
            Integer i = occurrences.get(num);
            if (i == null) {
                occurrences.put(num, 1);
            } else {
                occurrences.put(num, i + 1);
            }
        }
        for (int majorityEl : occurrences.keySet()) {
            if (occurrences.get(majorityEl) > (nums.length / 2)) return majorityEl;
        }
        return 0;
    }

    public int majorityElementV1(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    public int majorityElementV2(int[] nums) {
        int count = 0, majorityNumber = 0;
        for (int num : nums) {
            if (count == 0) {
                count++;
                majorityNumber = num;
            } else {
                if (majorityNumber == num) count++;
                else count--;
            }
        }
        return majorityNumber;
    }

    public int majorityElementV3(int[] nums) {
        return findMajorityElementRec(nums, 0, nums.length - 1);
    }

    private int findMajorityElementRec(int[] nums, int lo, int hi) {
        if (lo == hi) {
            return nums[lo];
        }
        int mid = lo + (hi - lo) / 2;
        int left = findMajorityElementRec(nums, lo, mid);
        int right = findMajorityElementRec(nums, mid + 1, hi);

        if (left == right) {
            return left;
        }
        int leftCount = countInRange(nums, left, lo, hi);
        int rightCount = countInRange(nums, right, lo, hi);

        return leftCount > rightCount ? left : right;
    }

    private int countInRange(int[] nums, int num, int lo, int hi) {
        int count = 0;
        for (int i = lo; i <= hi; i++) {
            if (nums[i] == num) {
                count++;
            }
        }
        return count;
    }
}
