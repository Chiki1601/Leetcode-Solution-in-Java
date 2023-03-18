class Solution {
   public int maxScore(int[] nums) {
    Arrays.sort(nums);
    if(nums[nums.length-1]==0)
    {
        return 0;
    }
    int n=nums.length-1;
    long sum=0;
    int c=0;
    while(n>=0)
    {
        sum+=nums[n--];
        if(sum<=0)
        {
            break;
        }else{
        c++;
        }
    }
    return c;
}
}
