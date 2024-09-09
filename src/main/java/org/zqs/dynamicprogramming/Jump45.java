package org.zqs.dynamicprogramming;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Jump45 {

    public static void main(String[] args) {
        int result = jump1(new int [] {2,3,0,1,4});
        System.out.println(result);
    }

    public static int jump(int[] nums) {
        if (nums == null && nums.length < 2) {
            return 0;
        }
        Map<Integer, Integer> step = new HashMap<>();

        int minStep = nums.length - 1;
        for (int i = 0; i < nums.length - 1; i++) {
            minStep = Math.min(minStep, jump(nums, step, i));
        }

        return step.get(0);
    }

    public static int jump(int[] nums, Map<Integer,Integer> stepMap, int index) {
        Integer step = stepMap.get(index);
        if (Objects.nonNull(step)) {
            return step;
        }

        int n = nums[index];
        if (n >= nums.length - 1 - index ) {
            stepMap.put(index, 1);
            return 1;
        }

        Integer currentMinStep = nums.length - 2;
        for (int i = index + 1; i <= index + n; i++) {
            int currentStep = jump(nums, stepMap, i);
            currentMinStep = Math.min(currentStep, currentMinStep);
        }

        stepMap.put(index, currentMinStep + 1);
        return currentMinStep + 1;
    }




    public static int jump1(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }

        int step = 1;
        int nextStep = 0;
        while (nextStep < nums.length) {
            int num = nums[nextStep];

            if (nextStep + num >= nums.length - 1) {
                return step;
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
            step++;
        }

        return step;
    }

}
