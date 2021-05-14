package com.github.ajanthan.jplay.algo.pattern.p5;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/*
Problem Statement
For a given number ‘N’, write a function to generate all combination of ‘N’ pairs of balanced parentheses.
Example 1:
Input: N=2
Output: (()), ()()
Example 2:
Input: N=3
Output: ((())), (()()), (())(), ()(()), ()()()
 */
public class Solution {

    final String singlePair = "()";

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println("Output: " + solution.getBalancedParentheses(2));
        System.out.println("Output: " + solution.getBalancedParentheses(3));
        System.out.println();
        System.out.println("Output: " + solution.getBalancedParenthesesV1(2));
        System.out.println();
        System.out.println("Output: " + solution.getBalancedParenthesesV2(2));
    }

    public List<String> getBalancedParentheses(int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(singlePair);
        }
        String in = sb.toString();
        List<String> res = new ArrayList<>();
        getBalancedParentheses("", 0, in, res);
        return res;
    }

    private void getBalancedParentheses(String prefix, int pStatus, String s, List<String> res) {
        if (s.isEmpty() && pStatus == 0) {
            if (!res.contains(prefix))
                res.add(prefix);
            return;
        }

        for (int i = 0; i < s.length(); i++) {
            int lPStatus = pStatus;
            if (i > 0 && s.charAt(i) == s.charAt(i - 1)) return;
            char c = s.charAt(i);
            if (c == '(') {
                lPStatus++;
            } else {
                lPStatus--;
            }
            if (lPStatus < 0) {
                // lPStatus = Integer.MAX_VALUE;
                return;
            }
            if (i == s.length() - 1) {
                getBalancedParentheses(prefix + c, lPStatus, s.substring(0, i), res);
            } else {
                getBalancedParentheses(prefix + c, lPStatus, s.substring(0, i) + s.substring(i + 1), res);
            }
        }
    }

    public List<String> getBalancedParenthesesV1(int n) {
        List<String> res = new ArrayList<>();
        Queue<PString> q = new ArrayDeque<>();
        q.add(new PString("", 0, 0));
        while (!q.isEmpty()) {
            PString p = q.poll();
            if (p.openCount == n && p.closeCount == n) {
                res.add(p.s);
            } else {
                if (p.openCount > p.closeCount) q.add(new PString(p.s + ")", p.openCount, p.closeCount + 1));
                if (p.openCount < n) q.add(new PString(p.s + "(", p.openCount + 1, p.closeCount));
            }
        }
        return res;
    }

    class PString {
        String s;
        int openCount;
        int closeCount;

        public PString(String in, int openCount, int closeCount) {
            this.s = in;
            this.openCount = openCount;
            this.closeCount = closeCount;
        }
    }

    public List<String> getBalancedParenthesesV2(int n) {
        List<String> res = new ArrayList<>();
        getBalancedParenthesesV2Helper(n, "", 0, 0, res);
        return res;
    }

    private void getBalancedParenthesesV2Helper(int n, String s, int openCount, int closeCount, List<String> res) {
        if (openCount == n && closeCount == n) {
            res.add(s);
            return;
        }
        if (openCount > closeCount) {
            getBalancedParenthesesV2Helper(n, s + ")", openCount, closeCount + 1, res);
        }
        if (openCount < n) {
            getBalancedParenthesesV2Helper(n, s + "(", openCount + 1, closeCount, res);
        }
    }
}

