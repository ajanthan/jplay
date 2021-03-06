package com.github.ajanthan.problems.p21;

import com.github.ajanthan.problems.ListNode;

public class Solution {

    public ListNode mergeTwoListsV0(ListNode l1, ListNode l2) {
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

    public ListNode mergeTwoListsV1(ListNode l1, ListNode l2) {
        ListNode root = new ListNode(0);
        ListNode handler = root;
        while (l1 != null && l2 != null) {
            if (l1.val >= l2.val) {
                handler.next = l2;
                handler = l2;
                l2 = l2.next;
            } else {
                handler.next = l1;
                handler = l1;
                l1 = l1.next;
            }
        }
        if (l1 == null && l2 != null) {
            handler.next = l2;
        } else if (l1 != null && l2 == null) {
            handler.next = l1;
        }
        return root.next;
    }

    public ListNode mergeKListsV1(ListNode[] lists) {
        if (lists.length > 0) {
            ListNode merged = lists[0];
            for (int i = 1; i < lists.length; i++) {
                merged = mergeTwoListsV1(merged, lists[i]);
            }
            return merged;
        } else {
            return null;
        }

    }

    public ListNode mergeKListsV2(ListNode[] lists) {
        if (lists.length > 0) {
            int interval = 1;
            while (interval < lists.length) {
                for (int i = 0; i + interval < lists.length; i += interval * 2) {
                    lists[i] = mergeTwoListsV1(lists[i], lists[i + interval]);
                }
                interval *= 2;
            }
            return lists[0];
        } else {
            return null;
        }

    }
}
