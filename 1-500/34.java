class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums == null) return new int[]{-1, -1};
        int len = nums.length;
        int index = binarySearch(0, len - 1, nums, target);
        if(-1 == index) return new int[]{-1, -1};
        else{
            int high = index;
            while(++high < len && nums[high] == target){};
            int low = index;
            while(--low >= 0 && nums[low] == target){}
            return new int[]{low + 1, high - 1};
        }
    }
    private static int binarySearch(int low, int high, int[] nums, int target){
        if(low > high)
            return -1;
        int mid = low + (high - low) / 2;
        int midVal = nums[mid];
        if(midVal == target) return mid;
        if(midVal > target)
            return binarySearch(low, mid - 1, nums, target);
        else
            return binarySearch(mid + 1, high, nums, target);
    }
}
