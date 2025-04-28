class Solution {
    public long countSubarrays(int[] nums, long k) {
        int start = 0;
        long sum = 0;
        long count = 0;
        
        for (int end = 0; end < nums.length; end++) {
            sum += nums[end];
            
            // Shrink the window if the score exceeds or equals k
            while (sum * (end - start + 1) >= k) {
                sum -= nums[start];
                start++;
            }
            
            // Add the number of valid subarrays ending at 'end'
            count += (end - start + 1);
        }
        
        return count;
    }
}
