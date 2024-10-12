package org.zqs.nums;

public class TwoNumSum {

    public static void main(String[] args) {
        int [] params = new int [] {1,2,3,4,4,9,56,90};
        int [] result = twoSum1(params, 8);
        System.out.println(result);
    }

    public int[] twoSum(int[] numbers, int target) {
        int l = 0;
        int r = numbers.length - 1;

        while (l < r) {
            int num1 = numbers[l];
            int num2 = numbers[r];

            if (num1 + num2 == target) {
                return new int [] {l + 1, r + 1};
            } else if (num1 + num2 < target) {
                num1++;
            } else {
                num2--;
            }
        }

        return new int [2];
    }


    /**
     * 二分查找
     * @param numbers
     * @param target
     * @return
     */
    public static int[] twoSum1(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            int num2 = target - numbers[i];
            int l = i + 1;
            int r = numbers.length - 1;
            while (l <= r) {
                int mid = (r - l) / 2 + l;
                if (numbers[mid] > num2) {
                    r = mid - 1;
                } else if (numbers[mid] < num2) {
                    l = mid + 1;
                } else {
                    return new int [] {i + 1, mid + 1};
                }
            }
        }
        return new int [2];
    }
}
