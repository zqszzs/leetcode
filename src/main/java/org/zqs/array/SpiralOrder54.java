package org.zqs.array;

import java.util.ArrayList;
import java.util.List;

public class SpiralOrder54 {

    public static void main(String[] args) {
        int [] [] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        List<Integer> result = spiralOrder(matrix);
        System.out.println(result);
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        int up = 0;
        int down = matrix.length -1;
        int left = 0;
        int right = matrix[0].length - 1;

        List<Integer> list = new ArrayList<>();

        while (true) {
            // 从左到右走
            for (int i = left; i <= right; i++) {
                list.add(matrix[up][i]);
            }
            // 上边界向下移动, 上下相交退出
            if (++up > down) {
                break;
            }

            //从上到下走
            for (int i = up; i <= down; i++) {
                list.add(matrix[i][right]);
            }
            //
            // 右边界向左移动，左右相机退出
            if (--right < left) {
                break;
            }

            // 从右到左移动
            for (int i = right; i >= left; i--) {
                list.add(matrix[down][i]);
            }
            // 下边界向上移动，上下相交退出
            if (--down < up) {
                break;
            }

            //从上到下走
            for (int i = down; i >= up; i--) {
                list.add(matrix[i][left]);
            }
            // 左边界向右移动，左右相交退出
            if (++left > right) {
                break;
            }
        }

        return list;
    }
}
