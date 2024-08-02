package org.zqs.dynamicprogramming;

/**
 * 打家劫舍
 *
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：[1,2,3,1]
 * 输出：4
 * 解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 *      偷窃到的最高金额 = 1 + 3 = 4 。
 * 示例 2：
 *
 * 输入：[2,7,9,3,1]
 * 输出：12
 * 解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
 *      偷窃到的最高金额 = 2 + 9 + 1 = 12 。
 *
 * 作者：LeetCode
 * 链接：https://leetcode.cn/leetbook/read/top-interview-questions-easy/xnq4km/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class Rob {

    public static void main(String[] args) {
        int nums []  = new int [] {6,3,10,8,2,10,3,5,10,5,3};
        int result = rob3(nums);
        System.out.println(result);
    }

    /**
     * 1. 确认状态:  dp[i][0]今天偷东西可以获取的最大价值, dp[i][1]今天不偷东西可以获取的最大价值
     *
     * 2. 确认表达式:
     * // 今天偷最大值 = Math.max(前天偷, 昨天不偷) + 今天值
     * dp[i][0] = Math.max(dp[i - 2][0], dp[i - 1][1]) + nums[i];
     * // 今天不偷: 最大值 = Math.max(前天偷,昨天偷)
     * dp[i][1] = Math.max(dp[i - 1][0], dp[i - 2][0]);
     *
     * 3. 确认边界
     * 数组小于2时, return nums[0]
     * 数组小于3时, return Math.max(nums[0], nums[1])
     * 遍历从2开始
     *
     * @param nums
     * @return
     */
    public static int rob(int[] nums) {
        if (nums.length < 2) {
            return nums[0];
        }

        if (nums.length < 3) {
            return Math.max(nums[0], nums[1]);
        }

        int dp [] [] = new int[nums.length][2];
        dp[0][0] = nums[0];
        dp[0][1] = 0;

        dp[1][0] = nums[1];
        dp[1][1] = nums[0];

        int result = 0;
        for (int i = 2; i < nums.length; i++) {
            // 今天偷: 最大值 = Math.max(前天偷, 昨天不偷) + 今天值
            dp[i][0] = Math.max(dp[i - 2][0], dp[i - 1][1]) + nums[i];
            // 今天不偷: 最大值 = Math.max(前天偷,昨天偷)
            dp[i][1] = Math.max(dp[i - 1][0], dp[i - 2][0]);
            result = Math.max(result, Math.max(dp[i][0], dp[i][1]));
        }

        return result;
    }


    /**
     * 1. 确认状态:  dp[i]为当天偷取的最大值
     *
     * 2. 确认表达式:
     * 当天偷取的最大值 = Math.max(前天的最大值 + 今天可以偷到的值， 昨天偷到的最大值)
     * dp[i] = Math.max(dp[i- 2] + nums[i], dp[i - 1])
     *
     * 3. 确认边界
     * 数组小于2时, return nums[0]
     * 数组小于3时, return Math.max(nums[0], nums[1])
     * 遍历从2开始
     *
     * @param nums
     * @return
     */
    public static int rob1(int[] nums) {
        if (nums.length < 2) {
            return nums[0];
        }

        if (nums.length < 3) {
            return Math.max(nums[0], nums[1]);
        }

        /**
         * res[i] 表示当前步骤能投的最大值
         */
        int [] res = new int [nums.length];
        res[0] = nums[0];
        res[1] = Math.max(nums[0], nums[1]);
        int result = 0;
        for (int i = 2; i < nums.length; i++) {
            //当天偷取的最大值 = Math.max(前天的偷到的最大值 + 今天可以偷到的值， 昨天偷到的最大值)
            res[i] = Math.max(res[i - 2] + nums[i], res[i - 1]);
            result = Math.max(res[i], result);
        }

        return result;
    }


    /**
     * 优化空间复杂度
     * @param nums
     * @return
     * 6,3,10,8,2,10,3,5,10,5,3
     *
     */
    public static int rob3(int[] nums) {
        if (nums.length < 2) {
            return nums[0];
        }

        if (nums.length < 3) {
            return Math.max(nums[0], nums[1]);
        }

        /**
         * res[i] 表示当前步骤能投的最大值
         */

        int yesterdayBefore = nums[0];
        int yesterday = Math.max(nums[0], nums[1]);
        int result = 0;
        for (int i = 2; i < nums.length; i++) {
            //当天偷取的最大值 = Math.max(前天的偷到的最大值 + 今天可以偷到的值， 昨天偷到的最大值)
            int today = Math.max(yesterdayBefore + nums[i], yesterday);
            result = Math.max(today, result);

            yesterdayBefore = yesterday;
            yesterday = today;
        }

        return result;
    }

}
