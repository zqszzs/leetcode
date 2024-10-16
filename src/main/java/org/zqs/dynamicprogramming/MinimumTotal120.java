package org.zqs.dynamicprogramming;

import org.omg.CORBA.INTERNAL;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumTotal120 {

    public static void main(String[] args) {

        int [] [] arrays = {{2},{3,4},{6,5,7},{4,1,8,3}};


        List<List<Integer>> params = convert2DArrayToList(arrays);

        int result = minimumTotal(params);

        System.out.println(result);
    }

    public static int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size() == 1) {
            return triangle.get(0).get(0);
        }

        int [][] dp = new int [triangle.size()] [triangle.get(triangle.size() - 1).size()];
        dp[0][0] = triangle.get(0).get(0);
        int value = Integer.MAX_VALUE;

        for (int i = 1; i < triangle.size(); i++) {
            int bestPath = Integer.MAX_VALUE;
            for (int j = 0; j < triangle.get(i).size(); j++) {
                int path;
                if (j == 0) {
                    path = dp[i - 1][0] + triangle.get(i).get(j);
                } else if (j == triangle.get(i).size() - 1) {
                    path = dp[i - 1][j - 1] + triangle.get(i).get(j);
                } else {
                    path = Math.min(dp[i - 1][j] + triangle.get(i).get(j), dp[i - 1][j - 1] + triangle.get(i).get(j));
                }
                dp[i][j] = path;
                value = bestPath = Math.min(path, bestPath);
            }
        }

        return value;
    }

    public static List<List<Integer>> convert2DArrayToList(int[][] array) {
        List<List<Integer>> list = new ArrayList<>();
        for (int[] row : array) {
            // 使用Arrays.asList将数组转换成List，但注意这个List是固定大小的
            // 如果需要可变大小的List，可以将其添加到新的ArrayList中
            List<Integer> rowList = new ArrayList<>(Arrays.asList(Arrays.stream(row).boxed().toArray(Integer[]::new)));
            list.add(rowList);
        }
        return list;
    }
}
