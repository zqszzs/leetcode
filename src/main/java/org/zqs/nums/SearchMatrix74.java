package org.zqs.nums;

public class SearchMatrix74 {
    public static void main(String[] args) {
        boolean result = searchMatrix(new int [][] {{1}}, 3);
        System.out.println(result);
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int left = 0;
        int right = matrix.length - 1;

        int targetArray = -1;
        while (left <= right) {
            int middle = left + (right - left) / 2;

            int [] nums = matrix[middle];
            if (nums[0] <= target && nums[nums.length - 1] >= target) {
                targetArray = middle;
                break;
            }

            if (target > nums[nums.length - 1]) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }

        if (targetArray < 0) {
            return false;
        }

        left = 0;
        right = matrix[targetArray].length - 1;
        int [] nums = matrix[targetArray];
        while (left <= right) {
            int middle = left + (right - left) / 2;

            if (nums[middle] == target) {
                return true;
            }
            if (target > nums[middle]) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }

        return false;
    }
}
