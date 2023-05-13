class Solution {
    static long [] dp;
    static int mod = (int)(1e9+7);
    static int countGoodStrings(int low, int high, int zero, int one) {
        dp = new long [(int)(1e6)];
        Arrays.fill(dp, -1);
        return (int)getResult(low, high, zero, one, 0);
    }
    static long getResult(int low, int high, int x, int y, int cur){
        if(cur > high) return 0;
        if(dp[cur] != -1) return dp[cur];
        long ans = (cur >= low && cur <= high? 1:0) + getResult(low, high, x, y, cur + x) + getResult(low, high, x, y, cur + y);
        return dp[cur] = ans % mod;
    }
}
