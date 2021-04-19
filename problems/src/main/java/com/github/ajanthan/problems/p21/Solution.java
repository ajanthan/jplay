package com.github.ajanthan.problems.p21;

import com.github.ajanthan.problems.ListNode;

public class Solution {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode root, l, current, prev;
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }
        if (l1.val < l2.val) {
            root = l1;
            l = l2;
        } else {
            root = l2;
            l = l1;
        }
        current = root.next;
        prev = root;
        while (current != null && l != null) {
            if (current.val < l.val) {
                prev = current;
                current = current.next;
            } else {
                ListNode temp = l;
                l = l.next;
                prev.next = temp;
                temp.next = current;
                prev = temp;
            }
        }
        if (current == null && l != null) {
            prev.next = l;
        }
        return root;
    }
}
