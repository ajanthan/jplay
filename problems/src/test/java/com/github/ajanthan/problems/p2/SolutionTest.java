package com.github.ajanthan.problems.p2;

import com.github.ajanthan.problems.ListNode;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SolutionTest {
    private Solution solution;

    @Before
    public void setUp() throws Exception {
        solution = new Solution();
    }

    @Test
    public void addTwoNumbers() {
        /*
        [2,4,3]
[5,6,4]
[0]
[0]
[9,9,9,9,9,9,9]
[9,9,9,9]
         */
        ListNode l11 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l12 = new ListNode(5, new ListNode(6, new ListNode(4)));

        ListNode l21 = new ListNode(0);
        ListNode l22 = new ListNode(0);

        ListNode l31 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9)))))));
        ListNode l32 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))));
        int[] ans = { 807, 0, 10009998 };

        ListNode r = solution.addTwoNumbers(l11, l12);
        Assert.assertTrue(isSame(ans[0], r));

        r = solution.addTwoNumbers(l21, l22);
        Assert.assertTrue(isSame(ans[1], r));

        r = solution.addTwoNumbers(l31, l32);
        Assert.assertTrue(isSame(ans[2], r));
    }

    private boolean isSame(int i, ListNode head) {
        int currentDigit;
        while (head != null) {
            currentDigit = i % 10;
            if (head.val != currentDigit) {
                return false;
            }
            head = head.next;
            i /= 10;
        }
        return i == 0;
    }
}