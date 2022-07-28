class Solution {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        // we will be going from right to left and search for the index
        int violatingIncreasingOrder = -1;
        int length = nums.length;
        for (int i=length - 1; i>0; i--) {
            if (nums[i] > nums[i - 1]) {
                violatingIncreasingOrder = i - 1;
                break;
            }
        }
        // if already in greatest form, then just reverse the whole array
        if (violatingIncreasingOrder == -1) {
            reverse(nums, 0, length - 1);
            return;
        }
        int nextGreaterElementOfI = nums[violatingIncreasingOrder + 1];
        int violationNumber = nums[violatingIncreasingOrder];
        int nextGreaterIndex = violatingIncreasingOrder + 1;
        // find for the next greater index which is just greater than the violating number
        for (int i=violatingIncreasingOrder + 1; i<length; i++) {
            int currentNumber = nums[i];
            if (currentNumber > violationNumber && currentNumber <= nextGreaterElementOfI) {
                nextGreaterElementOfI = currentNumber;
                nextGreaterIndex = i;
            }
        }
        // reverse from the point of violation and the next greater element of that violation number
        swap(nums, violatingIncreasingOrder, nextGreaterIndex);
        reverse(nums, violatingIncreasingOrder + 1, length - 1);
    }

    private void reverse(int [] nums, int i, int j) {
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private void swap(int [] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
