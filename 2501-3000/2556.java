class Solution {
    public boolean isPossibleToCutPath(int[][] a) {
        int m = a.length, n = a[0].length;
        boolean [][]vis1 = new boolean[m+2][n+2];
        boolean [][]vis2 = new boolean[m+2][n+2];
        vis1[0][1] = true;
        vis2[m+1][n] = true;
        int []cnt = new int[m+n];
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                vis1[i][j] = a[i-1][j-1] == 1 && (vis1[i-1][j] || vis1[i][j-1]);
            }
        }
        for (int i = m; i >= 1; --i) {
            for (int j = n; j >= 1; --j) {
                vis2[i][j] = a[i-1][j-1] == 1 && (vis2[i+1][j] || vis2[i][j+1]);
                if (vis1[i][j] && vis2[i][j]) cnt[i+j-2]++;
            }
        }
        for (int i = 1; i < m+n-2; ++i) {
            if (cnt[i] <= 1) return true;
        }
        return false;
    }
}
