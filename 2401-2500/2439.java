class Solution {
    public int minimizeArrayValue(int[] nums) {
    long minmax = 0, sum = 0;
    for (int i = 0; i < nums.length; ++i) {
        sum += nums[i];
        minmax = Math.max((sum + i) / (i + 1), minmax);
    }
    return (int)minmax;
}
}
