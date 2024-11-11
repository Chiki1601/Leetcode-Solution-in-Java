class Solution {
    public int maxFrequency(int[] nums, int k, int numOperations) {
        int n = nums.length, ans = 0, left = 0, right = 0;
        Arrays.sort(nums);

        // HashMap to store the frequency of each number in the sorted array
        HashMap<Integer, Integer> count = new HashMap<>();
        for(int num : nums) count.put(num, count.getOrDefault(num, 0) + 1);

        // First pass: choose an existing number as the "reference point"
        for(int mid = 0; mid < n; mid++) {
            // Move the left pointer to maintain that the difference between nums[mid] and nums[left] is <= k
            while(nums[mid] - nums[left] > k) {
                left++;
            }

            // Move the right pointer to maintain that the difference between nums[right] and nums[mid] is <= k
            while(right < n - 1 && nums[right + 1] - nums[mid] <= k) {
                right++;
            }

            int total = right - left + 1; // total elements in the current range
            ans = Math.max(ans, Math.min(total - count.get(nums[mid]), numOperations) + count.get(nums[mid]));
        }

        // Second pass: choose a non-existent number as the "reference point"
        left = 0;
        for(right = 0; right < n; right++) {
            int mid = (nums[left] + nums[right]) / 2;

            // Move the left pointer until the mid-point falls within range [nums[left], nums[right]]
            while(mid - nums[left] > k || nums[right] - mid > k) {
                left++;
                mid = (nums[left] + nums[right]) / 2;
            }
            ans = Math.max(ans, Math.min(right - left + 1, numOperations));
        }

        return ans;
    }
}
