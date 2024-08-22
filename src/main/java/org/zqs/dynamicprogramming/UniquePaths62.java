package org.zqs.dynamicprogramming;

/**
 * 找规律，杨辉三角
 * ._1__2__3__4__5__
 * 1| 1  1  1  1  1
 * 2| 1  2  3  4  5
 * 3| 1  3  6 10 15
 * 4| 1  4 10 20 35
 * 5| 1  5 15 35 70
 */
public class UniquePaths62 {


    public static void main(String[] args) {
        int result = uniquePaths(3, 2);
        System.out.println(result);
    }

    /**
     *
     * 1. 边界: m <= 1 || n <= 1, return 1
     * 2. 状态：dp[i][j]表示到这个格子需要的步数
     * 3. 表达式: dp[i][j] = dp[i - 1][j] + dp[i][j - 1]
     *
     * @param m
     * @param n
     * @return
     */
    public static int uniquePaths(int m, int n) {
        if (m <= 1 || n <= 1) {
            return 1;
        }

        int[][] dp = new int[m + 1][n + 1];
        dp[1][2] = 1;
        dp[2][1] = 1;
        for (int i = 2; i <= m; i++) {
            for (int j = 2; j <= n; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], 1) + Math.max(dp[i][j - 1], 1);
            }
        }

        return dp[m][n];
    }
}
