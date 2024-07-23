import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static void main(String[] args) {
        int [] nums = new int [] {3,2,4};
        int target = 6;
        int [] result = twoSum1(nums, target);
        System.out.println(result[0] + ":" + result[1]);
    }

    public static int[] twoSum(int[] nums, int target) {
        int [] newNums = Arrays.copyOf(nums, nums.length);
        Arrays.sort(newNums);

        int [] a = new int [2];
        for (int newNum : newNums) {
            int left = 0;
            int right = newNums.length - 1;
            Integer newNum2 = twoSum(newNums, left, right, target - newNum);
            if (newNum2 != null) {
                a[0] = newNum;
                a[1] = newNum2;
                break;
            }
        }
        int x = -1, y = -1;
        for (int i = 0; i<nums.length; i++) {
            if (nums[i] == a[0] && x < 0) {
                x = i;
            } else if (nums[i] == a[1] && y < 0) {
                y = i;
            }
        }
        return new int [] {x, y};
    }

    public static Integer twoSum(int[] nums, int left, int right, int num) {
        if (left >= right) {
            return null;
        }
        int middle = left + (right - left) / 2;
        if (middle == left) {
            middle += 1;
        }
        int middleNum = nums[middle];

        if (middleNum > num) {
            right = middle;
            return twoSum(nums, left, right, num);
        } else if (middleNum < num) {
            left = middle;
            return twoSum(nums, left, right, num);
        } else {
            return middleNum;
        }
    }

    public static int[] twoSum1(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer,Integer>();

        for (int i = 0; i < nums.length; i++) {
            int num1 = nums[i];
            int num2 = target - num1;

            if (!map.containsKey(num1)) {
                map.put(num1, i);
            }

            if (map.containsKey(num2)) {
                int index = map.get(num2);
                if (index != i) {
                    return new int [] {i, index};
                }
            }
        }

        return null;
    }
}
