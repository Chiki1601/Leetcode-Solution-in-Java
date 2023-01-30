class Solution {
    public long countQuadruplets(int[] nums) {
        int n = nums.length;
        long[] dp = new long[n];
        long ans = 0;
        for (int j = 0; j < n; j++) {
            int prev_small = 0;
            for (int i = 0; i < j; i++) {
                if (nums[j] > nums[i]) {
                    prev_small++;
                    ans += dp[i];
                } else if (nums[j] < nums[i]) {
                    dp[i] += prev_small;
                }
            }
        }
        return ans;
    }
}
