package org.zqs.dynamicprogramming;

public class Jump55 {

    public static void main(String[] args) {

        boolean result = canJump(new int [] {3,2,1,0,4});
        System.out.println(result);
    }

    public static boolean canJump(int[] nums) {
        if (nums == null || nums.length < 2) {
            return true;
        }
        int nextStep = 0;
        while (nextStep < nums.length) {
            int num = nums[nextStep];
            if (num == 0) {
                return false;
            }
            if (nextStep + num >= nums.length - 1) {
                return true;
            }

            int tempStep = 0;
            int nextBestValue = num;
            for (int j = 1; j <= num; j++) {
                if (nums[nextStep + j] + j >= nextBestValue) {
                    nextBestValue = nums[nextStep + j] + j;
                    tempStep = nextStep + j;
                }
            }
            nextStep = tempStep;
        }

        return false;
    }


    /**
     * 优化
     * 1. 最远可达
     *
     */

    public static boolean canJump1(int[] nums) {
        // 当前最远可达到的位置
        int rightRoast = 0;

        for (int i = 0; i < nums.length; i++) {
            // 如果当前位置小于最远可达，表示当前位置也可达
            if (i <= rightRoast) {
                // 更新最远可达位置
                rightRoast = Math.max(i + nums[i], rightRoast);
                // 如果最远可达大于数组最后位置，则可以通过
                if (rightRoast >= nums.length - 1) {
                    return true;
                }
            }
        }

        return false;
    }

}
