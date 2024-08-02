package org.zqs.dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

/**
 * 爬楼梯
 *
 *
 * 动态规划
 * 1: 状态转移
 * 2：重叠子问题
 * 3：边界
 */
public class ClimbStairs {


    public static void main(String[] args) {
        int result = climbStairs(6);
        System.out.println(result);
    }

    public static int climbStairs(int n) {
        return climbStairs(n, new HashMap<>());
    }


    public static int climbStairs(int n, Map<Integer, Integer> map) {
        /**
         * 解决重复子问题
         */
        if (map.containsKey(n)) {
            return map.get(n);
        }

        /**
         * 确定动态规划边界问题
         */
        if (n <= 1) {
            return 1;
        }
        if (n <= 2) {
            return 2;
        }

        /**
         * 确定状态转移方程
         */
        int res = climbStairs(n - 1, map) + climbStairs(n - 2, map);
        map.put(n, res);
        return res;
    }
}
