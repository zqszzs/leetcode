package org.zqs.dynamicprogramming;

public class CompleteCircuit134 {

    public static void main(String[] args) {
        int result = canCompleteCircuit(new int [] {1,2,3,4,5}, new int [] {3,4,5,1,2});
        System.out.println(result);
    }

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        // 开始节点
        int start = 0;
        // 走过多少节点
        int count = 0;
        // 剩余油量
        int leftover = 0;

        int i = start;
        while (count < gas.length && start <= gas.length - 1) {
            leftover = gas[i] + leftover - cost[i];

            if (leftover >= 0) {
                count++;
                i++;
                if (i > gas.length - 1) {
                    i = 0;
                }
            } else {
                start++;
                i = start;
                leftover = 0;
                count = 0;
            }
        }

        return count >= gas.length ? start : -1;
    }
}
