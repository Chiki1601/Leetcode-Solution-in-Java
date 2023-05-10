class Solution {
    int ans = 0;
    int dfs(int n,int[] cost,int i) {
        if(i > n) return 0;
        int leftCost = dfs(n,cost,2 * i);
        int rightCost = dfs(n,cost,2 * i + 1);
        ans += Math.abs(leftCost - rightCost);
        return Math.max(leftCost,rightCost) + cost[i - 1];
    }
    public int minIncrements(int n, int[] cost) {
        dfs(n,cost,1);
        return ans;
    }
}
