package org.zqs.array;


public class SearchRange34 {

    public static void main(String[] args) {
       int [] result = searchRange(new int [] {1, 4}, 4);
        System.out.println(result);
    }

    public static int[] searchRange(int[] nums, int target) {
        if (nums == null) {
            return new int [] {-1,-1};
        }
        if (nums.length == 1) {

            return nums[0] == target ?  new int [] {0,0} : new int [] {-1,-1};
        }

        int left = 0;
        int right = nums.length - 1;
        int middle = (left + right) / 2;

        int index = -1;
        while (left <= right) {
            if (nums[middle] > target) {
                right = middle - 1;
                middle = (left + right) / 2;
            } else if (nums[middle] < target) {
                left = middle + 1;
                middle = (left + right) / 2;
            } else {
                index = middle;
                break;
            }
        }

        if (index >= 0) {
            int start = index;
            int end = index;

            while (--start >= 0) {
                if (nums[start] != target) {
                    break;
                }
            }
            while (++end < nums.length) {
                if (nums[end] != target) {
                    break;
                }
            }

            return new int [] {start + 1, end - 1};
        }

        return new int [] {-1, -1};
    }
}
