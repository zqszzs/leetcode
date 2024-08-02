package org.zqs.dynamicprogramming;

/**
 * 最佳子序列和
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 子数组 是数组中的一个连续部分。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 * 示例 2：
 *
 * 输入：nums = [1]
 * 输出：1
 * 示例 3：
 *
 * 输入：nums = [5,4,-1,7,8]
 * 输出：23
 *
 * 作者：LeetCode
 * 链接：https://leetcode.cn/leetbook/read/top-interview-questions-easy/xn3cg3/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class MaxSubArray {

    public static void main(String[] args) {
        int [] params = new int [] {-2,1,-3,4,-1,2,1,-5,4};
        int result = maxSubArray(params);
        System.out.println(result);
    }

    /**
     * 1. 确认状态：        res[i]表示i点的最佳子序列和
     * 2. 转移表达式：      res[i] = res[i-1] > 0 ? res[i - 1] + nums[i] : nums[i];
     * 3. 确定边界         0的最佳子序列为nums[0], 计算从下标1开始
     * @param nums
     * @return
     */
    public static int maxSubArray(int[] nums) {
        int [] res = new int [nums.length];
        int result = nums[0];
        res[0] = result;
        for (int i = 1; i < nums.length; i++) {
            int max = res[i -1] > 0 ? res[i -1] + nums[i] : nums[i];
            res[i] = max;
            result = Math.max(result, max);
        }

        return result;
    }

    /***
     * 优化
     * @param nums
     * @return
     */
    public static int maxSubArray2(int[] nums) {
        int result, last;
        result = last = nums[0];
        for (int i = 1; i < nums.length; i++) {
            last = last > 0 ? last + nums[i] : nums[i];
            result = Math.max(result, last);
        }

        return result;
    }
}
