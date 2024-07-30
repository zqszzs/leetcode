package org.zqs;

public class RemoveElement27 {
    public static void main(String[] args) {

        int nums [] = new int [] {1};
        int result = removeElement(nums, 1);
        System.out.println(result);
    }

    public static int removeElement(int[] nums, int val) {
        if (nums == null) {
            return 0;
        }

        int tail = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            if (i == tail) {
                if (nums[i] == val) {
                    tail--;
                }
                break;
            }

            if (nums[i] == val) {
                nums[i] = nums[tail];
                nums[tail] = val;
                tail--;
                i--;
            }
        }

        return tail + 1;
    }
}
