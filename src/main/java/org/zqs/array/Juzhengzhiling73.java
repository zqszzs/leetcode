package org.zqs.array;

public class Juzhengzhiling73 {

    public static void main(String[] args) {
        int [] [] param = new int [][] {{1,1,1},{1,0,1},{1,1,1}};
        setZeroes(param);
    }


    public static void setZeroes(int[][] matrix) {
        if (matrix == null) {
            return;
        }

        int length1 = matrix.length;
        int length2 = matrix[0].length;

        int i = 0, j = 0;
        while (i < length1) {
            while (j < length2) {
                if (matrix[i][j] == 0) {
                    for (int k = 0; k < length2; k++) {
                        matrix[i][k] = 0;
                    }
                    for (int k = 0; k < length1; k++) {
                        matrix[k][j] = 0;
                    }
                }
                j++;
            }
            i++;
        }
    }
}
