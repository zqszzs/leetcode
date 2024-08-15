package org.zqs.dynamicprogramming;

import java.util.Arrays;

public class Lingqianduihuan322 {

    public static void main(String[] args) {
        int result = coinChange(new int [] {186,419,83,408}, 6249);
        System.out.println(result);
    }

    public static int coinChange(int[] coins, int amount) {
        if (amount < 1) {
            return 0;
        }
        Arrays.sort(coins);
        int count = 0;
        for (int i = coins.length - 1; i >= 0 && amount > 0; i--) {
            int subCount = amount / coins[i];
            if (subCount > 0) {
                count += subCount;
                amount = amount % coins[i];
            }
        }

        return amount > 0 ? -1 : count;
    }
}
