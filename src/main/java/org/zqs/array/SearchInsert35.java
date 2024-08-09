package org.zqs.array;

/**
 * 搜索插入位置
 */
public class SearchInsert35 {

    public static void main(String[] args) {
        int result = searchInsert(new int [] {2,3,5,6}, 1);
        System.out.println(result);
    }

    public static int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                return mid;
            }
        }

        return left;
    }
}
