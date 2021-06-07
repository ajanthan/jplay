package com.github.ajanthan.tree;

public class InOrder {
    public TreeNode listToBST(Integer[] nums) {
        return listToBSTHelper(nums, 0, nums.length - 1);
    }

    private TreeNode listToBSTHelper(Integer[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = listToBSTHelper(nums, start, mid - 1);
        root.right = listToBSTHelper(nums, mid + 1, end);
        return root;
    }
}
