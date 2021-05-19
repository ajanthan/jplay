package com.github.ajanthan.jplay.algo.pattern;

import java.util.ArrayList;
import java.util.List;

public class Knapsack {
    public static void main(String[] args) {
        Knapsack knapsack = new Knapsack();
        System.out.println(knapsack.getFruitsForMaxProfit(new String[]{ "Apple", "Orange", "Banana", "Melon" }, new int[]{ 2, 3, 1, 4 }, new int[]{ 4, 5, 3, 7 }, 5));
        System.out.println(knapsack.getMaxProfitV1(new int[]{ 2, 3, 1, 4 }, new int[]{ 4, 5, 3, 7 }, 5));
        System.out.println(knapsack.getMaxProfitV2(new int[]{ 2, 3, 1, 4 }, new int[]{ 4, 5, 3, 7 }, 5));
        System.out.println(knapsack.getMaxProfitV3(new int[]{ 2, 3, 1, 4 }, new int[]{ 4, 5, 3, 7 }, 5));
    }

    public Result getFruitsForMaxProfit(String[] fruits, int[] weights, int[] profits, int cap) {
        return getFruitsForMaxProfit(fruits, weights, profits, cap, 0, 0, 0, new ArrayList<String>());
    }

    private Result getFruitsForMaxProfit(String[] fruits, int[] weights, int[] profits, int cap, int currentWeight, int profit, int i, List<String> bag) {
        if (i == fruits.length) {
            if (currentWeight <= cap) {
                return new Result(profit, currentWeight, new ArrayList<String>(bag));
            }
            return null;
        }
        if (currentWeight > cap) {
            return null;
        }
        Result temProfit1 = getFruitsForMaxProfit(fruits, weights, profits, cap, currentWeight, profit, i + 1, bag);
        bag.add(fruits[i]);
        Result temProfit2 = getFruitsForMaxProfit(fruits, weights, profits, cap, currentWeight + weights[i], profit + profits[i], i + 1, bag);
        bag.remove(fruits[i]);
        if (temProfit1 != null && temProfit2 != null) {
            if (temProfit1.maxProfit > temProfit2.maxProfit) {
                return temProfit1;
            } else {
                return temProfit2;
            }
        } else {
            return temProfit1 == null ? temProfit2 : temProfit1;
        }
    }

    class Result {
        int maxProfit;
        int weight;
        List<String> fruits;

        public Result(int maxProfit, int weight, List<String> fruits) {
            this.maxProfit = maxProfit;
            this.weight = weight;
            this.fruits = fruits;
        }

        @Override
        public String toString() {
            return "Result{" +
                "maxProfit=" + maxProfit +
                ", weight=" + weight +
                ", fruits=" + fruits +
                '}';
        }
    }

    public int getMaxProfitV1(int[] capacities, int[] profits, int capacity) {
        return getMaxProfitRecursive(profits, capacities, capacity, 0);
    }

    public int getMaxProfitV2(int[] capacities, int[] profits, int capacity) {
        return getMaxProfitRecursive(profits, capacities, capacity, 0, new int[capacities.length][capacity + 1]);
    }

    public int getMaxProfitV3(int[] capacities, int[] profits, int capacity) {
        int[][] dp = new int[capacities.length][capacity + 1];
        for (int i = 0; i < capacities.length; i++) {
            dp[i][0] = 0;
        }

        for (int i = 0; i <= capacity; i++) {
            if (capacities[0] <= i) {
                dp[0][i] = profits[0];
            }
        }

        for (int i = 1; i < profits.length; i++) {
            for (int c = 1; c <= capacity; c++) {
                if (capacities[i] <= c) {
                    dp[i][c] = Math.max(profits[i] + dp[i - 1][c - capacities[i]], dp[i - 1][c]);
                } else {
                    dp[i][c] = dp[i - 1][c];
                }
            }
        }
        System.out.print("Selected weights: ");
        int tempCapacity = capacity, tempProfit = dp[profits.length - 1][capacity];
        for (int i = profits.length - 1; i >= 1; i--) {
            if (tempProfit != dp[i - 1][tempCapacity]) {
                System.out.print(capacities[i] + " ");
                tempCapacity -= capacities[i];
                tempProfit -= profits[i];
            }
        }
        if (tempProfit != 0) {
            System.out.print(capacities[0]);
        }
        System.out.println();
        return dp[profits.length - 1][capacity];
    }

    private int getMaxProfitRecursive(int[] profits, int[] capacities, int capacity, int currentIndex) {
        if (capacity <= 0 || currentIndex >= profits.length) {
            return 0;
        }
        int profit1 = 0;
        if (capacities[currentIndex] <= capacity) {
            profit1 = profits[currentIndex] + getMaxProfitRecursive(profits, capacities, capacity - capacities[currentIndex], currentIndex + 1);
        }
        int profit2 = getMaxProfitRecursive(profits, capacities, capacity, currentIndex + 1);
        return Math.max(profit1, profit2);
    }

    private int getMaxProfitRecursive(int[] profits, int[] capacities, int capacity, int currentIndex, int[][] memoization) {
        if (capacity <= 0 || currentIndex >= profits.length) {
            return 0;
        }
        if (memoization[currentIndex][capacity] != 0) {
            return memoization[currentIndex][capacity];
        }
        int profit1 = 0;
        if (capacities[currentIndex] <= capacity) {
            profit1 = profits[currentIndex] + getMaxProfitRecursive(profits, capacities, capacity - capacities[currentIndex], currentIndex + 1);
        }
        int profit2 = getMaxProfitRecursive(profits, capacities, capacity, currentIndex + 1);
        memoization[currentIndex][capacity] = Math.max(profit1, profit2);
        return memoization[currentIndex][capacity];
    }
}
