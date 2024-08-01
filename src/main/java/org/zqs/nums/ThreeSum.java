package org.zqs.nums;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ThreeSum {

    public static void main(String[] args) {

    }

    public static int[] threeSum(int[] nums) {
        Map<Integer, Integer[]> map = new HashMap<Integer, Integer[]>();

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            Integer [] sumList = map.get(num);
            if (sumList == null) {
                int [] twoNum = twoSum(nums, 0 - num);
                //map.put(num, twoNum);
            }
        }


        return null;
    }



    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer,Integer>();

        for (int i = 0; i < nums.length; i++) {
            int num1 = nums[i];
            int num2 = target - num1;

            if (!map.containsKey(num1)) {
                map.put(num1, i);
            }

            if (map.containsKey(num2)) {
                int index = map.get(num2);
                return new int [] {i, index};
            }
        }

        return null;
    }
}
