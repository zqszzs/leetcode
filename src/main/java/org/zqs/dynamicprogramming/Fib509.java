package org.zqs.dynamicprogramming;

/**
 * 509. 斐波那契数
 */
public class Fib509 {

    public static int fib(int n) {
        if (n < 2) {
            return n;
        }
        int [] temp = new int [n + 1];
        temp[0] = 0;
        temp[1] = 1;
        return climbStairs(n, temp);
    }

    public static int climbStairs(int n, int [] temp) {
        if (n < 2) {
            return n;
        }

        if (temp[n] > 0) {
            return temp[n];
        }

        int result = climbStairs(n-1, temp) + climbStairs(n-2, temp);
        temp[n] = result;
        return result;
    }
}
