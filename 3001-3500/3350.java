class Solution {
    public int maxIncreasingSubarrays(int[] nums) {
        int prev = 0;
        int curr = 1;
        int ans = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] < nums[i]) {
                curr++;
            } else {
                prev = curr;
                curr = 1;
            }
            ans = Math.max(ans, Math.max(curr / 2, Math.min(prev, curr)));
        }
        
        return ans;
    }
}
