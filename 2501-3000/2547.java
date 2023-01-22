class Solution {
    public int minCost(int[] nums, int k) {
        int n = nums.length;
        
        int[][] trimmed = new int[n][n];
        for(int i=0;i<n;i++) {
            int curr = 0;
            int[] freq = new int[n];
            for(int j=i;j<n;j++) {
                freq[nums[j]]++;
                if(freq[nums[j]]==2) {
                    curr+=2;
                } else if(freq[nums[j]]>2) {
                    curr++;
                }
                trimmed[i][j] = curr;
            }
        }
        int[] dp = new int[n+1];
        for(int i=1;i<=n;i++) {
            int min = Integer.MAX_VALUE;
            for(int j=0;j<i;j++) {
                min = Math.min(min, dp[j]+k+trimmed[j][i-1]);
            }
            dp[i] = min;
        }
        return dp[n];
    }
}
