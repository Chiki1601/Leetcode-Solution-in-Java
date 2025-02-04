class Solution {
    public int maxAscendingSum(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        int ans = -1;
        int cs = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] < nums[i + 1]) {
                cs += nums[i];
            } else {
                ans = Math.max(ans, cs + nums[i]);
                cs = 0;
                ans = Math.max(ans, nums[i]);
            }
        }

        if (nums[nums.length - 1] > nums[nums.length - 2]) {
            ans = Math.max(ans, cs + nums[nums.length - 1]);
            ans = Math.max(ans, nums[nums.length - 1]);
        }

        return ans;
    }
}
