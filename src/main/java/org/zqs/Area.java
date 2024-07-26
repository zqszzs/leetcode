package org.zqs;

/**
 * leetcode
 */
public class Area {

    public static void main(String[] args) {
        int [] param = new int [] {1,1};
        int result = maxArea2(param);
        System.out.println(result);
    }

    /**
     * 效率垃圾
     * 解题思路：滑动窗口
     * @param height
     */
    public static int maxArea(int [] height) {
        int length = height.length;
        int result = 0;
        for (int i = 1; i <= length; i++) {
            int left = 0, right = left + i;
            while (right < length) {
                int tmpResult = (right - left) * Math.min(height[left], height[right]);
                if (tmpResult > result) {
                    result = tmpResult;
                }
                left+=1;
                right+=1;
            }
        }
        return result;
    }

    /**
     * 双指针
     * 解题思路：滑动窗口
     * @param height
     */
    public static int maxArea2(int [] height) {
        int left = 0, right = height.length - 1, result = 0;
        while (left < right) {
            int length = (right - left);
            int width = Math.min(height[left], height[right]);
            int tmpResult = length * width;
            if (tmpResult > result) {
                result = tmpResult;
            }
            if (width == height[left]) {
                left++;
            } else {
                right--;
            }
        }

        return result;
    }
}
