package org.zqs.nums;

public class FindMin153 {
    public static void main(String[] args) {

        int result = findMin(new int [] {1, 2, 4, 5, 0});
        System.out.println(result);
    }


    public static int findMin(int[] nums) {
        if (nums[0] <= nums[nums.length -1]) {
            return nums[0];
        }

        int left = 0;
        int right = nums.length - 1;
        int min = nums[0];

        while (left <= right) {
            int middle = left + (right - left) / 2;

            int num = nums[middle];
            if (num >= min) {
                left = middle + 1;
            } else {
                right = middle - 1;
                min = num;
            }
        }

        return min;
    }
}
