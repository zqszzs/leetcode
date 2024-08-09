package org.zqs.dynamicprogramming;

public class Trap41 {

    public static int trap(int[] height) {
        if (height == null || height.length < 3) {
            return 0;
        }

        int slow = 0;
        int fast = slow + 1;

        while (fast < height.length) {
            if (height[fast] <= height[slow]) {
                slow = fast;
            } else {


            }

            fast++;
        }
        return 1;
    }
}
