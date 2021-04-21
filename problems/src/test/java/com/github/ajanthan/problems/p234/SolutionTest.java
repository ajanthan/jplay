package com.github.ajanthan.problems.p234;

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
    public void isPalindrome() {
        ListNode head0 = new ListNode(1, new ListNode(2, new ListNode(1)));
        ListNode head1 = new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(1))));
        ListNode head2 = new ListNode(1, new ListNode(2));
        ListNode[] ins = { head0, head1, head2 };
        boolean[] ans = { true, true, false };

        for (int i = 0; i < ins.length; i++) {
            Assert.assertTrue(ans[i] == solution.isPalindromeV1(ins[i]));
        }
    }

    @Test
    public void isPalindromeV2() {
        ListNode head0 = new ListNode(1, new ListNode(2, new ListNode(1)));
        ListNode head1 = new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(1))));
        ListNode head2 = new ListNode(1, new ListNode(2));
        ListNode[] ins = { head0, head1, head2 };
        boolean[] ans = { true, true, false };

        for (int i = 0; i < ins.length; i++) {
            Assert.assertTrue(ans[i] == solution.isPalindromeV2(ins[i]));
        }
    }
}