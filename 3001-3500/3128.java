
public class Solution {
    public static long numberOfRightTriangles(int[][] grid) {
        int numRows = grid.length;
        int numCols = grid[0].length;

        long[][] top = new long[numRows][numCols];
        long[][] bottom = new long[numRows][numCols];
        long[][] right = new long[numRows][numCols];
        long[][] left = new long[numRows][numCols];

        for (int r = 0; r < numRows; r++) {
            for (int c = numCols - 1; c >= 0; c--) {
                if (c == numCols - 1) {
                    right[r][c] = grid[r][c];
                } else {
                    right[r][c] = right[r][c + 1] + grid[r][c];
                }
            }
            for (int c = 0; c < numCols; c++) {
                if (c == 0) {
                    left[r][c] = grid[r][c];
                } else {
                    left[r][c] = left[r][c - 1] + grid[r][c];
                }
            }
        }

        for (int c = 0; c < numCols; c++) {
            for (int r = 0; r < numRows; r++) {
                if (r == 0) {
                    bottom[r][c] = grid[r][c];
                } else {
                    bottom[r][c] = bottom[r - 1][c] + grid[r][c];
                }
            }
            for (int r = numRows - 1; r >= 0; r--) {
                if (r == numRows - 1) {
                    top[r][c] = grid[r][c];
                } else {
                    top[r][c] = top[r + 1][c] + grid[r][c];
                }
            }
        }

        long result = 0;
        for (int r = 0; r < numRows; r++) {
            for (int c = 0; c < numCols; c++) {
                if (grid[r][c] == 1) {
                    if (top[r][c] > 1 && right[r][c] > 1) {
                        result += (top[r][c] - 1) * (right[r][c] - 1);
                    }
                    if (top[r][c] > 1 && left[r][c] > 1) {
                        result += (top[r][c] - 1) * (left[r][c] - 1);
                    }
                    if (bottom[r][c] > 1 && right[r][c] > 1) {
                        result += (bottom[r][c] - 1) * (right[r][c] - 1);
                    }
                    if (bottom[r][c] > 1 && left[r][c] > 1) {
                        result += (bottom[r][c] - 1) * (left[r][c] - 1);
                    }
                }
            }
        }

        return result;
    }
}
