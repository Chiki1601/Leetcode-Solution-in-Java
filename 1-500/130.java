class Solution {
    public void solve(char[][] board) {
        if (board == null || board.length == 0)
            return;
        if (board.length < 3 || board[0].length < 3)
            return;
        int row = board.length;
        int col = board[0].length;
        for (int i=0; i<row; i++) {
            if (board[i][0] == 'O') {
                dfs(board, i, 0);
            }
            if (board[i][col - 1] == 'O') {
                dfs(board, i, col-1);
            }
        }
        for (int j=0; j<col; j++) {
            if (board[0][j] == 'O') {
                dfs(board, 0, j);
            }
            if (board[row-1][j] == 'O') {
                dfs(board, row-1, j);
            }
        }
        for (int i=0; i<row; i++) {
            for (int j=0; j<col; j++) {
                if (board[i][j] == '+') {
                    board[i][j] = 'O';
                }
                else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    public void dfs(char [][] board, int i, int j) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != 'O')
            return;
        board[i][j] = '+';
        dfs(board, i+1, j);
        dfs(board, i-1, j);
        dfs(board, i, j-1);
        dfs(board, i, j+1);
    }
}
