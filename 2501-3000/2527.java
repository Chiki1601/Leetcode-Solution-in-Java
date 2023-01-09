class Solution {
        public int xorBeauty(int[] nums) {
        int answer = 0;
        for(int i=0; i<nums.length; i++)    answer ^= nums[i];
        return answer;
    }
}
