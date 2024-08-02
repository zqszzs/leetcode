package org.zqs.nums;

public class SubarraySum {

    public static void main(String[] args) {
        int params [] = new int[] {-1,-1,1};
        int result = subarraySum(params, 0);
        System.out.println(result);
    }


    public static  int subarraySum(int[] nums, int k) {
        int slow = 0;
        int fast = 0;
        int result = 0;
        int sum = nums[slow];
        while (fast < nums.length) {
            sum = slow == fast ? nums[fast] : sum + nums[fast];
            if (sum < k) {
                fast++;
            } else if (sum == k) {
                sum = sum - nums[slow];
                result++;
                slow++;
                fast++;
            } else {
                if (slow < fast) {
                    sum = sum - nums[slow];
                    slow++;
                } else {
                    fast++;
                }
            }
        }

        return result;
    }
}
