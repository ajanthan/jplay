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

    /**
     * 4
     * / \
     * /   \
     * 2     6
     * / \   / \
     * 1   3 5   7
     * <p>
     * 1
     * \
     * 2
     * \
     * 3
     * \
     * 4
     * \
     * \
     * 6
     * / \
     * 5   7
     *
     * @param root
     */
    public void printTreeMorrisTraversal(TreeNode root) {
        TreeNode current = root, previous;
        while (current != null) {
            if (current.left == null) {
                System.out.print(" " + current.val + " ");
                current = current.right;
            } else {
                previous = current.left;
                while (previous.right != null) {
                    previous = previous.right;
                }
                previous.right = current;
                TreeNode temp = current;
                current = current.left;
                temp.left = null;
            }
        }
    }

    public boolean isBinarySearchTreeNoRecursion(TreeNode root) {
        TreeNode currentNode = root, previousNode;
        int previousVal = Integer.MIN_VALUE;
        while (currentNode != null) {
            if (currentNode.left != null) {
                previousNode = currentNode.left;
                while (previousNode.right != null && previousNode.right != currentNode) {
                    previousNode = previousNode.right;
                }
                if (previousNode.right == null) {
                    previousNode.right = currentNode;
                    currentNode = currentNode.left;
                } else {
                    previousNode.right = null;
                    if (currentNode.val <= previousVal) {
                        return false;
                    }
                    previousVal = currentNode.val;
                    currentNode = currentNode.right;
                }
            } else {
                if (currentNode.val <= previousVal) {
                    return false;
                }
                previousVal = currentNode.val;
                currentNode = currentNode.right;
            }
        }
        return true;
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
