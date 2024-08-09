package org.zqs.array;

public class Search33 {

    public static void main(String[] args) {
        int result = search(new int [] {4,5,6,7,0,1,2}, 0);
        System.out.println(result);
    }

    public static int search(int[] nums, int target) {
        if (nums == null || target > nums.length - 1) {
            return -1;
        }

        int startIndex = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                startIndex = i + 1;
                break;
            }
        }

        int slow = 0;
        int fast = startIndex;

        while (target < nums.length) {
            int slowNum = nums[slow];
            int fastNum = nums[fast];

            if (slowNum == target) {
                return fast;
            }
            if (fastNum == target) {
                return slow;
            }

            nums[fast] = slowNum;
            nums[slow] = fastNum;

            slow++;
            fast++;
        }

        return -1;
    }
}
