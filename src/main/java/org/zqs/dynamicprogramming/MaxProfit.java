package org.zqs.dynamicprogramming;

/**
 * 股票买卖
 */
public class MaxProfit {

    public static void main(String[] args) {
        int [] prices = new int [] {7,1,5,3,6,4};
        int maxProfit = maxProfit(prices);
        System.out.println(maxProfit);
    }

    public static int maxProfit(int[] prices) {
        int [][] profit = new int [prices.length][2];
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (i == 0) {
                profit[0][0] = 0;
                profit[0][1] = -prices[i];
            } else {
                int notHas = Math.max(profit[i - 1][0], profit[i - 1][1] + prices[i]);
                int has = Math.max(profit[i - 1][1], -prices[i]);
                profit[i][0] = notHas;
                profit[i][1] = has;
                maxProfit = Math.max(notHas, has);
            }
        }

        return maxProfit;
    }
}
