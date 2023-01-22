class Solution {
     public long minOperations(int[] nums1, int[] nums2, int k) {
        if (k == 0) {
            return Arrays.equals(nums1, nums2) ? 0 : -1;
        }
        long ops = 0, bal = 0;
        for (int i = 0; i < nums1.length; ++i) {
            int diff = nums1[i] - nums2[i];
            if (diff % k != 0) {
                return -1;
            }
            if (diff > 0) {
                ops += diff / k;
            }
            bal += diff;
        } 
        return bal == 0 ? ops : -1;        
    }
}
