package org.zqs.array;

public class IsValidSudoku {

    public static void main(String[] args) {

        char[][] param = new char[][]{
                {'5','3','.','.','7','.','.','.','.'}
                ,{'6','.','.','1','9','5','.','.','.'}
                ,{'.','9','8','.','.','.','.','6','.'}
                ,{'8','.','.','.','6','.','.','.','3'}
                ,{'4','.','.','8','.','3','.','.','1'}
                ,{'7','.','.','.','2','.','.','.','6'}
                ,{'.','6','.','.','.','.','2','8','.'}
                ,{'.','.','.','4','1','9','.','.','5'}
                ,{'.','.','.','.','8','.','.','7','9'}
        };

        boolean result = isValidSudoku(param);

        System.out.println(result);
    }

    public static boolean isValidSudoku(char[][] board) {

        int [][] rows = new int [9] [9];
        int [][] column = new int [9] [9];

        int [][][] subBox = new int [3] [3] [9];

        for (int i = 0; i < board.length - 1; i++) {
            for (int j = 0; j < board[i].length; j++) {
                char a = board[i][j];
                if (a != '.') {
                    int number = a - '0' - 1;
                    rows[i][number]++;
                    column[j][number]++;
                    subBox[i/3][j/3][number]++;

                    if (rows[i][number] > 1 || column[j][number] > 1 || subBox[i/3][j/3][number] > 1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
