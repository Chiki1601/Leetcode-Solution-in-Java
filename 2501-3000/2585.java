class Solution {
 int[][] cache;
public int waysToReachTarget(int target, int[][] types) {
    cache = new int[target + 1][types.length + 1];
    Arrays.stream(cache).forEach(a -> Arrays.fill(a, -1)); // init cache with -1
    return dfs(0, target, types);
}
private int dfs(int i, int target, int[][] types) {
    if (target == 0) return 1;
    if (i >= types.length || target < 0) return 0;
    if (cache[target][i] != -1) return cache[target][i];
    int ans = 0;
    for (int j = 0; j <= types[i][0]; j++)
        ans = (ans + dfs(i + 1, target - j * types[i][1], types)) % 1000000007;
    cache[target][i] = ans;
    return ans;
}
}
