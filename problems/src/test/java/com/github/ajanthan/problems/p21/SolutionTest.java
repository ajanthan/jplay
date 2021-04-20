package com.github.ajanthan.problems.p21;

import com.github.ajanthan.problems.ListNode;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SolutionTest {
    private Solution solution;

    @Before
    public void setUp() throws Exception {
        this.solution = new Solution();
    }

    @Test
    public void mergeTwoListsV0() {
        ListNode root1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode root2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode root3 = null;
        ListNode root4 = null;
        ListNode root5 = new ListNode(0);
        ListNode root6 = new ListNode(1, new ListNode(3, new ListNode(5)));
        ListNode root7 = new ListNode(2, new ListNode(4, new ListNode(6)));
        ListNode root8 = new ListNode(1, new ListNode(3, new ListNode(5, new ListNode(5, new ListNode(9)))));
        ListNode root9 = new ListNode(2, new ListNode(5, new ListNode(6)));
        ListNode[][] ins = { { root1, root2 }, { root3, root4 }, { root3, root5 }, { root6, root7 }, { root8, root9 } };
        for (ListNode[] root : ins) {
            Assert.assertTrue(isAscending(solution.mergeTwoListsV0(root[0], root[1])));
        }
    }

    @Test
    public void mergeTwoListsV1() {
        ListNode root1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode root2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode root3 = null;
        ListNode root4 = null;
        ListNode root5 = new ListNode(0);
        ListNode root6 = new ListNode(1, new ListNode(3, new ListNode(5)));
        ListNode root7 = new ListNode(2, new ListNode(4, new ListNode(6)));
        ListNode root8 = new ListNode(1, new ListNode(3, new ListNode(5, new ListNode(5, new ListNode(9)))));
        ListNode root9 = new ListNode(2, new ListNode(5, new ListNode(6)));
        ListNode[][] ins = { { root1, root2 }, { root3, root4 }, { root3, root5 }, { root6, root7 }, { root8, root9 } };
        for (ListNode[] root : ins) {
            Assert.assertTrue(isAscending(solution.mergeTwoListsV1(root[0], root[1])));
        }
    }

    private boolean isAscending(ListNode root) {
        if (root == null) {
            return true;
        }
        ListNode current = root, next = root.next;
        while (next != null) {
            if (current.val > next.val) {
                System.out.println();
                return false;
            }
            System.out.printf("%d => ", current.val);
            current = next;
            next = next.next;
        }
        System.out.println(current.val);
        return true;
    }

    @Test
    public void mergeKListsV2() {
        ListNode root1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode root2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode root3 = null;
        ListNode root4 = null;
        ListNode root5 = new ListNode(0);
        ListNode root6 = new ListNode(1, new ListNode(3, new ListNode(5)));
        ListNode root7 = new ListNode(2, new ListNode(4, new ListNode(6)));
        ListNode root8 = new ListNode(1, new ListNode(3, new ListNode(5, new ListNode(5, new ListNode(9)))));
        ListNode root9 = new ListNode(2, new ListNode(5, new ListNode(6)));
        ListNode[][] ins = { { root1, root2 }, { root3, root4 }, { root3, root5 }, { root6, root7, root8, root9 } };
        for (ListNode[] root : ins) {
            Assert.assertTrue(isAscending(solution.mergeKListsV2(root)));
        }
    }

    @Test
    public void mergeKListsV1() {
        ListNode root1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode root2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode root3 = null;
        ListNode root4 = null;
        ListNode root5 = new ListNode(0);
        ListNode root6 = new ListNode(1, new ListNode(3, new ListNode(5)));
        ListNode root7 = new ListNode(2, new ListNode(4, new ListNode(6)));
        ListNode root8 = new ListNode(1, new ListNode(3, new ListNode(5, new ListNode(5, new ListNode(9)))));
        ListNode root9 = new ListNode(2, new ListNode(5, new ListNode(6)));
        ListNode[][] ins = { { root1, root2 }, { root3, root4 }, { root3, root5 }, { root6, root7, root8, root9 } };
        for (ListNode[] root : ins) {
            Assert.assertTrue(isAscending(solution.mergeKListsV1(root)));
        }
    }
}