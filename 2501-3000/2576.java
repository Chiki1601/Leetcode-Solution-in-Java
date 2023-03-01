class Solution {
    public int maxNumOfMarkedIndices(int[] nums) {
        Arrays.sort(nums);
        int l=0,r=nums.length/2;
        while (r<nums.length && l<nums.length/2)
        {
            if(2*nums[l]<=nums[r])
            {
                l+=1;
            }
            r+=1;
        }
        return l*2;
    }
}
