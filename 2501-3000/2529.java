class Solution {
   
  public int maximumCount(int[] nums) {
    // All negative or all possitive. We can be sure that the larger number will be array's length
    if (nums[0] > 0 || nums[nums.length - 1] < 0) return nums.length;
    
    // find 0
    int l = 0, r = nums.length - 1, mid;
    while (l < r) {
      mid = l + (r - l) / 2;
      if (nums[mid] < 0) l = mid + 1;
      else r = mid;
    }
    
    // currently, `l` is pointing to the left most position that nums[l] >= 0
    int neg = l;
    
    // Move l to right to exclude zeros.
    while (l < nums.length && nums[l] == 0) l++;
    int pos = nums.length - l;
    
    return Math.max(neg, pos);
  }
}
