class Solution {
    static void dfs(int i, int j, int w, int h, int[][] M, byte[] dp, List<List<Integer>> ans) {
        int ij = i * M[0].length + j;
        if ((dp[ij] & w) > 0 || M[i][j] < h) return;
        dp[ij] += w;
        h = M[i][j];
        if (dp[ij] == 3) ans.add(Arrays.asList(i,j));
        if (i + 1 < M.length) dfs(i+1, j, w, h, M, dp, ans);
        if (i > 0) dfs(i-1, j, w, h, M, dp, ans);
        if (j + 1 < M[0].length) dfs(i, j+1, w, h, M, dp, ans);
        if (j > 0) dfs(i, j-1, w, h, M, dp, ans);
    }
    public List<List<Integer>> pacificAtlantic(int[][] M) {
        List<List<Integer>> ans = new ArrayList<>();
        if (M.length == 0) return ans;
        int y = M.length, x = M[0].length;
        byte[] dp = new byte[x * y];
        for (int i = 0; i < x; i++) {
            dfs(0, i, 1, M[0][i], M, dp, ans);
            dfs(y-1, i, 2, M[y-1][i], M, dp, ans);
        }   
        for (int i = 0; i < y; i++) {
            dfs(i, 0, 1, M[i][0], M, dp, ans);
            dfs(i, x-1, 2, M[i][x-1], M, dp, ans);
        }
        return ans;
    }
}
