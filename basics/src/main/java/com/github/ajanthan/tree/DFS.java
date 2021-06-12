package com.github.ajanthan.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DFS {
    public List<Integer> traverse(TreeNode root, Method method, Order order) {
        List<Integer> list = null;
        switch (method) {
            case ITERATIVE:
                list = traverseIterator(root, order);
                break;
            case RECURSIVE:
                list = new ArrayList<>();
                traverseRecursively(root, list, order);
        }
        return list;
    }

    private void traverseRecursively(TreeNode root, List<Integer> list, Order order) {
        if (root == null) {
            return;
        }
        switch (order) {
            case PRE_ORDER:
                list.add(root.val);
                traverseRecursively(root.left, list, order);
                traverseRecursively(root.right, list, order);
                break;
            case IN_ORDER:
                traverseRecursively(root.left, list, order);
                list.add(root.val);
                traverseRecursively(root.right, list, order);
                break;
            case POST_ORDER:
                traverseRecursively(root.left, list, order);
                traverseRecursively(root.right, list, order);
                list.add(root.val);
        }
    }

    private List<Integer> traverseIterator(TreeNode root, Order order) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode node;
        switch (order) {
            case PRE_ORDER:
                while (!stack.isEmpty()) {
                    node = stack.pop();
                    list.add(node.val);
                    if (node.right != null) {
                        stack.push(node.right);
                    }
                    if (node.left != null) {
                        stack.push(node.left);
                    }
                }
                break;
            case IN_ORDER:
                node = root.left;
                while (node != null || !stack.isEmpty()) {
                    while (node != null) {
                        stack.push(node);
                        node = node.left;
                    }
                    node = stack.pop();
                    list.add(node.val);
                    node = node.right;
                }
                break;
            case POST_ORDER:
                Stack<TreeNode> stack2 = new Stack<>();
                while (!stack.isEmpty()) {
                    node = stack.pop();
                    stack2.push(node);
                    if (node.left != null) {
                        stack.push(node.left);
                    }
                    if (node.right != null) {
                        stack.push(node.right);
                    }
                }
                while (!stack2.isEmpty()) {
                    list.add(stack2.pop().val);
                }
        }
        return list;
    }

    enum Order {
        PRE_ORDER, IN_ORDER, POST_ORDER
    }

    enum Method {
        ITERATIVE, RECURSIVE
    }
}
