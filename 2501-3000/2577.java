class Solution {
   public int minimumTime(int[][] grid) {
    if (grid[0][1] > 1 && grid[1][0] > 1) return -1;
    
    int m = grid.length, n = grid[0].length;
    int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    boolean[] visited = new boolean[m * n];
    TreeSet<int[]> ts = new TreeSet<>((a, b) -> {
        if (a[0] != b[0]) return a[0] - b[0];
        if (a[1] != b[1]) return a[1] - b[1];
        return a[2] - b[2];
    });
    ts.add(new int[]{grid[0][0], 0, 0});
    
    while (!ts.isEmpty()) {
        int[] curr = ts.pollFirst();
        int time = curr[0], row = curr[1], col = curr[2];
        int idx = row * n + col;
        
        if (idx == m * n - 1) return time;
        if (visited[idx]) continue;
        visited[idx] = true;
        
        int[][] adjDirs = {{1, 0}, {0, 1}}; // check adjacent neighbors first
        if (row == m - 1) adjDirs = new int[][]{{0, 1}, {-1, 0}};
        else if (col == n - 1) adjDirs = new int[][]{{1, 0}, {0, -1}};
        
        for (int[] dir : adjDirs) {
            int r = row + dir[0], c = col + dir[1];
            if (r < 0 || r >= m || c < 0 || c >= n) continue;
            int idx2 = r * n + c;
            if (visited[idx2]) continue;
            int wait = ((grid[r][c] - time) % 2 == 0) ? 1 : 0;
            ts.add(new int[]{Math.max(grid[r][c] + wait, time + 1), r, c});
        }
    }
    return -1;
}
}
