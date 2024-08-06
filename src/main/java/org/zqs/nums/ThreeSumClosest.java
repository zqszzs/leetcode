package org.zqs.nums;

import java.util.Arrays;

public class ThreeSumClosest {

    public static void main(String[] args) {
        int result = threeSumClosest(new int [] {-1,2,1,-4}, 1);
        System.out.println(result);
    }


    public static int threeSumClosest(int[] nums, int target) {
        if (nums.length < 3) {
            return 0;
        }

        Arrays.sort(nums);
        int result = nums[0] + nums[1] + nums[2];
        for (int first = 0; first < nums.length; first++) {
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }

            int second = first + 1;
            int third = nums.length - 1;
            while (second < third) {
                if (Math.abs(result - target) > Math.abs(nums[first] + nums[second] + nums[third] - target)) {
                    result = nums[first] + nums[second] + nums[third];
                }
                if (nums[first] + nums[second] + nums[third] < target) {
                    second++;
                } else if (nums[first] + nums[second] + nums[third] > target) {
                    third--;
                } else {
                    return target;
                }
            }
        }
        return result;
    }
}
