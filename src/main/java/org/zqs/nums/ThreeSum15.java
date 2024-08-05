package org.zqs.nums;

import java.util.*;

public class ThreeSum15 {

    public static void main(String[] args) {
        List<List<Integer>> result = threeSum2(new int [] {1,2,-2,-1});
        System.out.println(result);
    }

    public static List<List<Integer>> threeSum (int[] nums) {
        if (nums.length < 3) {
            return null;
        }

        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int k = nums.length -1;
            for (int j = i + 1;  j < k; j++) {
                int value = 0 - nums[i];
                while (j < k) {
                    if (nums[j] + nums[k] == value) {
                        List<Integer> list = new ArrayList();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        if (!result.contains(list)) {
                            result.add(list);
                        }
                        k--;
                        j++;
                    } else if (nums[j] + nums[k] > value) {
                        k--;
                    } else {
                        j++;
                    }
                }
            }
        }

        return result;
    }



    public static List<List<Integer>> threeSum2 (int[] nums) {
        if (nums.length < 3) {
            return null;
        }

        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int first = 0; first < nums.length; first++) {
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }

            int value = 0 - nums[first];
            int third = nums.length -1;
            for (int second = first + 1; second < third;  second++) {
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }

                while (second < third && nums[third] + nums[second] > value) {
                   third--;
                }

                if (second == third) {
                    break;
                }

                if (nums[third] + nums[second] == value) {
                    List<Integer> list = new ArrayList();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);


                    result.add(list);
                }

            }
        }

        return result;
    }
}
