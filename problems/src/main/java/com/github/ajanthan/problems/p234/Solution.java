package com.github.ajanthan.problems.p234;

import com.github.ajanthan.problems.ListNode;

import java.util.Stack;

public class Solution {
    public boolean isPalindromeV1(ListNode head) {
        if (head == null) {
            return false;
        } else if (head.next == null) {
            return true;
        }
        Stack<Integer> stack = new Stack<>();
        ListNode slow = head, fast = head;
        stack.push(slow.val);
        while (fast != null && fast.next != null) {
            slow = slow.next;
            stack.push(slow.val);
            fast = fast.next.next;
        }
        if (fast == null) {
            stack.pop();
        }
        while (slow != null) {
            if (stack.pop().compareTo(slow.val) != 0) {
                return false;
            }
            slow = slow.next;
        }
        return true;
    }

    public boolean isPalindromeV2(ListNode head) {
        ListNode ret = walkRecursively(head, head);
        return ret == null || ret.val != -1;
    }

    private ListNode walkRecursively(ListNode slow, ListNode fast) {
        if (fast == null) {
            return slow;
        } else if (fast.next == null) {
            return slow.next;
        }
        ListNode reverseNode = walkRecursively(slow.next, fast.next.next);
        if (reverseNode.val != slow.val) {
            return new ListNode(-1);
        } else {
            return reverseNode.next;
        }
    }
}
