class Solution {
    public int jump(int[] nums) {
        if(nums.length == 1){
            return 0;
        }
        int max = 0;
        int curr = 0;
        int count = 0;
        for(int i = 0 ; i < nums.length - 1 ; i++){
            max = Math.max(max , i + nums[i]);
            if(curr == i){
                curr = max;
                count++;
            }
            if(curr>nums.length-1){
                return count;
            }
        }
        return count;
    }
}
