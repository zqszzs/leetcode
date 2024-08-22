package org.zqs.dynamicprogramming;

public class MinPathSum64 {

    public static void main(String[] args) {
       int result = minPathSum1(new int [] [] {{1,2},{1,1}});
        System.out.println(result);
    }

    public static int minPathSum(int[][] grid) {
        if (grid == null) {
            return 0;
        }

        int [][][] dp = new int[grid.length][grid[0].length][2];
        dp[0][0][0] = grid[0][0];
        dp[0][0][1] = grid[0][0];
        
        int m = grid.length;
        int n = grid[0].length;

        for (int i = 1; i < n; i++) {
            dp[0][i][0] = dp[0][i - 1][0] + grid[0][i];
            dp[0][i][1] = dp[0][i - 1][0] + grid[0][i];
        }

        for (int i = 1; i < m; i++) {
            dp[i][0][0] = dp[i - 1][0][0] + grid[i][0];
            dp[i][0][1] = dp[i - 1][0][0] + grid[i][0];
        }
        
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                // 从上面过来
                dp[i][j][0] =  Math.min(dp[i][j - 1][0], dp[i][j - 1][1]) + grid[i][j];
                // 从下面过来
                dp[i][j][1] =  Math.min(dp[i - 1][j][0], dp[i - 1][j][1]) + grid[i][j];
            }
        }

        return Math.min(dp[m-1][n-1][0], dp[m-1][n-1][1]);
    }


    public static int minPathSum1(int[][] grid) {
        if (grid == null) {
            return 0;
        }

        int [][] dp = new int[grid.length][grid[0].length];
        dp[0][0] = grid[0][0];
        dp[0][0] = grid[0][0];

        int m = grid.length;
        int n = grid[0].length;

        for (int i = 1; i < n; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }

        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i][j - 1], dp[i - 1][j]) + grid[i][j];
            }
        }

        return dp[m-1][n-1];
    }
}
