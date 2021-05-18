package com.github.ajanthan.jplay.algo.pattern;

import java.util.ArrayList;
import java.util.List;

public class Knapsack {
    public static void main(String[] args) {
        Knapsack knapsack = new Knapsack();
        System.out.println(knapsack.getFruitsForMaxProfit(new String[]{ "Apple", "Orange", "Banana", "Melon" }, new int[]{ 2, 3, 1, 4 }, new int[]{ 4, 5, 3, 7 }, 5));
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
}
