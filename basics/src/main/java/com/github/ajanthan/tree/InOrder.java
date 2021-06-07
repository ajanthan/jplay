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

    public void printTree(TreeNode root) {
        if (root == null) {
            return;
        }
        printTree(root.left);
        System.out.print(" " + root.val + " ");
        printTree(root.right);
    }

    public boolean isBinarySearchTree(TreeNode root) {
        return isInOrder(root, Integer.MIN_VALUE) == null ? false : true;
    }

    private Integer isInOrder(TreeNode root, Integer previousValue) {
        if (root == null) {
            return previousValue;
        }
        if ((previousValue = isInOrder(root.left, previousValue)) == null) {
            return null;
        }
        if (previousValue >= root.val) {
            return null;
        }
        previousValue = root.val;
        return isInOrder(root.right, previousValue);
    }

    public boolean isBinarySearchTreeRecursive(TreeNode root) {
        return isBinarySearchTreeRecursive(root, Integer.MAX_VALUE, Integer.MIN_VALUE);
    }

    private boolean isBinarySearchTreeRecursive(TreeNode root, int max, int min) {
        if (root == null) {
            return true;
        }
        if (root.val >= max || root.val <= min) {
            return false;
        }
        return isBinarySearchTreeRecursive(root.left, root.val, min)
            && isBinarySearchTreeRecursive(root.right, max, root.val);
    }
}
