package org.zqs.array;

public class Juzhengzhiling73 {

    public static void main(String[] args) {
        //int [] [] param = new int [][] {{0,1,2,0},{3,4,5,2},{1,3,1,5}};

        int [] [] param = new int [][] {{1,1,1},{1,0,0},{1,0,1}};
        setZeroes(param);
    }


    public static void setZeroes(int[][] matrix) {
        if (matrix == null) {
            return;
        }

        int i = 0;
        int j = 0;

        while (i < matrix.length && j < matrix[0].length) {
            boolean hasZero = false;
            for (int i1 = i; i1 < matrix[i].length; i1++) {
                if (hasZero) {
                    matrix[i][i1] = 0;
                    continue;
                } else if (matrix[i][i1] == 0) {
                    hasZero = true;
                    i1 = i-1;
                }
            }

            hasZero = false;
            for (int j1 = j; j1 < matrix.length; j1++) {
                if (hasZero) {
                    matrix[j1][j] = 0;
                    continue;
                } else if (matrix[j1][j] == 0) {
                    hasZero = true;
                    j1 = j-1;
                }
            }
            if (i == matrix.length - 1 && j == matrix[0].length - 1) {
                break;
            }

            if (i < matrix.length - 1) {
                i++;
            }
            if (j < matrix[0].length - 1) {
                j++;
            }
        }

        System.out.println(matrix);
    }
}
