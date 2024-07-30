package org.zqs;

public class Divide29 {
    public static void main(String[] args) {
        int result = divide(-2147483648, -1);
        System.out.println(result);
    }

    public static int divide(int dividend, int divisor) {

        if (-2147483648 == dividend && divisor == -1) {
            return 2147483647;
        }
        if (-2147483648 == dividend && divisor == 1) {
            return -2147483648;
        }

        boolean less0 = dividend < 0 || divisor < 0;
        if (less0) {
            less0 = !(dividend < 0 && divisor < 0);
        }

        int result = 0;
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);

        if (divisor == 1) {
            return less0 ? 0 - dividend : dividend;
        }

        while (dividend - divisor >= 0) {
            result++;
            dividend = dividend - divisor;
        }

        if (less0) {
            return 0 - result;
        }
        return result;
    }
}
