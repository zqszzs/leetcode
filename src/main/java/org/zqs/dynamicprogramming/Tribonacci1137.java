package org.zqs.dynamicprogramming;

/**
 * 1137. 第 N 个泰波那契数
 */
public class Tribonacci1137 {
    public static int tribonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }

        int [] temp = new int [n + 1];
        temp[0] = 0;
        temp[1] = 1;
        temp[2] = 1;
        return climbStairs(n, temp);
    }

    public static int climbStairs(int n, int [] temp) {
        if (n == 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        if (temp[n] > 0) {
            return temp[n];
        }

        int result = climbStairs(n-1, temp) + climbStairs(n-2, temp) + climbStairs(n-3, temp);
        temp[n] = result;
        return result;
    }
}
