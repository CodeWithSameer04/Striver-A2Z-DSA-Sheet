import java.util.*;

class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];

        for (int i = 0; i < n; i++)
            Arrays.fill(board[i], '.');

        backtrack(0, board, result);
        return result;
    }

    private void backtrack(int row, char[][] board, List<List<String>> result) {
        if (row == board.length) {
            result.add(construct(board));
            return;
        }

        for (int col = 0; col < board.length; col++) {
            if (isSafe(board, row, col)) {
                board[row][col] = 'Q';
                backtrack(row + 1, board, result);
                board[row][col] = '.'; // backtrack
            }
        }
    }

    private boolean isSafe(char[][] board, int row, int col) {
        // check column
        for (int i = 0; i < row; i++)
            if (board[i][col] == 'Q')
                return false;

        // check upper-left diagonal
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 'Q')
                return false;

        // check upper-right diagonal
        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++)
            if (board[i][j] == 'Q')
                return false;

        return true;
    }

    private List<String> construct(char[][] board) {
        List<String> res = new ArrayList<>();
        for (char[] row : board)
            res.add(new String(row));
        return res;
    }
}
