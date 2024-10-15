package org.zqs.dynamicprogramming;

/**
 * 不同路径
 */
public class UniquePathsWithObstacles63 {

    public static void main(String[] args) {
        int [] [] param = new int [] [] {{0,0,0},{0,1,0},{0,0,0}};
        int result = uniquePathsWithObstacles(param);
        System.out.println(result);
    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int i = obstacleGrid.length;
        int j = obstacleGrid[0].length;

        int [] [] dp = new int [obstacleGrid.length] [obstacleGrid[0].length];
        dp[0][0] = obstacleGrid[0][0] == 0 ? 1 : 0;
        for (int k = 1; k < i; k++) {
            if (obstacleGrid[k][0] == 0 && dp[k -1][0] == 1) {
                dp[k][0] = 1;
            } else {
                dp[k][0] = 0;
            }
        }
        for (int k = 1; k < j; k++) {
            if (obstacleGrid[0][k] == 0 && dp[0][k-1] == 1) {
                dp[0][k] = 1;
            } else {
                dp[0][k] = 0;
            }
        }

        if (i < 1) {
            return dp[0][obstacleGrid.length - 1];
        }
        if (j < 1) {
            return dp[obstacleGrid.length - 1][0];
        }

        for (int a = 1; a < i; a++) {
            for (int b = 1; b < j; b++) {
                if (obstacleGrid[a][b] == 1) {
                    dp[a][b] = 0;
                } else {
                    dp[a][b] = dp[a - 1][b] + dp[a][b - 1];
                }
            }
        }

        return dp[i-1][j -1];
    }
}
