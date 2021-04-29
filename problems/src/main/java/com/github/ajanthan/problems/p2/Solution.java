package com.github.ajanthan.problems.p2;

import com.github.ajanthan.problems.ListNode;

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(-1);
        ListNode current = dummyHead;
        int sum = 0;
        while (l1 != null || l2 != null) {
            sum /= 10;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            current.next = new ListNode(sum % 10);
            current = current.next;
        }
        sum /= 10;
        if (sum > 0) current.next = new ListNode(sum);
        return dummyHead.next;
    }
}
