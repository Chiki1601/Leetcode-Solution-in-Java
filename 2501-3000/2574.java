class Solution {
    public int[] leftRigthDifference(int[] nums) {
        long x=0;
        int n=nums.length;
        int[] ans = new int[n];
        int[] a = new int[n+1];
        a[0]=0;
        for(int i=0;i<nums.length;i++)
        {
            a[i+1]=a[i]+nums[i];
        }
        for(int i=1;i<n+1;i++) ans[i-1]=Math.abs(a[n]-a[i]-a[i-1]);
        return ans;
    }
}
