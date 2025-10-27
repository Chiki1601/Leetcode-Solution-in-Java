class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            nums[i] = Math.abs(nums[i]);
        }
        Arrays.sort(nums);
        long ans = 0;
        int idx = 0;
        while(idx < n / 2) {
            int last = nums[n - idx - 1];
            int first = nums[idx];
            ans += (last * last) - (first * first);
            idx++;
        }
        if(n % 2 == 1) ans += nums[idx] * nums[idx];
        return ans;
    }
}
