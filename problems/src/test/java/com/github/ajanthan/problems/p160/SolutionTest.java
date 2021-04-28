package com.github.ajanthan.problems.p160;

import com.github.ajanthan.problems.ListNode;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SolutionTest {
    private Solution solution;
    ListNode common0 = new ListNode(8, new ListNode(4, new ListNode(5)));
    ListNode headA0 = new ListNode(4, new ListNode(1, common0));
    ListNode headB0 = new ListNode(5, new ListNode(6, new ListNode(1, common0)));

    ListNode common1 = new ListNode(2, new ListNode(4));
    ListNode headA1 = new ListNode(1, new ListNode(9, new ListNode(1, common1)));
    ListNode headB1 = new ListNode(3, common1);

    ListNode headA2 = new ListNode(2, new ListNode(6, new ListNode(4)));
    ListNode headB2 = new ListNode(1, new ListNode(5));

    @Before
    public void setUp() throws Exception {
        solution = new Solution();
    }

    @Test
    public void getIntersectionNodeV0() {
        ListNode res = solution.getIntersectionNodeV0(headA0, headB0);
        Assert.assertEquals(common0, res);

        res = solution.getIntersectionNodeV0(headA1, headB1);
        Assert.assertEquals(common1, res);

        res = solution.getIntersectionNodeV0(headA2, headB2);
        Assert.assertEquals(null, res);
    }

    @Test
    public void getIntersectionNodeV1() {
        ListNode res = solution.getIntersectionNodeV1(headA0, headB0);
        Assert.assertEquals(common0, res);

        res = solution.getIntersectionNodeV1(headA1, headB1);
        Assert.assertEquals(common1, res);

        res = solution.getIntersectionNodeV1(headA2, headB2);
        Assert.assertEquals(null, res);
    }
}