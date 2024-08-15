package org.zqs.dynamicprogramming;

public class MaxLengthChildArray300 {

    public static void main(String[] args) {
        int result = lengthOfLIS(new int [] {0,1,0,3,2,3});
        System.out.println(result);
    }

    public static int lengthOfLIS(int[] nums) {
        int [] dp = new int [nums.length];
        int result = 1;
        dp[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }

                result =Math.max(result, dp[i]);
            }
        }
        return result;
    }

}
