class Solution {
    public int removeElement(int[] nums, int val) {
        int start = -1;
        for(int i = 0; i < nums.length; ++i) {
            if(nums[i] != val) {
                nums[++start] = nums[i];
            }
        }
        
        return start + 1;
    }
}
