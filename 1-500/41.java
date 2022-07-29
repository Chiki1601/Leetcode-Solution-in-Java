public class Solution {
    public int firstMissingPositive(int[] nums) {

       for (int i = 0; i < nums.length; ) {
            if (nums[i] > 0 && i != nums[i] - 1 && nums[i] -1 < nums.length && nums[nums[i] -1] != nums[i]) {
                swap(nums, nums[i] - 1, i);
            } else{
                i ++;
            }
        }
        for(int i = 0; i < nums.length; i ++) {
            if (nums[i] !=i+1)
                return i+1;
        }

        return nums.length + 1;
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];

        nums[i] = nums[j];
        nums[j] = temp;
    }
}
