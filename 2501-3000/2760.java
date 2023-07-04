class Solution {
    public int longestAlternatingSubarray(int[] nums, int th) {
        int n = nums.length,maxi = 0,i = 0,j = 0,flag = 0;
        while(j < n){
            if(flag == 0){
               if(nums[j] % 2 == 0 && nums[j] <= th){
                    i = j;
                    maxi = Math.max(maxi,j - i + 1);
                    flag = 1;
                } 
            }
            else if(flag == 1){
                int x = nums[j-1],y = nums[j],c = x + y;
                if(c % 2 != 0 && nums[j] <= th)
                    maxi = Math.max(maxi,j - i + 1);
                else{
                    flag = 0;
                    j--;
                }
            }
            j++;
        }
        return maxi;
    }
}
